package com.example.userservice.domain.user.service;

import com.example.userservice.domain.order.dto.response.OrderResponseDto;
import com.example.userservice.domain.order.service.OrderServiceClient;
import com.example.userservice.domain.user.dto.request.CreateUserRequestDto;
import com.example.userservice.domain.user.dto.response.UserResponseDto;
import com.example.userservice.domain.user.entity.UserEntity;
import com.example.userservice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final OrderServiceClient orderServiceClient;
    private final Environment env;
    private final RestTemplate restTemplate;

    @Override
    public UserResponseDto createUser(CreateUserRequestDto userRequestDto) {
            UserEntity user = UserEntity.builder()
                    .email(userRequestDto.getEmail())
                    .userId(UUID.randomUUID().toString())
                    .encryptedPwd(passwordEncoder.encode(userRequestDto.getPwd()))
                    .name(userRequestDto.getName()).build();

        userRepository.save(user);

        return new UserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getUserByAll() {
        List<UserEntity> userEntityList = userRepository.findAll();

        return userEntityList.stream().map(UserResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserByUserId(String userId) {
        Optional<UserEntity> byUserId = userRepository.findByUserId(userId);

        /* Using as rest Template */
        /*
        String orderUrl = String.format(env.getProperty("order_service.url"), userId);
        List<OrderResponseDto> orderList = restTemplate.exchange(orderUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<OrderResponseDto>>() {
                }).getBody();
        */

        /* Feign exception handling */
        /* FeignErrorDecoder 사용할 경우, 필요 없음 !
        List<OrderResponseDto> orderList = null;
        try {
            orderList = orderServiceClient.getOrders(userId);
        } catch(FeignException ex) {
            log.error(ex.getMessage());
        }
        */

        /* ErrorDecoder */
        List<OrderResponseDto> orderList = orderServiceClient.getOrders(userId);

        if(byUserId.isEmpty()) throw new UsernameNotFoundException("존재하지 않는 사용자입니다.");

        return new UserResponseDto(byUserId.get(), orderList);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserId(username).orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을 수 없습니다."));

        log.info("Success find member {}", user.toString());

        return User.builder()
                .username(user.getName())
                .password(user.getEncryptedPwd()).build();
    }
}

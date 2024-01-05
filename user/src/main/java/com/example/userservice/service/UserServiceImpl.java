package com.example.userservice.service;

import com.example.userservice.dto.request.CreateUserRequestDto;
import com.example.userservice.dto.response.UserResponseDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserId(username).orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을 수 없습니다."));

        log.info("Success find member {}", user.toString());

        return User.builder()
                .username(user.getName())
                .password(user.getEncryptedPwd()).build();
    }
}

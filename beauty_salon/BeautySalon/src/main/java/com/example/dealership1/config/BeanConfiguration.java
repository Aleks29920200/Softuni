package com.example.dealership1.config;

import com.example.dealership1.domain.dto.UserDto;
import com.example.dealership1.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class BeanConfiguration {
    @Bean
    public UserDto userDto(){
        return new UserDto();
    }
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
    @Bean
    public LoggedUser loggedUser(){
        return new LoggedUser();
    }

}

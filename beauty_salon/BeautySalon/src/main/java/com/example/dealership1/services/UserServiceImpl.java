package com.example.dealership1.services;

import com.example.dealership1.domain.binding.RegisterDto;
import com.example.dealership1.domain.dto.UserDto;
import com.example.dealership1.domain.entity.Role;
import com.example.dealership1.domain.entity.User;
import com.example.dealership1.repositories.RoleRepo;
import com.example.dealership1.repositories.UserRepo;
import com.example.dealership1.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;

    private ModelMapper mapper;
    private LoggedUser loggedUser;
    private RoleRepo roleRepo;
    private UserDto userDto;

    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, ModelMapper mapper, LoggedUser loggedUser, RoleRepo roleRepo, UserDto userDto, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.loggedUser = loggedUser;
        this.roleRepo = roleRepo;
        this.userDto = userDto;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void logout() {
        this.loggedUser.clearFields();
    }
    @Override
    public User findUserByEmail(String email) {
        return this.userRepo.findUserByEmail(email).orElse(null);
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepo.findUserByUsername(username).orElse(null);

    }
    @Override
    public void registerUser(RegisterDto userDto) {
        User map = this.mapper.map(userDto, User.class);
        map.setPassword(passwordEncoder.encode(userDto.getPassword()));
        if(this.userRepo.count()==0){
           map.getAuthorities().add(this.roleRepo.findRoleByAuthority("ADMIN").get());
        }else{
             map.getAuthorities().add(this.roleRepo.findRoleByAuthority("USER").get());
        }
        this.userRepo.saveAndFlush(map);
    }

    @Override
    public Role findRoleByName(String name) {
        return this.roleRepo.findRoleByAuthority(name).orElse(null);
    }

    @Override
    public List<User> allUsers() {
        return this.userRepo.findAll();
    }



}

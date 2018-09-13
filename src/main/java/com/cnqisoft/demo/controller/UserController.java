package com.cnqisoft.demo.controller;


import com.cnqisoft.demo.entity.User;
import com.cnqisoft.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CacheConfig(cacheNames = "user")
@PreAuthorize("hasAuthority('admin')")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("users")
    public Iterable<User> getList() {
        return userRepository.findAll();
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable Integer id) {
      return userRepository.findById(id).get();
    }

    @PostMapping("user")
    public User addUser(User user) {
        return addOrUpdateUser(user);
    }

    @PutMapping("user")
    public User updateUser(User user) {
        return addOrUpdateUser(user);
    }

    public User addOrUpdateUser(User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    @CacheEvict(key = "#id")
    public String deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "success";
    }

}

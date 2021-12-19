package com.books.books.rest;

import com.books.books.converters.UserConverterImpl;
import com.books.books.dto.UserDTO;
import com.books.books.repositoriesSpringDataJPA.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserConverterImpl userConverterImpl;

    public UserController(UserRepository userRepository, UserConverterImpl userConverterImpl) {
        this.userRepository = userRepository;
        this.userConverterImpl = userConverterImpl;
    }

    @GetMapping("/api/users")
    public List<UserDTO> getAllusers() {
        return userRepository.findAll().stream().map(userConverterImpl::toDTO)
                .collect(Collectors.toList());
    }
}

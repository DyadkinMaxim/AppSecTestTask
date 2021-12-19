package com.books.books.converters;

import com.books.books.dto.UserDTO;
import com.books.books.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverterImpl implements UserConverter{

    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserName()
        );
    }
}

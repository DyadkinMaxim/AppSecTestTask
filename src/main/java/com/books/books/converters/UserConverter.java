package com.books.books.converters;

import com.books.books.dto.UserDTO;
import com.books.books.models.User;

public interface UserConverter {
    UserDTO toDTO(User user);
}

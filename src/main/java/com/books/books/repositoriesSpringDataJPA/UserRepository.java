package com.books.books.repositoriesSpringDataJPA;

import com.books.books.models.User;
import com.books.books.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByUserNameContains(String name);
}

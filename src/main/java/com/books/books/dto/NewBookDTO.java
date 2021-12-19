package com.books.books.dto;

import com.books.books.models.User;
import com.books.books.models.Style;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBookDTO {
    private long id;
    private String bookName;
    private List<String> users;
    private List<String> styles;
    private List<String> comments;

}

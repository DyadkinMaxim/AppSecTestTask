package com.books.books.converters;

import com.books.books.dto.BookDTO;
import com.books.books.models.User;
import com.books.books.models.Book;
import com.books.books.models.Comment;
import com.books.books.models.Style;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookConverterImpl implements BookConverter {

    public BookDTO toDTO(Book book) {
        List<String> comments = new ArrayList<>();
        for (Comment comment : book.getComment()) {
            comments.add(comment.getCommentText());
        }
        return new BookDTO(book.getId(),
                book.getBookName(),
                book.getUser().getUserName(),
                book.getStyle().getStyleName(),
                comments);
    }

    public Book toBook(BookDTO bookDTO) {

        User user = new User();
        user.setUserName(bookDTO.getUserName());
        Style style = new Style();
        style.setStyleName(bookDTO.getStyleName());
        List<Comment> comments = new ArrayList<>();
        if(Objects.nonNull(bookDTO.getComments())) {
            for (String commentText : bookDTO.getComments()) {
                Comment comment = new Comment();
                comment.setCommentText(commentText);
                comments.add(comment);
            }
        }
        return new Book(bookDTO.getId(),
                bookDTO.getBookName(),
                user,
                style,
                comments);
    }
}

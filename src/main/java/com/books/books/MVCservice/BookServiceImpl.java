package com.books.books.MVCservice;

import com.books.books.models.User;
import com.books.books.models.Book;
import com.books.books.models.Comment;
import com.books.books.models.Style;
import com.books.books.repositoriesSpringDataJPA.UserRepository;
import com.books.books.repositoriesSpringDataJPA.BookRepository;
import com.books.books.repositoriesSpringDataJPA.CommentRepository;
import com.books.books.repositoriesSpringDataJPA.StyleRepository;
import com.books.books.rest.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements  BookService{

    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final StyleRepository styleRepository;
    private User existingUser;
    private Style existingStyle;

    public BookServiceImpl(BookRepository bookRepository,
                           CommentRepository commentRepository,
                           UserRepository userRepository,
                           StyleRepository styeRepository){
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.styleRepository = styeRepository;
    }


    @Transactional
    public Book save(Book book, List<Comment> comments){
        for(Comment comment : comments) {
            comment.setBook(book);
        }
        existingUser = userRepository.findByUserNameContains(book.getUser().getUserName());
        existingStyle = styleRepository.findByStyleNameContains(book.getStyle().getStyleName());
        book.setUser(existingUser);
        book.setStyle(existingStyle);
        book.setComment(comments);
        Book newBook = bookRepository.save(book);
        return newBook;
    }

    @Transactional
    public void update(Book book) {
        Book savedBook = bookRepository.findById(book.getId()).orElseThrow(NotFoundException::new);
        savedBook.setBookName(book.getBookName());
        existingUser = userRepository.findByUserNameContains(book.getUser().getUserName());
        existingStyle = styleRepository.findByStyleNameContains(book.getStyle().getStyleName());
        savedBook.setUser(existingUser);
        savedBook.setStyle(existingStyle);
    }
}

package com.books.books.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
@NamedEntityGraph(name = "comment-entity-graph", attributeNodes = {@NamedAttributeNode("comment")})
@NamedEntityGraph(name = "bookName-entity-graph", attributeNodes = {@NamedAttributeNode("bookName")})
@NamedEntityGraph(name = "user-entity-graph", attributeNodes = {@NamedAttributeNode("user")})
@NamedEntityGraph(name = "style-entity-graph", attributeNodes = {@NamedAttributeNode("style")})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book", nullable = false)
    private String bookName;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Style.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "style_id", nullable = false)
    private Style style;

    @Nullable
    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "book")
    private List<Comment> comment;
}

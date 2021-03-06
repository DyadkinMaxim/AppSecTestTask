/* --ROLLBACK
 drop table if exists comments;
 drop table if exists books;
 drop table if exists styles;
 drop table if exists users;
 */

create table styles (
                        ID LONG  NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        STYLE VARCHAR(255)
);

create table users (
                         ID LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         user VARCHAR(255)
);

create table books (
                       ID LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       BOOK VARCHAR(255),
                       user_ID LONG,
                       STYLE_ID LONG,
                       FOREIGN KEY (user_ID) REFERENCES users(ID) ON DELETE CASCADE,
                       FOREIGN KEY (STYLE_ID) REFERENCES styles(ID) ON DELETE CASCADE
);

create table comments (
                          ID LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          COMMENT VARCHAR(255),
                          BOOK_ID LONG,
                          FOREIGN KEY (BOOK_ID) REFERENCES books(ID) ON DELETE CASCADE
);
CREATE TABLE Movie
(
    id          INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(1000),
    grade       INT,
    likes       INT
);
CREATE TABLE review
(
    id      INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    movie_id INT                            NOT NULL,
    review  VARCHAR(2000)
);
ALTER TABLE review
    ADD CONSTRAINT review_movie_id
        foreign key (movie_id) REFERENCES movie (id)
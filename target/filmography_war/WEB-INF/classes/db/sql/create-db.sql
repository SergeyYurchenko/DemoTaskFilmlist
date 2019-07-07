

CREATE TABLE films
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    year int(4),
    genre VARCHAR(20),
    watched BIT DEFAULT false  NOT NULL,
    language VARCHAR(3)
);
CREATE UNIQUE INDEX films_title_index ON films (title);

INSERT INTO `films` (`title`,`year`,`genre`, watched,language)
VALUES
('Inception', 2010, 'sci-fi', 1,'UA'),
('The Lord of the Rings: The Fellowship of the Ring', 2001, 'fantasy', 1,'RU'),
('Tag', 2018, 'comedy', 0,'EN'),
('Gunfight at the O.K. Corral', 1957, 'western', 0,'UA'),
('Die Hard', 1988, 'action', 1,'UA');
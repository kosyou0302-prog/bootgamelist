CREATE TABLE IF NOT EXISTS game_genre (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    genre VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS game_list (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    genre_id BIGINT NOT NULL,
    title VARCHAR(20) NOT NULL,
    release_date date,
    maker VARCHAR(20),
    FOREIGN KEY (genre_id) REFERENCES game_genre(id)
);
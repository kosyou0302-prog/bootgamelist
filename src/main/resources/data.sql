MERGE INTO game_genre(id, genre)
KEY(id)
VALUES(1, 'RPG');

MERGE INTO game_list(id, genre_id, title, release_date, maker)
KEY(id)
VALUES(1, 1, 'ポケットモンスター銀', '1999-11-21', '任天堂');

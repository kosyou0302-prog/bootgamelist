package com.example.bootgamelist.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bootgamelist.Entites.Game;
import com.example.bootgamelist.Entites.Genre;

@Repository
public interface GameListRepository extends JpaRepository<Game, Long>{
    List<Game> findByGenreId(Long genreId);
}

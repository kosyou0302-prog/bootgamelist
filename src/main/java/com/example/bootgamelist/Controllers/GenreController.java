package com.example.bootgamelist.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bootgamelist.Entites.Game;
import com.example.bootgamelist.Entites.Genre;
import com.example.bootgamelist.Repository.GameListRepository;
import com.example.bootgamelist.Repository.GenreRepository;

@Controller
public class GenreController {

    @Autowired
    GameListRepository repository;
    @Autowired
    GenreRepository genreRepository;

    @GetMapping("/genre")
    public ModelAndView genre(@RequestParam Long genre_id, ModelAndView mav) {
        mav.setViewName("ht/genre");
        Genre genre = genreRepository.findById(genre_id).get();
        mav.addObject("genre", genre);
        List<Game> list = repository.findByGenreId(genre_id);
        mav.addObject("data",list);
        return mav;
    }

}

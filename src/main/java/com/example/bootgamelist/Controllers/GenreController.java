package com.example.bootgamelist.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bootgamelist.Entitys.Genre;
import com.example.bootgamelist.Repository.GenreRepository;

@Controller
public class GenreController {

    @Autowired
    GenreRepository repository;

    @GetMapping("/genre")
    public ModelAndView genre(@RequestParam Long genre_id, ModelAndView mav) {
        mav.setViewName("ht/genre");
        mav.addObject("title", "ジャンル");
        List<Genre> list = repository.findByGenreId(genre_id);
        mav.addObject("data",list);
        return mav;
    }

}

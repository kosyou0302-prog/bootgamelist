package com.example.bootgamelist.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bootgamelist.Entites.Game;
import com.example.bootgamelist.Repository.GameListRepository;

import jakarta.transaction.Transactional;

@Controller
public class GameController {

    @Autowired
    GameListRepository repository;

    @GetMapping("/gameList")
    public ModelAndView gameList(ModelAndView mav) {
        mav.setViewName("ht/gameList");
        mav.addObject("title","ゲームリスト");
        List<Game> list = repository.findAll();
        mav.addObject("data",list);
        return mav;
    }

    // 追加------------------------------------------------------------------------------------------------------
    @GetMapping("/gameInto")
    public ModelAndView gameInto(@ModelAttribute("formModel") Game game, ModelAndView mav) {
        mav.setViewName("ht/gameInto");
        mav.addObject("title", "追加");
        return mav;
    }
    @PostMapping("/gameInto")
    @Transactional
    public ModelAndView into(@ModelAttribute Game game) {
        repository.saveAndFlush(game);
        return new ModelAndView("redirect:/gameList");
    }

    // 更新------------------------------------------------------------------------------------------------------
    @GetMapping("/gameUpdate/{id}")
    public ModelAndView gameUpdate(@ModelAttribute("formModel") Game game, @PathVariable Long id, ModelAndView mav) {
        mav.setViewName("ht/gameUpdate");
        mav.addObject("title","更新");
        Optional<Game> data = repository.findById(id);
        mav.addObject("formModel", data.get());
        return mav;
    }
    @PostMapping("/gameUpdate")
    @Transactional
    public ModelAndView update(@ModelAttribute Game game) {
        repository.saveAndFlush(game);
        return new ModelAndView("redirect:/gameList");
    }
    // 削除------------------------------------------------------------------------------------------------------
    @GetMapping("/gameDelete/{id}")
    public ModelAndView gameDelete(@ModelAttribute("formModel") Game game, @PathVariable Long id, ModelAndView mav) {
        mav.setViewName("ht/gameDelete");
        mav.addObject("title", "削除");
        Optional<Game> data = repository.findById(id);
        mav.addObject("formModel", data.get());
        return mav;
    }
    @PostMapping("/gameDelete")
    @Transactional
    public ModelAndView delete(@RequestParam Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/gameList");
    }
}

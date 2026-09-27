package com.example.bootgamelist.Entites;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "game_list")
@Getter
@Setter

public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(length = 20)
    private String title;

    @ManyToOne(optional= false, fetch= FetchType.LAZY)
    @JoinColumn(name="genre_id")
    private Genre genre;

    @Column
    private LocalDate releaseDate;

    @Column(length = 20)
    private String maker;
}

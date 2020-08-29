package ru.netology.manager;

import lombok.Getter;
import ru.netology.domain.DisplayFilm;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    @Getter
    private int quantityFilms = 10;
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager() {
    }

    public AfishaManager(int quantityFilms, AfishaRepository repository) {
        this.repository = repository;
        if (quantityFilms > 0)
            this.quantityFilms = quantityFilms;
    }

    public void add(DisplayFilm film) {
        repository.save(film);
    }

    public DisplayFilm[] getShowLast() {
        DisplayFilm[] films = repository.findAll();

        int lengthDisplayFilm = Math.min(films.length, quantityFilms);
        DisplayFilm[] result = new DisplayFilm[lengthDisplayFilm];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
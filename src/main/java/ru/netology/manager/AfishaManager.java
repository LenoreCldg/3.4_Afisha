package ru.netology.manager;

import lombok.Getter;
import ru.netology.domain.DisplayFilm;

public class AfishaManager {
    @Getter
    private int quantityFilms = 10;
    private DisplayFilm[] films = new DisplayFilm[0];

    public AfishaManager() {
    }

    public AfishaManager(int quantityFilms) {
        if (quantityFilms > 0) {
            this.quantityFilms = quantityFilms;
        }
    }

    public void add(DisplayFilm film) {
        int length = films.length + 1;
        DisplayFilm[] tmp = new DisplayFilm[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public DisplayFilm[] getShowLast() {
        int lengthDisplayFilm = Math.min(films.length, quantityFilms);
        DisplayFilm[] result = new DisplayFilm[lengthDisplayFilm];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
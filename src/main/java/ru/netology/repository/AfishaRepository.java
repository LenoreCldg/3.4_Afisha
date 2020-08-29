package ru.netology.repository;

import ru.netology.domain.DisplayFilm;

public class AfishaRepository {
    private DisplayFilm[] films = new DisplayFilm[0];

    public DisplayFilm[] findAll(){
        return films;
    }

    public void save(DisplayFilm film) {
        int length = films.length + 1;
        DisplayFilm[] tmp = new DisplayFilm[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public DisplayFilm findById(int id) {
        for (DisplayFilm film : films) {
            if (film.getProductId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        DisplayFilm[] tmp = new DisplayFilm[length];
        int index = 0;
        for (DisplayFilm film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new DisplayFilm[0];
    }
}
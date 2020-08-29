package ru.netology.manager;

import lombok.Getter;
import ru.netology.domain.DisplayFilm;

public class AfishaManager {
    @Getter
    private DisplayFilm[] films = new DisplayFilm[0];

    public void add(DisplayFilm film) {
        int length = films.length + 1;
        DisplayFilm[] tmp = new DisplayFilm[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public DisplayFilm[] getAll() {
        DisplayFilm[] result = new DisplayFilm[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - i - 1;
            result[i] = films[index];
        }
        return result;
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
}
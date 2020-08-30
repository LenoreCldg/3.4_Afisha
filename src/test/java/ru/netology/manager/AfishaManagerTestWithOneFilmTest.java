package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.DisplayFilm;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTestWithOneFilmTest {
    private AfishaManager manager = new AfishaManager();
    private DisplayFilm first = new DisplayFilm(1, 1, "Бладшот", "Боевик", false);

    @BeforeEach
    public void showFilm(){
        manager.add(first);
    }

    @Test
    public void shouldDisplayOneFilm(){
        DisplayFilm[] actual = manager.getShowLast();
        DisplayFilm[] expected = new DisplayFilm[]{first};

        assertArrayEquals(expected, actual);

    }



}
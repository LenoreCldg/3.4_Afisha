package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.DisplayFilm;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTestNotExist {
    private AfishaManager manager = new AfishaManager();

    @Test
    public void shouldDisplayIfNotExist(){
        DisplayFilm[] actual = manager.getShowLast();
        DisplayFilm[] expected = new DisplayFilm[]{};

        assertArrayEquals(expected, actual);

    }

}
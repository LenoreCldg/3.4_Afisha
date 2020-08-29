package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.DisplayFilm;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    private DisplayFilm first = new DisplayFilm(1, 1, "first", 1, 1);
    private DisplayFilm second = new DisplayFilm(2, 2, "second", 2, 2);
    private DisplayFilm third = new DisplayFilm(3, 3, "third", 3, 3);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }


    @Test
    void shouldAdd() {
        DisplayFilm film = new DisplayFilm();
        manager.add(film);

        DisplayFilm[] expected = new DisplayFilm[]{film};
        assertArrayEquals(expected, manager.getFilms());
    }

    @Test
    void shouldRemoveIfExist() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        DisplayFilm[] actual = manager.getAll();
        DisplayFilm[] expected = new DisplayFilm[]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfNotExist() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        DisplayFilm[] actual = manager.getAll();
        DisplayFilm[] expected = new DisplayFilm[]{third, second, first};

        assertArrayEquals(expected, actual);
    }


}
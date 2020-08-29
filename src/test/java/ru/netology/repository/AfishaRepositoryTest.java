package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.DisplayFilm;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AfishaRepositoryTest {
    AfishaRepository repository = new AfishaRepository();

    private DisplayFilm first = new DisplayFilm(1, 1, "Бладшот", "Боевик", false);
    private DisplayFilm second = new DisplayFilm(2, 2, "Вперёд", "Мультфильм", false);
    private DisplayFilm third = new DisplayFilm(3, 3, "Отель - Белград", "Комедия", false);
    private DisplayFilm fourth = new DisplayFilm(4, 4, "Джентельмены", "Боевик", false);
    private DisplayFilm fifth = new DisplayFilm(5, 5, "Человек - Невидимка", "Ужасы", false);
    private DisplayFilm sixth = new DisplayFilm(6, 6, "Толли. Мировой тур", "Мультфильм", true);
    private DisplayFilm seventh = new DisplayFilm(7, 7, "Номер один", "Комедия", true);
    private DisplayFilm eight = new DisplayFilm(8, 8, "ИП Пирогова", "Комедия", true);
    private DisplayFilm ninth = new DisplayFilm(9, 9, "Ведьмак", "Ужасы", true);
    private DisplayFilm tenth = new DisplayFilm(10, 10, "Человек - паук", "Фантастика", true);


    @BeforeEach
    public void showsUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eight);
        repository.save(ninth);
        repository.save(tenth);
    }


    @Test
    public void shouldFindAll() {
        DisplayFilm[] actual = repository.findAll();
        DisplayFilm[] expected = {first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindIfNotExist(){
        int idToFind = 25;
        DisplayFilm actual = repository.findById(idToFind);

        assertNull(actual);
    }

    @Test
    void shouldFindById() {
        int idToFind = 7;
        DisplayFilm actual = repository.findById(idToFind);

        assertEquals(seventh, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 7;
        repository.removeById(idToRemove);

        DisplayFilm[] actual = repository.findAll();
        DisplayFilm[] expected = {first, second, third, fourth, fifth, sixth, eight, ninth, tenth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();

        DisplayFilm[] actual = repository.findAll();
        DisplayFilm[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdIfNotExist() {
        int idToRemove = 15;

        repository.removeById(idToRemove);

        DisplayFilm[] actual = repository.findAll();
        DisplayFilm[] expected = {first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};

        assertArrayEquals(expected, actual);
    }
}
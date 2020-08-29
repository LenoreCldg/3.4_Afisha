package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.DisplayFilm;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTestWithOneFilm {

    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    private DisplayFilm first = new DisplayFilm(1, 1, "Бладшот", "Боевик", false);

    @BeforeEach
    public void showFilm(){
        manager.add(first);
    }

    @Test
    public void shouldDisplayOneFilm(){
        DisplayFilm[] returned = new DisplayFilm[]{first};
        doReturn(returned).when(repository).findAll();

        DisplayFilm[] actual = manager.getShowLast();
        DisplayFilm[] expected = new DisplayFilm[]{first};

        assertArrayEquals(expected, actual);

    }



}
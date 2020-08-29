package ru.netology.manager;

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
class AfishaManagerTestNotExist {

    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

    @Test
    public void shouldDisplayIfNoFilm(){
        DisplayFilm[] returned = new DisplayFilm[]{};
        doReturn(returned).when(repository).findAll();

        DisplayFilm[] actual = manager.getShowLast();
        DisplayFilm[] expected = new DisplayFilm[]{};

        assertArrayEquals(expected, actual);

    }

}
package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MoviePoster;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieManagerTest {

    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MovieManager manager;

    MoviePoster first = new MoviePoster(1, 5, "Titanic", "melodrama");
    MoviePoster second = new MoviePoster(2, 6, "Carrier", "action");
    MoviePoster third = new MoviePoster(3, 7, "Matrix", "action");
    MoviePoster fourth = new MoviePoster(4, 8, "Rambo", "action");
    MoviePoster fifth = new MoviePoster(5, 9, "Curse", "horrors");

    @Test
    public void shouldNoAddedMovies() {
        MoviePoster[] returned = {};
        doReturn(returned).when(repository).findAll();
        MoviePoster[] expected = {};
        MoviePoster[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldOneAddedMovies() {
        MoviePoster[] returned = {first};
        doReturn(returned).when(repository).findAll();
        MoviePoster[] expected = {first};
        MoviePoster[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldFourAddedMovies() {
        MoviePoster[] returned = {first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        MoviePoster[] expected = {fourth, third, second, first};
        MoviePoster[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}


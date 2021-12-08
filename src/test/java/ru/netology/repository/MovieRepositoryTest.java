package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {


    MovieRepository movie = new MovieRepository();
    MoviePoster first = new MoviePoster(1, 5, "Titanic", "melodrama");
    MoviePoster second = new MoviePoster(2, 6, "Carrier", "action");
    MoviePoster third = new MoviePoster(3, 7, "Matrix", "action");
    MoviePoster fourth = new MoviePoster(4, 8, "Rambo", "action");
    MoviePoster fifth = new MoviePoster(5, 9, "Curse", "horrors");
    MoviePoster sixth = new MoviePoster(6, 10, "Terminator", "action");
    MoviePoster seventh = new MoviePoster(7, 11, "Venom", "action");
    MoviePoster eighth = new MoviePoster(8, 12, "Friends", "comedy");
    MoviePoster ninth = new MoviePoster(9, 13, "Harry Potter", "fantasy");
    MoviePoster tenth = new MoviePoster(10, 14, "Forrest Gump", "drama");
    MoviePoster eleventh = new MoviePoster(11, 15, "Shrek", "comedy");
    MoviePoster twelfth = new MoviePoster(12, 16, "Lost", "drama");


    @Test
    public void shouldNoAddedMovies() {
        MovieRepository movie = new MovieRepository();
        MoviePoster[] expected = {};
        MoviePoster[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneAddedMovies() {
        MovieRepository movie = new MovieRepository();
        movie.save(first);

        MoviePoster[] expected = {first};
        MoviePoster[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFiveAddedMovies() {
        MovieRepository movie = new MovieRepository();
        movie.save(first);
        movie.save(second);
        movie.save(third);
        movie.save(fourth);
        movie.save(fifth);

        MoviePoster[] expected = {first, second, third, fourth, fifth};
        MoviePoster[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldTenAddedMovies() {
        movie.save(first);
        movie.save(second);
        movie.save(third);
        movie.save(fourth);
        movie.save(fifth);
        movie.save(sixth);
        movie.save(seventh);
        movie.save(eighth);
        movie.save(ninth);
        movie.save(tenth);

        MoviePoster[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        MoviePoster[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        MoviePoster[] actual = movie.removeAll();
        MoviePoster[] expected = new MoviePoster[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        movie.save(first);
        movie.save(second);
        movie.removeById(2);

        MoviePoster[] actual = movie.findAll();
        MoviePoster[] expected = {first};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {
        movie.save(first);
        movie.save(second);

        MoviePoster actual = movie.findById(1);
        MoviePoster expected = first;

        assertEquals(expected, actual);
    }

}
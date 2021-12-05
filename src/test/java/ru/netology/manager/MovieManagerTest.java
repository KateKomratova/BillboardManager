package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

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
        MovieManager movie = new MovieManager(5);
        MoviePoster[] expected = {};
        MoviePoster[] actual = movie.getLastAdd();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneAddedMovies() {
        MovieManager movie = new MovieManager(8);
        movie.save(first);

        MoviePoster[] expected = {first};
        MoviePoster[] actual = movie.getLastAdd();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFiveAddedMovies() {
        MovieManager movie = new MovieManager(9);
        movie.save(first);
        movie.save(second);
        movie.save(third);
        movie.save(fourth);
        movie.save(fifth);

        MoviePoster[] expected = {fifth, fourth, third, second, first};
        MoviePoster[] actual = movie.getLastAdd();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNineAddedMovies() {
        MovieManager movie = new MovieManager();
        movie.save(first);
        movie.save(second);
        movie.save(third);
        movie.save(fourth);
        movie.save(fifth);
        movie.save(sixth);
        movie.save(seventh);
        movie.save(eighth);
        movie.save(ninth);

        MoviePoster[] expected = {ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MoviePoster[] actual = movie.getLastAdd();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTenAddedMovies() {
        MovieManager movie = new MovieManager();
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

        MoviePoster[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MoviePoster[] actual = movie.getLastAdd();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMoreLimit() {
        MovieManager movie = new MovieManager();
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
        movie.save(eleventh);
        movie.save(twelfth);
        MoviePoster[] expected = {twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        MoviePoster[] actual = movie.getLastAdd();

        assertArrayEquals(expected, actual);
    }
}

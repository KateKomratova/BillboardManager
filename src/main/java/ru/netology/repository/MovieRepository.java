package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MoviePoster;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieRepository {
    private MoviePoster[] movies = new MoviePoster[0];

    public MoviePoster[] findAll() {
        return movies;
    }

    public void save(MoviePoster movie) {
        int length = movies.length + 1;
        MoviePoster[] tmp = new MoviePoster[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MoviePoster findById(int id) {
        for (MoviePoster movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public MoviePoster[] removeById(int id) {
        int length = movies.length - 1;
        MoviePoster[] tmp = new MoviePoster[length];
        int index = 0;
        for (MoviePoster movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
        return movies;
    }

    public MoviePoster[] removeAll() {
        movies = new MoviePoster[0];

        return movies;
    }
}
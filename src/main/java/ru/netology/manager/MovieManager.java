package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MoviePoster;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieManager {
    private MoviePoster[] movies = new MoviePoster[0];
    private int limitMovie = 10;

    public MovieManager(int limitMovie) {
        this.limitMovie = limitMovie;
    }

    public void save(MoviePoster movie) {
        int length = movies.length + 1;
        MoviePoster[] tmp = new MoviePoster[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MoviePoster[] getLastAdd() {
        int resultLength;
        if (movies.length < limitMovie) {
            resultLength = movies.length;
        } else {
            resultLength = limitMovie;
        }
        MoviePoster[] result = new MoviePoster[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}




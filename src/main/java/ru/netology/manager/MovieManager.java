package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MoviePoster;
import ru.netology.repository.MovieRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieManager {
    private MovieRepository repository;
    private int limitMovie = 10;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieManager(int limitMovie) {
        this.limitMovie = limitMovie;
    }

    public void save(MoviePoster movie) {
        repository.save(movie);
    }

    public MoviePoster[] findById(int id) {
        repository.findById(id);

        return new MoviePoster[0];
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void remoteAll() {
        repository.removeAll();
    }

    public MoviePoster[] getLastAdd() {
        MoviePoster[] movies = repository.findAll();
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





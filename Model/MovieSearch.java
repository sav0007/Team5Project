package com.company.Model;

/**
 * This class is used to perform the movie search functionality by filtering
 * and creating sub-movie databases and retrieving the results.
 *
 * Example usage:
 * final MovieSearch search = new MovieSearch(movieDb);
 * search.filterByTitle("Batman");
 * search.filterByMPAA("PG-13");
 * ...
 * search.getResults();
 */
public class MovieSearch {
    private MovieDatabase movies;

    public MovieSearch(final MovieDatabase movies) {
        this.movies = movies;
    }

    public void filterMoviesByTitle(final String title) {
        if (title != null && !title.isBlank()) {
            this.movies = this.movies.filterByTitle(title);
        }
    }

    public void filterMoviesByMPAA(final String mpaa) {
        if (mpaa != null && !mpaa.isBlank()) {
            this.movies = this.movies.filterMPAA(mpaa);
        }
    }

    public MovieDatabase getResults() {
        return this.movies;
    }
}

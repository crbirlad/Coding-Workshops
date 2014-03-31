package com.oracle.workshop.model;

import com.oracle.workshop.model.impl.SimpleMovieFinder;
import com.oracle.workshop.model.showbiz.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class MovieLister {
    public List<Movie> getMoviesNewerThan(int year) {
        SimpleMovieFinder finder = new SimpleMovieFinder();
        List<Movie> movies = finder.findAll();

        List<Movie> results = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getYear() >= year) {
                results.add(movie);
            }
        }

        return results;
    }

    public static List<Movie> getMoviesInYearRange(List<Movie> movies, int startYear, int endYear) {
        List<Movie> results = new ArrayList<>();

        for (Movie movie : movies) {
            if (startYear <= movie.getYear() && movie.getYear() <= endYear) {
                results.add(movie);
            }
        }

        return results;
    }

    public static void printMovies(List<Movie> movies, CheckMovie tester) {
        for (Movie movie : movies) {
            if (tester.test(movie)) {
                System.out.println(movie);
            }
        }
    }

    public static void printMoviesWithPredicate(List<Movie> movies, Predicate<Movie> tester) {
        for (Movie movie : movies) {
            if (tester.test(movie)) {
                System.out.println(movie);
            }
        }
    }

    public static void processMovies(List<Movie> movies,
                                     Predicate<Movie> tester,
                                     Consumer<Movie> block) {
        for (Movie movie : movies) {
            if (tester.test(movie)) {
                block.accept(movie);
            }
        }
    }

    public static <X,Y> void processMoviesWithFunction(Iterable<X> source,
                                     Predicate<X> tester,
                                     Function<X, Y> mapper,
                                     Consumer<Y> block) {
        for (X x : source) {
            if (tester.test(x)) {
                Y data = mapper.apply(x);
                block.accept(data);
            }
        }
    }

    public static void main(String args[]) {
        SimpleMovieFinder finder = new SimpleMovieFinder();
        MovieLister lister = new MovieLister();
        System.out.println(lister.getMoviesNewerThan(1990));

        List<String> results = new ArrayList<>();

        getMoviesInYearRange(finder.findAll(), 2004, 2008);

//        printMovies(finder.findAll(), new CheckMovie() {
//                    public boolean test(Movie movie) {
//                        return movie.getGenre() == Movie.Genre.DRAMA
//                                && movie.getYear() >= 2003
//                                && movie.getYear() <= 2008;
//                    }
//                }
//        );

//        printMovies(
//                finder.findAll(),
//                (Movie movie) -> movie.getGenre() == Movie.Genre.ACTION
//                        && movie.getYear() >= 2003
//                        && movie.getYear() <= 2008
//        );

//        printMoviesWithPredicate(
//                finder.findAll(),
//                movie -> movie.getGenre() == Movie.Genre.ACTION
//                        && movie.getYear() >= 2003
//                        && movie.getYear() <= 2008
//        );

//        processMovies(
//                finder.findAll(),
//                movie -> movie.getGenre() == Movie.Genre.ACTION
//                        && movie.getYear() >= 2003
//                        && movie.getYear() <= 2008,
//                movie -> System.out.println(movie)
//        );

//        processMoviesWithFunction(
//                finder.findAll(),
//                movie -> movie.getGenre() == Movie.Genre.ACTION
//                        && movie.getYear() >= 2003
//                        && movie.getYear() <= 2008,
//                movie -> movie.getDirector(),
//                director -> System.out.println(director)
//        );



//        finder.findAll()
//                .stream()
//                .filter(
//                        movie -> (movie.getGenre() == Movie.Genre.ACTION || movie.getGenre() == Movie.Genre.DRAMA)
//                                && movie.getYear() >= 1990
//                                && movie.getYear() <= 2020)
//                .map(movie -> movie.getTitle())
//                .forEach(title -> results.add(title));

        System.out.println(results);
    }
}

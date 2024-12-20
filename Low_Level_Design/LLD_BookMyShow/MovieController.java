package Low_Level_Design.LLD_BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Low_Level_Design.LLD_BookMyShow.Enums.City;

public class MovieController {
  Map<City, List<Movie>> cityVsMovies;
  List<Movie> allMovies;

  public MovieController() {
    cityVsMovies = new HashMap<>();
    allMovies = new ArrayList<>();
  }

  /**
   * Adds a movie to the list of movies in the system.
   * The movie is added to the list of all movies as well as the list of movies
   * specific to the given city.
   *
   * @param movie the movie to add.
   * @param city the city to add the movie to.
   */
  public void addMovie(Movie movie, City city) {

    allMovies.add(movie);

    List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
    movies.add(movie);
    cityVsMovies.put(city, movies);
  }


  /**
   * Retrieves a movie from the list of all movies by its name.
   *
   * @param movieName the name of the movie to search for.
   * @return the Movie object with the specified name, or null if no such movie is found.
   */

  public Movie getMovieByName(String movieName) {

    for (Movie movie : allMovies) {
      if ((movie.getMovieName()).equals(movieName)) {
        return movie;
      }
    }
    return null;

  }

  /**
   * Retrieves the list of movies available in a given city.
   *
   * @param city the city to retrieve movies for.
   * @return the list of movies available in the given city.
   */
  public List<Movie> getMoviesByCity(City city) {
    return cityVsMovies.get(city);
  }
}

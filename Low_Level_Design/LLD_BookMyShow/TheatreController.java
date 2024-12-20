package Low_Level_Design.LLD_BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Low_Level_Design.LLD_BookMyShow.Enums.City;

public class TheatreController {
  Map<City, List<Theatre>> cityVsTheatre;
  List<Theatre> allTheatre;

  public TheatreController() {
    cityVsTheatre = new HashMap<>();
    allTheatre = new ArrayList<>();
  }

/**
 * Adds a theatre to the system.
 * 
 * The theatre is added to the list of all theatres in the system as well as
 * to the list of theatres specific to the given city.
 *
 * @param theatre the theatre to add.
 * @param city the city to associate the theatre with.
 */

  public void addTheatre(Theatre theatre, City city) {

    allTheatre.add(theatre);

    List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
    theatres.add(theatre);
    cityVsTheatre.put(city, theatres);
  }

  /**
   * Retrieves the list of all shows for a given movie in a given city.
   * 
   * @param movie the movie to retrieve shows for.
   * @param city the city to retrieve shows for.
   * @return a map of theatres to list of shows for the given movie in the given city.
   */
  public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
    Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
    List<Theatre> theatres = cityVsTheatre.get(city);

    for(Theatre theatre: theatres) {
      List<Show> givenMovieShows = new ArrayList<>();
      List<Show> shows = theatre.getShows();

      for(Show show: shows){
        if(show.movie.getMovieId() == movie.getMovieId()){
          givenMovieShows.add(show);
        }
      }

      if(!givenMovieShows.isEmpty()){
        theatreVsShows.put(theatre, givenMovieShows);
      }
    }
    return theatreVsShows;
  }
}

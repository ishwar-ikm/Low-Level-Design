package Low_Level_Design.LLD_BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Low_Level_Design.LLD_BookMyShow.Enums.City;
import Low_Level_Design.LLD_BookMyShow.Enums.SeatCategory;

public class BookMyShow {
  MovieController movieController;
  TheatreController theatreController;

  public BookMyShow() {
    movieController = new MovieController();
    theatreController = new TheatreController();
  }

  /**
   * Main method to demonstrate booking functionality
   * @param args 
   */
  public static void main(String[] args) {
    BookMyShow bookMyShow = new BookMyShow();
    bookMyShow.initialize();

    // book seats for user1
    bookMyShow.createBooking(City.Bangalore, "Gravity");

    // book seats for user2
    bookMyShow.createBooking(City.Bangalore, "Gravity");
  }

  /**
   * Creates a booking for a specified movie in a given city.
   * 
   * This method performs the following steps:
   * 1. Searches for movies available in the specified city.
   * 2. Selects the specified movie from the list of available movies.
   * 3. Retrieves all shows of the selected movie in the specified city's theatres.
   * 4. Chooses a particular show that the user is interested in.
   * 5. Attempts to select a seat for the show.
   *    - If the seat is available, it books the seat and confirms the booking.
   *    - If the seat is already booked, it notifies the user and aborts the process.
   * 
   * @param userCity The city where the user wants to watch the movie.
   * @param movieName The name of the movie the user wants to book.
   */

  private void createBooking(City userCity, String movieName) {

    // 1. search movie by my location
    List<Movie> movies = movieController.getMoviesByCity(userCity);

    // 2. select the movie which you want to see. i want to see Baahubali
    Movie interestedMovie = null;
    for (Movie movie : movies) {

      if ((movie.getMovieName()).equals(movieName)) {
        interestedMovie = movie;
      }
    }

    // 3. get all show of this movie in Bangalore location
    Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

    // 4. select the particular show user is interested in
    Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
    List<Show> runningShows = entry.getValue();
    Show interestedShow = runningShows.get(0);

    // 5. select the seat
    int seatNumber = 30;
    List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
    if (!bookedSeats.contains(seatNumber)) {
      bookedSeats.add(seatNumber);
      // startPayment
      Booking booking = new Booking();
      List<Seat> myBookedSeats = new ArrayList<>();
      for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
        if (screenSeat.getSeatId() == seatNumber) {
          myBookedSeats.add(screenSeat);
        }
      }
      booking.setBookedSeats(myBookedSeats);
      booking.setShow(interestedShow);
    } else {
      // throw exception
      System.out.println("seat already booked, try again");
      return;
    }

    System.out.println("BOOKING SUCCESSFUL");
  }

  /**
   * Initializes the system by creating movies and theatres.
   */
  private void initialize() {
    createMovies();
    createTheatre();
  }

  /**
   * Creates movies and adds them to the system.
   * 
   * The movies are added against the cities they are available in.
   */
  private void createMovies() {
    // create Movies1
    Movie greenMile = new Movie();
    greenMile.setMovieId(1);
    greenMile.setMovieName("Green Mile");
    greenMile.setMovieDuration(189);

    // create Movies2
    Movie gravity = new Movie();
    gravity.setMovieId(2);
    gravity.setMovieName("Gravity");
    gravity.setMovieDuration(90);

    // add movies against the cities
    movieController.addMovie(greenMile, City.Bangalore);
    movieController.addMovie(greenMile, City.Delhi);
    movieController.addMovie(gravity, City.Bangalore);
    movieController.addMovie(gravity, City.Delhi);
  }

  /**
   * Creates theatres and adds them to the system.
   * 
   * The theatres are added against the cities they are located in.
   * The shows for each theatre are also created and added to the theatre.
   */
  private void createTheatre() {
    Movie gravity = movieController.getMovieByName("Gravity");
    Movie greenMile = movieController.getMovieByName("Green Mile");

    Theatre inoxTheatre = new Theatre();
    inoxTheatre.setTheatreId(1);
    inoxTheatre.setScreen(createScreen());
    inoxTheatre.setCity(City.Bangalore);
    List<Show> inoxShows = new ArrayList<>();
    Show inoxMorningShow = createShows(1, inoxTheatre.getScreen().get(0), gravity, 8);
    Show inoxEveningShow = createShows(2, inoxTheatre.getScreen().get(0), greenMile, 16);
    inoxShows.add(inoxMorningShow);
    inoxShows.add(inoxEveningShow);
    inoxTheatre.setShows(inoxShows);

    Theatre pvrTheatre = new Theatre();
    pvrTheatre.setTheatreId(2);
    pvrTheatre.setScreen(createScreen());
    pvrTheatre.setCity(City.Delhi);
    List<Show> pvrShows = new ArrayList<>();
    Show pvrMorningShow = createShows(3, pvrTheatre.getScreen().get(0), gravity, 13);
    Show pvrEveningShow = createShows(4, pvrTheatre.getScreen().get(0), greenMile, 20);
    pvrShows.add(pvrMorningShow);
    pvrShows.add(pvrEveningShow);
    pvrTheatre.setShows(pvrShows);

    theatreController.addTheatre(inoxTheatre, City.Bangalore);
    theatreController.addTheatre(pvrTheatre, City.Delhi);
  }

  /**
   * Creates a screen and adds seats to it.
   * 
   * @return a list containing the created screen.
   */
  private List<Screen> createScreen() {
    List<Screen> screens = new ArrayList<>();
    Screen screen1 = new Screen();
    screen1.setScreenId(1);
    screen1.setSeats(createSeats());
    screens.add(screen1);

    return screens;
  }

/**
 * Creates a new show with the given details.
 *
 * @param showId the unique identifier for the show
 * @param screen the screen where the show will be displayed
 * @param movie the movie to be shown
 * @param showStartTime the start time of the show
 * @return the created Show object
 */

  private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {
    Show show = new Show();
    show.setShowId(showId);
    show.setScreen(screen);
    show.setMovie(movie);
    show.setShowStartTime(showStartTime);
    return show;
  }

/**
 * Creates a list of seats with different categories.
 *
 * The function initializes a list of 100 seats, where seats with IDs from 0 to 39 
 * are categorized as SILVER, seats with IDs from 40 to 69 are categorized as GOLD, 
 * and seats with IDs from 70 to 99 are categorized as PLATINUM.
 *
 * @return a list containing all the created seats with their respective categories.
 */

  private List<Seat> createSeats() {
    List<Seat> seats = new ArrayList<>();

    for (int i = 0; i < 40; i++) {
      Seat seat = new Seat();
      seat.setSeatId(i);
      seat.setSeatCategory(SeatCategory.SILVER);
      seats.add(seat);
    }

    for (int i = 40; i < 70; i++) {
      Seat seat = new Seat();
      seat.setSeatId(i);
      seat.setSeatCategory(SeatCategory.GOLD);
      seats.add(seat);
    }

    for (int i = 70; i < 100; i++) {
      Seat seat = new Seat();
      seat.setSeatId(i);
      seat.setSeatCategory(SeatCategory.PLATINUM);
      seats.add(seat);
    }

    return seats;
  }

}

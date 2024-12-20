package Low_Level_Design.LLD_CarRentalSystem;

import java.sql.Date;

import Low_Level_Design.LLD_CarRentalSystem.product.Vehicle;

public class Reservation {
  public int reservationId;
  User user;
  Vehicle vehicle;
  Date bookingDate;
  Date dateBookedFrom;
  Date dateBookedTo;
  Long fromTimeStamp;
  Long toTimeStamp;
  Location pickUpLocation;
  Location dropLocation;
  ReservationType reservationType;
  ReservationStatus reservationStatus;
  Location location;

  /**
   * This method creates a new reservation for the given user and vehicle.
   * It will assign a new reservation id to the reservation and set the reservation status to SCHEDULED and reservation type to DAILY.
   * 
   * @param user the user who is making the reservation
   * @param vehicle the vehicle that the user wants to reserve
   * @return the reservation id of the newly created reservation
   */
  public int createReserve(User user, Vehicle vehicle) {

    // generate new id
    reservationId = 12232;
    this.user = user;
    this.vehicle = vehicle;
    reservationType = ReservationType.DAILY;
    reservationStatus = ReservationStatus.SCHEDULED;

    return reservationId;
  }

  // Methods can be created to update and delete the details of the reservation
}

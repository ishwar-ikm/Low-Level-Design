package Low_Level_Design.LLD_CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.LLD_CarRentalSystem.product.Vehicle;
import Low_Level_Design.LLD_CarRentalSystem.product.VehicleType;

public class Store {
  public int storeId;
  VehicleInventoryManagement inventoryManagement;
  Location storeLocation;
  List<Reservation> reservations = new ArrayList<>();

  /**
   * Retrieves a list of all vehicles of the given type in the store's inventory.
   *
   * @param vehicleType the type of vehicles to retrieve
   * @return a list of vehicles of the given type
   */
  public List<Vehicle> getVehicles(VehicleType vehicleType) {
    return inventoryManagement.getVehicles(vehicleType);
  }

  // addVehicles, update vehicles, use inventory management to update those.

  /**
   * Sets the store's vehicle inventory to the given list of vehicles. This will
   * replace any existing inventory.
   *
   * @param vehicles the list of vehicles to set as the store's inventory
   */
  public void setVehicles(List<Vehicle> vehicles) {
    inventoryManagement = new VehicleInventoryManagement(vehicles);
  }

  /**
   * Creates a new reservation for the given vehicle and user, and adds it to the
   * store's list of reservations.
   *
   * @param vehicle the vehicle to reserve
   * @param user the user making the reservation
   * @return the newly created reservation
   */
  public Reservation createReservation(Vehicle vehicle, User user) {
    Reservation reservation = new Reservation();
    reservation.createReserve(user, vehicle);
    reservations.add(reservation);
    return reservation;
  }

  /**
   * Completes a reservation for the given reservation ID and removes it from the store's
   * list of reservations.
   *
   * @param reservationID the ID of the reservation to complete
   * @return true if the reservation was found and completed successfully, false otherwise
   */
  public boolean completeReservation(int reservationID) {
    // take out the reservation from the list and call complete the reservation method.
    return true;
  }

  // update reservation

}

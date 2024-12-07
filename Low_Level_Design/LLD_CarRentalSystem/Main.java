package Low_Level_Design.LLD_CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.LLD_CarRentalSystem.product.Car;
import Low_Level_Design.LLD_CarRentalSystem.product.Vehicle;
import Low_Level_Design.LLD_CarRentalSystem.product.VehicleType;

public class Main {
  /**
   * This is the main method which demonstrates the complete workflow of the Car Rental System
   * 
   * The workflow is as follows:
   * 1. User comes
   * 2. User searches for store based on location
   * 3. User selects the vehicle of interest
   * 4. User reserves the vehicle
   * 5. User pays the bill
   * 6. User completes the reservation and submits the vehicle
   * 
   * @param args
   */
  public static void main(String args[]) {

    List<User> users = addUsers();
    List<Vehicle> vehicles = addVehicles();
    List<Store> stores = addStores(vehicles);

    VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

    // 0. User comes
    User user = users.get(0);

    // 1. user search store based on location
    Location location = new Location(403012, "Bangalore", "Karnataka", "India");
    Store store = rentalSystem.getStore(location);

    // 2. get All vehicles you are interested in (based upon different filters)
    List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

    // 3.reserving the particular vehicle
    Reservation reservation = store.createReservation(storeVehicles.get(0), user);

    // 4. generate the bill
    Bill bill = new Bill(reservation);

    // 5. make payment
    Payment payment = new Payment();
    payment.payBill(bill);

    // 6. trip completed, submit the vehicle and close the reservation
    store.completeReservation(reservation.reservationId);

  }

  /**
   * This method adds vehicles to the system. For now, we have only cars as the vehicle type.
   * The vehicle ID is set and the vehicle type is set to CAR
   * 
   * @return a List of Vehicle objects
   */
  public static List<Vehicle> addVehicles() {

    List<Vehicle> vehicles = new ArrayList<>();

    Vehicle vehicle1 = new Car();
    vehicle1.setVehicleID(1);
    vehicle1.setVehicleType(VehicleType.CAR);

    Vehicle vehicle2 = new Car();
    vehicle1.setVehicleID(2);
    vehicle1.setVehicleType(VehicleType.CAR);

    vehicles.add(vehicle1);
    vehicles.add(vehicle2);

    return vehicles;
  }

  /**
   * This method adds users to the system. For now, we have only one user.
   * The user ID is set to 1.
   * 
   * @return a List of User objects
   */
  public static List<User> addUsers() {

    List<User> users = new ArrayList<>();
    User user1 = new User();
    user1.setUserId(1);

    users.add(user1);
    return users;
  }

  /**
   * This method adds stores to the system. For now, we have only one store.
   * The store ID is set to 1 and the vehicles that are added to the store
   * are the ones passed as a parameter.
   *
   * @return a List of Store objects
   */
  public static List<Store> addStores(List<Vehicle> vehicles) {

    List<Store> stores = new ArrayList<>();
    Store store1 = new Store();
    store1.storeId = 1;
    store1.setVehicles(vehicles);

    stores.add(store1);
    return stores;
  }

}

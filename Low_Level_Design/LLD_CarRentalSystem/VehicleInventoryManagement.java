package Low_Level_Design.LLD_CarRentalSystem;

import java.util.List;

import Low_Level_Design.LLD_CarRentalSystem.product.Vehicle;
import Low_Level_Design.LLD_CarRentalSystem.product.VehicleType;

public class VehicleInventoryManagement {
  List<Vehicle> vehicles;

  VehicleInventoryManagement(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

/**
 * Retrieves a list of vehicles that match the specified vehicle type.
 *
 * @param vehicleType the type of vehicles to filter and retrieve
 * @return a list of vehicles of the specified type
 */
  public List<Vehicle> getVehicles(VehicleType vehicleType) {
    // filtering logic comes here
    return vehicles;
  }

/**
 * Sets the inventory of vehicles to the provided list of vehicles.
 * This will overwrite any existing inventory.
 *
 * @param vehicles the new list of vehicles to set as the inventory
 */
  public void setVehicles(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

}

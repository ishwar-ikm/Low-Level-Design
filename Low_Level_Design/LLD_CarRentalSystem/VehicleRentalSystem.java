package Low_Level_Design.LLD_CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {
  List<Store> storeList;
  List<User> userList;

  public VehicleRentalSystem(List<Store> stores, List<User> users) {
    this.storeList = stores;
    this.userList = users;
  }

  /**
   * Retrieves a store based on the given location.
   *
   * This method filters the store list to find and return a store
   * that matches the specified location. Currently, it returns the 
   * first store in the list as a placeholder.
   *
   * @param location the location to filter the stores by
   * @return the store that matches the specified location
   */
  public Store getStore(Location location) {
    // based on location, we will filter out the Store from storeList.
    return storeList.get(0);
  }

  // addUsers

  // remove users

  // add stores

  // remove stores

}

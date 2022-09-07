package lesson_3;

import java.util.HashSet;
import java.util.Set;

public class CarRegistry<Car extends Vehicle> implements Registry<Car> {
  private static CarRegistry carRegistry;
  Set<Car> cars = new HashSet<>();

  private CarRegistry() {
  }

  public static CarRegistry getCarRegistry() {
    if (carRegistry == null) {
      carRegistry = new CarRegistry();
    }
    return carRegistry;
  }

  @Override
  public void register(Car vehicle) {
    vehicle.setRegistered(true);
    cars.add(vehicle);
  }

  @Override
  public boolean isRegistered(Car vehicle) {
    for (Car car : cars) if (car.equals(vehicle)) return true;
    return false;
  }
}

package lesson_3;

import java.util.HashSet;

public abstract class Car extends Vehicle implements refillResource {
  private String name;
  private TypeOfCar type;
  private HashSet<Person> passengers;

  private int percentageOfResource = 10;
  private int countOfPassengers = 0;

  private static int countOfCars = 0;

  public Car(TypeOfCar type, int maxSpeed, String name) {
    super(maxSpeed);
    this.name = name;
    this.type = type;
    this.passengers = new HashSet<Person>(type.getMaxCountOfPassengers());
    countOfCars++;
  }

  public void becomeAPassenger(Person person) {
    if (countOfPassengers < type.getMaxCountOfPassengers()) {
      System.out.println("Плюс один пассажир");
      countOfPassengers++;
      passengers.add(person);
      person.setState(StateOfPerson.PASSENGER);
    } else System.out.println("В машине нет места");
  }

  public void getOutPassenger(Person person) {
    countOfPassengers--;
    passengers.remove(person);
    person.setState(StateOfPerson.WALKER);
  }

  public static int getCountOfCars() {
    return countOfCars;
  }
}

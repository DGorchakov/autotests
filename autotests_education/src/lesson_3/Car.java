package lesson_3;

import java.util.HashSet;

public abstract class Car extends Vehicle implements topUpResource{
  private String name;
  private TypeOfCar type;
  private HashSet<Person> passangers;

  private int persentageOfResource = 10;
  private int countOfPassangers = 0;

  private static int countOfCars = 0;

  public Car(TypeOfCar type, int maxSpeed, String name) {
    super(maxSpeed);
    this.name = name;
    this.type = type;
    this.passangers = new HashSet<Person>(type.getMaxCountOfPassangers());
    countOfCars++;
  }

  public void becomeAPassanger(Person person){
    if (countOfPassangers<type.getMaxCountOfPassangers()) {
      System.out.println("Плюс один пассажир");
      countOfPassangers++;
      passangers.add(person);
      person.setState(StateOfPerson.PASSENGER);
    }
    else System.out.println("В машине нет места");
  }

  public void getOutPassanger(Person person){
    countOfPassangers--;
    passangers.remove(person);
    person.setState(StateOfPerson.WALKER);
  }

  public static int getCountOfCars() {
    return countOfCars;
  }
}

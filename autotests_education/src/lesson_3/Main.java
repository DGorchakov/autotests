package lesson_3;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    FordFocus fordFocus = new FordFocus("Белый", TypeOfResources.PETROL);
    FordFocus anotherFordFocus = new FordFocus("Черный", TypeOfResources.DIESEL);
    Bicycle bicycle = new Bicycle("Черный");

    Person person = new Person(500);
    Person anotherPerson = new Person(700);
    ArrayList<Person> passangers = new ArrayList<>();
    for (int k = 0; k < 10; k++) {
      passangers.add(new Person(200));
    }
    fordFocus.becomeADriver(anotherPerson);
    fordFocus.getOutDriver();
    fordFocus.becomeADriver(anotherPerson);

    fordFocus.printModel();
    anotherFordFocus.printModel();
    bicycle.printModel();

    CarRegistry<Car> carRegistry = CarRegistry.getCarRegistry();
    carRegistry.register(fordFocus);
    System.out.println(carRegistry.isRegistered(fordFocus));
    System.out.println(carRegistry.isRegistered(anotherFordFocus));
  }
}

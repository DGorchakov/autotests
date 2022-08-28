package lesson_3;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    FordFocus fordFocus = new FordFocus("Белый", TypeOfResources.PETROL);
    FordFocus fordFocus1 = new FordFocus("Черный", TypeOfResources.DIESEL);
    Bicycle bicycle = new Bicycle("Черный");

    Person person = new Person(500);
    Person person1 = new Person(700);
    ArrayList<Person> passangers = new ArrayList<>();
    for (int k =0; k<10; k++){
      passangers.add(new Person(200));
    }
    fordFocus.becomeADriver(person1);
    fordFocus.getOutDriver();
    fordFocus.becomeADriver(person1);
    for (Person passanger : passangers){
      fordFocus.becomeAPassanger(person);
    }
  }
}

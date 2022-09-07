package lesson_3;

public enum TypeOfCar {
  MICRO("Микро", 1, "B"),
  SEDAN("Седан", 3, "B"),
  MINIVAN("Минивен", 5, "B"),
  TRACK("Грузовик", 1, "C"),
  BUS("Автобус", 32, "D");

  private String name;
  private int maxCountOfPassengers;
  private String licence;

  TypeOfCar(String name, int maxCountOfPassangers, String licence) {
    this.name = name;
    this.maxCountOfPassengers = maxCountOfPassangers;
    this.licence = licence;
  }

  public String getName() {
    return name;
  }

  public int getMaxCountOfPassengers() {
    return maxCountOfPassengers;
  }

  public String getLicence() {
    return licence;
  }
}

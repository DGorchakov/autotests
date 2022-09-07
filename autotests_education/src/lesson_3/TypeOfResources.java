package lesson_3;

public enum TypeOfResources {
  PETROL("бензин", 7),
  DIESEL("дизель", 6),
  ELECTRICITY("электричество", 5),
  FOOD("еда", 1);

  private String name;
  private int pricePerPercent;

  TypeOfResources(String name, int pricePerPercent) {
    this.name = name;
    this.pricePerPercent = pricePerPercent;
  }

  public String getName() {
    return name;
  }

  public int getPricePerPercent() {
    return pricePerPercent;
  }
}

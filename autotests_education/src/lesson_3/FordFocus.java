package lesson_3;

public class FordFocus extends Car implements refillResource {

  private String color;
  private TypeOfResources typeOfEngine;

  public FordFocus(String color, TypeOfResources typeOfEngine) {
    super(TypeOfCar.SEDAN, 200, "ФордФокус");
    this.color = color;
    this.typeOfEngine = typeOfEngine;
  }

  @Override
  public void refillResource(int percent, Person buyer) {
    if (typeOfEngine.getPricePerPercent()* percent < buyer.getAmountOfMoney()) System.out.println("У плательщика недостаточно средств");
    else if (this.getLevelOfResource() + percent > 100) {
      System.out.println("Объем " + typeOfEngine.getName() + " в " + percent + " % не помещается, заполняем до 100%");
      int cost = typeOfEngine.getPricePerPercent() * (100 - this.getLevelOfResource());
      this.setPersentageOfResource(100);
      buyer.spendMoney(cost);
      System.out.println("С Вас списано : " + cost);
    }
    else {
      this.setPersentageOfResource(this.getLevelOfResource() + percent);
      buyer.spendMoney(percent * typeOfEngine.getPricePerPercent());
    }
  }

  @Override
  public void printModel() {
    System.out.println("Модель фордфокус, тип двигателя: " + this.typeOfEngine + ", цвет : " + this.color);
  }
}

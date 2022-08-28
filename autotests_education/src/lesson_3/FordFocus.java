package lesson_3;

public class FordFocus extends Car implements topUpResource{

  private String color;
  private TypeOfResources typeOfEngine;

  public FordFocus(String color, TypeOfResources typeOfEngine) {
    super(TypeOfCar.SEDAN, 200, "ФордФокус");
    this.color = color;
    this.typeOfEngine = TypeOfResources.PETROL;
  }

  @Override
  public void topUpResource(int persent, Person buyer) {
    if (typeOfEngine.getPricePerPercent()*persent < buyer.getAmountOfMoney()) System.out.println("У плательщика недостаточно средств");
    else if (this.getLevelOfResource() + persent > 100) {
      System.out.println("Объем " + typeOfEngine.getName() + " в " + persent + " % не помещается, заполняем до 100%");
      int cost = typeOfEngine.getPricePerPercent() * (100 - this.getLevelOfResource());
      this.setPersentageOfResource(100);
      buyer.spendMoney(cost);
      System.out.println("С Вас списано : " + cost);
    }
    else {
      this.setPersentageOfResource(this.getLevelOfResource() + persent);
      buyer.spendMoney(persent * typeOfEngine.getPricePerPercent());
    }
  }
}

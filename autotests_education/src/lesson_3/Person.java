package lesson_3;

public class Person {
  private int amountOfMoney;
  private int levelOfHungry = 100;
  private StateOfPerson state = StateOfPerson.WALKER;

  public void setAmountOfMoney(int amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

  public int getLevelOfHungry() {
    return levelOfHungry;
  }

  public void setLevelOfHungry(int levelOfHungry) {
    this.levelOfHungry = levelOfHungry;
  }

  public Person(int amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

  public int getAmountOfMoney() {
    return amountOfMoney;
  }

  public void spendMoney(int amount){
    if (amountOfMoney>=amount) amountOfMoney-=amount;
    else System.out.println("У вас недостаточно средств для оплаты");
  }

  public StateOfPerson getState() {
    return state;
  }

  public void setState(StateOfPerson state) {
    this.state = state;
  }
}

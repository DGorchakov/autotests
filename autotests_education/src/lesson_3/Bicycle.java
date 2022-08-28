package lesson_3;

public class Bicycle extends Vehicle implements topUpResource{
  private String color;
  private TypeOfResources typeOfResources;

  public Bicycle(String color) {
    super(25);
    this.color = color;
    this.typeOfResources = TypeOfResources.FOOD;
  }

  @Override
  public void becomeADriver(Person person){
    if (this.getState()==State.WAITING && person.getState()==StateOfPerson.WALKER) {
      System.out.println("Вы сели за велосипед");
      this.setDriver(person);
      this.setState(State.STANDING);
      person.setState(StateOfPerson.DRIVER);
      this.setLevelOfResource(person.getLevelOfHungry());
    } else System.out.println("Невозможно стать водителем велосипеда");
  }

  @Override
  public void topUpResource(int persent, Person buyer) {
    if (getDriver() == null) {
      System.out.println("Водителя нет");
      return;
    }
    if (getDriver().getLevelOfHungry() + persent <= 100) {
      getDriver().setLevelOfHungry(getDriver().getLevelOfHungry() + persent);
      buyer.spendMoney(persent * typeOfResources.getPricePerPercent());
      System.out.println("Водитель велосипеда не полностью наелся");
    }
    else {
      System.out.println("Водитель полностью сыт");
      getDriver().setLevelOfHungry(100);
      buyer.spendMoney(persent * typeOfResources.getPricePerPercent()); // платит за всё, а не то, что съел
    }
  }

  @Override
  public void run(int distant){
    if (getDriver().getLevelOfHungry()<=0) {
      setState(State.WAITING);
      System.out.println("Недостаточен уровень ресурса для поездки");
    }
    if (getState() == State.STANDING || getState() == State.RUNNING) {
      System.out.println("Едем");
      setState(State.RUNNING);
      int resourceNeeded = distant/4; //условный расход топлива в процентах
      if (getDriver().getLevelOfHungry() < resourceNeeded) {
        getDriver().setLevelOfHungry(0);
        stop();
        setState(State.WAITING);
        System.out.println("Ресурс закончился");
      }
      else getDriver().setLevelOfHungry(getDriver().getLevelOfHungry()-resourceNeeded);
    }
  }


}
package lesson_3;

public abstract class Vehicle {
   private int maxSpeed;

  private int levelOfResource;

  private Person driver = null;

  private State state = State.WAITING;

  public Vehicle(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public int getLevelOfResource() {
    return levelOfResource;
  }

  public void setPersentageOfResource(int persentageOfResource) {
    this.levelOfResource = persentageOfResource;
  }

  public void becomeADriver(Person person){
    if (this.state==State.WAITING) {
      System.out.println("Вы стали водителем");
      driver = person;
      state = State.STANDING;
      person.setState(StateOfPerson.DRIVER);
    } else System.out.println("Невозможно стать водителем транспортного средства");
  }

  public void getOutDriver(){
    System.out.println("Вы вышли из транспортного средства");
    this.getDriver().setState(StateOfPerson.WALKER);
    state = State.WAITING;
    driver = null;
  }

  public Person getDriver() {
    return driver;
  }

  public void setDriver(Person driver) {
    this.driver = driver;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public void run(int distant){
    if (levelOfResource<=0) {
      setState(State.WAITING);
      System.out.println("Недостаточен уровень ресурса для поездки");
    }
    if (getState() == State.STANDING || getState() == State.RUNNING) {
      System.out.println("Едем");
      setState(State.RUNNING);
      int resourceNeeded = distant/4; //условный расход топлива в процентах
      if (levelOfResource < resourceNeeded) {
        levelOfResource = 0;
        stop();
        setState(State.WAITING);
        System.out.println("Ресурс закончился");
      }
      else levelOfResource-=resourceNeeded;
    }
  }

  public void stop(){
    System.out.println("Остановлен");
    setState(State.STANDING);
  }

  public void setLevelOfResource(int levelOfResource) {
    this.levelOfResource = levelOfResource;
  }
}

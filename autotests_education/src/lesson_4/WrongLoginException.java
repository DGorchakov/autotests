package lesson_4;

public class WrongLoginException extends Exception{
  public WrongLoginException() {
  }

  public WrongLoginException(String message) {
    super(message);
  }
}

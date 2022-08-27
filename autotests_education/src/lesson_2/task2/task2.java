package lesson_2.task2;

public class task2 {
  public static void main(String[] args) {
    printDigitsOfNumber(5467);
  }

  public static void printDigitsOfNumber(int x){
    if (x/10 > 0) printDigitsOfNumber(x/10);
    System.out.println(x%10);
  }
}

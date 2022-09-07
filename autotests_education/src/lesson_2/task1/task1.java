package lesson_2.task1;

public class task1 {
  public static void main(String[] args) {
    System.out.println(isDotInsideCircle(2,1,2,1,1)); //true
    System.out.println(isDotInsideCircle(2, 1.5, 3.2, 2.4, 4));  //true
    System.out.println(isDotInsideCircle(2, 1.4, 4, 7, 1.8)); //false
  }
  public static boolean isDotInsideCircle(double circleX, double circleY, double circleR, double dotX, double dotY) {
    return Math.pow(circleX- dotX, 2) + Math.pow(circleY-dotY, 2) <= Math.pow(circleR, 2) ? true : false;
  }
}


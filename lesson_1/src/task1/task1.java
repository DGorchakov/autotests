package task1;

import java.util.Scanner;

public class task1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while(true){
      int input;
      try {
        System.out.println("Введите трехзначное положительное число: ");
        input = Integer.parseInt(scanner.next());
      }catch (NumberFormatException e) {
        System.out.println("Ошибка. Введено нечисловое значение");
        continue;
      }

      if (input/100<1 || input/100>9 || input<0) {
        System.out.println("Ошибка. Введено не трехзначное или отрицательное число");
        continue;
      }

      System.out.println("РЕЗУЛЬТАТ: ");
      byte firstDigit = (byte)(input/100);
      byte secondDigit = (byte) (input%100/10);
      byte thirdDigit = (byte)(input%10);

      if(input>500) {
        System.out.println("Число больше 500, возвращаю в обратном порядке: " + (thirdDigit*100 + secondDigit*10 +firstDigit));
      }
      else {
        System.out.println("Число меньше либо равно 500, переставляю десятки и единицы: " + (firstDigit*100 + thirdDigit*10 + secondDigit));
      }

      System.out.println("\n=====================================================================\n");
    }

  }
}
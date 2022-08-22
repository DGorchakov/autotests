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

      String strInput = String.valueOf(input);
      if (strInput.length()!=3 || input<0) {
        System.out.println("Ошибка. Введено не трехзначное или отрицательное число");
        continue;
      }

      System.out.println("РЕЗУЛЬТАТ: ");

      if(input>500) {
        System.out.println("Число больше 500, возвращаю в обратном порядке: " + new StringBuffer(strInput).reverse());
      }
      else {
        System.out.println("Число меньше либо равно 500, переставляю десятки и единицы: " + strInput.charAt(0) + strInput.charAt(2) + strInput.charAt(1));
      }

      System.out.println("\n=====================================================================\n");
    }

  }
}
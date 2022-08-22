package task2;

import java.util.Scanner;

public class task2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while(true){
      int input;
      try {
        System.out.println("Введите трехзначное число: ");
        input = Integer.parseInt(scanner.next());
      }catch (NumberFormatException e) {
        System.out.println("Ошибка. Введено нечисловое значение");
        continue;
      }

      String strInput = String.valueOf(input);
      if (strInput.replace("-","").length()!=3) {
        System.out.println("Ошибка. Введено не трехзначное число");
        continue;
      }

      System.out.println("РЕЗУЛЬТАТ: ");

      if(strInput.charAt(strInput.length()-1)=='0') {
        int result = 0;
        if (input<0) input *= -1; //берем только натуральные числа, иначе всегда сумма будет 0

        for (int i = 1; i<=input; i++) {
          if((double)input%i == 0) result += i;
        }

        if (result%10 == 0) System.out.println("Успешно! " + input + " заканчивается на 0 и сумма его натуральных делителей" +
            " (" + result + ") тоже заканчивается на 0");

        else System.out.println("Число не прошло условие: Сумма делителей должна заканчиваться на 0. Сумма делителей: " + result);
      }
      else System.out.println("Число не подходит под условиe: Оно должно заканчиваться на 0");
      System.out.println("\n=====================================================================\n");
    }

  }
}


package lesson_1.task3;

import java.util.Scanner;

public class task3 {
  private static final int MAX_WEIGHT = 450;
  private static final int MAX_COUNT = 6;

  public static void main(String[] args) {
    int sumWeight = 0;
    int count = 0;
    String reasonToStop;

    Scanner scanner = new Scanner(System.in);
    while (true) {
      int inputWeight;
      try {
        inputWeight = Integer.parseInt(scanner.next());
      } catch (NumberFormatException e) {
        System.out.println("Ошибка ввода веса: нечисловое значение, попробуйте снова");
        continue;
      }
      if (inputWeight <= 0) {
        System.out.println("Вес не может быть отрицательным или быть равным нулю, попорбуйте снова");
        continue;
      }
      if (count+1 <= MAX_COUNT) count++;
      else {
        reasonToStop = String.format("Количество людей достигло лимита: %d", MAX_COUNT);
        break;
      }
      if (inputWeight + sumWeight <= MAX_WEIGHT) sumWeight += inputWeight;
      else {
        reasonToStop = String.format("Со следующим человеком будет перевес: %d. Ограничение: %d", inputWeight + sumWeight, MAX_WEIGHT);
        count--;
        break;
      }
    }
    System.out.printf("Количество людей, зашедших в лифт: %d \nОбщий вес: %d \n Причина отказа следующему: %s%n",
        count, sumWeight, reasonToStop);

  }
}

package task4;

import java.util.Arrays;
import java.util.HashSet;

public class task4 {
  public static  int [] array1 = new int[(int)(10 + Math.random()*20)];
  public static int [] array2 = new int[(int)(10 + Math.random()*20)];

  public static void main(String[] args) {
    arrayGenerator(array1);
    arrayGenerator(array2);
    //беру сет для уникальных значений
    HashSet<Integer> sameValues = new HashSet<>();
    HashSet<Integer> differentValues = new HashSet<>();
    for (int i =0; i<array1.length; i++) {
      boolean sameFound = false;
      for (int j : array2) {
        if (array1[i] == j) {
          sameValues.add(array1[i]);
          sameFound = true;
          break;
        }
      }
      if (!sameFound) differentValues.add(array1[i]);
    }

    int [] same = new int[sameValues.size()];
    int i = 0;
    for (int value : sameValues) {
      same[i] = value;
      i++;
    }
    int [] diffrent = new int[differentValues.size()];
    i = 0;
    for (int value : differentValues) {
      diffrent[i] = value;
      i++;
    }
    int [][] result = {same, diffrent};

    System.out.printf("Исходные массивы:    \n %s    \n %s \nОдинаковые значения: %s \nРазличные: %s%n",
        Arrays.toString(array1), Arrays.toString(array2), Arrays.toString(same), Arrays.toString(diffrent));

  }

  private static void arrayGenerator(int [] array) {
    for(int i = 0; i<array.length; i++) {
      array[i] = (int)(Math.random()*25);
    }
  }
}

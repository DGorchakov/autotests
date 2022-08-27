package task4;

import java.util.Arrays;

public class task4 {
  public static  int [] array1 = new int[(int)(10 + Math.random()*20)];
  public static int [] array2 = new int[(int)(10 + Math.random()*20)];
  public static int [][] result = new int[2][Math.max(array1.length, array2.length)];
  public static int indexSame = 0;
  public static int indexDiff = 0;

  public static void main(String[] args) {
    arrayGenerator(array1);
    arrayGenerator(array2);
    compareFirstWithSecond(array1, array2);
    compareFirstWithSecond(array2, array1);
    int [][] finalResult = {Arrays.copyOf(result[0], indexSame), Arrays.copyOf(result[1], indexDiff)};

    System.out.printf("Исходные массивы:    \n %s    \n %s \nОдинаковые значения: %s \nРазличные: %s",
        Arrays.toString(array1), Arrays.toString(array2), Arrays.toString(finalResult[0]), Arrays.toString(finalResult[1]));
  }

  private static void arrayGenerator(int [] array) {
    for(int i = 0; i<array.length; i++) {
      array[i] = (int)(Math.random()*20);
    }
  }
  private static boolean isValueAlreadyExists(int value, int[] array){
    boolean result = false;
    for (int i : array) {
      if (i==value) {
        result = true;
        break;
      }
    }
    return result;
  }

  private static void compareFirstWithSecond(int[] first, int[] second) {
    for (int i =0; i<first.length; i++) {
      boolean sameFound = false;
      for (int j=0; j<second.length; j++) {
        if (first[i] == second[j]) {
          if(!isValueAlreadyExists(first[i], result[0])) result[0][indexSame++] = first[i];
          sameFound = true;
          break;
        }
      }
      if (!sameFound && !isValueAlreadyExists(first[i], result[1])) result[1][indexDiff++] = first[i];
    }
  }
}

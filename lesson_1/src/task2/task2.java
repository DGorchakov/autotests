package task2;

import java.util.Scanner;

public class task2 {
  public static void main(String[] args) {

    for (int i = 100; i<1000; i++) {
      if(i%10 == 0) {
        int sum = 0;
        for (int k = 1; k<=i; k++){
          if(i%k == 0 && k%2 != 0) sum += k;
        }
        if (sum%10 == 0) System.out.println(i);
      }
    }
  }
}


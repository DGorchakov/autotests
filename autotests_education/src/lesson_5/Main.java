package lesson_5;

public class Main {
  public static void main(String[] args) {
    Converter<Integer, Boolean> converter = b -> b % 13 == 0;
    System.out.println(converter.getBoolean(14)); //false
    System.out.println(converter.getBoolean(26)); //true

    Discriminant<Double> discriminant = (a, b, c) -> b * b - 4 * a * c;
    System.out.println(discriminant.getDiscriminant(4.5, 4.0, 5.5)); //-83.0
  }
}

package lesson_5;

@FunctionalInterface

public interface Discriminant<Double> {
  Double getDiscriminant(Double a, Double b, Double c);
}

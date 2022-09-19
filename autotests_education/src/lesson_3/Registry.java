package lesson_3;

public interface Registry<T extends Vehicle> {
  void register(T vehicle);

  boolean isRegistered(T vehicle);
}

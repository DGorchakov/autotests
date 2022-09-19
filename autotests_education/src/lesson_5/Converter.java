package lesson_5;

@FunctionalInterface
public interface Converter<Integer, Boolean> {
  Boolean getBoolean(Integer k);
}

package lesson_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {

    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Введите логин, пароль, повторный пароль через энтер: ");
      System.out.println("Успешность авторизации: " + checkCredentials(scanner.next(), scanner.next(), scanner.next()));
    }
  }

  public static boolean checkCredentials(String login, String password, String confirmPassword) {
    try {
      String regex = "(?=.*[0-9])(?=.*[A-z])(?=.*_)[0-9A-z_]{1,19}";
      if (!Pattern.matches(regex, login)) throw new WrongLoginException("Логин не соответвствует требованиям");
      if (!Pattern.matches(regex, password)) throw new WrongPasswordException("Пароль не соответствует требованиям");
      if (!password.equals(confirmPassword)) throw new WrongPasswordException("Пароли не совпадают");
    } catch (WrongLoginException e) {
      System.out.println("Ошибка : " + e.getMessage());
      return false;
    } catch (WrongPasswordException e) {
      System.out.println("Ошибка : " + e.getMessage());
      return false;
    }
    return true;
  }
}

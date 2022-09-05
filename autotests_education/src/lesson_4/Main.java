package lesson_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Введите логин, пароль, повторный пароль через энтер: ");
      System.out.println("Успешность логина: " + checkCredentials(scanner.next(), scanner.next(), scanner.next()));
    }
  }

  public static boolean checkCredentials(String login, String password, String confirmPassword) {

    //Генерация допустимых символов

    ArrayList<Character> availbleSymbols = new ArrayList<>(50);
    for (int i = 97; i<=122; i++) {
      availbleSymbols.add((char)i);
    }
    for (int i = 65; i<=90; i++) {
      availbleSymbols.add((char)i);
    }
    for (int i = 48; i<=57; i++){
      availbleSymbols.add((char)i);
    }
    availbleSymbols.add((char)95);

    try {

    //Проверка логина

      if (login.length() == 0) throw new WrongLoginException("Логин должен содержать хотя бы один символ");
      if (login.length() >= 20) throw new WrongLoginException("Логин должен быть менее 20 символов");
      for (char loginChar : login.toCharArray()) {
        boolean isWrongSymbolFound = true;
        char wrongSymbol = 0;
        for (char availibleChar : availbleSymbols) {
          if (loginChar == availibleChar) {
            isWrongSymbolFound = false;
            break;
          }
        }
        if (isWrongSymbolFound) {
          wrongSymbol = loginChar;
          throw new WrongLoginException("Логин содержит недопустимый символ: " + wrongSymbol);
        }
      }

    //Проверка пароля

      if (password.length() == 0) throw new WrongPasswordException("Пароль должен содержать хотя бы один символ");
      if (password.length() >= 20) throw new WrongPasswordException("Пароль должен быть менее 20 символов");
      for (char passChar : password.toCharArray()) {
        boolean isWrongSymbolFound = true;
        char wrongSymbol = 0;
        for (char availibleChar : availbleSymbols) {
          if (passChar == availibleChar) {
            isWrongSymbolFound = false;
            break;
          }
        }
        if (isWrongSymbolFound) {
          wrongSymbol = passChar;
          throw new WrongLoginException("Логин содержит недопустимый символ: " + wrongSymbol);
        }
      }
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

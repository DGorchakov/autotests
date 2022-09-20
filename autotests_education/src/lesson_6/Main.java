package lesson_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static List<Student> students = new ArrayList<>();

  public static void main(String[] args) {
    try {
      students.add(new Student("Петя", "F", 3, Map.of(
          Subject.ALGEBRA, 3,
          Subject.HISTORY, 4,
          Subject.STATISTICS, 5,
          Subject.PSYCHOLOGY, 5,
          Subject.COMPUTER_SCIENCE, 3)));
    } catch (WrongValueException e) {
      System.out.println("Ошибка создания студента: " + e.getMessage());
    }

    try {
      students.add(new Student("Вася", "K", 2, Map.of(
          Subject.ALGEBRA, 2,
          Subject.HISTORY, 2,
          Subject.STATISTICS, 3,
          Subject.PSYCHOLOGY, 1,
          Subject.COMPUTER_SCIENCE, 3)));
    } catch (WrongValueException e) {
      System.out.println("Ошибка создания студента: " + e.getMessage());
    }

    try {
      students.add(new Student("Коля", "K", 6, Map.of(
          Subject.ALGEBRA, 5,
          Subject.HISTORY, 5,
          Subject.STATISTICS, 3,
          Subject.PSYCHOLOGY, 4,
          Subject.COMPUTER_SCIENCE, 3)));
    } catch (WrongValueException e) {
      System.out.println("Ошибка создания студента: " + e.getMessage());
    }

    try {
      students.add(new Student("Настя", "K", 4, Map.of(
          Subject.ALGEBRA, 5,
          Subject.HISTORY, 9,
          Subject.STATISTICS, 3,
          Subject.PSYCHOLOGY, 4,
          Subject.COMPUTER_SCIENCE, 3)));
    } catch (WrongValueException e) {
      System.out.println("Ошибка создания студента: " + e.getMessage());
    }

    try {
      students.add(new Student("Саша", "K", 3, Map.of(
          Subject.ALGEBRA, 5,
          Subject.HISTORY, 5,
          Subject.STATISTICS, 3,
          Subject.PSYCHOLOGY, 4,
          Subject.COMPUTER_SCIENCE, 3)));
    } catch (WrongValueException e) {
      System.out.println("Ошибка создания студента: " + e.getMessage());
    }

    System.out.println(students);
    printStudents(students, 2);
    System.out.println(leaveStudentsForNextYear(students));
    printStudents(students, 4);

    FacultyFactory facultyFactory = new FacultyFactory();
    Faculty physicsFaculty = facultyFactory.getFaculty(FacultyType.PHYSICS);
    Faculty psychologyFactory = facultyFactory.getFaculty(FacultyType.PSYCHOLOGY);

    psychologyFactory.printDescription();
    System.out.println();
    physicsFaculty.printDescription();

    System.out.println(physicsFaculty.getSubjects(2));
    System.out.println(psychologyFactory.getSubjects(1));

    psychologyFactory.acceptStudents(1, students.get(0), students.get(1));
    System.out.println(psychologyFactory.getStudents(1));

    Faculty psychologyFactoryAgain = facultyFactory.getFaculty(FacultyType.PSYCHOLOGY);  // проверка синглтона
    System.out.println(psychologyFactoryAgain.getStudents(1));

  }

  public static List<Student> leaveStudentsForNextYear(List<Student> students) {
    /* убираю ещё 5-тикурсников, их двигать некуда
     * сделал через removeIf, а не фильтр, чтобы удалить из списка
     * среднюю оценку посчитал по мат округлению, наверно за 3.9 не нужно отчислять?
     */

    students.removeIf(student -> Math.round(student.getScores().values().stream().mapToInt(e -> e).average().getAsDouble()) < 3 || student.getCourse() == 5);
    students.stream().peek(student -> {
      try {
        student.setCourse(student.getCourse() + 1);
      } catch (WrongValueException e) {
        System.out.println(e.getMessage());
      }
    }).collect(Collectors.toList());
    return students;
  }

  public static void printStudents(List<Student> students, int course) {
    System.out.print("Студенты " + course + " курса  :  ");
    students.stream()
        .filter(student -> student.getCourse() == course)
        .peek(student -> System.out.print(student.getName() + ", "))
        .collect(Collectors.toList());
    System.out.println();
  }
}

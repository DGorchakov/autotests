package lesson_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacultyOfPhysics extends Faculty {

  private static final Map<Integer, List<Subject>> subjects;

  private static final Map<Integer, List<Student>> students = new HashMap<>();
  private static FacultyOfPhysics faculty;

  private final static String DESCRIPTION = "Как устроена Вселенная? Что влияет на трансформацию материи? Некоторые люди с рождения ищут ответы на подобные вопросы. " +
      "И не просто ищут – экспериментируют. С температурой, весом, давлением. Именно они и становятся физиками.\n" +
      "Физика – это безграничные возможности, с одной стороны, и структурированный порядок, с другой." +
      " Здесь нужно проверять любую теорию. Выдвигать свою. Доказывать. А там, может быть, и до Нобелевской премии недалеко.\n" +
      "Человек всегда пытался понять загадки Вселенной. Всегда исследовал окружающее пространство, " +
      "искал закономерности, чтобы сделать мир понятней и удобней во всем. Некоторым это особенно удалось. Так и появились физики.";

  static {
    subjects = new HashMap<Integer, List<Subject>>() {{
      put(1, new ArrayList<Subject>() {{
        add(Subject.ALGEBRA);
        add(Subject.HISTORY);
        add(Subject.PSYCHOLOGY);
        add(Subject.ECOLOGY);
      }});
      put(2, new ArrayList<Subject>() {{
        add(Subject.PHILOSOPHY);
        add(Subject.COMPUTER_SCIENCE);
        add(Subject.FOREIGN_LANGUAGE);
        add(Subject.POLITICS);
      }});
      put(3, new ArrayList<Subject>() {{
        add(Subject.FOREIGN_LANGUAGE);
        add(Subject.ALGEBRA);
        add(Subject.STATISTICS);
        add(Subject.SOCIOLOGY);
      }});
      put(4, new ArrayList<Subject>() {{
        add(Subject.COMPUTER_SCIENCE);
        add(Subject.INFORMATION_SECURITY);
        add(Subject.LOGIC);
      }});
    }};
  }

  /*
      Singletone pattern
   */
  private FacultyOfPhysics() {
    super(DESCRIPTION, subjects, students);
  }

  public static FacultyOfPhysics getFaculty() {
    if (faculty == null) {
      faculty = new FacultyOfPhysics();
    }
    return faculty;
  }
}

package lesson_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacultyOfPsychology extends Faculty {

  private static final Map<Integer, List<Subject>> subjects;

  private static final Map<Integer, List<Student>> students = new HashMap<>();
  private static FacultyOfPsychology faculty;

  private final static String DESCRIPTION = "Факультет готовит специалистов, как для практической, так и для научной деятельности." +
      "В период обучения студентам создаются условия для научно-исследовательской деятельности – они привлекаются к " +
      "комплексным исследованиям вместе с профессорско-преподавательским составом, участвуют в научных психологических олимпиадах," +
      " конференциях регионального, государственного, международного уровня." +
      "Существует студенческое научное общество, в котором будущие психологи осуществляют первые научные пробы. " +
      "Многие студенты-психологи  являются призерами Республиканских олимпиад по психологии, победителями научных конкурсов.";

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

  private FacultyOfPsychology() {
    super(DESCRIPTION, subjects, students);
  }

  public static FacultyOfPsychology getFaculty() {
    if (faculty == null) {
      faculty = new FacultyOfPsychology();
    }
    return faculty;
  }
}

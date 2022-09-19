package lesson_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacultyOfBioengineering extends Faculty {

  private static final Map<Integer, List<Subject>> subjects;

  private static final Map<Integer, List<Student>> students = new HashMap<>();
  public static FacultyOfBioengineering faculty;

  private final static String DESCRIPTION = "Биоинженерия (англ. Bioengineering) – одно из самых современных направлений науки, возникшее на стыке физико-химической биологии, биофизики, генной инженерии и компьютерных технологий." +
      "Биоинженеры имеют дело с живыми системами и применяют передовые технологии для решения медицинских проблем. " +
      "Они участвуют в создании приборов и оборудования, в разработке новых процедур на основе междисциплинарных знаний, в исследованиях," +
      " направленных на получение новой информации для решения новых задач.";

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

  private FacultyOfBioengineering() {
    super(DESCRIPTION, subjects, students);
  }

  public static FacultyOfBioengineering getFaculty() {
    if (faculty == null) {
      faculty = new FacultyOfBioengineering();
    }
    return faculty;
  }
}

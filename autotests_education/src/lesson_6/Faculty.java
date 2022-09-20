package lesson_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Faculty {

  private Map<Integer, List<Student>> students;
  private Map<Integer, List<Subject>> subjects;
  private String description;

  public Faculty(String description, Map<Integer, List<Subject>> subjects, Map<Integer, List<Student>> students) {
    this.description = description;
    this.students = students;
    this.subjects = subjects;
  }

  public List<Subject> getSubjects(int course) {
    return subjects.get(course);
  }

  public List<Student> getStudents(int course) {
    return students.get(course);
  }

  public void acceptStudents(int course, Student... students) {
    if (this.students.containsKey(course)) {
      for (Student student : students) {
        this.students.get(course).add(student);
        try {
          student.setCourse(course);
        } catch (WrongValueException e) {
          System.out.println(e.getMessage());
        }
      }
      return;
    }
    this.students.put(course, new ArrayList<Student>() {{
      for (Student student : students) {
        add(student);
        try {
          student.setCourse(course);
        } catch (WrongValueException e) {
          System.out.println(e.getMessage());
        }
      }
    }});
  }

  public void printDescription() {
    System.out.println(description);
  }
}

package lesson_6;

import java.util.Map;

public class Student {
  private String name;
  private String group;
  private int course;
  private Map<Subject, Integer> scores;

  public Student(String name, String group, int course, Map<Subject, Integer> scores) throws WrongValueException {
    this.name = name;
    this.group = group;
    setCourse(course);
    setScores(scores);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public int getCourse() {
    return course;
  }

  public void setCourse(int course) throws WrongValueException {
    if (course <= 5 && course > 0) this.course = course;
    else throw new WrongValueException("Неверно указан курс. Студент: " + this.getName() + ". Курс: " + course);
  }

  public Map<Subject, Integer> getScores() {
    return scores;
  }

  public void setScores(Map<Subject, Integer> scores) throws WrongValueException {
    for (Map.Entry<Subject, Integer> entry : scores.entrySet()) {
      if (entry.getValue() > 5 || entry.getValue() < 0) throw new WrongValueException("Указана неверная оценка. " +
          "Студент: " + this.getName() +
          ". Курс: " + course +
          ". Предмет: " + entry.getKey() +
          ". Оценка: " + entry.getValue());
    }
    this.scores = scores;
  }

  @Override
  public String toString() {
    return "[" + name + " " + course + " курс]";
  }
}

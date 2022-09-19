package lesson_6;

public class FacultyFactory {

  public Faculty getFaculty(FacultyType type) {
    Faculty faculty = null;
    switch (type) {
      case PSYCHOLOGY:
        faculty = FacultyOfPsychology.getFaculty();
        break;
      case PHYSICS:
        faculty = FacultyOfPhysics.getFaculty();
        break;
      case BIOENGINEERING:
        faculty = FacultyOfBioengineering.getFaculty();
        break;
      default:
        throw new IllegalArgumentException("Wrong type:" + type);
    }
    return faculty;
  }
}

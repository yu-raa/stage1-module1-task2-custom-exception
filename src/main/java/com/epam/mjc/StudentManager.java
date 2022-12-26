package com.epam.mjc;

class InvalidStudentIdException extends IllegalArgumentException {
  public InvalidStudentIdException(String message) {
    super(message);
  }

  public InvalidStudentIdException(String message, Throwable cause) {
    super(message, cause);
  }
}

public class StudentManager {

  private static final long[] IDs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

  public Student find(long studentID) throws InvalidStudentIdException {
    if (Student.getValueOf(studentID) == null) {
      throw new InvalidStudentIdException(String.format("Could not find student with ID %d", studentID));
    }
    return Student.getValueOf(studentID);
  }

  public static void main(String[] args) {
    StudentManager manager = new StudentManager();

    for (int i = 0; i < IDs.length; i++) {
      try {
        Student student = manager.find(IDs[i]);
        System.out.println("Student name " + student.getName());
      }
      catch (InvalidStudentIdException e) {
        System.err.println(e.getMessage());
      }
    }

  }
}
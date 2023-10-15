package com.kodilla.bytemanipulation;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
@RestController
@RequestMapping("/student")
public class StudentController
{
  @GetMapping("/generateStudents")
  public Map<Integer, String> generateStudents(
    @RequestParam(value = "n", defaultValue = "20") int n,
    @RequestParam(value = "z", defaultValue = "10") int z
  ) {
    Map<Integer, String> result = new HashMap<>();
    Student[] students = new Student[n];

    for (int i = 0; i < n; i++) {
      students[i] = new Student(z);
      try {
        Field signatureField = Student.class.getDeclaredField("indexNumber");
        signatureField.setAccessible(true);

        String value = (String) signatureField.get(students[i]);

        result.put(System.identityHashCode(students[i]), value);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return result;
  }
}

package com.kodilla.bytemanipulation;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class Student
{
  private String indexNumber;

  public Student(int z)
  {
    this.indexNumber = RandomStringGenerator.generate(z);
  }
}

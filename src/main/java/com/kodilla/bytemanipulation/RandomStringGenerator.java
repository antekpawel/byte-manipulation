package com.kodilla.bytemanipulation;

import java.util.Random;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class RandomStringGenerator
{
  public static String generate(int targetStringLength)
  {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    Random random = new Random();

    return random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
  }
}

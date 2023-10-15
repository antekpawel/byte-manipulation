package com.kodilla.bytemanipulation;

import java.lang.reflect.*;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class ReflectionPrivate
{
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
  {
    Book book = new Book("Title", "Signature", 2003);
    Field signatureField = Book.class.getDeclaredField("signature");
    signatureField.setAccessible(true);

    String value = (String) signatureField.get(book);
    System.out.println(value);

    Method rentBookMethod = Book.class.getDeclaredMethod("rentBook", null);
    rentBookMethod.setAccessible(true);

    boolean result = (boolean)rentBookMethod.invoke(book);
    System.out.println(result);

    Method setDetailsMethod
      = Book.class.getDeclaredMethod("setDetails", new Class[]{String.class, int.class});

    setDetailsMethod.setAccessible(true);
    setDetailsMethod.invoke(book, "new Signature", 1990);
    System.out.println(book.getSignature());
    System.out.println(book.getYear());
  }
}

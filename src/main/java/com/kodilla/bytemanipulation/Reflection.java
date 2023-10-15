package com.kodilla.bytemanipulation;

import java.lang.reflect.*;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class Reflection
{
  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
  {
    Class<Book> descriptor = Book.class;
    for (Method method : descriptor.getMethods()) {
      System.out.println(method.getName());
    }

    int modifiers = descriptor.getModifiers();
    boolean isPublic = Modifier.isPublic(modifiers);
    boolean isAbstract = Modifier.isAbstract(modifiers);

    System.out.println(isPublic);
    System.out.println(isAbstract);

    Constructor<Book> constructor = descriptor.getConstructor(String.class, String.class, int.class);
    Book book = constructor.newInstance("Title", "Signature", 2000);
    System.out.println(book.getTitle());

  }
}
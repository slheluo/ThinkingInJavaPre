package book.generics;
//: generics/ExplicitTypeSpecification.java
import book.typeinfo.pets.*;
import java.util.*;
import book.net.mindview.util.*;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~

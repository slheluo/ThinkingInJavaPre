package book.generics;
//: generics/SimplerPets.java
import book.typeinfo.pets.*;
import java.util.*;
import book.net.mindview.util.*;

public class SimplerPets {
  public static void main(String[] args) {
    Map<Person, List<? extends Pet>> petPeople = New.map();
    // Rest of the code is the same...
  }
} ///:~

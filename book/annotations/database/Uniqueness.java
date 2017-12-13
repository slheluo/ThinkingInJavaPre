//: annotations/database/Uniqueness.java
// Sample of nested annotations
package book.annotations.database;

public @interface Uniqueness {
  Constraints constraints()
    default @Constraints(unique=true);
} ///:~

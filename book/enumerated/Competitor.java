//: enumerated/Competitor.java
// Switching one enum on another.
package book.enumerated;

public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~

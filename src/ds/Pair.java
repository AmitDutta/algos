package ds;

public class Pair<E, T> {
   private E first;
   private T second;
   public Pair(E foo, T bar) {
      first = foo;
      second = bar;
   }
   public E getFirst() {
      return first;
   }
   public T getSecond() {
      return second;
   }
   public String toString() {
      StringBuffer buffer = new StringBuffer();
      buffer.append("<");
      buffer.append(first == null ? "null" : first.toString());
      buffer.append(",");
      buffer.append(second == null ? "null" : second.toString());
      buffer.append(">");
      return buffer.toString();
   }
   public boolean equals(Object other) {
      if (this == other) {
         return true;
      }
      if (other == null) {
         return false;
      }
      if (getClass() != other.getClass()) {
         return false;
      }
      Pair that = (Pair) other;
      if (first == null) {
         if (that.first != null) {
            return false;
         }
      }else if (!first.equals(that.first)) {
         return false;
      }
      if (second == null) {
         if (that.second != null) {
            return false;
         }
      }else if (!second.equals(that.second)) {
         return false;
      }
      return true;
   }
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((first == null) ? 0 : first.hashCode());
      result = prime * result + ((second == null) ? 0 : second.hashCode());
      return result;
   }
}

package ds;
public class BV {
   private int buckets = 0;
   private int[] map = null;
   public BV() {
      this(Integer.MAX_VALUE);
   }
   public BV(int total) {
      buckets = (total / 32) + 1;
      map = new int[buckets];
   }
   public void add(int key) {
      int rowIndex = key / 32;
      int colIndex = key % 32;
      map[rowIndex] |= (1 << colIndex);
   }
   public boolean containsKey(int key) {

      int rowIndex = key / 32;
      int colIndex = key % 32;
      return ((map[rowIndex] & (1 << colIndex)) >> colIndex) == 1;
   }
   public void remove(int key) {
      int rowIndex = key / 32;
      int colIndex = key % 32;
      int tmp =  ((1 << colIndex) ^ 0xFFFFFFFF);
      map[rowIndex] &= tmp;
   }
}

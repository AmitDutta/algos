package misc;
// This is very critical and full of corner cases.
// Think about when we read more than allocated chunk
// Tests exposes some of these cases, but I believe there are more
public class BufferedReader {
   private int size, start, end, offset;
   private char[] source;
   private char[] buffer;
   private boolean eof = false;
   public BufferedReader(char[] src) {
      this(40, src);
   }
   public BufferedReader(int chunk, char[] src) {
      size = chunk;
      this.source = src;
      offset = 0;
      buffer = new char[size];
   }
   private void ReadInt() throws Exception{
      if (eof) {
         throw new Exception("Stream finished.");
      }
      start = 0;
      end = size;
      int i = start;
      for (; i < end; ++i) {
         if ((offset + i) < source.length) {
            buffer[i] = source[offset + i];
         } else {
            eof = true;
            break;
         }
      }
      offset += i;
   }
   public String Read() throws Exception{
      return Read(10);
   }
   public String Read(int total) throws Exception{
      StringBuffer result = new StringBuffer();
      if (start == end) {
         ReadInt();
      }
      // stream is (start, end] // end points outside
      if (start + total < end) {
         int i = start;
         for (; i < start + total; ++i) {
            result.append(buffer[i]);
         }
         start = i;
      } else {
         while (start + total >= end) {
            // first read whatever we have
            int limit = eof ? Math.min(start + total, end) : end;
            int cnt = 0;
            for (; start < limit; ++start) {
               cnt++;
               result.append(buffer[start]);
            }
            total = total - cnt;
            // Reload buffer, this can throw exception if eof found
            // will reset start, end
            ReadInt();
         }
         if (total != 0 && end > total) {
            // we need to make sure we read all chars, that will make total 0
            for (; start < total; ++start) {
               result.append(buffer[start]);
            }
         }
      }
      return result.toString();
   }
}

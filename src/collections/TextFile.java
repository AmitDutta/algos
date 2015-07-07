package collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

   /* The idea is same as I was talking during interview. Cache data in hasnext,
    * (if not already cached) and invalidate the cache in next. Close file if
    * no data available */
   public class TextFile implements Iterable<String> {
      private String path;
      public TextFile (String path) {
         this.path = path;
      }
      @Override
      public Iterator<String> iterator() {
         return new TextIterator(path);
      }
      
      public class TextIterator implements Iterator<String> {
         private BufferedReader reader;
         private String line;
         public TextIterator(String filePath) {
            try {
               reader = new BufferedReader(new FileReader(filePath));
               line = null;
            } catch (Exception ex) {
            }
         }
         @Override
         public boolean hasNext() {
            try {
               // do not read if cached
               if (line == null) {
                  line = reader.readLine();
                  if (line == null) {
                     // close reader
                     reader.close();
                  }
               }
               return line != null;
            } catch (Exception ex) {
               return false;
            }
         }
         @Override
         public String next() {
            if (hasNext()) {
               // Do a deep copy of the line
               String result = line;
               // clear cached line
               line = null;
               return result;
            }
            throw new NoSuchElementException();
         }
      }
   }


package concurrency;

public class ReaderWriterTest implements Runnable {
   // Lets say only multiple of 5 are writers
   private Thread[] threads;
   private StringBuffer buffer;
   private ReadWriteLock lock;
   public ReaderWriterTest(int n) {
      threads = new Thread[n];
      lock = new ReadWriteLockImpl(); 
      buffer = new StringBuffer();
      for (int i = 0; i < n; ++i) {
         String name = i % 10 == 0 ? "Writer" + i : "Reader" + i;
         threads[i] = new Thread(this, name);
         threads[i].start();
      }
   }
   @Override
   public void run() {
      try {
         while (true) {
            if (Thread.currentThread().getName().startsWith("Reader")) {
               //System.out.println("Before reading: " + Thread.currentThread().getName());
               lock.ReadLock();
               System.out.println(Thread.currentThread().getName() + ":" + buffer.toString());
               Thread.sleep(1000);
               lock.ReadUnLock();
               //System.out.println("After reading: " + Thread.currentThread().getName());
            } else {
               lock.WriteLock();
               buffer.append('a');
               System.out.println(Thread.currentThread().getName() + ":" + buffer.toString());
               lock.WriteUnLock();
               Thread.sleep(10000);
            }
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
   public static void main(String... s) {
      new ReaderWriterTest(20);
      while (true) {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}

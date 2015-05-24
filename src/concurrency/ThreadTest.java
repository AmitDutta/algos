package concurrency;

public class ThreadTest {
   public class Q {
      private int n;
      boolean set = false;
      public synchronized int get() {
         while (!set) {
            try {
               wait();
            } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
         set = false;
         notify();
         return n;
      }
      public synchronized void put(int val) {
         while (set) {
            try {
               wait();
            } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
         n = val;
         set = true;
         notify();
      }
   }
   public class Producer implements Runnable {
      private Q q;
      int n = 0;
      public Producer (Q q) {
         this.q = q;
         new Thread(this, "Producer").start();
      }
      public void run() {
         try {
            while (true) {
               System.out.println("Put: " + n);
               q.put(n++);
               Thread.sleep(500);
            }
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   public class Consumer implements Runnable {
      private Q q;
      public Consumer (Q q) {
         this.q = q;
         new Thread(this, "Consumer").start();
      }
      public void run() {
         try {
            while (true) {
               System.out.println("Got: " + q.get());
               Thread.sleep(500);
            }
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   public void process() {
      Q q = new Q();
      Producer producer = new Producer(q);
      Consumer consumer = new Consumer(q);
   }
   public static void main(String... args) {
      ThreadTest th = new ThreadTest();
      th.process();
   }
}

package concurrency;

public class BoundedBlockingQueue implements Runnable {
   private Thread[] thread;
   private int[] queue;
   private int top = 0;
   private int item = 0;
  public BoundedBlockingQueue(int n) {
      queue = new int[n];
   }
   public synchronized void add(int item) throws InterruptedException {
      // wait if queue is full
      while (top == queue.length) {
         wait();
      }
      queue[top] = item;
      top++;
      notifyAll();
   }
   public synchronized int remove() throws InterruptedException {
      while (top == 0) {
         wait();
      }
      top--;
      int item = queue[top];
      notifyAll();
      return item;
   }
   public void test(int n) {
      thread = new Thread[n];
      for (int i = 0; i < n; ++i) {
         String name = i % 2 == 0 ? "Add" : "Remove"; 
         thread[i] = new Thread(this, name + i);
         thread[i].start();
      }
   }
   public void run() {
      try {
         while (true) {
            if (Thread.currentThread().getName().startsWith("Add")) {
               add(item);
               item++;
               System.out.println(Thread.currentThread().getName() + ":added " + item);
               Thread.sleep((long) (100));
            } else {
               int it = remove();
               System.out.println(Thread.currentThread().getName() + ":removed " + it);
               Thread.sleep((long) (Math.random() * 10000));
            }
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
   public static void main(String... s) {
      BoundedBlockingQueue queue = new BoundedBlockingQueue(10);
      queue.test(2);
      while (true) {
         try {
            Thread.sleep(10000);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
}

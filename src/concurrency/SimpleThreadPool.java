package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SimpleThreadPool {
   private class SimpleThread  extends Thread {
      private boolean isStopped = false;
      @Override
      public void run() {
         while (!isStopped) {
            try {
               // if queue is empty, thread will wait here
               Runnable task = queue.remove();
               task.run();
            } catch (Exception ex) {
               
            }
         }
      }
      public synchronized void doStop() {
         isStopped = true;
         interrupt();
      }
      
      // synchronized key word is not required
      public synchronized boolean isStopped() {
         return isStopped;
      }
   }
   private BlockingQueue<Runnable> queue;
   private SimpleThread[] threads;
   private boolean isStopped = false;;
   public SimpleThreadPool(int maxTasks, int maxThreads) {
      threads = new SimpleThread[maxThreads];
      queue = new ArrayBlockingQueue<Runnable>(maxTasks, true);
      for (int i = 0; i < threads.length; ++i) {
         threads[i] = new SimpleThread();
         threads[i].start();
      }
   }
   public synchronized void addTask(Runnable task) {
      if (isStopped) {
         throw new IllegalArgumentException("Threadpool is stopped.");
      }
      // if queue is full, caller therd will wait
      queue.add(task);
   }
   public synchronized void stop() {
      isStopped = true;
      for (SimpleThread thread : threads) {
         thread.stop();
      }
   }
   
   // Does it need to be synchronized? It's only a read
   public synchronized boolean isStopped() {
      return isStopped;
   }
}

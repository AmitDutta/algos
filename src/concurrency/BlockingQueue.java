package concurrency;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Key thing to note that, producer and consumer will never wait at same time
 * So, notifyall will always wake up other thread. It will never happen that 2
 * producer and 3 consumer is waiting.
 * */

public class BlockingQueue<T> {
   private Queue<T> queue;
   private int limit;
   public BlockingQueue(int size) {
      this.limit = size;
      queue = new LinkedList<T>();
   }
   public synchronized void enqueue(T item) throws InterruptedException {
      while (isFull()) {
         wait();
      }
      boolean empty = isEmpty();
      queue.add(item);
      if (empty) {
         notifyAll();
      }
      
   }
   public synchronized T dequeue() throws InterruptedException {
      while (isEmpty()) {
         wait();
      }
      boolean full = isFull();
      T item = queue.poll();
      if (full) {
         notifyAll();
      }
      return item;
   }
   private boolean isEmpty() {
      return queue.size() == 0;
   }
   private boolean isFull() {
      return queue.size() == limit;
   }
}

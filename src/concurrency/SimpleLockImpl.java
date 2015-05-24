package concurrency;

public class SimpleLockImpl implements SimpleLock{

   private boolean locked = false;
   private Thread lockingThred = null;
   // This filed is important, we lock three times with same object
   // If we dont count, a single unclock call will unclock all three lock calls!
   int count = 0;

   @Override
   public synchronized void Lock() throws InterruptedException {
      Thread callingThred = Thread.currentThread();
      /* And condition is very important here. It is not OR. Any other thread
       * will only wait if both of them are true*/
      while (lockingThred != callingThred && locked) {
         wait();
      }
      count++;
      lockingThred = callingThred;
      locked = true;
   }

   @Override
   public synchronized void UnLock() {
      /* Why we check currenThread? If some other thread create a new lock
       * instance, and directly call unlock, we would make counter -ve.*/
      if (Thread.currentThread() == lockingThred) {
         count--;
      }
      if (count == 0) {
         locked = false;
         notify();
      }
   }
}

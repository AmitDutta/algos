package concurrency;

public class ReadWriteLockImpl implements ReadWriteLock{
   /*
    * 1. If reader is reading, another reader is also allowed to read. But no
    * writer is allowed to write.
    * 2. If writer is writing, readers will not allowed to read. Another writer
    * need to wait until current writer finishes.
    * 3. A reader can not read if a writer is writing or some writers are
    * waiting.
    * 4. Writers will not starve, if any writer is waiting, reader will wait.
    * 5. A reader or writer can only unlock if it locks it. This is not 
    * re-entrant
    * */
   private int readers = 0, writers = 0, writersWaiting = 0;

   @Override
   public synchronized void ReadLock() throws InterruptedException {
      // Never this is IF, must be loop
      while (writers > 0 || writersWaiting > 0) {
         wait();
      }
      readers++;
   }

   @Override
   public synchronized void ReadUnLock() {
      readers--;
      notifyAll();
   }

   @Override
   public synchronized void WriteLock() throws InterruptedException {
      writersWaiting++;
      while (readers > 0 || writers > 0) {
         wait();
      }
      writersWaiting--;
      writers++;
   }

   @Override
   public synchronized void WriteUnLock() {
      writers--;
      notifyAll(); // If one writer ends up writing, we can allow all readers
      // to start reading
   }
}

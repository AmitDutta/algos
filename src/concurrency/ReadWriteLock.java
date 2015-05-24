package concurrency;

public interface ReadWriteLock {
   void ReadLock() throws InterruptedException;
   void ReadUnLock();
   void WriteLock() throws InterruptedException;
   void WriteUnLock();
}

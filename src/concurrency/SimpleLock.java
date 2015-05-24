package concurrency;

/**
 * Basic Lock Implementation
 * 1. Reentrant (If I lock, I should be able to lock without calling unlock)
 * 2. Not Fair (After unlock, just notify, does not keep a queue of requests)
 */
public interface SimpleLock {
   void Lock() throws InterruptedException;
   void UnLock();
}

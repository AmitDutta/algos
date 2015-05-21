package concurrency;

public class Deadlock implements Runnable {
   private Thread thread1, thread2;
   private A a;
   private B b;
   public class A {
      public synchronized void method1(B b) {
         try {
            Thread.sleep(1000);
            System.out.println("Inside A.method1: " + Thread.currentThread().getName());
         }catch (InterruptedException ex) {
            ex.printStackTrace();
         }
         System.out.println("Trying to call B:method2");
         b.method2();
      }
      public synchronized void method2() {
         System.out.println("Inside A:method2");
      }
   }
   public class B {
      public synchronized void method1(A a) {
         try {
            Thread.sleep(1000);
            System.out.println("Inside B.method1: " + Thread.currentThread().getName());
         }catch (InterruptedException ex) {
            ex.printStackTrace();
         }
         System.out.println("Trying to call A:method2");
         a.method2();
      }
      public synchronized void method2() {
         System.out.println("Inside B:method2");
      }
   }
   public Deadlock() {
      a = new A();
      b = new B();
      thread1 = new Thread(this, "Thread1");
      thread2 = new Thread(this, "Thread2");
      thread1.start();
      thread2.start();
   }
   public void run() {
      if (Thread.currentThread().getName().equals("Thread1")) {
         try {
            Thread.sleep(1000);
            System.out.println("Calling A.Method1");
            a.method1(b);
         } catch (InterruptedException ex) {
            ex.printStackTrace();
         }
      } else if (Thread.currentThread().getName().equals("Thread2")){
         try {
            Thread.sleep(1000);
            System.out.println("Calling B.Method1");
            b.method1(a);
            // No deadlock. Order locks
            // a.method1(b);
         } catch (InterruptedException ex) {
            ex.printStackTrace();
         }
      }
   }
   public static void main(String... args) {
      new Deadlock();
   }
}

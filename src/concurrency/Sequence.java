package concurrency;

public class Sequence implements Runnable{
   private Thread a, b, c;
   private String current = "A";
   public Sequence() {
      a = new Thread(this, "A");
      b = new Thread(this, "B");
      c = new Thread(this, "C");
      a.start();
      b.start();
      c.start();
   }
   @Override
   public void run() {
      while (true) {
         synchronized (this) {
            while (!current.equals(Thread.currentThread().getName())) {
               try {
                  //System.out.println(Thread.currentThread().getName() + ": waiting");
                  wait();
               } catch (InterruptedException ex) {
                  ex.printStackTrace();
               }
            }
            String name = Thread.currentThread().getName();
            System.out.println(name);
            if (name.equals("A")) {
               current = "B";
            } else if (name.equals("B")) {
               current = "C";
            } else {
               current = "A";
            }
            notifyAll();
         }
      }
   }
   
   public static void main(String... args) {
      new Sequence();
      try {
         Thread.currentThread().sleep(5000);
      } catch (InterruptedException ex) {
         ex.printStackTrace();
      }
   }
}

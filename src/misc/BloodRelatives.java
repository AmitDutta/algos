package misc;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class BloodRelatives {
   // Blood relative means they are in same connected component.
   // just doing dfs from one node should suffice. just check
   // component id of two nodes. If not connected, other node will
   // not have any id.
   public class Person {
      private List<Person> parents;
      public Person(Person mother, Person father) {
         parents = new ArrayList<Person>();
         if (mother != null) {
            parents.add(mother);
         }
         if (father != null) {
            parents.add(father);
         }
      }
   }
   public boolean isRelative(Person p1, Person p2) {
      if (p1 == null || p2 == null) {
         return false;
      }
      if (p1.parents.contains(p2)) {
         return true;
      }
      for (Person a : p1.parents) {
        if (isRelative(a, p2)) {
           return true;
        }
        for (Person b : p2.parents) {
           if (a.equals(b)) {
              return true;
           }
           if (isRelative(a, b)) {
              return true;
           }
        }
      }
      return false;
   }
   @Test
   public void isRelativeTest1() {
      Person c = new Person(null, null);
      Person d = new Person(null, null);
      Person e = new Person(null, null);
      Person a = new Person(c, d);
      Person b = new Person(d, e);
      Assert.assertTrue(isRelative(a, b));
      Assert.assertFalse(isRelative(c, e));
   }
   @Test
   public void isRelativeTest2() {
      Person b = new Person(null, null);
      Person g = new Person(null, null);
      Person d = new Person(null, null);
      Person h = new Person(null, null);
      Person f = new Person(null, null);
      Person c = new Person(g, d);
      Person a = new Person(b, c);
      Person e = new Person(d, h);
      Person i = new Person(f, e);
      Assert.assertTrue(isRelative(a, i));
      
      a = new Person(b, c);
      i = new Person(c, b);
      Assert.assertTrue(isRelative(a, i));
      
      d = new Person(null, null);
      c = new Person(null, d);
      b = new Person(null, c);
      a = new Person(null, b);
      Assert.assertTrue(isRelative(a, c));
      Assert.assertTrue(isRelative(a, d));
   }
 }

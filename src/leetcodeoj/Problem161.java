package leetcodeoj;

import org.junit.*;

// One edit distance
public class Problem161 {
   // here s and t mush have same legnth. if they mismatch in 2 points
   // they are not 1 edit distance
   private boolean oneedit(String s, String t)  {
      int mismatch = 0;
      for (int i = 0; i < s.length(); ++i) {
         if (s.charAt(i) != t.charAt(i)) {
            mismatch++;
         }
         if (mismatch > 1) {
            return false;
         }
      }
      return mismatch == 1;
   }
   // lets take s has bigger length (if they differ in length)
   public boolean onedistance(String s, String t) {
      if (s.length() < t.length()) return onedistance(t, s);
      if (s.length() - t. length() > 1) return false;
      else if (s.length() == t.length()) {
         return oneedit(s, t);
      } else {
         // s has one char more, if we remove the first char that mismatch
         // from s, then if s and t are equal return true else false
         StringBuffer buffer = new StringBuffer();
         for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
               buffer.append(s.substring(i +1, s.length()));
               break;
            } else {
               buffer.append(s.charAt(i));
            }
         }
         return buffer.toString().equals(t);
      }
   }
   
   @Test
   public void test1() {
      Assert.assertTrue(onedistance("amit", "a1it"));
      Assert.assertTrue(onedistance("amit", "amitd"));
      Assert.assertTrue(onedistance("amit", "amdit"));
      Assert.assertTrue(onedistance("amit", "damit"));
      Assert.assertTrue(onedistance("", "a"));
   }
   
   @Test
   public void test2() {
      Assert.assertFalse(onedistance("amit", "amit"));
      Assert.assertFalse(onedistance("amit", "5656"));
      Assert.assertFalse(onedistance("amit", "am1d"));
      Assert.assertFalse(onedistance("", "aa"));
   }
}

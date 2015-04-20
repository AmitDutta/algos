package leetcodeoj;

import java.util.Stack;
import org.junit.Test;
import org.junit.Assert;

public class Problem71 {
   public String simplifyPath(String path) {
      String[] parts = path.split("/");
      Stack<String> stack = new Stack<String>();
      StringBuffer buffer = new StringBuffer();
      for (int i = 0; i < parts.length; ++i) {
         if(parts[i].length() == 0) continue;
         if (parts[i].length() == 1 && parts[i].equals(".")) continue;
         if (parts[i].equals("..")) {
            if (!stack.empty()) {
               stack.pop();
            }
         }else {
            stack.push(parts[i]);
         }
      }
      Stack<String> out = new Stack<String>();
      while (!stack.empty()) {
         out.push(stack.pop());
      }

      if (out.size() == 0) {
         buffer.append("/");
      }else {
         while (!out.empty()) {
            buffer.append("/");
            buffer.append(out.pop());
         }
      }

      return buffer.toString();
   }
   
   @Test
   public void simplifyPathTest1() {
      Problem71 p71 = new Problem71();
      Assert.assertEquals("/c", p71.simplifyPath("/a/./b/../../c/"));
   }

   @Test
   public void simplifyPathTest2() {
      Problem71 p71 = new Problem71();
      Assert.assertEquals("/home", p71.simplifyPath("/home/"));
   }
   
   @Test
   public void simplifyPathTest3() {
      Problem71 p71 = new Problem71();
      Assert.assertEquals("/f/j", p71.simplifyPath("/abc/../def/../././f/h/../j"));
   }

   @Test
   public void simplifyPathTest4() {
      Problem71 p71 = new Problem71();
      Assert.assertEquals("/a/b/c", p71.simplifyPath("/a/b/c"));
   }
   
   @Test
   public void simplifyPathTest5() {
      Problem71 p71 = new Problem71();
      Assert.assertEquals("/", p71.simplifyPath("../../../../"));
   }
   
   @Test
   public void simplifyPathTest6() {
      Problem71 p71 = new Problem71();
      Assert.assertEquals("/", p71.simplifyPath("../../../../a/../b/c/../../"));
   }
   
   @Test
   public void simplifyPathTest8() {
      Problem71 p71 = new Problem71();
      Assert.assertEquals("/home/foo", p71.simplifyPath("/home//foo/"));
   }
 }

package leetcodeoj;

import org.junit.*;

public class Problem211 {
   class TrieNode {
      private boolean value;
      private TrieNode[] lst;
      public TrieNode() {
         value = false;
         lst = new TrieNode[26];
      }
   }
   private TrieNode root;
   public Problem211() {
      root = new TrieNode();
   }
   public void addWord(String word) {
      TrieNode cur = root;
      TrieNode first = null;
      for (int i = 0; i < word.length(); ++i) {
         int index = word.charAt(i) - 97;
         if (cur.lst[index] == null) {
            cur.lst[index] = new TrieNode();
         }
         cur = cur.lst[index];
         if (first == null) {
            first = cur;
         }
      }
      cur.value = true;
   }
   
   public boolean searchInt(String word, int index, TrieNode node, TrieNode parent) {
      if (node == null) {
         return false;
      }
      if (index >= word.length()) {
         if (word.charAt(index -1) == '.') {
            for (int i = 0; i < parent.lst.length; ++i) {
               if (parent.lst[i] != null && parent.lst[i].value) {
                  return true;
               }
            }
            return false;
         }
         return node.value;
      }
      if (word.charAt(index) == '.') {
         for (int j = 0; j < node.lst.length; ++j) {
            if (node.lst[j] == null) {
               continue;
            }
            if (searchInt(word, index + 1, node.lst[j], node)) {
               return true;
            }
         }
         return false;
      }
      return searchInt(word, index + 1, node.lst[word.charAt(index) - 97], node);
   }
   
   public boolean search(String word) {
      if (word.length() == 0) {
         return root.value;
      }
      return searchInt(word, 0, root, null);
   }
   
   @Test
   public void Test0() {
      Problem211 p211 = new Problem211();
      p211.addWord("ab");
      Assert.assertTrue(p211.search("ab"));
   }
   
   @Test
   public void Test1() {
      Problem211 p211 = new Problem211();
      Assert.assertFalse(p211.search(""));
      p211.addWord("");
      p211.addWord("bad");
      p211.addWord("dad");
      p211.addWord("mad");
      Assert.assertTrue(p211.search(""));
      Assert.assertFalse(p211.search("pad"));
      Assert.assertTrue(p211.search("bad"));
      Assert.assertTrue(p211.search(".ad"));
      Assert.assertTrue(p211.search("b.."));
      Assert.assertTrue(p211.search("..."));
      Assert.assertFalse(p211.search("."));
   }
   @Test
   public void Test2() {
      Problem211 p211 = new Problem211();
      p211.addWord("a");
      p211.addWord("a");
      p211.search(".");
      p211.search("a");
      p211.search("aa");
      p211.search("a");
      p211.search(".a");
      p211.search("a.");
   }
   @Test
   public void Test3() {
      Problem211 p211 = new Problem211();

      p211.addWord("at");
      p211.addWord("and");
      p211.addWord("an");
      p211.addWord("add");

      Assert.assertFalse(p211.search("a"));
      Assert.assertFalse(p211.search(".at"));

      p211.addWord("bat");

      Assert.assertTrue(p211.search(".at"));
      Assert.assertTrue(p211.search("an."));
      Assert.assertFalse(p211.search("a.d."));
      Assert.assertFalse(p211.search("b."));
      Assert.assertTrue(p211.search("a.d"));
      Assert.assertFalse(p211.search("."));
   }
}

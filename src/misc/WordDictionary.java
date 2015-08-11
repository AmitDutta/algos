package misc;
import org.junit.*;

// This program has lot of corner cases, see the tests carefully
public class WordDictionary {
   class TrieNode {
      private boolean value;
      private TrieNode[] nodes;
      public TrieNode() {
         value = false;
         nodes = new TrieNode[26];
         for (int i = 0; i < 26; ++i) {
            nodes[i] = null;
         }
      }
  }
   private TrieNode root;
   
   public WordDictionary() {
      root = new TrieNode();
   }
   public void addWord(String word) {
      TrieNode cur = root;
      if (word.equals("")) {
         root.value = true;
         return;
      }
      for (int i = 0; i <= word.length() - 1; ++i) {
         int x = word.charAt(i) - 97;
         if (cur.nodes[x] == null) {
            cur.nodes[x] = new TrieNode();
         }
         if (i == word.length() - 1) {
            cur.nodes[x].value = true;
         }
         cur = cur.nodes[x];
      }
   }
   
   private boolean searchInt(String word, TrieNode node) {
      if (word.equals("")) {
         for (int i = 0; i < 26; ++i) {
            if (node.nodes[i] != null && node.nodes[i].value) {
               return true;
            }
         }
         return false;
      }
      int i = 0;
      char ch  = word.charAt(0);
      if (ch != '.') {
         int x = ch - 97;
         TrieNode nd = node.nodes[x];
         if (nd == null) {
            return false;
         }
         if (i == word.length() - 1) {
            return nd.value;
         }
         return searchInt(word.substring(i + 1), nd);
      } else {
         /* If char is . and word is of one length, we need to check the
          * current level, if there is any word ends there.*/
         if (word.length() == 1) {
            return searchInt(word.substring(i + 1), node);
         }
         // Otherwise we can advance level
         for (int j = 0; j < 26; ++j) {
            if (node.nodes[j] != null) {
               if (searchInt(word.substring(i + 1), node.nodes[j])) {
                  return true;
               }
            }
         }
         return false;
      }
   }

   public boolean search(String word) {
      return searchInt(word, root);
   }

   @Test
   public void test1() {
      addWord("bad");
      addWord("dad");
      addWord("mad");
      Assert.assertFalse(search("pad"));
      Assert.assertTrue(search("bad"));
      Assert.assertTrue(search(".ad"));
      Assert.assertTrue(search("b.."));
      Assert.assertFalse(search("."));
   }

   @Test
   public void test2() {
      addWord("bak");
      addWord("bze");
      Assert.assertTrue(search("b.e"));
      Assert.assertFalse(search("b.a"));
   }

   @Test
   public void test3() {
      addWord("a");
      Assert.assertFalse(search(".a"));
      Assert.assertTrue(search("."));
   }

   @Test
   public void test4() {
      addWord("a");
      addWord("aa");
      Assert.assertTrue(search("."));
   }
}

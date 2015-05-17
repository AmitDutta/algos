package ds;

import org.junit.*;

public class RWayTrie {
   class TrieNode {
      private boolean value;
      private TrieNode[] lst;
      public TrieNode() {
         value = false;
         lst = new TrieNode[26];
      }
   }
   public class Trie {
      private TrieNode root;
      public Trie() {
         root = new TrieNode();
      }
      public void insert(String word) {
         TrieNode cur = root;
         for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 97;
            if (cur.lst[index] == null) {
               cur.lst[index] = new TrieNode();
            }
            cur = cur.lst[index];
         }
         cur.value = true;
      }
      public boolean search(String word) {
         TrieNode cur = root;
         for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 97;
            cur = cur.lst[index];
            if (cur == null) {
               break;
            }
         }
         return cur == null ? false : cur.value;
      }
      public boolean startsWith(String prefix) {
         TrieNode cur = root;
         int i = 0;
         for (; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 97;
            cur = cur.lst[index];
            if (cur == null) {
               break;
            }
         }
         return cur != null;
      }
   }
   @Test
   public void TrieTest1() {
      Trie trie = new Trie();
      
      Assert.assertFalse(trie.search(""));
      
      trie.insert("somestring");
      trie.insert("amit");
      trie.insert("ashit");
      trie.insert("hexamethylenetetramine");
      trie.insert("");

      Assert.assertTrue(trie.search(""));
      Assert.assertTrue(trie.search("amit"));
      Assert.assertTrue(trie.search("ashit"));
      Assert.assertTrue(trie.search("somestring"));
      Assert.assertTrue(trie.search("hexamethylenetetramine"));
      
      Assert.assertFalse(trie.search("ami"));
      Assert.assertFalse(trie.search("somethn"));
      Assert.assertFalse(trie.search("hexamethylenetetramin"));

      Assert.assertTrue(trie.startsWith("ami"));
      Assert.assertTrue(trie.startsWith("somest"));
      Assert.assertTrue(trie.startsWith("hexamethylenetetrami"));
   }
}

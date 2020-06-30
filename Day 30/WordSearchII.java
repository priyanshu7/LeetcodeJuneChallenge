package june2020;

import java.util.*;

public class WordSearchII {
	
	public List<String> findWords(char[][] board, String[] words) {
		List<String> ans = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, ans);
			}
		}
		return ans;
	}

	public void dfs(char[][] board, int i, int j, TrieNode node, List<String> ans) {
		char c = board[i][j];
		if (c == '#' || node.next[c - 'a'] == null)
			return;
		node = node.next[c - 'a'];
		if (node.word != null) { 
			ans.add(node.word);
			node.word = null;
		}

		board[i][j] = '#';
		if (i > 0)
			dfs(board, i - 1, j, node, ans);
		if (j > 0)
			dfs(board, i, j - 1, node, ans);
		if (i < board.length - 1)
			dfs(board, i + 1, j, node, ans);
		if (j < board[0].length - 1)
			dfs(board, i, j + 1, node, ans);
		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode prefix = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (prefix.next[i] == null)
					prefix.next[i] = new TrieNode();
				prefix = prefix.next[i];
			}
			prefix.word = w;
		}
		return root;
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}

}




// Alternate Approach

class TrieNode{
  public TrieNode[] children = new TrieNode[26];
  public String item = "";
}


class Trie{
  public TrieNode root = new TrieNode();

  public void insert(String word){
      TrieNode node = root;
      for(char c: word.toCharArray()){
          if(node.children[c-'a']==null){
              node.children[c-'a']= new TrieNode();
          }
          node = node.children[c-'a'];
      }
      node.item = word;
  }

  public boolean search(String word){
      TrieNode node = root;
      for(char c: word.toCharArray()){
          if(node.children[c-'a']==null)
              return false;
          node = node.children[c-'a'];
      }
      if(node.item.equals(word)){
          return true;
      }else{
          return false;
      }
  }

  public boolean startsWith(String prefix){
      TrieNode node = root;
      for(char c: prefix.toCharArray()){
          if(node.children[c-'a']==null)
              return false;
          node = node.children[c-'a'];
      }
      return true;
  }
}


class Solution {
   Set<String> result = new HashSet<String>(); 

  public List<String> findWords(char[][] board, String[] words) {

      Trie trie = new Trie();
      for(String word: words){
          trie.insert(word);
      }

      int m=board.length;
      int n=board[0].length;

      boolean[][] visited = new boolean[m][n];

      for(int i=0; i<m; i++){
          for(int j=0; j<n; j++){
             dfs(board, visited, "", i, j, trie);
          }
      }

      return new ArrayList<String>(result);
  }

  public void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie){
      int m=board.length;
      int n=board[0].length;

      if(i<0 || j<0||i>=m||j>=n){
          return;
      }

      if(visited[i][j])
          return;

      str = str + board[i][j];

      if(!trie.startsWith(str))
          return;

      if(trie.search(str)){
          result.add(str);
      }

      visited[i][j]=true;
      dfs(board, visited, str, i-1, j, trie);
      dfs(board, visited, str, i+1, j, trie);
      dfs(board, visited, str, i, j-1, trie);
      dfs(board, visited, str, i, j+1, trie);
      visited[i][j]=false;
  }
}

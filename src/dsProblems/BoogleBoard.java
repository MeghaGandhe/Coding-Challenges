package dsProblems;

import java.util.ArrayList;
import java.util.List;

public class BoogleBoard {
	
	public static void main(String[] args){
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		
		String[] words = {"oath","pea","eat","rain","eate"};
		
		BoogleBoard boogleBoard = new BoogleBoard();
		
		List<String> wordList = boogleBoard.findWords(board,words);
		for(int i =0;i<wordList.size();i++) {
			System.out.println(wordList.get(i));
		}
		
		
	}
	
	public List<String> findWords(char[][] board, String[] words) {
		Trie root = buildTrie(words);
		List<String> res = new ArrayList<>();
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				dfs(board,i,j,root,res);
			}
		}
		return res;
		
	}
	
	public void dfs(char[][]board,int i, int j, Trie root,List<String> res) {
		if(i<0 || j<0 || i>=board.length || j>=board[i].length)
			return;
		char c = board[i][j];
		if(c == 1 || root.next[c-'a'] == null) return;
		root = root.next[c-'a'];
		if(root.word!=null) {
			res.add(root.word);
			root.word = null;
		}
		
		board[i][j] = 1;
		dfs(board,i,j+1,root,res);
		dfs(board,i+1,j,root,res);
		dfs(board,i-1,j,root,res);
		dfs(board,i,j-1,root,res);
		board[i][j] = c;	
	}
	
	public Trie buildTrie(String[] words) {
		Trie root = new Trie();
		for(int i =0;i<words.length;i++) {
			Trie p = root;
			String word = words[i];
			for(int j=0;j<words[i].length();j++) {
				char ch = word.charAt(j);
				int k = ch - 'a';
				if(p.next[k] == null) {
					p.next[k] = new Trie();
				}
				p = p.next[k];
			}
			p.word = word;	
		}
		
		return root;
	}
	
	static class Trie{
		String word;
		Trie[] next = new Trie[26];
		public Trie() {
			
		}
		public Trie(String word,Trie[] next) {
			this.word = word;
			this.next = next;
		}
	}

}

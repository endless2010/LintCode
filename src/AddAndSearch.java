import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class AddAndSearch {

	@Test
	public void test() {
		WordDictionary dic = new WordDictionary();
		dic.addWord("bad");
		dic.addWord("dad");
		dic.addWord("mad");
		Assert.assertEquals(false, dic.search("pad"));
		Assert.assertEquals(true, dic.search("bad"));
		Assert.assertEquals(true, dic.search(".ad"));
		Assert.assertEquals(true, dic.search("b.."));
	}
}

class WordDictionary {

	 private TrieNode root = new TrieNode();
	 
	    public void addWord(String word) {  
	        Map<Character, TrieNode> children = root.children;  
	        for(int i=0; i<word.length(); i++) {  
	            char c = word.charAt(i);  
	            TrieNode t;  
	            if(children.containsKey(c)) {  
	                t = children.get(c);  
	            } else {  
	                t = new TrieNode(c);  
	                children.put(c, t);  
	            }  
	            children = t.children;  
	            if(i==word.length()-1) t.leaf=true;  
	        }  
	    }  
	  
	    public boolean search(String word) {  
	        return searchNode(word, root);  
	    }  
	      
	    public boolean searchNode(String word, TrieNode tn) {  
	        if(tn==null) return false;  
	        if(word.length() == 0 ) return tn.leaf;  
	          
	        Map<Character, TrieNode> children = tn.children;  
	        TrieNode t = null;  
	        char c = word.charAt(0);  
	        if(c=='.') {  
	            for(char key : children.keySet() ) {  
	                if(searchNode(word.substring(1), children.get(key) )) return true;  
	            }  
	            return false;  
	        } else if(!children.containsKey(c)) {  
	            return false;  
	        } else {  
	            t = children.get(c);  
	            return searchNode(word.substring(1), t);  
	        }  
	    } 
	    
		class TrieNode {  
		    char c;  
		    boolean leaf;  
		    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();  
		      
		    public TrieNode(char c) {  
		        this.c = c;  
		    }  
		          
		    public TrieNode(){};  
		} 
	}  
	  

import java.util.Map;

class Wrapper{
	TrieNode node;
	boolean finished=false;
	Wrapper(TrieNode node){
		this.node=node;
	}	
}

public class TrieNode {
	public char value;
	public Map<Character,Wrapper> child;
    public TrieNode() {
        
    }
}
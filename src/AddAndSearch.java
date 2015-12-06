import java.util.HashMap;

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

	public void addWord(String word) {
	}

	public boolean search(String word) {
	}
}

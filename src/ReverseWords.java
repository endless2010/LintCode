import org.junit.Assert;
import org.junit.Test;


public class ReverseWords {
    public String reverseWords(String s) {	
    	String[] words=s.split("\\s+");
    	StringBuilder sb=new StringBuilder();
    	for(int i=words.length-1;i>=0;--i)
    		sb.append(words[i]).append(" ");
        return sb.toString().trim();
    }
    @Test
    public void test(){
    	Assert.assertEquals("1",reverseWords(" 1"));
    	Assert.assertEquals("1",reverseWords("1 "));
    	Assert.assertEquals("1",reverseWords(" 1 "));
    	Assert.assertEquals("",reverseWords(" "));
    	Assert.assertEquals("hi",reverseWords("hi"));
    	Assert.assertEquals("the sky is blue",reverseWords("blue is sky the"));
    	Assert.assertEquals("is blue",reverseWords("blue   is"));
    	
    }
}

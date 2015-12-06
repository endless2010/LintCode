import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * Implement an algorithm to determine if a string has all unique characters.
 * TODO:Challenge:What if you can not use additional data structures?
 */
public class UniqueCharacters {
    public boolean isUnique(String str) {
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        for(int i=1;i<chars.length;++i)
        	if(chars[i]==chars[i-1])
        		return false;
        return true;
    }
    @Test
    public void test(){
    	Assert.assertEquals(true,isUnique("abc"));
    	Assert.assertEquals(false,isUnique("aab"));
    }
}

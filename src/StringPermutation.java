import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given two strings, write a method to decide if one is a permutation of the other.
 * abcd is a permutation of bcad, but abbe is not a permutation of abe
 */
public class StringPermutation {
    public boolean stringPermutation(String A, String B) {
        if(A==null || B==null || A.length()!=B.length())
        	return false;
        char[] charsA=A.toCharArray();
        char[] charsB=B.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        return Arrays.equals(charsA, charsB);
    }
    @Test
    public void test(){
    	Assert.assertEquals(true,stringPermutation("abcd","bcad"));
    	Assert.assertEquals(false,stringPermutation("abcd","bca"));
    	Assert.assertEquals(false,stringPermutation("abcd","bcaq"));
    	Assert.assertEquals(false,stringPermutation(null,""));
    }
}

import org.junit.Assert;
import org.junit.Test;

/*
 * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 * 比如 s1 = "aabcc" s2 = "dbbca"
 * 当 s3 = "aadbbcbcac",返回  true. 
 * 当 s3 = "aadbbbaccc", 返回 false.
 */
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s1.length()==0)
        	return s2.equals(s3);
        if(s2==null || s2.length()==0)
        	return s1.equals(s3);
        if(s3.length() == 0) 
        	return s1.length() + s2.length() == 0;
        
        if(s1.charAt(0) == s3.charAt(0) && s2.charAt(0) != s3.charAt(0))  
            return isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length()));  
        else if(s1.charAt(0) != s3.charAt(0) && s2.charAt(0) == s3.charAt(0))  
            return isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()));  
        else if(s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0))  
            return isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length()))
            	|| isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()));   
        else  
            return false; 
    }
    @Test
    public void test(){
    	Assert.assertEquals(true,isInterleave("aabcc","dbbca","aadbbcbcac"));
       	Assert.assertEquals(false,isInterleave("aabcc","dbbca","aadbbbaccc"));
    }
}

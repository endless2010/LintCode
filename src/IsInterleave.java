import org.junit.Assert;
import org.junit.Test;

/*
 * ���������ַ���:s1��s2��s3���ж�s3�Ƿ���s1��s2���湹�ɡ�
 * ���� s1 = "aabcc" s2 = "dbbca"
 * �� s3 = "aadbbcbcac",����  true. 
 * �� s3 = "aadbbbaccc", ���� false.
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

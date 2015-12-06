import org.junit.Assert;
import org.junit.Test;

/*
 * �Ƚ������ַ���A��B��ȷ��A���Ƿ����B�����е��ַ����ַ���A��B�е��ַ����� ��д��ĸ
 * http://www.cnblogs.com/EdwardLiu/p/4273817.html
 */
public class CompareStrings {
    public boolean compareStrings(String A, String B) {
    	if(A==null ||A.length()<B.length())
    		return false;
        int[] arrayA = new int[26];
        int[] arrayB = new int[26];
         for (int i=0; i<A.length(); i++) {
        	 arrayA[A.charAt(i) - 'A']++;
         }
        for (int i=0; i<B.length(); i++) {
        	arrayB[B.charAt(i) - 'A']++;
            if (arrayB[B.charAt(i) - 'A'] > arrayA[B.charAt(i) - 'A']) 
            	return false;
         }
        return true;
    }
    @Test
    public void test(){
    	Assert.assertEquals(true,compareStrings("ABCD","ACD"));
    	Assert.assertEquals(true,compareStrings("DCAB","ACD"));
    	Assert.assertEquals(true,compareStrings("ACAB","AAB"));
    	Assert.assertEquals(true,compareStrings("ABAD","AAB"));
    	Assert.assertEquals(false,compareStrings("ABCD","AABC"));
    	Assert.assertEquals(true,compareStrings("AABC","AAB"));
    	Assert.assertEquals(true,compareStrings("ABAD","AAB"));
    }
}

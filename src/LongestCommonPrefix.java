import org.junit.Assert;
import org.junit.Test;

/*
 * 给k个字符串，求出他们的最长公共前缀(LCP)
 * 在 "ABCD" "ABEF" 和 "ACEF" 中,  LCP 为 "A"
 * 在 "ABCDEFG", "ABCEFG", "ABCEFA" 中, LCP 为 "ABC"
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
        	return "";
        StringBuilder sb=new StringBuilder();
        int length=1;
        while(true){
        	for(int i=0;i<strs.length;++i){
        		if(strs[i].length()<length)
        			return sb.toString();	
        		if(i!=0 &&(strs[i].charAt(length-1)!=strs[0].charAt(length-1)))
        			return sb.toString();
        		if(i==strs.length-1)
        			sb.append(strs[0].charAt(length-1));
        	}
        	length++;
        }
    }
    @Test
    public void test(){
    	Assert.assertEquals("A",longestCommonPrefix(new String[]{"ABCD","ABEF","ACEF"}));
    	Assert.assertEquals("ABC",longestCommonPrefix(new String[]{"ABCDEFG","ABCEFG","ABCEFA"}));
    }
}

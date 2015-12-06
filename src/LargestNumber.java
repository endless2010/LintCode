import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/*
 * 给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数
 * 给出样例 [1, 20, 23, 4, 8]，返回组合最大的整数为8423201
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
		String[] array = new String[num.length];
		int numberOf0=0;
		for (int i = 0; i < num.length; i++){
			if(num[i]==0)
				numberOf0++;
			array[i] = String.valueOf(num[i]);
		}
		if(numberOf0==num.length)
			return "0";
    	Comparator<String> cmp=new Comparator<String>(){
			@Override
			public int compare(String str1, String str2) {
				int length=str1.length()>str2.length()?str1.length():str2.length();
				for(int i=0;i<length;++i){
					char c1=i<str1.length()?str1.charAt(i):str1.charAt(str1.length()-1);
					char c2=i<str2.length()?str2.charAt(i):str2.charAt(str2.length()-1);
					if(c1>c2) return -1;
					if(c1<c2) return 1;
				}
				return 0;
			}
		};
		Arrays.sort(array,cmp);
		StringBuilder sb=new StringBuilder();
		for(String str:array)
			sb.append(str);
		return sb.toString();
    }
    
    @Test
	public  void test(){
    	Assert.assertEquals("0",largestNumber(new int[]{0,0}));
    	Assert.assertEquals("100",largestNumber(new int[]{0,0,1}));
    	Assert.assertEquals("201",largestNumber(new int[]{1,20}));
    	Assert.assertEquals("111",largestNumber(new int[]{1,11}));
    	Assert.assertEquals("3210",largestNumber(new int[]{1,0,2,3}));
    	Assert.assertEquals("33210",largestNumber(new int[]{1,0,32,3}));
    	Assert.assertEquals("34310",largestNumber(new int[]{1,0,34,3}));
    	Assert.assertEquals("884644220110",largestNumber(new int[]{1,20,8,8,10,4,42,46}));
	}
}

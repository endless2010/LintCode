import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
 * 基本字符	I V X  L  C   D   M
        1 5 10 50 100 500 1000
相应的阿拉伯数字表示为	

相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
正常使用时、连写的数字重复不得超过三次。（表盘上的四点钟“IIII”例外）；
 */
public class RomanToInt {
	public int romanToInt(String s) {
		if(s==null || s.length()==0)
			return -1;
		s=s.toUpperCase();
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        map.put('I',1); map.put('V',5);map.put('X',10);
        map.put('L',50); map.put('C',100);map.put('D',500);
        map.put('M',1000);
        int result=map.get(s.charAt(0));
        int prev,curr;
        for(int i=1 ;i<s.length();++i){
        	prev=map.get(s.charAt(i-1));
        	curr=map.get(s.charAt(i));
        	if(curr<=prev)
        		result+=curr;
        	else
        		result+=curr-2*prev;
        }
        return result;
	}
	@Test
	public void test(){
		Assert.assertEquals(4,romanToInt("IV"));
		Assert.assertEquals(12,romanToInt("XII"));
		Assert.assertEquals(21,romanToInt("XXI"));
		Assert.assertEquals(99,romanToInt("XCIX"));
 	}
}

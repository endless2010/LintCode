import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
 * �����ַ�	I V X  L  C   D   M
        1 5 10 50 100 500 1000
��Ӧ�İ��������ֱ�ʾΪ	

��ͬ��������д������ʾ����������Щ������ӵõ��������磺��=3��
С�������ڴ�����ֵ��ұߡ�����ʾ����������Щ������ӵõ������� �磺��=8����=12��
С�����֡������� ��X �� C���ڴ�����ֵ���ߡ�����ʾ�������ڴ�����С���õ��������磺��=4����=9��
����ʹ��ʱ����д�������ظ����ó������Ρ��������ϵ��ĵ��ӡ�IIII�����⣩��
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

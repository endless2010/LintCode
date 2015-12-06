import org.junit.Assert;
import org.junit.Test;

/*

�����ַ�	I V X  L  C   D   M
        1 5 10 50 100 500 1000
��Ӧ�İ��������ֱ�ʾΪ	

��ͬ��������д������ʾ����������Щ������ӵõ��������磺��=3��
С�������ڴ�����ֵ��ұߡ�����ʾ����������Щ������ӵõ������� �磺��=8����=12��
С�����֡������� ��X �� C���ڴ�����ֵ���ߡ�����ʾ�������ڴ�����С���õ��������磺��=4����=9��
����ʹ��ʱ����д�������ظ����ó������Ρ��������ϵ��ĵ��ӡ�IIII�����⣩��
 */
public class Int2Rome {
	
    public String intToRoman(int n) {
        String[][] roman = {  
                {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},//1-9  
                {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},//10-90  
                {"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},//100-900
                {"","M", "MM", "MMM"}  //1000-3000
            }; 
        String str=String.valueOf(n);
        if(n<10)
        	return roman[0][n];
        else if(n<100)
        	return roman[1][str.charAt(0)-'0']+roman[0][str.charAt(1)-'0'];
        else if(n<1000)
        	return roman[2][str.charAt(0)-'0']+roman[1][str.charAt(1)-'0']+
        			roman[0][str.charAt(2)-'0'];
        else
        	return roman[3][str.charAt(0)-'0']+roman[2][str.charAt(1)-'0']+
        		   roman[1][str.charAt(2)-'0']+roman[0][str.charAt(3)-'0'];
    }

	@Test
    public void test(){	
    	Assert.assertEquals("I",intToRoman(1));
    	Assert.assertEquals("IV",intToRoman(4));
    	Assert.assertEquals("VI",intToRoman(6));
    	Assert.assertEquals("XXIX",intToRoman(29));  	   
    	Assert.assertEquals("MDCLXVI",intToRoman(1666));  	   
}
}
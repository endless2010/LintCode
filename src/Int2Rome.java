import org.junit.Assert;
import org.junit.Test;

/*

基本字符	I V X  L  C   D   M
        1 5 10 50 100 500 1000
相应的阿拉伯数字表示为	

相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
正常使用时、连写的数字重复不得超过三次。（表盘上的四点钟“IIII”例外）；
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
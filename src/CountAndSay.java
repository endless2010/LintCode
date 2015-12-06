/*
 * 报数指的是，按照其中的整数的顺序进行报数，然后得到下一个数。如下所示：
 * 1, 11, 21, 1211, 111221, ...
 * 1 读作 "one 1" -> 11.
 * 11 读作 "two 1s" -> 21.
 * 21 读作 "one 2, then one 1" -> 1211.
 * 给定一个整数 n, 返回 第 n 个顺序。
 */
public class CountAndSay {
	 String countAndSayForOneString(String input) {  
	        char tmp = input.charAt(0);  
	        int  num = 1;  
	        StringBuffer newString = new StringBuffer("");  
	        for(int k=1;k<input.length();k++) {  
	            if(input.charAt(k)==tmp) {  
	                num++;  
	                continue;  
	            }  
	            newString.append(Integer.toString(num) + tmp);  
	            tmp = input.charAt(k);  
	            num = 1;  
	        }  
	        newString.append(Integer.toString(num) + tmp);  
	        return newString.toString();  
	    }  
	      
	    public String countAndSay(int n) {  
	        String result = "1";  
	        int i = 1;  
	        while(i<n) {  
	            result = countAndSayForOneString(result);  
	            i++;  
	        }  
	        return result;  
	    }  
}

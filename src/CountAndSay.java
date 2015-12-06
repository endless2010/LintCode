/*
 * ����ָ���ǣ��������е�������˳����б�����Ȼ��õ���һ������������ʾ��
 * 1, 11, 21, 1211, 111221, ...
 * 1 ���� "one 1" -> 11.
 * 11 ���� "two 1s" -> 21.
 * 21 ���� "one 2, then one 1" -> 1211.
 * ����һ������ n, ���� �� n ��˳��
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

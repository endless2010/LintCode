import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class LetterCombinations {
	
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result=new ArrayList<String>();
        if(digits==null ||digits.length()==0)
        	return result;
        result.add("");
        String[] keyboard={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0;i<digits.length();++i){
        	ArrayList<String> temp=new ArrayList<String>();
        	for(int j=0;j<keyboard[digits.charAt(i)-'0'].length();++j){//a b c
        			for(int k=0;k<result.size();++k){     				
        				temp.add(result.get(k)+keyboard[digits.charAt(i)-'0'].charAt(j));
        			}
        	}
        	result=temp; 
        }
        Collections.sort(result);
        return result;
    }
    @Test
    public void test(){
    	System.out.println(letterCombinations("22"));
    	System.out.println(letterCombinations("23"));
    	System.out.println(letterCombinations("234"));
    }
}
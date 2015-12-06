import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/*
 * ��һ���ʵ䣬�ҳ�����������ĵ��ʡ������ж��
 * �������εİ취�������뵽�����ֻ����һ������û��ʲô�ð취��
 */

public class LongestWords {
    ArrayList<String> longestWords(String[] dictionary) {
    	ArrayList<String> list=new ArrayList<String>();
    	if(dictionary==null||dictionary.length<1)
    		return list;
    	list.add(dictionary[0]);
    	int currentLength=dictionary[0].length();
    	for(int i=1;i<dictionary.length;++i)
    			if(dictionary[i].length()>currentLength){
    				list.clear();
    				list.add(dictionary[i]);
    				currentLength=dictionary[i].length();
    			}else if(dictionary[i].length()==currentLength){
    				list.add(dictionary[i]);
    			}
        return list;
    }
    @Test
    public void test(){
    	ArrayList<String> list1=longestWords(new String[]{
    		  "dog",
    		  "google",
    		  "facebook",
    		  "internationalization",
    		  "blabla"
    	});
    	Assert.assertEquals(1,list1.size());
    	Assert.assertEquals(true,list1.contains("internationalization"));
    	ArrayList<String> list2=longestWords(new String[]{
    		  "like",
    		  "love",
    		  "hate",
    		  "yes"
    		});
    	Assert.assertEquals(3,list2.size());
    	Assert.assertEquals(true,list2.contains("like"));
    	Assert.assertEquals(true,list2.contains("love"));
    	Assert.assertEquals(true,list2.contains("hate"));
    }
}

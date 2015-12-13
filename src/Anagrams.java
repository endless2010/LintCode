import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an array of strings, return all groups of strings that are anagrams.
 * Have you met this question in a real interview? Yes
 * Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 * All inputs will be in lower-case
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> list=new ArrayList<String>();
        if(strs==null ||strs.length==0)
        	return list;
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(String s:strs){
        	char[] chars=s.toCharArray();
        	Arrays.sort(chars);
        	String sorted=String.valueOf(chars);
        	if(map.get(sorted)==null)
        		map.put(sorted, new ArrayList<String>());
        	map.get(sorted).add(s);
        }
        for(String s:map.keySet())
        	if(map.get(s)!=null && map.get(s).size()>1)
        		list.addAll(map.get(s));
        return list;
    }
    @Test
    public void test(){
    	List<String> list1=anagrams(new String[]{"lint", "intl", "inlt", "code"});
    	Assert.assertEquals(3,list1.size());
    	Assert.assertTrue(list1.contains("lint"));
    	Assert.assertTrue(list1.contains("intl"));
    	Assert.assertTrue(list1.contains("inlt"));
    	
    	List<String> list2=anagrams(new String[]{"ab", "ba", "cd", "dc", "e"});
    	Assert.assertEquals(4,list2.size());
    	Assert.assertTrue(list2.contains("ab"));
    	Assert.assertTrue(list2.contains("ba"));
    	Assert.assertTrue(list2.contains("cd"));
    	Assert.assertTrue(list2.contains("dc"));
    }
}

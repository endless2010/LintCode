import java.util.ArrayList;


public class LintCodeUtils {
    public static ArrayList<Integer> toArrayList(int[] nums){
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	for(int num:nums)
    		list.add(num);
    	return list;
    }
    public static int[] fromArrayList(ArrayList<Integer> list){
    	int[] array=new int[list.size()];
    	for(int i=0;i<list.size();++i)
    		array[i]=list.get(i);
    	return array;
    }
}

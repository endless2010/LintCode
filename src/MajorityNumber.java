import java.util.ArrayList;

/*
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 */
public class MajorityNumber {
	// 剑指offer算法29  
	    public int majorityNumber(ArrayList<Integer> nums) {
	    	int result=nums.get(0);
	    	int times=1;
	    	for(int i=1;i<nums.size();++i){
	    		if(times==0){
	    			result=nums.get(i);
	    			times=1;
	    		}
	    		else if(nums.get(i)==result)
	    			times++;
	    		else
	    			times--; 			
	    	}
	    	return result;
	    }

}

import java.util.ArrayList;

/*
 * ����һ���������飬�ҳ���Ԫ�أ����������еĳ��ִ����ϸ��������Ԫ�ظ����Ķ���֮һ��
 */
public class MajorityNumber {
	// ��ָoffer�㷨29  
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

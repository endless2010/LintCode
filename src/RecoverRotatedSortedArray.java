import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/*
 * 给定一个旋转排序数组，在原地恢复其排序。

您在真实的面试中是否遇到过这个题？ Yes
样例
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]


比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 */
public class RecoverRotatedSortedArray {
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	if(nums==null ||nums.size()==0)
    		return;
        int index=nums.size()-1;
        for(int i=1;i<nums.size();++i){
        	if(nums.get(i)<nums.get(i-1)){
        		index=i-1;
        		break;
        	}
        }
        reverse(nums,0,index);
        reverse(nums,index+1,nums.size()-1);
        reverse(nums,0,nums.size()-1);
    }
    private void reverse(ArrayList<Integer> nums,int from, int to) {
		while(from<to){
			int temp=nums.get(from);
			nums.set(from, nums.get(to));
			nums.set(to, temp);
			++from;
			--to;
		}	
	}
	@Test 
    public void test(){
    	ArrayList<Integer> list1=LintCodeUtils.toArrayList(new int[]{1,2,3,4,5});
    	ArrayList<Integer> list2=LintCodeUtils.toArrayList(new int[]{2,3,4,5,1});
    	ArrayList<Integer> list3=LintCodeUtils.toArrayList(new int[]{3,4,5,1,2});
    	ArrayList<Integer> list4=LintCodeUtils.toArrayList(new int[]{4,5,1,2,3});
    	ArrayList<Integer> list5=LintCodeUtils.toArrayList(new int[]{5,1,2,3,4});
    	recoverRotatedSortedArray(list1);
    	recoverRotatedSortedArray(list2);
    	recoverRotatedSortedArray(list3);
    	recoverRotatedSortedArray(list4);
    	recoverRotatedSortedArray(list5);
    	Assert.assertEquals(LintCodeUtils.toArrayList(new int[]{1,2,3,4,5}),list1);
    	Assert.assertEquals(LintCodeUtils.toArrayList(new int[]{1,2,3,4,5}),list2);
    	Assert.assertEquals(LintCodeUtils.toArrayList(new int[]{1,2,3,4,5}),list3);
    	Assert.assertEquals(LintCodeUtils.toArrayList(new int[]{1,2,3,4,5}),list4);
    	Assert.assertEquals(LintCodeUtils.toArrayList(new int[]{1,2,3,4,5}),list5);
    }
}

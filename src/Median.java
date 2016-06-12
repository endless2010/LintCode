import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ��δ������������飬�ҵ�����λ����
 * ��λ���������������м�ֵ���������ĸ�����ż�������򷵻����������ĵ�N/2������
 * ʱ�临�Ӷ�ΪO(n)
 */
public class Median {
	private void swap(int[] nums,int i,int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
    public int median(int[] nums) {
    	int mid=nums.length/2;
    	int i=mid-1,j=mid+1;
        for(;i>=0&&j<nums.length;i--,j++){
        	if(nums[i]>nums[mid])
        		swap(nums,i,mid);
        	if(nums[j]<nums[mid])
        		swap(nums,j,mid);
        }
        System.out.println(Arrays.toString(nums));
        	return nums[mid];
    }
    @Test
    public void test(){
    	Assert.assertEquals(3,median(new int[]{4, 5, 1, 2, 3}));
    	Assert.assertEquals(5,median(new int[]{7, 9, 4, 5}));
    	Assert.assertEquals(-3,median(new int[]{-1,-2,-3,-100,-1,-50}));
    }
}

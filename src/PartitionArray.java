import org.junit.Assert;
import org.junit.Test;

/*
 * �ָ�һ���������飬ʹ��������ǰż���ں�
 * ��ս:��ԭ��������ɣ���ʹ�ö���ռ䡣
 */
public class PartitionArray {
    public void partitionArray(int[] nums) {
        if(nums==null||nums.length==0)
        	return;
        int i=0,j=nums.length-1;
        while(i<j){
        	while(i<nums.length &&nums[i]%2!=0)
        		i++;
        	while(j>=0&&nums[j]%2==0)
        		j--;
        	if(i<j){
        		int temp=nums[i];
        		nums[i]=nums[j];
        		nums[j]=temp;
        	}
        }
    }
    @Test
    public void test(){
    	int[] nums={1,2,3,4};
    	partitionArray(nums);
    	Assert.assertArrayEquals(nums,new int[]{1, 3, 2, 4});
    }
}

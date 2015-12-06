import org.junit.Assert;
import org.junit.Test;

/*
 *������һ������İ�δ֪����ת����ת������(���磬0 1 2 4 5 6 7 ���ܳ�Ϊ4 5 6 7 0 1 2)��
 *����һ��Ŀ��ֵ����������������������ҵ�Ŀ��ֵ���������е�����λ�ã����򷵻�-1��
 *����[4, 5, 1, 2, 3]��target=1������ 2
 *����[4, 5, 1, 2, 3]��target=0������ -1
*/
public class SearchRotatedArray {
    public int search(int[] A, int target) {
    	if(A==null ||A.length==0)
    		return -1;
    	int low=0;
    	int high=A.length-1;
    	while(low<=high){
    		int mid=(low+high)/2;
        	if(A[mid]==target)
        		return mid;
        	if(A[low]<=A[mid]){
        		if(A[low]<=target && target<A[mid])
        			high=mid-1;
        		else
        			low=mid+1;
        	}else{
        		if(A[mid]<target && target<=A[high])
        			low=mid+1;
        		else
        			high=mid-1;
        	}
    	}
        return -1;
    }
    @Test
    public void test(){
    	Assert.assertEquals(2,search(new int[]{4, 5, 1, 2, 3},1));
    	Assert.assertEquals(-1,search(new int[]{4, 5, 1, 2, 3},0));
    	Assert.assertEquals(2,search(new int[]{4, 5, 6, 2, 3},6));
    	Assert.assertEquals(4,search(new int[]{4, 5, 6, 2, 3},3));
    	Assert.assertEquals(1,search(new int[]{4, 5, 6, 2, 3},5));
    	Assert.assertEquals(2,search(new int[]{6, 2, 3, 4, 5},3));
    	Assert.assertEquals(1,search(new int[]{2, 3, 4, 5, 6},3));
    }
}

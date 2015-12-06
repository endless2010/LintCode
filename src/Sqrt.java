import org.junit.Assert;
import org.junit.Test;

/*
 * ʵ�� int sqrt(int x) ���������㲢���� x ��ƽ������
 * O(log(x))
 */
public class Sqrt {
	   public int sqrt(int x) {
			if(x<2)
				return x;
			int low=0;
			int high=x;
			int mid=0;
			while(low<=high){
				mid=(low+high)/2;
				int xdivmid=x/mid;
				if (xdivmid==mid)
					return mid;
				else if(xdivmid>mid)
					low=mid+1;
				else
					high=mid-1;
			}
			return high;
	    }
	   @Test
	   public void test(){
		  Assert.assertEquals(1,sqrt(3));
		  Assert.assertEquals(2,sqrt(4));
		  Assert.assertEquals(2,sqrt(5));
		  Assert.assertEquals(3,sqrt(10));
	   }
}

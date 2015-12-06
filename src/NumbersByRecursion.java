import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/*
 * �õݹ�ķ����ҵ���1������Nλ������
 * ���� N = 1, ����[1,2,3,4,5,6,7,8,9].
 * ���� N = 2, ����[1,2,3,4,5,6,7,8,9,10,11,...,99].
 */
public class NumbersByRecursion {
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> result=new ArrayList<Integer>();
        if(n<=0)
        	return result;
        numbersByRecursion(result,1,n);
        return result;
    }

	private void numbersByRecursion(List<Integer> result,int m, int n) {
       if(m>n)
    	   return;
		long max=1;
        for(int i=0;i<m;++i)
        	max*=10;
        for(int i=(int) (max/10);i<max;++i)
        	result.add(i);
		numbersByRecursion(result,m+1,n);
	}
	@Test
	public void test(){
		System.out.println(numbersByRecursion(1));
		System.out.println(numbersByRecursion(2));
	}
}

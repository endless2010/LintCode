import org.junit.Assert;
import org.junit.Test;

/*
 * ����a��n�η� % b������a��b��n����32λ��������
 */
public class FastPower {
    public int fastPower(int a, int b, int n) {
        if(n==0)  
            return 1%b;  
        if(n==1)  
            return a%b;  
        long half = fastPower(a,b,n/2);  
        if((n&1)==1)  
            return (int) (((half*half)%b)*a%b);  
        else  
            return (int) (half*half%b);	
    }

    @Test
    public void test(){
    	Assert.assertEquals(1,fastPower(2,3,2));
    	Assert.assertEquals(2,fastPower(2,3,3));
    	Assert.assertEquals(2,fastPower(2,3,31));
    	Assert.assertEquals(0,fastPower(100,1000,1000));
    	Assert.assertEquals(5249911,fastPower(109,10000007,1000001)); 
    }
}

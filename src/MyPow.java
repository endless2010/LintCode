import org.junit.Assert;
import org.junit.Test;

public class MyPow {
    public double myPow(double x, int n) {
    	if(n<0)
    		return 1/myPow(x,-n);
    	if(n==0)
    		return 1;
    	if(n==1)
    		return x;
        double half=myPow(x,n/2);
        double result=half*half;
        if(n%2==1)
        	result*=x;
        return result;
    }
    @Test
    public void test(){
    	Assert.assertEquals(9.261,myPow(2.1,3),0.001);
    	Assert.assertEquals(0,myPow(0,1),0.001);
    	Assert.assertEquals(1,myPow(1,0),0.001);
    	Assert.assertEquals(0.25,myPow(2,-2),0.001);
    }
}

import org.junit.Assert;
import org.junit.Test;


public class Fibonacci {
    public int fibonacci(int n) {
    	if(n==1) return 0;
    	if(n==2) return 1;
    	int f1=0;
    	int f2=1;
    	int result=0;
    	for(int i=2;i<n;++i){
    		result=f1+f2;
    		f1=f2;
    		f2=result;
    	}
    	return result;
    }
    @Test
    public void test(){
    	Assert.assertEquals(0,fibonacci(1));
    	Assert.assertEquals(1,fibonacci(2));
    	Assert.assertEquals(1,fibonacci(3));
    	Assert.assertEquals(2,fibonacci(4));
    	Assert.assertEquals(3,fibonacci(5));
    	Assert.assertEquals(5,fibonacci(6));
    	Assert.assertEquals(8,fibonacci(7));
    	//0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    }
}

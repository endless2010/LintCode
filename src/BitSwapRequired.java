import org.junit.Assert;
import org.junit.Test;


public class BitSwapRequired {
    public int bitSwapRequired(int a,int b){
		String str1=Integer.toBinaryString(a);
		String str2=Integer.toBinaryString(b);
		int bits=0;
		for(int i=str1.length()-1,j=str2.length()-1;i>=0||j>=0;--i,--j){
			char c1=i>=0?str1.charAt(i):'0';
			char c2=j>=0?str2.charAt(j):'0';
			if(c1!=c2)
				bits++;
		}
		return bits;
	}
	@Test
	public void test(){
		Assert.assertEquals(0,bitSwapRequired(1,1));
		Assert.assertEquals(1,bitSwapRequired(0,1));
		Assert.assertEquals(2,bitSwapRequired(2,8));
		Assert.assertEquals(2,bitSwapRequired(4,13));
		Assert.assertEquals(4,bitSwapRequired(67,31));
		Assert.assertEquals(32,bitSwapRequired(Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
}

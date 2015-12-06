import org.junit.Assert;
import org.junit.Test;

/*
 * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
 * 请判定 第一个玩家 是输还是赢？
 */
public class FirstWillWin {
	   public boolean firstWillWin(int n) {
	        return n%3!=0;
	    }
	   
	   @Test
	   public void test(){
		   Assert.assertEquals(true,firstWillWin(1));
		   Assert.assertEquals(true,firstWillWin(2));
		   Assert.assertEquals(false,firstWillWin(3));
		   Assert.assertEquals(true,firstWillWin(4));
		   Assert.assertEquals(true,firstWillWin(5));
	   }
}
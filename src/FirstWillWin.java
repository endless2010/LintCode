import org.junit.Assert;
import org.junit.Test;

/*
 * �� n ��Ӳ���ų�һ���ߡ������������������ұ��������� 1 �� 2 ��Ӳ�ң�ֱ��û��Ӳ��Ϊֹ���õ����һöӲ�ҵ��˻�ʤ��
 * ���ж� ��һ����� ���仹��Ӯ��
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
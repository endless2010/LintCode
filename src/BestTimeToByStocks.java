import org.junit.Assert;
import org.junit.Test;

/*
 * ������һ�����飬���ĵ�i��Ԫ����һ֧�����Ĺ�Ʊ�ڵ�i��ļ۸�
 * ��������ֻ�������һ�ν���(����,һ��������Ʊ),���һ���㷨���ҳ��������
 * ����һ���������� [3,2,3,1,2], ���� 1 
 */
public class BestTimeToByStocks {
    public int maxProfit(int[] prices) {
    	if(prices==null||prices.length==0)
    		return 0;
    	int maxProfit=0;
    	int currentMin=Integer.MAX_VALUE;
    	for(int i=0;i<prices.length;++i){
    		if(prices[i]<currentMin)
    			currentMin=prices[i];
    		else if((prices[i]-currentMin)>maxProfit)
    			maxProfit=(prices[i]-currentMin);
    	}
        return maxProfit;
    }
    @Test
    public void test(){
    	Assert.assertEquals(1,maxProfit(new int[]{1,2}));
    	Assert.assertEquals(0,maxProfit(new int[]{2,1}));
    	Assert.assertEquals(1,maxProfit(new int[]{3,2,3,1,2}));
    	Assert.assertEquals(2,maxProfit(new int[]{3,2,4,1,2}));
    }
}
import org.junit.Assert;
import org.junit.Test;

/*
 * ������һ�����飬���ĵ�i��Ԫ����һ�������Ĺ�Ʊ�ڵ�i��ļ۸����һ���㷨���ҵ���������
 * �������ɾ����ܶ�Ľ���(���������Ʊ)��Ȼ��,�㲻��ͬʱ����������(��������ٴι���ǰ���۹�Ʊ)��
 * ����һ����������[2,1,2,0,1], ���� 2
 */
public class BestTimeToByStocks2 {
	
    public int maxProfit(int[] prices) {
    	if(prices==null||prices.length==0)
    		return 0;
    	int maxProfit=0;
    	int currentMin=prices[0];
    	for(int i=1;i<prices.length;++i){
    		if(prices[i]>currentMin)
    			maxProfit+=prices[i]-currentMin;
    		currentMin=prices[i];
    	}
        return maxProfit;
    }
    @Test
    public void test(){
    	Assert.assertEquals(4,maxProfit(new int[]{1,2,3,4,5}));
    	Assert.assertEquals(0,maxProfit(new int[]{5,4,3,2,1}));
    	Assert.assertEquals(3,maxProfit(new int[]{3,2,4,1,2}));
    	Assert.assertEquals(2,maxProfit(new int[]{2,1,2,0,1}));
    }
}
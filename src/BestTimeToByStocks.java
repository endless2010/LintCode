import org.junit.Assert;
import org.junit.Test;

/*
 * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
 * 如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
 * 给出一个数组样例 [3,2,3,1,2], 返回 1 
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
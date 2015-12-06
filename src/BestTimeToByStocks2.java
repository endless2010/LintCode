import org.junit.Assert;
import org.junit.Test;

/*
 * 假设有一个数组，它的第i个元素是一个给定的股票在第i天的价格。设计一个算法来找到最大的利润。
 * 你可以完成尽可能多的交易(多次买卖股票)。然而,你不能同时参与多个交易(你必须在再次购买前出售股票)。
 * 给出一个数组样例[2,1,2,0,1], 返回 2
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
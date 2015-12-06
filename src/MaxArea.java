import org.junit.Assert;
import org.junit.Test;

/*
 *  
 * 给定 n 个非负整数 a1, a2, ..., an, 每个数代表了坐标中的一个点 (i, ai)。画 n 条垂直线，
 * 使得 i 垂直线的两个端点分别为(i, ai)和(i, 0)。
 * 找到两条线，使得其与 x 轴共同构成一个容器，以容纳最多水。
 */
public class MaxArea {
    public int maxArea(int[] heights) {
    	if(heights==null ||heights.length==0)
    		return 0;
    	int maxArea=0;
    	for(int i=0,j=heights.length-1;i>=0&&i<j;){
    		int area=0;
    		if(heights[i]<heights[j]){
    			area=heights[i]*(j-i);
    			i++;
    		}else{
    			area=heights[j]*(j-i);
    			j--;
    		}
    		if(area>maxArea)
    			maxArea=area;
    	}
        return maxArea;
    }
    @Test
    public void test(){
    	Assert.assertEquals(2,maxArea(new int[]{1,3,2}));
    	Assert.assertEquals(1,maxArea(new int[]{1,1}));
    }
}

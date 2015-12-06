import org.junit.Assert;
import org.junit.Test;

/*
 *  
 * ���� n ���Ǹ����� a1, a2, ..., an, ÿ���������������е�һ���� (i, ai)���� n ����ֱ�ߣ�
 * ʹ�� i ��ֱ�ߵ������˵�ֱ�Ϊ(i, ai)��(i, 0)��
 * �ҵ������ߣ�ʹ������ x �Ṳͬ����һ�����������������ˮ��
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

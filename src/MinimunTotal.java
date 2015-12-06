import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
比如，给出下列数字三角形：
[
  [2],
  [3,4],
  [6,5,7],
  [4,1,8,3]
]
从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)
 */
public class MinimunTotal {
	public int minimumTotal(int[][] triangle){
		if(triangle==null)
			return 0;
		List<Integer> total=new ArrayList<Integer>();
		for(int i=triangle.length-1;i>=0;--i){
			for(int j=0;j<=i;++j){
				if(i==triangle.length-1)
					total.add(triangle[i][j]);
				else{
					total.set(j, triangle[i][j]+Math.min(total.get(j),total.get(j+1)));
				}
			}
		}
		return total.get(0);
	}
}

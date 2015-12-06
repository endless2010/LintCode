import java.util.ArrayList;
import java.util.List;

/*
 * ����һ�����������Σ��ҵ��Ӷ������ײ�����С·���͡�ÿһ�������ƶ�������һ�е����������ϡ�
���磬�����������������Σ�
[
  [2],
  [3,4],
  [6,5,7],
  [4,1,8,3]
]
�Ӷ����ײ�����С·����Ϊ11 ( 2 + 3 + 5 + 1 = 11)
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

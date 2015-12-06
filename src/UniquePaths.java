import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 * ��һ�������˵�λ��һ��M��N���������Ͻǣ���ͼ�б��Ϊ'Start'����
 * ������ÿһʱ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ���ͼ�б��Ϊ'Finish'����
 * ���ж�������ͬ��·����
 */
public class UniquePaths {
	
	public List<Integer> next(List<Integer> temp){
		List<Integer> result=new ArrayList<Integer>();
		result.add(1);
		for(int i=1;i<temp.size();++i)
			result.add(temp.get(i)+temp.get(i-1));
		result.add(1);
		return result;
	}
    public List<Integer> getRow(int rowIndex) {
		 List<Integer> list=Arrays.asList(1);
		 for(int i=0;i<rowIndex;++i){
			 list=next(list);
		 }
		 return list;
    }
    
	public int uniquePaths(int  m,int n){
		if(m>n)
			return getRow(m+1).get(n+1);
		else
			return getRow(n+1).get(m+1);
	}
	@Test
	public void test(){
		Assert.assertEquals(3,uniquePaths(2,3));
		Assert.assertEquals(4,uniquePaths(2,4));
		Assert.assertEquals(6,uniquePaths(3,3));
		Assert.assertEquals(10,uniquePaths(3,4));
	}
}

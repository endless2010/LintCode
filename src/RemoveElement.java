import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ�������һ��ֵ����ԭ��ɾ����ֵ��ͬ�����֣�����������ĳ��ȡ�
 * Ԫ�ص�˳����Ըı䣬����ֵ֮���Ԫ������û��Ӱ��
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
    	if(A==null||A.length==0)
    		return 0;
        int insertIndex=0;
        for(int i=0;i<A.length;++i){
        	if(A[i]!=elem)
        		A[insertIndex++]=A[i];
        }
        return insertIndex;
    }
    @Test
    public void test(){
    	Assert.assertEquals(3,removeElement(new int[]{1,2,3,4},4));
    	Assert.assertEquals(0,removeElement(new int[]{4,4,4,4},4));
    	Assert.assertEquals(4,removeElement(new int[]{0,4,4,0,0,2,4,4},4));
    }
}

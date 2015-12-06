import org.junit.Assert;
import org.junit.Test;

/*
 * �����ݽṹ�У���ϣ������������һ���ַ��������κ��������ͣ�ת��ΪС�ڹ�ϣ���С�Ҵ��ڵ������������һ���õĹ�ϣ�������Ծ������ٵز�����ͻ��
 * һ�ֹ㷺ʹ�õĹ�ϣ�����㷨��ʹ����ֵ33�������κ��ַ������ǻ���33��һ�������������磺
 
	hashcode("abcd") = (ascii(a) * 33(3) + ascii(b) * 33(2) + ascii(c) *33 + ascii(d)) % HASH_SIZE 
                              = (97* 33*33*33 + 98 * 33*33 + 99 * 33 +100) % HASH_SIZE
                              = 3595978 % HASH_SIZE
 * ����HASH_SIZE��ʾ��ϣ��Ĵ�С(���Լ���һ����ϣ�����һ������0 ~ HASH_SIZE-1������)��
 * ����һ���ַ�����Ϊkey��һ����ϣ��Ĵ�С����������ַ����Ĺ�ϣֵ��
 * ����key="abcd" ���� size=100�� ���� 78                         
 */
public class HashCode {
    public int hashCode(char[] key,int HASH_SIZE) {
    	long sum=0;
    	long power=1;
    	for(int i=key.length-1;i>=0;--i){
    		sum+=((int)key[i]*power)%HASH_SIZE;
    		power=(power*33)%HASH_SIZE;
    	}
        return (int) (sum%HASH_SIZE);
    }
    @Test
    public void test(){
    	Assert.assertEquals(78,hashCode("abcd".toCharArray(),100));
    	Assert.assertEquals(549,hashCode("ubuntu".toCharArray(),1007));
    	Assert.assertEquals(1673,hashCode("abcdefghijklmnopqrstuvwxyz".toCharArray(),2607));
    }
}

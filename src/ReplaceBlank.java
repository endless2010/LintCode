import org.junit.Assert;
import org.junit.Test;

/*
 * ���һ�ַ�������һ���ַ����е����пո��滻�� %20 ��
 * ����Լ�����ַ������㹻�Ŀռ��������µ��ַ�������õ����ǡ���ʵ�ġ��ַ����ȡ�
 * �����ַ���"Mr John Smith", ����Ϊ 13
 * �滻�ո�֮��Ľ��Ϊ"Mr%20John%20Smith"
 * ��ԭ�ַ���(�ַ�����)������滻����ʹ�ö���ռ�
 */
public class ReplaceBlank {
    public int replaceBlank(char[] string, int length) {
        int numOfBlanks=0;
        for(int i=0;i<length;++i)
        	if(string[i]==' ')
        		numOfBlanks++;
        int realLength=length+numOfBlanks*2;
        for(int i=length-1,j=realLength-1;i>=0&&i<j;--i)
        	if(string[i]==' '){
        		string[j--]='0';
        		string[j--]='2';
        		string[j--]='%';
        	}else{
        		string[j--]=string[i];
        	}
        return realLength;
    }
    @Test
    public void test(){
    	Assert.assertEquals(5,replaceBlank("Hello".toCharArray(),5));
    	Assert.assertEquals(17,replaceBlank("Mr John Smith       ".toCharArray(),13));
    }
}

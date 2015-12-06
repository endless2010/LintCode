import org.junit.Assert;
import org.junit.Test;

/*
 * 设计一种方法，将一个字符串中的所有空格替换成 %20 。
 * 你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
 * 对于字符串"Mr John Smith", 长度为 13
 * 替换空格之后的结果为"Mr%20John%20Smith"
 * 在原字符串(字符数组)中完成替换，不使用额外空间
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

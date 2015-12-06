import org.junit.Test;

/*
 * ����һ��ֻ������ĸ���ַ�����������Сд��ĸ���д��ĸ��˳���������
 */
public class SortLetters {
    public void sortLetters(char[] chars) {
    	if(chars==null||chars.length<=1)
    		return;
    	int i=0,j=chars.length-1;
    	while(i<j){
    		while(i<chars.length&&'a'<=chars[i]&&chars[i]<='z')
    			i++;
    		while(j>0&&'A'<=chars[j]&&chars[j]<='Z')
    			j--;
    		if(i<j&&i<chars.length && j>=0){
    			char temp=chars[i];
    			chars[i]=chars[j];
    			chars[j]=temp;
    		}
    	}
    }
   
    /**
     * 
     */
    @Test
    public void test(){
    	sortLetters("abAcD".toCharArray());
    	sortLetters("ab".toCharArray());
    }
}

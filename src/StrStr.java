/*
 * �ַ������ң��ֳƲ������ַ����������ַ���������һ�������õĺ��������������ʵ�����������
 * ����һ�������� source �ַ�����һ�� target �ַ�������Ӧ���� source �ַ������ҳ� target �ַ������ֵĵ�һ��λ��(��0��ʼ)
 * ��������ڣ��򷵻� -1
 * TODO:O(n2)���㷨�ǿ��Խ��ܵġ����������O(n)���㷨�������Ǹ��Ӻá�����ʾ��KMP��
 */
public class StrStr {
    public int strStr(String source, String target) {
        if(source==null || target==null)
        	return -1;
        return source.indexOf(target);
    }
}

import org.junit.Test;

/*
 * ����һ������ÿ���ڵ����һ���������ӵ����ָ�����ָ�������е��κνڵ��յĽڵ㡣
 * ����һ�����������
 * http://blog.csdn.net/litoupu/article/details/41623807
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {  
        
        if (head == null)  
            return head;  
        /*��һ��:��OldList��ÿ���ڵ���涼����һ��copyNode(��������Ľ��)*/  
        RandomListNode nowNode = head;  
        while (nowNode != null){  
            RandomListNode copyNode = new RandomListNode(nowNode.label);  
            copyNode.random = nowNode.random;  
            copyNode.next = nowNode.next;  
            nowNode.next = copyNode;  
            nowNode = nowNode.next.next;  
        }  
          
        /*�ڶ���:ȷ��NewList��ÿ���ڵ�,������������Random������ĸ��� 
         *      ��Ϊ��һ���Ѿ�������NewList�ϵĽ�㶼������*/  
        nowNode = head;  
        while (nowNode != null){  
            if (nowNode.random != null){  
                nowNode.next.random = nowNode.random.next;  
            }  
            nowNode = nowNode.next.next;  
        }  
          
        /*����������ԭOldList��nextΪһ��ʼ��next��� 
         *      ��ƴ��NewList��next����������Ӧ�ù�����next��� 
         *      ��������������OldList���䣬ƴ��������NewList�� 
         * */  
        RandomListNode pHead = new RandomListNode(0);  
        pHead.next = head;  
        RandomListNode newlist = pHead;  
          
        nowNode = head;  
        while (nowNode != null){  
            pHead.next = nowNode.next;  
            nowNode.next = pHead.next.next;  
            pHead = pHead.next;  
            nowNode = nowNode.next;  
        }  
        return newlist.next;  
    }  
    @Test
    public void test(){
    	
    }
}

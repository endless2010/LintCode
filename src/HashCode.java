import org.junit.Assert;
import org.junit.Test;

/*
 * 在数据结构中，哈希函数是用来将一个字符串（或任何其他类型）转化为小于哈希表大小且大于等于零的整数。一个好的哈希函数可以尽可能少地产生冲突。
 * 一种广泛使用的哈希函数算法是使用数值33，假设任何字符串都是基于33的一个大整数，比如：
 
	hashcode("abcd") = (ascii(a) * 33(3) + ascii(b) * 33(2) + ascii(c) *33 + ascii(d)) % HASH_SIZE 
                              = (97* 33*33*33 + 98 * 33*33 + 99 * 33 +100) % HASH_SIZE
                              = 3595978 % HASH_SIZE
 * 其中HASH_SIZE表示哈希表的大小(可以假设一个哈希表就是一个索引0 ~ HASH_SIZE-1的数组)。
 * 给出一个字符串作为key和一个哈希表的大小，返回这个字符串的哈希值。
 * 对于key="abcd" 并且 size=100， 返回 78                         
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

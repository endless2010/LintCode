/*
 * 字符串查找（又称查找子字符串），是字符串操作中一个很有用的函数。你的任务是实现这个函数。
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)
 * 如果不存在，则返回 -1
 * TODO:O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）
 */
public class StrStr {
    public int strStr(String source, String target) {
        if(source==null || target==null)
        	return -1;
        return source.indexOf(target);
    }
}

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;
/*
 * Given an absolute path for a file (Unix-style), simplify it.

Have you met this question in a real interview? Yes
Example
"/home/", => "/home"

"/a/./b/../../c/", => "/c"

Challenge
Did you consider the case where path = "/../"?

In this case, you should return "/".

Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".

In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {

	public String simplifyPath(String path) {
		if (path == null || path.length() <= 1)
			return path;
		Stack<String> stack = new Stack<String>();
		for (String str : path.split("/")) {
			if (str == null || str.length() == 0 || str.equals("."))
				continue;
			if (str.equals("..") && !stack.isEmpty())
				stack.pop();
			else
				stack.push(str);
		}
		StringBuilder sb = new StringBuilder();
		if (stack.isEmpty())
			sb.append("/");
		else {
			while (!stack.isEmpty()) {
				sb.insert(0, "/" + stack.pop());
			}
		}
		return sb.toString();
	}

	@Test
	public void test() {
		Assert.assertEquals("/", simplifyPath("/"));
		Assert.assertEquals("/", simplifyPath("///"));
		Assert.assertEquals("/home", simplifyPath("home"));
		Assert.assertEquals("/home", simplifyPath("/home"));
		Assert.assertEquals("/home", simplifyPath("/home/"));
		Assert.assertEquals("/home/test", simplifyPath("/home/test"));
		Assert.assertEquals("/home/test", simplifyPath("/home/test/./"));
		Assert.assertEquals("/home", simplifyPath("/home/test/../"));
		Assert.assertEquals("/home", simplifyPath("/home/././test/../"));
	}
}
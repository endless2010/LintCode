import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

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
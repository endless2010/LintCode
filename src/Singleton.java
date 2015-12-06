/*
 * Singleton is a most widely used design pattern. 
 * If a class has and only has one instance at every moment, 
 * we call this design as singleton. For example, 
 * for class Mouse (not a animal mouse), we should design it in singleton.
 * You job is to implement a getInstance method for given class,
 * return the same instance of this class every time you call this method.
 * 
 * Challenge:If we call getInstance concurrently, can you make sure your code could run correctly
 */
class Solution {
	private static Solution instance = new Solution();
	public static Solution getInstance() {
		return instance;
	}
}

public class Singleton {

}

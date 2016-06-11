import org.junit.Assert;
import org.junit.Test;

/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * You can assume that no duplicate edges will appear in edges. 
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class ValidTree {
    public boolean validTree(int n, int[][] edges) {  
        int[] parent = new int[n];  
        for(int i = 0; i < n; i++)  
            parent[i] = i;  
        for(int i = 0; i < edges.length; i++) {  
            int root1 = find(parent, edges[i][0]);  
            int root2 = find(parent, edges[i][1]);  
            if(root1 == root2)  
                return false;  
            parent[root2] = root1;  
        }  
        return edges.length == n - 1;  
    }  
      
    private int find(int[] root, int e) {  
        if(root[e] == e)  
            return e;  
        else  
            return find(root, root[e]);  
    } 

	@Test
	public void test() {
		int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 }, };
		Assert.assertEquals(true, validTree(5, edges1));

		int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 }, };
		Assert.assertEquals(true, validTree(5, edges2));
	}
}

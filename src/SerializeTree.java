import org.junit.Test;

public class SerializeTree {

	public String  serialize(TreeNode root){
		if(root==null)
			return "";
		else{
			String left=serialize(root.left);
			String right=serialize(root.right);
			String leftPart=root.val+"{";
			return leftPart+left+","+right+"["+leftPart.length()+","+(leftPart.length()+left.length())+"]}";
		}
	}
	
	public TreeNode  deserialize(String data){
		TreeNode root=null;
		if(data==null ||data.length()==0)
			return root;
		int lastIndexOfComma=data.lastIndexOf(',');
		int leftIndex=Integer.parseInt(data.substring(data.lastIndexOf('[')+1,
				lastIndexOfComma));
		int rightIndex=Integer.parseInt(data.substring(lastIndexOfComma+1,
					data.lastIndexOf(']')));
		
		root=new TreeNode(Integer.parseInt(data.substring(0,data.indexOf('{'))));
		if(rightIndex==leftIndex){
			root.left=null;
		}else if(rightIndex>leftIndex){
			root.left=deserialize(data.substring(leftIndex,rightIndex));			
		}
		root.right=deserialize(data.substring(rightIndex+1, data.lastIndexOf('[')));
		return root;
	}
	
	@Test
	public void test(){
		TreeNode root=TreeNode.createTree(1,2,3,null,null,4);
		System.out.println(serialize(root));
		System.out.println(deserialize(serialize(root)));
		
		TreeNode node=new TreeNode(1);
		node.right=new TreeNode(2);
		System.out.println(serialize(node));
		System.out.println(deserialize(serialize(node)));
		
	}
}

public class BinarySearchTree {

	public static float BSTComparisons;

	class Node
	{
		String key;
		Node left, right;
		
		public Node(String item) 
		{
			key = item;
			left = right = null;
		}
	}
	Node root; 
	
	BinarySearchTree()
	{
		root = null;
	}
	
	public void insert (String key)
	{
		root = insertRecurssive( root,  key);
	}
	
	public Node insertRecurssive(Node root, String key)
	{
		if (root == null)
		{
			root = new Node(key);
			return root;
		}//if
		
		if(key.compareToIgnoreCase(root.key)<0)
		{
			root.left = insertRecurssive(root.left, key);
			System.out.print("L");
		}
		else if(key.compareToIgnoreCase(root.key)>=0)
		{
			root.right = insertRecurssive(root.right, key);
			System.out.print("R");
		}
		return root;
	}
	
	public void inOrder()
	{
		inOrderRecurissive(root);
	}
	
	public void inOrderRecurissive(Node root)
	{
		if(root != null)
		{
			inOrderRecurissive(root.left);
			System.out.println(root.key);
			inOrderRecurissive(root.right);
		}
	}
	
	public Node search( Node root, String key)
	{
		if(root == null || root.key.compareToIgnoreCase(key) == 0)
		{
			BSTComparisons++;
			return root;
		}
			
		if (root.key.compareToIgnoreCase(key)< 0)
		{
			BSTComparisons++;
			System.out.print("R");
			return search(root.right, key);
		}
			
		else
		{
			BSTComparisons++;
			System.out.print("L");
			return search(root.left, key);
		}
		
			
	}
	
	public float countComps()
	{
		return BSTComparisons;
	}
	
	public void resetComps()
	{
		BSTComparisons = 0; 
	}
}


public class BinarySearchTree 
{

	//comparison counter 
	public static float BSTComparisons;

	class Node
	{
		String key;
		Node left, right;
		
		public Node(String item) 
		{
			key = item;
			left = right = null;
		}//Node
	}//Node 
	
	Node root; 
	
	BinarySearchTree()
	{
		root = null;
	}//BinarySearchTree
	
	public void insert (String key)
	{
		root = insertRecurssive( root,  key);
	}//insert
	
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
		}//if
		else if(key.compareToIgnoreCase(root.key)>=0)
		{
			root.right = insertRecurssive(root.right, key);
			System.out.print("R");
		}//elseif
		return root;
	}//insertRecurssive
	
	public void inOrder()
	{
		inOrderRecurissive(root);
	}//inOrder
	
	public void inOrderRecurissive(Node root)
	{
		if(root != null)
		{
			inOrderRecurissive(root.left);
			System.out.println(root.key);
			inOrderRecurissive(root.right);
		}//inOrderRecurissive
	}//inOrderRecurissive
	
	public Node search( Node root, String key)
	{
		//if the tree is empty or the one we are looking at matches the one 
		//we are searching for return the one we are looking at (root)
		if(root == null || root.key.compareToIgnoreCase(key) == 0)
		{
			BSTComparisons++;
			return root;
		}//if
			
		//if key comes after the one we are looking at go the right 
		if (root.key.compareToIgnoreCase(key)< 0)
		{
			BSTComparisons++;
			System.out.print("R");
			return search(root.right, key);
		}//if
		
		//if key comes before the one we are looking at go the left 
		else
		{
			BSTComparisons++;
			System.out.print("L");
			return search(root.left, key);
		}//else
	}//search
	
	public float countComps()
	{
		return BSTComparisons;
	}//countComps
	
	public void resetComps()
	{
		BSTComparisons = 0; 
	}//resetComps
}//BinarySearchTree

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class LinkedListNew {
	Node root = null;
	int count;
	
	public void addNode(Object data) throws Exception
	{
		if(data instanceof Character && data.toString().length() == 1)
		{
			return;
		}
		
		if((int)data > (Integer.MAX_VALUE - 1)  || (int)data < (Integer.MIN_VALUE+ 1))
		{
			throw new IllegalArgumentException("The data entered does not fitst in the range of integers");
		}	
		
		Node newNode = new Node();
		newNode.data = (int)data;
		
		if(root == null)
		{
			root = newNode;
			count++;
			return;
		}
		
		
		Node tempNode = root;
		while(tempNode.nextNode != null)
			tempNode = tempNode.nextNode;
				
		tempNode.nextNode = newNode;
		//root.nextNode.data = data;
		count++;
	}
	
	public int getNodesCount()
	{
		return count;
	}
	
	public int getDataAt(int index)
	{
		int tracker = 0;
		Node tempNode = root;
		while(tracker != index && index < count)
		{
			tempNode = tempNode.nextNode;
			tracker+=1;
		}
		
		return tempNode.data;
	}
	
	public void removeAt(int index)
	{
		int tracker = 0;
		Node tempNode = root;
		Node tempNode2 = root.nextNode;
		
		
		while(tracker != index -1 && index < count)
		{
			tempNode = tempNode.nextNode;
			tempNode2 = tempNode2.nextNode;
			tracker+=1;
		}
		tempNode.nextNode = tempNode2.nextNode;
		
	}
	
	public void reverse()
	{
		Node current = root;
		Node next = null;
		Node prev = null;
		
		while(current != null)
		{
			next = current.nextNode;
			current.nextNode = prev;
			prev = current;
			current = next;
		}
		root = prev;
	}
	
	public String toString()
	{
		
		Node tempNode = root;
		String cat = "";
		
		int i = 0;
		while(tempNode != null)
		{
			cat += "[Node "+i+" -> "+ tempNode.data+"]";
			
			tempNode = tempNode.nextNode;
			i++;
		}
		return cat + " " + count;
	}

}

class Node
{
	Node currentNode;
	Node nextNode;
	int data;
	
	Node()
	{
		
	}
	
	Node(int data)
	{
		this.data = data;
	}
}




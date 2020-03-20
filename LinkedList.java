public class LinkedList<T> implements List<T>  {
    int size = 0;
    Node head;  // head of list 
    
  //Creates an empty list
    public LinkedList() {
    	head = null;
    }
    
    //Linked List node
    public class Node{
    	T list;
        Node next;
        
       //constructor node
        public Node(T item) {
            list = item;
        }
    }
  
    //insert a node : Add method
    public void add(T item) {
        //if the linked list is empty then make the new node as head
        if(head == null) {
            head = new Node(item);
            size++;
        }
        else {
        	// Else traverse till the last node 
            // and insert the new_node there 
            Node node = new Node(item);
            Node prev = head;
            while(prev.next != null)                
                prev = prev.next;
                prev.next = node;
            size++;
        }
    }
    
    // inserting the element at a position
    public void add(int pos, T item){
  
        if(pos == 0) {
            Node node = new Node(item);
            node.next = head;
            head = node;
            size++;
        }else{
            Node node = new Node(item);
            Node prev = head;
            for(int i = 0; i < pos-1; i++) 
                prev = prev.next;
        
            node.next = prev.next;
            prev.next = node;
            size++; 
        }   
    }
    
    //get list from the position node
    public T get(int pos) {
        
        if(pos < 0 || pos+1 > size)
            return null;
        
        Node node = head;
        
        for(int i = 0; i < pos; i++)
            node = node.next;
        
        return node.list;
        
        
        
    }
    //remove element 
    public T remove(int pos) {
        
        if(pos < 0 || pos+1 > size)
            return null;
        
        if(pos == 0) {
            Node node = head;
            head = head.next;
            size--;
            return node.list;
        }
        
        Node prev = head;
        for(int i = 0; i < pos-1; i++) 
            prev = prev.next;
        
        Node node = prev.next;
        prev.next = node.next;
        size--;
        return node.list;           
    }
	
    //Returns the number of elements currently in this list.
    public int size()
    {       
        return size;
    }

}
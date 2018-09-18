class Node<E> {
  public E data;
  public Node<E> next;
  public Node<E> previous;

  public Node(E data) {
    this.data = data;
  }

  public String toString() {
    return data + " ";
  }
}


class DoublyLinkedList<E> {
  private Node<E> first;
  private Node<E> last;
  int count;
  
  public DoublyLinkedList() {
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return first == null;
  }
  
  //Done
  public Node<E> getFirst() {
	  return first;
  }
  
  //Done
  public int contains(E data) {
	  Node<E> current = first;
	  int res = 0;
	  while(current != null) {
	      if (current.data.equals(data)) {
	    	  	return res;
	      }
	      else {
	    	  	res++;
	    	  	current = current.next;
	      }
	  }
	  return -1;
  }
  
  //Done
  public void insertFirst(E data) {
    Node<E> newNode = new Node<E>(data);
    if (isEmpty()){
      last = newNode;
    }
    else{
      first.previous = newNode;
    }
    newNode.next = first;
    first = newNode;
    count++;
  }
  
  //Done
  public void insertLast(E data) {
    Node<E> newLink = new Node<E>(data);
    if (isEmpty()){
      first = newLink;
    }
    else {
      last.next = newLink;
      newLink.previous = last;
    }
    last = newLink;
    count++;
  }

  //Done
  public Node<E> deleteFirst() {
    Node<E> temp = first;
    if (first.next == null){
      last = null;
    }else{
      first.next.previous = null;
    }
    first = first.next;
    return temp;
  }

  //Done
  public Node<E> deleteLast() {
    Node<E> temp = last;
    if (first.next == null){
      first = null;
    }else{
      last.previous.next = null;
    }
    last = last.previous;
    return temp;
  }

  //Done
  public void delete(E data) {
	    Node<E> current = first;
	    while (!(current.data.equals(data))) {
	      current = current.next;
	      if (current == null)
	        return;
	    }
	    if (current == first){
	      first = current.next;
	    }else{
	      current.previous.next = current.next;
	    }
	    
	    if (current == last){
	      last = current.previous;
	    }else{
	      current.next.previous = current.previous;
	    }
	    return;
  }
  
  //Done
  public String Forward() {
	  String str = "";
	  Node<E> current = first;
	  while (current != null) {
	      str += current.toString();
	      current = current.next;
	  }
	  return str;
  }
  
  //Done
  public String Backward() {
    String str = "";
    Node<E> current = first;
    current = last;
    while (current != null) {
      str += current.toString();
      current = current.previous;
    }
    return str;
  }
  
  
}


public class LL {
	
  public static void main(String[] args) {
    DoublyLinkedList<String> theList = new DoublyLinkedList<String>();

    theList.insertLast("Hello");
    theList.insertLast("There");
    theList.insertFirst("Welcome,");
    theList.insertLast("User");

    
    System.out.println("Forward: " + theList.Forward());

  }
  
 
}

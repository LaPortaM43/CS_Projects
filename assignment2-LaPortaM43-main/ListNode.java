package edu.monmouth.hw2;
import edu.monmouth.book.*;

public class ListNode {

  private Node head; 

  public ListNode() {
    head = null;
  }
  
  public Book removeFirst() {
    if (head == null) {
        return null;
    }
    Node removedNode = head;
    head = head.getNext();
    removedNode.setNext(null);
    return removedNode.getInfo();
  }
  
  
  public Book first() {
	    if (head == null) {
	        return null; 
	    }
	    return head.getInfo();
	}

  
  public Node last() {
	    if (head == null) {
	        return null;
	    }
	    Node current = head;
	    while (current.getNext() != null) {
	        current = current.getNext();
	    }
	    return current;
	}


  public void insert(Book element) {
    Node newNode = new Node(element);
    newNode.setNext(head);
    head = newNode;
  }

  public void insertEnd(Book element) {
	    Node newNode = new Node(element);
	    if (head == null) {
	        head = newNode;
	    } else {
	        Node lastNode = last();
	        lastNode.setNext(newNode);
	    }
	}


  public boolean isEmpty() { 
    return head == null;
  }
  
  public int size() {
    int count = 0;
    Node current = head;
    while (current != null) {
        count++;
        current = current.getNext();
    }
    return count;
  }
    
  public void clear() {
    head = null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node current = head;
    while (current != null) {
        sb.append(current.getInfo().toString()).append("\n");
        current = current.getNext();
    }
    return sb.toString();
  }
}


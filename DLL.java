public class DLL<E> {

	private Node<E> head;
	private Node<E> tail;
	private int counter;

	class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		// Initializes all fields to null.
		public Node() {
			this.element = null;
			this.prev = null;
			this.next = null;
		}

		// Initializes the element field to the
		// specified paramenter, and everything else null
		public Node(E element) {
			this.element = element;
			this.prev = null;
			this.next = null;
		}

		// Initializes all fields to the specified parameters
		public Node(E element, Node<E> prev, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}

		// getters and setters
		public E getElement() {
			return this.element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getPrev() {
			return this.prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return this.next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

	} // Node

	// DLL constructor
	public DLL() {
		this.head = null;
		this.tail = null;
		counter = 0;
	}

	// tested
	public int size() {
		return counter;
	}

	// tested
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	// tested
	// Returns (but does not remove) the first element of the list
	public E first() {
		if (this.isEmpty()) {
			return null;
		}
		return head.getElement();
	}

	// tested
	public E last() {
		if (this.isEmpty()) {
			return null;
		}
		return tail.element;
	}

	// tested 
	public void addFirst(E element) {
		Node<E> temp = new Node<E>(element);
		if (size() == 0) {
			head = temp;
			tail = temp;
		} else {
			temp.setNext(head);
			head.setPrev(temp);
			head = temp;
		}
		counter++;
	}

	// tested
	public void addLast(E element) {
		Node<E> temp = new Node<E>(element);
		if (size() == 0) {
			tail = temp;
			head = temp;
		} else {
			temp.setPrev(tail);
			tail.setNext(temp);
			tail = temp;
		}
		counter++;
	}

	// tested
	public String toString() {
		String temp = "null";
		Node<E> tempNode = new Node<E>();
		tempNode = head;
		if (this.isEmpty() == true) {
			return temp;
		} else {
			temp += " <-- ";
			while (tempNode.getNext() != null) {
				temp += tempNode.getElement() + " <--> ";
				tempNode = tempNode.getNext();
			}
			temp += tempNode.getElement() + " --> null";
		}
		return temp;
	}

	// Removes and returns the first element of the list.
	// tested
	public E removeFirst() {
		if (this.isEmpty()) {
			return null;
		}
		Node<E> temp = new Node<E>();
		temp = head;
		head = head.getNext();
		temp.setNext(null);
		counter--;
		return temp.getElement();
	}

	// tested
	public E removeLast() {
		if (this.isEmpty()) {
			return null;
		}
		Node<E> temp = new Node<E>();
		temp = tail;
		tail = tail.getPrev();
		tail.setNext(null);
		temp.setPrev(null);
		counter--;
		return temp.getElement();
	}

//tested!
//		 Retrieves an element at the specified position in the list(does
//  	not remove it from the list). If an index is out of bounds, return null. List
//		elements start at 0 
	public E get(int index) {
		// OOB check
		if (index >= this.size() || index < 0) {
			return null;
		}

		Node<E> temp = new Node<E>();
		temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp.getElement();
	}// get

	//tested
	public void insert(int index, E element) {
		// test OOB --> if empty and not 0
		if (this.isEmpty()) {
			if (index == 0) {
				this.addFirst(element);
			} else { // so if empty and index not 0
				System.out.println("OOB: index not 0 on empty list");
			}
		} else {
			if (this.size() < index || index < 0) {
				System.out.println("index OOB: index out of bounds for the list"); // assuming there can't be a 'blank
																					// space' in the DLL
			} else if (this.size() == index) {
				// make new tail node
				this.addLast(element);
			} else if (index == 0) {
				this.addFirst(element); //addFirst is correct, not the insertion logic here tho, problem moving it down
			} else {
				Node<E> temp = new Node<E>(element);
				Node<E> ptr = new Node<E>();
				ptr = head;
				for (int i = 0; i < index - 1; i++) { // what if given 0 NOT TESTED
					ptr = ptr.getNext();
				}
				temp.setPrev(ptr);
				temp.setNext(ptr.getNext());
				ptr.setNext(temp);
				ptr.getNext().getNext().setPrev(temp);
				counter++;
			}
		} // else -- list is not empty
	}

	// Removes an element at the specified position from the list, and returns the
	// element.
	public E remove(int index) {
		Node<E> temp = new Node<E>();
		temp = head;
		if (index == 0) {
			removeFirst();
		} else if (index == size()) {
			removeLast();
		} else {
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			} // for
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		} // else
		return temp.getElement();
	} // remove

	public E set(int index, E element) {
		Node<E> temp = new Node<E>();
		temp = head;
		E elem = temp.getElement();
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
			elem = temp.getElement();
		}
		temp.setElement(element);
		return elem;
	}

	public Node<E> find(E element) {
		Node<E> temp = new Node<E>();
		temp = head;
		for (int i = 0; i < size(); i++) {
			if (temp.getElement() == element) {
				return temp;
			} else {
				temp = temp.getNext();
			}

		}
		if (temp == tail) {
			temp = null;
		}
		return temp;
	}

}// DLL

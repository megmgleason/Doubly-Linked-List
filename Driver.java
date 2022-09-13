//import javax.xml.soap.Node;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL<Integer> list = new DLL<>();
		list.addFirst(5);
		//list.setNext();
		System.out.println(list.toString());
		System.out.println(list.get(0) + " :the elm is ");
		
		//test get
		//list.get(2);
		System.out.println("the elm at index 2 is: " + list.get(2)); //should be null
		System.out.println("the elm at index 0 is: " + list.get(0)); //should be 5
		System.out.println("the elm at index 1 is: " + list.get(1)); //should be null
		list.addLast(6);
		System.out.println("added last");
		System.out.println(list.toString());
		System.out.println("");
		System.out.println("the elm at index 2 is: " + list.get(2)); //should be null
		System.out.println("the elm at index 0 is: " + list.get(0)); //should be 5
		System.out.println("the elm at index 1 is: " + list.get(1)); //should be 6

		System.out.println("testing isEmpty()");
		System.out.println("list isEmpty(): " + list.isEmpty()); //false
		DLL<String> listTwo = new DLL<>();
		System.out.println("listTwo isEmpty(): " + listTwo.isEmpty()); //true
		
		System.out.println("");
		System.out.println("testing size()");
		System.out.println("list size(): " + list.size()); //2
		System.out.println("listTwo size(): " + listTwo.size()); //0
		
		System.out.println("");
		System.out.println("testing first()");
		System.out.println("list first(): " + list.first()); //5
		System.out.println("listTwo first(): " + listTwo.first()); //null
		
		System.out.println("");
		System.out.println("testing removeFirst()");
		System.out.println("list removeFirst(): " + list.removeFirst()); //5
//		System.out.println("list printed: " + list.toString()); // null --> 6 --> null
		list.addFirst(5);
//		System.out.println("list printed: " + list.toString()); // null -->5--> 6 --> null
		System.out.println("listTwo removeFirst(): " + listTwo.first()); //null

		//test insert
		System.out.println("");
		System.out.println("testing insert()"); //null <-- 5 <--> 6 --> null
		System.out.println(list.toString());
		System.out.println("list insert(1, Integer 0): "); 
		list.insert(1, new Integer(0)); 
		System.out.println(list.toString()); //null <-- 5 <--> 0 <--> 6 --> null
		System.out.println("list size: " + list.size()); //3
		//IF we have an empty list and are given like index 1 or 2 (not the beginning, how to handle?)
		//not mentioned in project doc --> assume OOB
		list.insert(10, new Integer(0));  //OOB index too big
		list.insert(-1, new Integer(0));  //OOB index too small
		DLL<Double> listThree = new DLL<>();
		listThree.insert(1, new Double(5.0)); //OOB, empty list index != 0
		System.out.println("listThree toString: " + listThree.toString()); //null
		System.out.println("test insert at 0 on non empty list");
		list.insert(0, new Integer(100)); //test insert beginning
		System.out.println("list toString: " + list.toString()); 
		list.removeFirst(); //set back to normal
		System.out.println("list toString after removeFirst: " + list.toString());
		list.insert(1, new Integer(100)); //test insert index 1
		System.out.println("list toString: " + list.toString()); 

		
		
		
		//this is messed up i think? need to check OOB
		System.out.println("");
		System.out.println("testing remove without return(Node<E> x)");
		DLL<Integer> listFour = new DLL<>();
		System.out.println("list before remove: " + list.toString());
		list.remove(list.find(100));
		System.out.println("list after remove is " + list.size() + " " + list.toString());
		
		//need to test find more
		listFour.remove(list.find(5));
		System.out.println(list.toString());
		System.out.println("list size: " + list.size()); //2


	}

}

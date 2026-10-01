//Carson Kim
//This program creates and shows the values of a linked list.
/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)


  //constructors go here
  ListNode head;

  public LinkedList (){
    head=null;
  }




  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    ListNode temp = head;
    //create what you want to add
    //head is null
    if(head==null || head.getValue().compareTo(line)>0){
      head = new ListNode(line, head);
      return head;
    }
     //when toadd is smaller 
     //find where to put it
     //if it needs to go first line < head.getValue()
     
     //otherwise search for it
    while(temp.getNext()!=null && line.compareTo(temp.getNext().getValue())>0){
      temp = temp.getNext();
    }
    ListNode now = new ListNode(line,temp.getNext());
    //found the right spot add a new node AFTER temp and make sure you don't lose the temp.getNext() node.
    temp.setNext(now);

  
    //otherwise travese to the right spot and add there instead
    return now;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    if(head == null){
      return null;
    }
    if(head.getValue().compareTo(line)==0){
      ListNode temp1 = head;
      head=head.getNext();
      return temp1;
    }
  
    for(ListNode i=head; i!=null;i=i.getNext()){
      if(i.getNext().getValue().compareTo(line)==0){
        ListNode temp2 = i.getNext();
        i.setNext(i.getNext().getNext());
        return temp2;
      }
    }
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String a = "";
    for(ListNode i=head; i!=null;i=i.getNext()){
    a+= i.getValue();
  }
  return a;
}

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = null;
    if(head==null){
      System.out.println("cleared");
    }
  }

  //input - reverse is called
  //output - listNodes will be reversed

  public ListNode reverse(){
    ListNode previous = null;
    ListNode current = head;
    ListNode next = null;

    while(current !=null){
      next=current.getNext();
      current.setNext(previous);
      previous=current;
      current=next;
    }
    head=previous;
    return head;
  }

  //input - number type will be the size of the groups reversed
  //output - listNodes will be reversed in groups of n
  public ListNode nReverse(int n){
    if(head==null||n<=1){
      return head;
    }
    ListNode current = head;
    ListNode nHead = null;
    ListNode oTail = null;

    while(current != null){
      ListNode headGroup = current;
      ListNode previous = null;
      ListNode next = null;
      int count =0;
    

    while(current != null &&count<n){
      next=current.getNext();
      current.setNext(previous);
      previous = current;
      current = next;
      count++;
    }
    if(nHead ==null){
      nHead=previous;
    }
    if(oTail!=null){
      oTail.setNext(previous);
    }
    oTail=headGroup;
  }
  head=nHead;
  return head;

  }
}

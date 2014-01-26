// doublyLinked.java
// It is a doubly-linked list
// ///////////////////////////
class Link
{
    public long dData;
    public Link next;
    public Link previous;

    public Link(long d)
    {
        dData =d;
    }

    public void displayLink()
    {
        System.out.print(dData + " " );
    }
}//end class Link

class DoublyLinkedList
{
    private Link first;
    private Link last;

    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void insertFirst(long dd)    // insert at front of list
    {
        Link newLink = new Link(dd);

        if( isEmpty() )
            last = newLink;             //newLink <-- last
        else
            first.previous = newLink;   // newLink <-- old first
        newLink.next = first;           // newLink --> old first
        first = newLink;                // first --> newLink
    }

    public void insertLast(long dd)     // insert at end of list
    {
        Link newLink = new Link(dd);
        if( isEmpty() )
            first = newLink;            //first -->newLink
        else
        {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public Link deleteFirst()           //delete first link
    {
        Link temp = first;
        if(first.next == null)          //if only one item
            last = null;
        else
            first.next.previous = null; // null <-- old next
        first= first.next;
        return temp;
    }

    public Link deleteLast()        //delete last link
    {
        Link temp = last;
        if(first.next == null)      //if only one item
            first = null;
        else
            last.previous.next = null;  // null <-- old next
        last = last.previous;           // first --> old next
        return temp;
    }

    public boolean insertAfter(long key, long dd)   //insert dd just after key
    {
        Link current = first;       // start at beginning
        while (current.dData != key)    //until match is found
        {
            current = current.next;
            if(current == null)
                return false;
        }
        Link newLink = new Link(dd);

        if(current == last)
        {
            newLink.next = null;
            last = newLink;
        }
        else
        {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }//end insertAfter

    public Link deleteKey(long key)  //delete item with given key
    {
        Link current = first;
        while(current.dData != key )
        {
            current = current.next;
            if(current == null)
                return null;                    //did not find it
        }
        if(current == first)
            first = current.next;
        else
            current.previous.next = current.next;
        if(current==last)
            last = current.previous;
        else
            current.next.previous = current.previous;
        return current;
    }// end deleteKey

    public void displayForward()
    {
        System.out.print("List (first-->last) : ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackward()
    {
        System.out.print("List (last-->first) : ");
        Link current = last;
        while(current != null)
        {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }

}//end DoublyLinkedList

class DoublyLinkApp
{
    public static void main(String[] args)
    {
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward();
        theList.displayBackward();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);
        
        theList.displayForward();
        
        theList.insertAfter(22,77);
        theList.insertAfter(33,88);

        theList.displayForward();

    }//end main
}//end 


//firstLastList.java
//demonstrates list with first and last references
/////////////////////////////////////////////////////
class Link
{
    public long dData;      //data item
    public Link next;       //next link in list

    public Link(long d)
    {
        dData = d;
    }

    public void displayLink()
    {
        System.out.print(dData + " ");
    }
    
}//end class Link

class FirstLastList
{
    private Link first;         // ref to first link
    private Link last;          // ref to last link

    public FirstLastList()      // constructor
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return (first==null);
    }

    public void insertFirst(long dd)         // insert at front of list
    {
        Link newLink = new Link(dd);        // make a new list

        if( isEmpty() )
            last = newLink;             //newLink <-- last
        newLink.next = first;           //newLink --> old first
        first = newLink;                //first --> newLink
    }

    public void insertLast(long dd)            // insert at end of list
    {
        Link newLink = new Link(dd);        // make new link
        
        if( isEmpty())
            first = newLink;                //if empty list              
        else
            last.next = newLink;          //old last --> newlink     
        last = newLink;                   //newLink <-- last 
    }

    public long deleteFirst()       //delete first link
    {
        long temp = first.dData;
        if(first.next == null)      // if only one item
            last = null;
        first = first.next;         //first --> old next
        return temp;
    }

    public void displayList()
    {
        System.out.print("LIst (first-->last): ");
        Link current = first;
        while(current !=null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}//end FirstLastList

class FirstLastApp
{
    public static void main(String[] args)
    {
        FirstLastList theList = new FirstLastList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);
        
        theList.displayList();      //display the list
    
        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();      //display the list
    }
}

//linkList.java
//demonstrates linked list
//////////////////////////////////////

class Link
{
    public int iData;       // data item (key)
    public double dData;    //data item
    public Link next;

    public Link(int id, double dd) //constructor
    {
        iData = id;      //initialize data
        dData = dd;      //'next' is automatically set to null
    }

    public void displayLink()       //display ourself
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}//end class Link

class LinkList
{
    private Link first;     //ref to first link on list

    public LinkList()   //constructor
    {
        first  = null;  //no items on list yet
    }

    public boolean isEmpty()
    {
        return (first==null);
    }

    public void insertFirst(int id, double dd)  // insert at start of list
    {
        Link newLink = new Link(id, dd);
        newLink.next = first;           // newlink --> old first
        first = newLink;                 // first --> newLink
    }

    public Link deleteFirst()       // delete first item
    {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;       //start at beginning of list
        while(current != null )     // until end of list
        {
            current.displayLink();  //print data
            current = current.next;  //move to next link
        }
        System.out.println("");
    }

}//end class LinkList

class LinkListApp
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList();      //make new list
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

        while( !theList.isEmpty() )         // until it's empty
        {
            Link aLink = theList.deleteFirst();      //delete link
            System.out.print("Deleted ");           // display it
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList();
    }
}//end LinkListapp

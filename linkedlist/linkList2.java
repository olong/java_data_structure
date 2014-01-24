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

    public Link find(int key)
    {
        Link current = first;
        while(current.iData !=key)
        {
            if(current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Link delete(int key)       // delete link with given key
    {
        Link current = first;
        Link previous = first;
        while(current.iData != key){
            if(current.next == null)
                return null;            // did not find it
            else
            {
                previous = current;        // go to next link 
                current = current.next;
            }
        }
        if(current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
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

        Link f = theList.find(44);      //find item
        if(f !=null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can't find link");

        Link d = theList.delete(66);            //delete item
        if( d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can't delete link");


        theList.displayList();
    }
}//end LinkListapp

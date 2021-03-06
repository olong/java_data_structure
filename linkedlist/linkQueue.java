//linkQueue.java
// queue implemented as double=dened list
// //////////////////
class Link
{
    public long dData;
    public Link next;

    public Link(long d)
    { dData = d;}

    public void displayLink()
    {
        System.out.print(dData + " ");
    }
}// end Link

class FirstLastList
{
    private Link first;
    private Link last;

    public FirstLastList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return (first ==null);
    }

    public void insertLast(long dd)  //insert at end of list
    {
        Link newLink = new Link(dd);
        if( isEmpty() )
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public long deleteFirst()
    {
        long temp = first.dData;
        if(first.next ==null)    // if only one item
            last =null;
        first = first.next;
        return temp;
    }

    public void displayList()
    {
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

}// end FirstLastList

class LinkQueue
{
    private FirstLastList theList;

    public LinkQueue()
    {   theList = new FirstLastList();  }

    public boolean isEmpty()
    { return theList.isEmpty(); }

    public void insert(long j)
    { theList.insertLast(j); }

    public long remove()
    { return theList.deleteFirst(); }

    public void displayQueue()
    {
        System.out.print("Queue Front-->rear : ");
        theList.displayList();
    }
}// end LinkQueue

class LinkQueueApp
{
    public static void main(String[] args)
    {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);
        theQueue.insert(40);

        theQueue.displayQueue();

        theQueue.insert(60);
        theQueue.insert(80);

        theQueue.displayQueue();
        
        theQueue.remove();
        theQueue.remove();

        theQueue.displayQueue();

    }
}






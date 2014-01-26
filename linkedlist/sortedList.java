// sortedList.java
// demonstrate sorted list
////////////////////////////
class Link
{
    public long dData;
    public Link next;

    public Link(long dd)
    { dData = dd; }

    public void displayLink()
    {
        System.out.print(dData + " ");
    }
}//end class List

class SortedList
{
    private Link first;

    public SortedList()
    { first=null; }

    public boolean isEmpty()
    { return (first == null); }

    public void insert(long key)
    {
      Link newLink = new Link(key);
      Link previous = null;     //start at first
      Link current = first;

      while(current !=null && key > current.dData)
      {
          previous = current;
          current = current.next;        // go to next item
      }
      if(previous==null)            // at beginning of list
          first = newLink;          // first --> newLink
      else
          previous.next = newLink;  //old prev -->newLink
      newLink.next = current;
    }

    public Link remove()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList()
    {
        System.out.print("List (first --> last : ");
        Link current = first;
        while(current != null )
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

}// end SortedList

class SortedListApp
{
    public static void main(String[] args)
    {
        SortedList theSortList = new SortedList();
        theSortList.insert(20);
        theSortList.insert(40);

        theSortList.displayList();

        theSortList.insert(10);
        theSortList.insert(30);
        theSortList.insert(50);
        
        theSortList.displayList();

        theSortList.displayList();
    }
}//end sortedListApp

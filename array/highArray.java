// highArray.java
// demostrates array class with high-level interface
// //////////////////////////////////////////////////////

class HighArray
{
    private long[] a;
    private int nElems;       // number of data items

    public HighArray(int max)     // constructor
    {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey)
    {  // find specified value
        int j;
        for(j=0; j<nElems; j++)
            if(a[j] == searchKey)
                break;

        if(j == nElems)
            return false;
        else
            return true;
    }
    
    public void insert(long value)
    {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems; j++)
            if (value == a[j] )
                break;
        if(j==nElems)
            return false;
        else
        {
            for(int k=j; k<nElems; k++)  // move higher ones down
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }
    
    public void display()
    {
        for(int j=0; j<nElems; j++)
            System.out.print(a[j]+" ");
        System.out.println(" ");
    }
}
    ////////////////////////////////////
    class HighArrayApp
    {
        public static void main(String[] args)
        {
            int maxSize = 100;  // array size
            HighArray arr;
            arr = new HighArray(maxSize);  //create the array

            arr.insert(77);
            arr.insert(99);
            arr.insert(44);
            arr.insert(55);
            arr.insert(22);
            arr.insert(88);
            arr.insert(11);
            arr.insert(00);
            arr.insert(66);
            arr.insert(33);

            arr.display();

            int searchKey = 35;
            if( arr.find(searchKey))
                System.out.println("Found " + searchKey);
            else
                System.out.println("can not find " + searchKey);

            arr.delete(00);
            arr.delete(55);
            arr.delete(99);

            arr.display();

        }// end main
    }//end HighArrayApp class


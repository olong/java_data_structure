//mergeSort.java
// demonstrates recursive merge sort
// /////////////
class DArray
{
    private long[] theArray;
    private int nElems;

    public DArray(int max)
    {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value)
    {
        theArray[nElems] = value;
        nElems++;
    }

    public void display()
    {
        for(int j=0; j<nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }

    public void mergeSort()     //called by main() provides workspace
    {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems-1);
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound)
    {
        if(lowerBound == upperBound)        // if rnge is 1, no use sorting;
             return;
        else
        {
            int mid = (lowerBound + upperBound)/2 ;  // find midpoint
            recMergeSort(workSpace, lowerBound, mid);   //sort low half
            recMergeSort(workSpace, mid+1, upperBound);     //sort high half
            merge(workSpace, lowerBound, mid+1, upperBound);
        }
    }//end recMergeSort

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound)
    {
        int j = 0;                              // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1 ;
        int n = upperBound-lowerBound+1;        // # of items

        while(lowPtr <=mid && highPtr <= upperBound)
        {
            if(theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        }

        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];

        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];

        for(j=0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];
    }//end merge

}// end class DAarray

class MergeSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;  // arry size
        DArray arr;
        arr = new DArray(maxSize);

        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);

        arr.display();

        arr.mergeSort();

        arr.display();
    }//end main
}

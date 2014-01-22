//array.java
//demonstrates Java array
/////////

class ArrayApp
{
 public static void main(String[] args)
 {
  long[] arr;               // reference to array
  arr = new long[100];
  int nElems = 0;          // numer of items
  int j;                   // loop counter
  long searchKey;          // key for item to search fo

  arr[0] = 77;             // insert 10 items
  arr[1] = 99;
  arr[2] = 44;
  arr[3] = 55;
  arr[4] = 22;
  arr[5] = 88;
  arr[6] = 11;
  arr[7] = 00;
  arr[8] = 66;
  arr[9] = 33;
  nElems = 10;              // now 10 items in array

  for(j=0; j<nElems;j++)
      System.out.print(arr[j] + " ");
  System.out.println(" ");
  
  searchKey = 66;         // find item with key 66
  for(j=0; j<nElems; j++)
      if(arr[j]==searchKey)
          break;
  if(j == nElems)
      System.out.println("Can't find " + searchKey);
  else
      System.out.println("Found " + searchKey);

//----------------------
  searchKey = 55;   //delete item with key 55
  for (j=0;j<nElems; j++)       //look for it
      if (arr[j] == searchKey)
          break;
  for(int k=j; k<nElems; k++)    //move highr ones down
      arr[k] = arr[k+1];
  nElems--;                 // decrement size
 
//----------------------
  for(j=0;j<nElems; j++)
      System.out.print( arr[j] + " ");
  System.out.println(" ");
 }
}

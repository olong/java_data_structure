//lowArray.java
//
//demonstrates Java array
/////////

class lowArray
{
    private long[] a;      //reference to array

    public lowArray(int size)   // constructor
    { a = new long[size];}

    public void setElem(int index, long value) //set value
    {  a[index] = value; }

    public long getElem(int index)
    {   return a[index];}
}


class ArrayApp
{
 public static void main(String[] args)
 {
   lowArray arr;  //reference
  arr = new lowArray(100);
  int nElems = 0;          // numer of items
  int j;                   // loop counter
  long searchKey;          // key for item to search fo


  arr.setElem(0,77);
  arr.setElem(1,99);
  arr.setElem(2,44);
  arr.setElem(3,55);
  arr.setElem(4,22);
  arr.setElem(5,88);
  arr.setElem(6,11);
  arr.setElem(7,00);
  arr.setElem(8,66);
  arr.setElem(9,33);

  nElems = 10;              // now 10 items in array

  for(j=0; j<nElems;j++)
      System.out.print(arr.getElem(j) + " ");
  System.out.println(" ");
  
  searchKey = 26;         // find item with key 
  for(j=0; j<nElems; j++)
      if(arr.getElem(j)==searchKey)
          break;
  if(j == nElems)
      System.out.println("Can't find " + searchKey);
  else
      System.out.println("Found " + searchKey);

//----------------------
  searchKey = 55;   //delete item with key 55
  for (j=0;j<nElems; j++)       //look for it
      if ( arr.getElem(j )== searchKey)
          break;
  for(int k=j; k<nElems; k++)    //move highr ones down
      arr.setElem(k, arr.getElem(k+1));
  nElems--;                 // decrement size
 
//----------------------
  for(j=0;j<nElems; j++)
      System.out.print( arr.getElem(j)+ " ");
  System.out.println(" ");
 }
}

//stack.java
//demostrates stacks
/////////////////////////
class StackX
{
    private int maxSize;     //size of stck array
    private long[] stackArray;
    private int top;         // top of stack

    public StackX(int s)     // constructor
    {
        maxSize = s;        //set array size
        stackArray = new long[maxSize];
        top = -1;           // no items yet
    }

    public void push(long j)    //put item on top of stack
    {
        stackArray[++top] = j;
    } 

    public long pop()
    {
        return stackArray[top--];
    }

    public long peek()
    {
        return stackArray[top];
    }

    public boolean isEmpty()    //true if stack is empty
    {
        return (top==-1);
    }

    public boolean ifFull()     // true if stack is full
    {
        return (top==maxSize-1);
    }

}// end StckX
//--------------------------

class Stackapp
{
    public static void main(String[] args)
     {
        StackX theStack = new StackX(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while( !theStack.isEmpty() )
       {
        long value = theStack.pop();
        System.out.print(value);
        System.out.print(" ");
       }
   
    System.out.println(" ");

   }//end main
}// end stackapp


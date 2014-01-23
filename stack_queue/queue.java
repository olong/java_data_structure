//queue.java
//demonstrates queue
////////////////////////////

class Queue
{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public Queue(int s)    //constructor
    {
        maxSize =s+1 ;
        queArray = new long[maxSize];
        front = 0;
        rear =-1;
    }

    public void insert(long j)    // put items at rear of queue
    {
        if(rear == maxSize-1)        //deal with wraparoud
            rear = -1;
        queArray[++rear] = j;
    }

    public long remove()         // take item from front of queue
    {
        long temp = queArray[front++];   //get value and increase front
        if(front == maxSize)            // deal with wraparound
            front = 0;
        return temp;
    }

    public long peekFront()
    {
        return queArray[front];
    }

    public boolean isEmpty()
    {
        return (rear+1==front || (front+maxSize-1==rear));
    }

    public boolean isFull()
    {
        return (rear+2==front || (front+maxSize-2==rear));
    }

    public int size()
    {
        if(rear>=front)
            return rear-front+1;
        else
            return (maxSize-front)+(rear+1);
    }

}//end class Queue

class QueueApp
{
    public static void main(String[] args)
    {
       Queue theQueue = new Queue(5);

       theQueue.insert(10);
       theQueue.insert(20);
       theQueue.insert(30);
       theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        while( !theQueue.isEmpty())     //remove and display
        {
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");

    }// end main
}// end class QueueApp:w


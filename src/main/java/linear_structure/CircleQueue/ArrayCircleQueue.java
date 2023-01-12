package linear_structure.CircleQueue;

//用数组模拟循环数列
public class ArrayCircleQueue {

    private int maxSize;
    private int head = 0;
    private int tail = 0;
    private int[] arr;//数组，存放数据，模拟队列


    //构造方法
    //由于设置tail指针是队尾元素的后一位，所以队列永远不会到达数组最大容量（数组的最大容量减一）
    public ArrayCircleQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }


    //判断是否为空
    public boolean isEmpty(){
        return head == tail;
    }


    //判断是否满
    public boolean isFull(){
        return (tail + 1) % maxSize == head;
    }

    //入队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能加入数据");
            return;
        }

        arr[tail] = n;
        //将tail后移，取模
        tail = (tail+1) % maxSize;

    }

    //出队列
    public int getQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列空，无数据");
        }
        int value = arr[head];
        //将head指针后移
        head = (head + 1) % maxSize;
        return value;
    }

    //求当前队列的元素个数
    public int size(){
        return (tail + maxSize - head) % maxSize;
    }

    //显示所以元素
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列是空的");
            return;
        }

        for(int i = head;i < head + size(); i++){
            System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
        }

    }

    //显示头元素
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列是空的");

        }
        return arr[head];
    }
}

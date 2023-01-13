package linear_structure.Queue;

//写一个队列(对象)
public class ArrayQueue {
    private int maxSize; //表述数组的最大容量
    private int head;//队列头，总是指向对头元素的前一个
    private int tail;//队列尾，指向最后一个元素
    private int[] arr;//数组，存放数据，模拟队列


    //构造器,输入队列的 长度
    public ArrayQueue(int MaxSize) {
        //先初始化head与tail指针
        this.maxSize = MaxSize;
        this.arr = new int[MaxSize];
        this.head = -1;
        this.tail = -1;
    }

    //判断队列是否已空，当头指针与尾指针相等时，就认为已空
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        } else {
            return false;
        }
    }

    //判断队列是否已满，当尾指针等于最大容量减一时，就认为队列已满（maxsize-1）
    public boolean isFull() {
        if (tail == maxSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能加入数据");
            return;
        }
        //尾指针向后移动
        tail++;
        arr[tail] = n;
    }

    //出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        head++;//由于头指针是指向对头前一位的，所以要先后移一位，再取数
        return arr[head];
    }

    //显示队列所有元素
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列已空");
            return;
        }
        for(int i = head+1;i<=tail;i++){
            System.out.println(arr[i]);
        }

    }

    //显示头数据，不是取数，所以头指针不用改变
    public int showHead(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }

        return arr[head+1];
    }


    //清空数据
    public void clear(){
        head = -1;
        tail = -1;
    }
}
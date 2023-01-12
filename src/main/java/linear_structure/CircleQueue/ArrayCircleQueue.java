package linear_structure.CircleQueue;

//������ģ��ѭ������
public class ArrayCircleQueue {

    private int maxSize;
    private int head = 0;
    private int tail = 0;
    private int[] arr;//���飬������ݣ�ģ�����


    //���췽��
    //��������tailָ���Ƕ�βԪ�صĺ�һλ�����Զ�����Զ���ᵽ�����������������������������һ��
    public ArrayCircleQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }


    //�ж��Ƿ�Ϊ��
    public boolean isEmpty(){
        return head == tail;
    }


    //�ж��Ƿ���
    public boolean isFull(){
        return (tail + 1) % maxSize == head;
    }

    //�����
    public void addQueue(int n){
        if(isFull()){
            System.out.println("�������������ܼ�������");
            return;
        }

        arr[tail] = n;
        //��tail���ƣ�ȡģ
        tail = (tail+1) % maxSize;

    }

    //������
    public int getQueue(){
        if(isEmpty()){
            throw  new RuntimeException("���пգ�������");
        }
        int value = arr[head];
        //��headָ�����
        head = (head + 1) % maxSize;
        return value;
    }

    //��ǰ���е�Ԫ�ظ���
    public int size(){
        return (tail + maxSize - head) % maxSize;
    }

    //��ʾ����Ԫ��
    public void showQueue(){
        if(isEmpty()){
            System.out.println("�����ǿյ�");
            return;
        }

        for(int i = head;i < head + size(); i++){
            System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
        }

    }

    //��ʾͷԪ��
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("�����ǿյ�");

        }
        return arr[head];
    }
}

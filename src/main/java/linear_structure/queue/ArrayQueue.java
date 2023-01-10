package linear_structure.queue;

//дһ������(����)
public class ArrayQueue {
    private int maxSize; //����������������
    private int head;//����ͷ������ָ���ͷԪ�ص�ǰһ��
    private int tail;//����β��ָ�����һ��Ԫ��
    private int[] arr;//���飬������ݣ�ģ�����


    //������,������е� ����
    public ArrayQueue(int MaxSize) {
        //�ȳ�ʼ��head��tailָ��
        this.maxSize = MaxSize;
        this.arr = new int[MaxSize];
        this.head = -1;
        this.tail = -1;
    }

    //�ж϶����Ƿ��ѿգ���ͷָ����βָ�����ʱ������Ϊ�ѿ�
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        } else {
            return false;
        }
    }

    //�ж϶����Ƿ���������βָ��������������һʱ������Ϊ����������maxsize-1��
    public boolean isFull() {
        if (tail == maxSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    //������ݵ�����
    public void addQueue(int n){
        if(isFull()){
            System.out.println("�������������ܼ�������");
            return;
        }
        //βָ������ƶ�
        tail++;
        arr[tail] = n;
    }

    //������
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("���пգ�����ȡ����");
        }
        head++;//����ͷָ����ָ���ͷǰһλ�ģ�����Ҫ�Ⱥ���һλ����ȡ��
        return arr[head];
    }

    //��ʾ��������Ԫ��
    public void showQueue(){
        if(isEmpty()){
            System.out.println("�����ѿ�");
            return;
        }
        for(int i = head+1;i<=tail;i++){
            System.out.println(arr[i]);
        }

    }

    //��ʾͷ���ݣ�����ȡ��������ͷָ�벻�øı�
    public int showHead(){
        if(isEmpty()){
            throw new RuntimeException("�����ѿ�");
        }

        return arr[head+1];
    }

}
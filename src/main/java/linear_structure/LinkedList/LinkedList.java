package linear_structure.LinkedList;


//����
public class LinkedList {
    //��ʼһ��ͷ���
    private Node head = new Node(-1);

    //��ӽڵ�
    public void add(int n){
        //һ�������ڵ�
        Node temp = head;

        //��ʼ��ǰ�ĵĽڵ�
        Node now = new Node(n);

        //�����������β����Ȼ����뵱ǰ�Ľڵ�
        while(true){
            if(temp.next == null){
                break;
            }else{
                //����������һ������������
                temp = temp.next;
            }
        }

        //����ڵ�(��Ϊ��ǰ�ڵ�������һλ��)
        temp.next = now;

    }

    //��������
    public void list(){
        Node temp = head.next;

        while(true){
            if(temp == null){
                System.out.print(" null");
                break;//����ˣ��˳�ѭ��
            }else{
                System.out.printf("%d ->",temp.data);
            }
        }
    }
}

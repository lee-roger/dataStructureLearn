package linear_structure.LinkedList;


//链表
public class LinkedList {
    //初始一个头结点
    private Node head = new Node(-1);

    //添加节点,随便加
    public void add(int n){
        //一个辅助节点
        Node temp = head;

        //初始当前的的节点
        Node now = new Node(n);

        //遍历到链表的尾部，然后插入当前的节点
        while(true){
            if(temp.next == null){
                break;
            }else{
                //如果不是最后一个，则往后移
                temp = temp.next;
            }
        }

        //插入节点(因为当前节点就是最后一位了)
        temp.next = now;

    }

    //按照大小进行插入，不重复,从大到小排
    public void addByOder(int n){
         Node temp = head;
         boolean flag = false;//是否已经重复了

        Node now = new Node(n);

        while(true){
            if(temp.next == null){
                //已经到链表尾了
                break;
            }else if(temp.next.data == n){
                //说明有重复元素了，不插入
                flag = true;
                break;
            }else if(temp.next.data < n){
                break;
            }
            temp = temp.next;
        }

        if(flag){
            System.out.println("已经有该节点了，不能插入");
        }else{
            now.next = temp.next;
            temp.next = now;
        }

    }

    //遍历链表
    public void list(){
        Node temp = head.next;
        System.out.print("head ->");

        while(true){
            if(temp == null){
                System.out.print(" null");
                break;//最后了，退出循环
            }else{
                System.out.printf(" %d ->",temp.data);
                temp = temp.next;
            }
        }
    }
}

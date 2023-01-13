package linear_structure.Queue;


import java.util.Scanner;

//用数组模拟队列（测试）
public class ArrayQueueDemo {
    public static void main(String[] args){
        //创建一个大小为3的数列
        ArrayQueue queue = new ArrayQueue(3);

        //接收用户的输入
        char key = ' ';

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;//循环

        while(loop){
            System.out.printf("\n\n\n");
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列（入队列）");
            System.out.println("g(get):从队列取数（出队列）");
            System.out.println("h(head):查看队列头");
            System.out.println("c(clear):清空队列");
            System.out.println("请输入选择");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;

                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;

                case 'e':
                    loop = false;
                    System.out.println("退出程序");
                    break;

                case 'c':
                    queue.clear();
                    break;

                case 'g':
                    try{
                        int result = queue.getQueue();
                        System.out.printf("出队列的数是：%d\n",result);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h':
                    try{
                        int result = queue.showHead();
                        System.out.printf("队列头的数是：%d\n",result);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    break;
            }
        }
    }
}

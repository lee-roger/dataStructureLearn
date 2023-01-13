package linear_structure.LinkedList;

import java.util.Scanner;

//测试单向链表
public class LinkedListTest {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        //接收用户的输入
        char key = ' ';

        LinkedList linkedList = new LinkedList();

        boolean loop = true;

        while (loop) {
            System.out.printf("\n\n\n");
            System.out.println("s(show):显示链表");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到链表");
            System.out.println("o(addByOrder):从大到小插入链表");
            System.out.println("d(delete):删除某个节点");
            System.out.println("请输入选择");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    linkedList.list();
                    break;

                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    linkedList.add(value);
                    break;

                case 'e':
                    loop = false;

                case 'o':
                    System.out.println("输入一个数");
                    int value2 = scanner.nextInt();
                    linkedList.addByOder(value2);
                    break;

                case 'd':
                    System.out.println("输入要删除数");
                    int value3 = scanner.nextInt();
                    linkedList.delete(value3);
                    break;

                default:
                    break;
            }
        }
    }
}
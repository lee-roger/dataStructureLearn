package Sort.SelectSort;

import Sort.bubbleSort.BubbleSort;

//冒泡排序的主程序
public class test {
    public static void main(String[] arg){
        int arr[] = new int[]{7,8,9,5,42,5,7,24,6,8,1,62,};//测试数据

        SelectSort.sort(arr);
        SelectSort.printAll(arr);
    }
}

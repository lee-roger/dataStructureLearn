package Sort.SelectSort;

import Sort.bubbleSort.BubbleSort;

//ð�������������
public class test {
    public static void main(String[] arg){
        int arr[] = new int[]{7,8,9,5,42,5,7,24,6,8,1,62,};//��������

        SelectSort.sort(arr);
        SelectSort.printAll(arr);
    }
}

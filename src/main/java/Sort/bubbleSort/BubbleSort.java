package Sort.bubbleSort;


//冒泡排序
public class BubbleSort {

    //交换
    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    //A=A XOR B (a XOR b)
    //B=B XOR A (b XOR a XOR b = a)
    //A=A XOR B (a XOR b XOR a = b)

    //一种不会溢出，且不用额外变量的交换
    public static void swapXOR(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //打印字符串
    public static void printAll(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }

    //最简单的冒泡时间复杂度：O(n^2)
    public static void sort1(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                  swap(arr, j, j+1);
                }
            }
        }
    }

    //优化的冒泡排序（如果某一次的遍历没有发生交换，说明排序完成，不需要再排序了）
    public static void sort2(int[] arr){
        boolean flag = true;//表示发没发生交换
        for(int i = 0; i < arr.length - 1; i++){
            if(!flag) break;
            flag = false;

            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    swapXOR(arr, j, j+1);
                    flag = true;//表示发生了交换
                }
            }
        }
    }






}

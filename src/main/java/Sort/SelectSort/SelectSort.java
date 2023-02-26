package Sort.SelectSort;


//选择排序（不稳定的排序）
//时间复杂度O（n^2）
public class SelectSort {

    //如果相等的数进行异或就会成零
    //所以此函数不能放入同一个数，否则会变成零
    public static void swapXOR(int[] arr, int i, int j){
        if(arr[i] == arr[j]){
            //相等的数不给交换
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[i] ^ arr[j];
    }

    //交换
    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void printAll(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void sort(int arr[]){
        for(int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //交换
            swapXOR(arr, minIndex, i);
        }
    }
}

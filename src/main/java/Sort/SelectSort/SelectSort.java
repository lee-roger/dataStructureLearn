package Sort.SelectSort;


//ѡ�����򣨲��ȶ�������
//ʱ�临�Ӷ�O��n^2��
public class SelectSort {

    //�����ȵ����������ͻ����
    //���Դ˺������ܷ���ͬһ���������������
    public static void swapXOR(int[] arr, int i, int j){
        if(arr[i] == arr[j]){
            //��ȵ�����������
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[i] ^ arr[j];
    }

    //����
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
            //����
            swapXOR(arr, minIndex, i);
        }
    }
}

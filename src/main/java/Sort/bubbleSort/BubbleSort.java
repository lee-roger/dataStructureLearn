package Sort.bubbleSort;


//ð������
public class BubbleSort {

    //����
    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    //A=A XOR B (a XOR b)
    //B=B XOR A (b XOR a XOR b = a)
    //A=A XOR B (a XOR b XOR a = b)

    //һ�ֲ���������Ҳ��ö�������Ľ���
    public static void swapXOR(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //��ӡ�ַ���
    public static void printAll(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }

    //��򵥵�ð��ʱ�临�Ӷȣ�O(n^2)
    public static void sort1(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                  swap(arr, j, j+1);
                }
            }
        }
    }

    //�Ż���ð���������ĳһ�εı���û�з���������˵��������ɣ�����Ҫ�������ˣ�
    public static void sort2(int[] arr){
        boolean flag = true;//��ʾ��û��������
        for(int i = 0; i < arr.length - 1; i++){
            if(!flag) break;
            flag = false;

            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    swapXOR(arr, j, j+1);
                    flag = true;//��ʾ�����˽���
                }
            }
        }
    }






}

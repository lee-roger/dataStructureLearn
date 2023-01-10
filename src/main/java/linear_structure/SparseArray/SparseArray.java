package linear_structure.SparseArray;

public class SparseArray {
    public static void main(String[] args){
        //����һ����ά���飨ԭʼ���飩
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        chessArr1[3][4] = 5;

        for(int[] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        System.out.println();

        //��ԭʼ����ת����ϡ������
        int[][] sparseArray = arrayToSparseArray(chessArr1);
        for(int[] row : sparseArray){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        System.out.println();

        //��ϡ������ת��Ϊԭʼ����
        int[][] array = sparseArrayToArray(sparseArray);
        for(int[] row : array){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

    //��ά����תϡ������
    public static int[][] arrayToSparseArray(int[][] array){
        if(array == null){
            return null;
        }

        int sum = 0; //��Ч����ĸ���

        //��ȡԭʼ����ĳ���
        int rowLength = array.length;
        int colLength = array[0].length;

        //����ԭʼ�Ķ�ά���飬�õ���Ч���ݵĸ���sum
        for(int i=0;i<rowLength;i++){
            for (int j=0;j<colLength;j++){
                if(array[i][j] != 0){
                    sum++;
                }
            }
        }

        // ����sum�Ϳ��Դ���ϡ������sparseArray int[sum+1][3],������һ�и�ֵ
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = rowLength;
        sparseArray[0][1] = colLength;
        sparseArray[0][2] = sum;

        //��¼��Ϊ0��Ԫ�صĸ���
        int count = 0;

        //��ԭʼ�����ֵ����ϡ������
        for(int i=0;i<rowLength;i++){
            for (int j=0;j<colLength;j++){
                if(array[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }

        return sparseArray;
    }


    //ϡ������ָ�Ϊԭʼ����
    public static int[][] sparseArrayToArray(int[][] sparseArray){
        if(sparseArray == null){
            return null;
        }

        //��ϡ��������ȡ��ԭʼ����Ĵ�С��������������
        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];

        for(int i=1;i<sparseArray.length;i++){
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        return array;

    }
}

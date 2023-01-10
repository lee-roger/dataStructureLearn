package linear_structure.SparseArray;

public class SparseArray {
    public static void main(String[] args){
        //创建一个二维数组（原始数组）
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;

        for(int[] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        int[][] sparseArray = arrayToSparseArray(chessArr1);

        for(int[] row : sparseArray){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

    //二维数组转稀疏数组
    public static int[][] arrayToSparseArray(int[][] array){
        if(array == null){
            return null;
        }

        int sum = 0; //有效数组的个数

        //获取原始数组的长度
        int rowLength = array.length;
        int colLength = array[0].length;

        //遍历原始的二维数组，得到有效数据的个数sum
        for(int i=0;i<rowLength;i++){
            for (int j=0;j<colLength;j++){
                if(array[i][j] != 0){
                    sum++;
                }
            }
        }

        // 根据sum就可以创建稀疏数组sparseArray int[sum+1][3],并将第一行赋值
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = rowLength;
        sparseArray[0][1] = colLength;
        sparseArray[0][2] = sum;

        //记录不为0的元素的个数
        int count = 0;

        //将原始数组的值赋给稀疏数组
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
}

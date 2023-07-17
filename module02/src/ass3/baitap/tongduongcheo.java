package ass3.baitap;

public class tongduongcheo {
    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        int sum = 0;
        for(int i =0; i < array.length; i++ ){
            sum += array[i][i];
        }
        System.out.println("Tổng đường chéo chính là : " + sum
        );
    }
}

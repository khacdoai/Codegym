package ass3.baitap;

public class timphantulonnhat {
    public static void main(String[] args) {

    int max = 0;
    int[][] array = {{1,2,3},{2,5,7},{10,11,23}};
    for (int i = 0; i < array.length; i++){
        for (int j = 0; j <array[i].length;j++ ){
            if ( array[i][j] > max){
                max = array[i][j];
            }
        }
    }
        System.out.println("phần tử lớn nhất của mảng 2 chiều là: " + max);

}
}

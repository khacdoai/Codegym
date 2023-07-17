package ass3.baitap;

public class gia_tri_nho_nhat_trong_mang {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,-1};
        int min = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        System.out.println("Phần tử nhỏ nhất của mảng là:" + min);
    }
}

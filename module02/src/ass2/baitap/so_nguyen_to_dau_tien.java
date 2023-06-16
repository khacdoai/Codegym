package ass2.baitap;

public class so_nguyen_to_dau_tien {
    public static void main(String[] args) {
        int numbers = 20;
        int count =0;
        int n = 2;
        if (count <= numbers){
            for (int i = 0; i < n; i++ ){
                if (n % i == 0 ){
                    n++;
                }else {
                    System.out.println(n);
                    count++;
                }
            }
        }
    }
}

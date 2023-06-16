package ass2.baitap;

public class so_nguyen_to_be_hon_100 {
    public static void main(String[] args) {
        int n = 2;
        while (n < 100){
            int count = 0;
            for (int i = 2; i < n ; i++){
                if (n%i == 0){
                    count ++;
                }
            }
            if (count == 0){
                System.out.println(n);
            }
            n++;
        }
    }
}

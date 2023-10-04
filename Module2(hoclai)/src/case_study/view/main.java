package case_study.view;

import case_study.controller.CustomerControler;
import case_study.controller.EmloyeeControler;
import case_study.model.Employee;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        CustomerControler customerControler = new CustomerControler();
        EmloyeeControler emloyeeControler = new EmloyeeControler();
        Scanner scanner = new Scanner(System.in);
        boolean chay = true;
        do {
            System.out.println(" 1.Quan ly Khach hang" +
                    "\n 2.Quan ly nhan vien" +
                    "\n 3.Thoat");
            int chon = Integer.parseInt(scanner.nextLine());
            switch (chon){
                case 1:
                    customerControler.displaymenu();
                    break;
                case 2:
                    emloyeeControler.displaymenu();
                    break;
                case 3:
                    chay = false;
            }

        }while (chay);



    }
}

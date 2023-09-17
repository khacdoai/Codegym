package ss12.luyentapsudungarraylistlinkedlist.model;

import java.util.Comparator;

public class sap_xep_giam implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o2.getGia()-o1.getGia();
    }
}

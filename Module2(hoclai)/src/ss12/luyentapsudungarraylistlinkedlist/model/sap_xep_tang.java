package ss12.luyentapsudungarraylistlinkedlist.model;

import java.util.Comparator;

public class sap_xep_tang implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getGia()-o2.getGia();
    }
}

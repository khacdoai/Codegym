package ss12.luyentapsudungarraylistlinkedlist.model;

import java.util.Comparator;

public class CompaByName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getTensanpham().compareTo(o2.getTensanpham());
    }
}

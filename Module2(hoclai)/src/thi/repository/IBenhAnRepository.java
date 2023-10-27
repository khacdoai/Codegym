package thi.repository;

import thi.model.BenhAn;

import java.util.ArrayList;
import java.util.List;

public  interface IBenhAnRepository<E> {
    void themmoi(E e);

    void xoa( String mabenhan);
//    List<E> hienthidanhsach();
}

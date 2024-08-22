package org.arthur.ss11_mvc.service;

import org.arthur.ss11_mvc.DTO.ProductDTO;
import org.arthur.ss11_mvc.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IService {
    List<ProductDTO> getAll();
    boolean add(Product product);
    boolean delete(int id);
    boolean updateProduct(Product product) throws SQLException;
    Product getProductByID(int id) throws SQLException;
    List<ProductDTO> getProductByName(String inputName) throws SQLException;

}

package org.arthur.ss11_mvc.service.impl;

import org.arthur.ss11_mvc.DTO.ProductDTO;
import org.arthur.ss11_mvc.model.Product;
import org.arthur.ss11_mvc.repository.IRepo;
import org.arthur.ss11_mvc.repository.impl.ProductRepo;
import org.arthur.ss11_mvc.service.IService;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IService {
    IRepo productRepo = new ProductRepo();
    @Override
    public List<ProductDTO> getAll() {
        return productRepo.getAll();
    }

    @Override
    public boolean add(Product product) {
        try {
            return productRepo.add(product);
        } catch (SQLException e) {
            return  false;
        }
    }

    @Override
    public boolean delete(int id) {
        return productRepo.delete(id);
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
    return  productRepo.update(product);
    }

    @Override
    public Product getProductByID(int id) throws SQLException {
        return productRepo.getProductByID(id);
    }

    @Override
    public List<ProductDTO> getProductByName(String inputName) throws SQLException {
        return  productRepo.getProductByName(inputName);
    }
}

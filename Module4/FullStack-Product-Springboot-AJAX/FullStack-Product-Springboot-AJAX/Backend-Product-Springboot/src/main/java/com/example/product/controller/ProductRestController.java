package com.example.product.controller;

import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.service.ICategoryService;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductRestController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IProductService iProductService;

    @GetMapping()
    public ResponseEntity<Page<Product>> showlist(@RequestParam(required = false) String keyword,
                                                  @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Product> list;
        if (keyword != null) {
            list = iProductService.searchName(pageable,keyword);
        } else {
            list = iProductService.showList(pageable);
        }
//            Tương tự request.setAttribute()
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> add(@RequestBody Product product){
        iProductService.add(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> showDelete(@RequestParam long id) {
        iProductService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        Optional<Product> product = iProductService.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product updatedProduct) {
        Optional<Product> optionalProduct = iProductService.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setColor(updatedProduct.getColor());
            existingProduct.setCategory(updatedProduct.getCategory());
            iProductService.add(existingProduct);
            return new ResponseEntity<>(existingProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


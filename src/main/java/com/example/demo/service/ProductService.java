package com.example.demo.service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entities.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDao productDao;

    public List<Product> getAll(){
        log.info(productDao.getProducts().toString());
        return productDao.getProducts();
    }

}

package org.example.data.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.data.entity.Product;
import org.example.data.entity.ProductStorage;

import java.io.File;
import java.util.List;

public class FileService {

    private ProductService productService = new ProductService();
    @SneakyThrows
    public void readJsonFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);


        productService.setProducts(
                objectMapper.readValue(file, new TypeReference<List<ProductStorage>>() {}));
        for (ProductStorage obj : productService.getProductsStorage()) {
            System.out.println(obj);
        }


    }

}
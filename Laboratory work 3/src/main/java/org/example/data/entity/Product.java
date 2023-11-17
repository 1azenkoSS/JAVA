package org.example.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.data.service.ProductService;
import org.example.enums.Category;

@Data
@NoArgsConstructor
public class Product {
    private double priceByCount;
    private String name;
    private Category category;
    private boolean inFreezer;
    private long count;
    private double sum;

    public Product(double priceByCount, String name, Category category, boolean inFreezer, long count){
        this.priceByCount = priceByCount;
        this.name = name;
        this.category = category;
        this.inFreezer = inFreezer;
        this.count = count;

        this.sum = count * priceByCount;
    }

    public void decrementCount(long size){
        if(count >= size)
            count -= size;
    }
}

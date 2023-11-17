package org.example.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Category;

@Data
@NoArgsConstructor
public class ProductStorage {
    private double priceByCount;
    private String name;
    private Category category;
    private boolean inFreezer;
}

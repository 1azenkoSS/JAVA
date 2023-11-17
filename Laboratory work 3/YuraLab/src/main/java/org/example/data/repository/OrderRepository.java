package org.example.data.repository;

import lombok.Getter;
import org.example.data.entity.Order;
import org.example.data.entity.Person;
import org.example.data.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    @Getter
    private List<Order> orders = new ArrayList<>();
    @Getter
    private Map<Person, List<Product>> preorders = new HashMap<>();

    @Getter
    private Map<Person, List<Order>> orderHistory = new HashMap<>();

    private static OrderRepository instance;

    public static OrderRepository getInstance(){
        if(instance == null)
            instance = new OrderRepository();

        return instance;
    }

    private OrderRepository(){};
}

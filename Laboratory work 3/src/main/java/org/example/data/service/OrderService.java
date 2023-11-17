package org.example.data.service;

import lombok.SneakyThrows;
import org.example.data.entity.Order;
import org.example.data.entity.Person;
import org.example.data.entity.Product;
import org.example.data.exceprion.NoPersonToCreateOrderException;
import org.example.data.exceprion.ProductDoesntExistException;
import org.example.data.exceprion.ProductQuantityUnavailableException;
import org.example.data.repository.OrderRepository;
import org.example.data.repository.ProductRepository;
import org.example.enums.Category;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class OrderService {
    private OrderRepository orderRepository = OrderRepository.getInstance();
    private ProductRepository productRepository = ProductRepository.getInstance();
    public Product getMostPopularProduct(){
        Map<Product, AtomicInteger> productsCount = new HashMap<>();
        orderRepository.getOrderHistory().forEach((person, orders) ->{
            orders.forEach(products ->{
                products.getProducts().forEach(product ->{
                    if(productsCount.containsKey(product)){
                        productsCount.get(product).incrementAndGet();
                    }else{
                        productsCount.put(product, new AtomicInteger(1));
                    }
                });
            });
        });

        return productsCount.entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().get()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    @SneakyThrows
    public Order createOrder(Person person){

        if(!orderRepository.getPreorders().containsKey(person)) {
            throw new NoPersonToCreateOrderException("Can't create order");
        }

        List<Product> products = orderRepository.getPreorders().get(person);

        StringBuilder comment = new StringBuilder("Don't forget to save products");
        if(products.stream().anyMatch(product -> product.isInFreezer())){

            products.stream().filter(product -> product.isInFreezer()).forEach(product ->{
                comment.append( " " + product.getName() + ",");
            });
            comment.deleteCharAt(comment.length() - 1);
            comment.append(" in Freezer");
            
        }

        Order order = Order.builder()
                .date(new Date())
                .products(products)
                .sum(products.stream().mapToDouble(product -> product.getPriceByCount()).sum())
                .comment(comment.toString())
                .packetsCount(products.stream()
                        .filter(product -> product.getCategory() == Category.FRUITS
                                || product.getCategory() == Category.VEGETABLES)
                        .count())
                .isPaid(false)
                .build();

        products.forEach(prod -> decrementProductCount(prod, prod.getCount()));
        orderRepository.getOrders().add(order);
        saveOrderToHistory(person, order);
        setOrderPaid(order);
        return order;
    }

    public void setOrderPaid(Order order){
        order.setPaid(true);
    }
    private void decrementProductCount(Product product, long decrementSize){
        productRepository.getProducts().stream().filter(prod -> prod.getName().equals(product.getName())).findAny().get().decrementCount(decrementSize);
    }

    @SneakyThrows
    public void addProductToPreorder(Person person, Product product){
        if(!productRepository.getProducts().stream().anyMatch(prod -> prod.getName().equals(product.getName())))
            throw new ProductDoesntExistException("Product doesnt exist");

        if(productRepository.getProducts().stream().filter(prod -> prod.getName().equals(prod.getName())).findAny().get().getCount() < product.getCount())
            throw new ProductQuantityUnavailableException("Product quantity is unavailable");

        if(!orderRepository.getPreorders().containsKey(person))
            orderRepository.getPreorders().put(person, new ArrayList<>());

        orderRepository.getPreorders().get(person).add(product);
    }

    private void saveOrderToHistory(Person person, Order order){
        if(orderRepository.getOrderHistory().containsKey(person))
            orderRepository.getOrderHistory().get(person).add(order);
        else
            orderRepository.getOrderHistory().put(person, List.of(order));
    }

    public double getAllCostProductsOfPerson(Person person, String productName){
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        orderRepository.getOrderHistory().get(person).forEach(order ->{
            sum.set(order.getProducts().stream().
                    filter(product -> product.getName().equals(productName)).
                    mapToDouble(Product::getSum).
                    sum());
        });

        return sum.get();
    }
}

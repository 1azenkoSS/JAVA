package org.example.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Order {

    private double sum;
    private List<Product> products;
    private Date date;
    private String comment;
    private long packetsCount;
    private boolean isPaid;


    @Override
    public String toString(){
        return "Sum: " + sum +
                "\n Products:" + products +
                "\n Date: " + date +
                "\n Comment: " + comment +
                "\n Packets count: " + packetsCount +
                "\n IsPaid: " + isPaid;
    }
}

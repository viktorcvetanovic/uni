package com.viktor.CS230_DZ04;

import lombok.Data;

@Data
public class Action {
    private int id;
    private String symbol;
    private String name;
    private double price;
    private double volume;
    private double dividend;
}

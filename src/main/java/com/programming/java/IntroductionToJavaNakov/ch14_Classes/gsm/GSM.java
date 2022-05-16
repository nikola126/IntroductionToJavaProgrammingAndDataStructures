package com.programming.java.IntroductionToJavaNakov.ch14_Classes.gsm;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GSM {
    private String model;
    private String brand;
    private double price;
    private String owner;
    private Display display;
    private Battery battery;

    private List<Call> callList = new ArrayList<>();

    private static GSM nokiaN95 = new GSM("N95", "Nokia", 500.0, "Nikola");

    public GSM(String model, String brand, double price, String owner) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.owner = owner;
        this.callList = new ArrayList<>();
    }

    public GSM(String model, String brand, Display display, Battery battery) {
        this.model = model;
        this.brand = brand;
        this.display = display;
        this.battery = battery;
        this.callList = new ArrayList<>();
    }

    public GSM getNokiaN95() {
        return nokiaN95;
    }

    public void addCall(Call call) {
        this.callList.add(call);
    }

    public void deleteCall(int index) {
        this.callList.remove(index);
    }

    public void deleteCallHistory() {
        this.callList = new ArrayList<>();
    }

    public double calculateCallPrice(double pricePerSecond) {
        double price = 0.0;
        for (Call call : callList) {
            price += pricePerSecond * (call.getDurationMs() / 1000.0);
        }
        return price;
    }
}

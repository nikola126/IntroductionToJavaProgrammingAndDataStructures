package com.programming.java.IntroductionToJavaNakov.ch14_Classes.gsm;

import lombok.Getter;

import java.util.Date;

@Getter
public class GSMCallHistoryTest {
    private double totalPrice;

    public GSMCallHistoryTest() {
        GSM gsm = new GSM();
        Call call1 = new Call(new Date(), new Date(), 55 * 1000);
        Call call2 = new Call(new Date(), new Date(), 32 * 1000);
        gsm.addCall(call1);
        gsm.addCall(call2);

        this.totalPrice = gsm.calculateCallPrice(0.37);
        System.out.println("Total price after two calls: " + totalPrice);

        gsm.deleteCall(0);
        this.totalPrice = gsm.calculateCallPrice(0.37);
        System.out.println("Total price after removing longest call: " + totalPrice);

        gsm.deleteCallHistory();
        this.totalPrice = gsm.calculateCallPrice(0.37);
        System.out.println("Total price after clearing call history: " + totalPrice);
    }
}

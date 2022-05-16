package com.programming.java.IntroductionToJavaNakov.ch14_Classes.gsm;

public class GSMTest {
    private static GSM[] GSMs;

    public GSMTest(int count) {
        GSMs = new GSM[count];
        for (int i = 0; i < count; i++)
            GSMs[i] = new GSM("K310i", "Sony Ericsson", 250.0, "Nikola");
    }

    public GSM[] getGSMs() {
        return GSMs;
    }

    public int getNumberOfGSMs() {
        return GSMs.length;
    }
}

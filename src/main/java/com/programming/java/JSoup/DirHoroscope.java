package com.programming.java.JSoup;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DirHoroscope {
    private String sign;
    private String horoscopeType;
    private LocalDate horoscopeStartDate;
    private LocalDate horoscopeEndDate;
    private String text;
    private List<HoroscopeCategory> categoryList;
}

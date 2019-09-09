package com.example.student.bai02;

import java.util.List;

public class ThongTinCaNhan {

    private String hoTen;
    private String cmnd;
    private String bangCap;
    private List<String> soThich;
    private String tTBoSung;

    public ThongTinCaNhan(String hoTen,String cmnd,String bangCap,List<String> soThich,String tTBoSung ){
        this.hoTen=hoTen;
        this.cmnd=cmnd;
        this.bangCap=bangCap;
        this.soThich=soThich;
        this.tTBoSung=tTBoSung;
    }
    public String xuat() {
        String a ="";
        for(String x : soThich){
            a+=x+" ";
        }
        return hoTen+cmnd+bangCap+a+tTBoSung;
    }
}

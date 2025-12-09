package com.example.final2012;

public class BaiTap1 {
    public static int TinhTongHam1den1000le(){
        int tong = 0;
        for(int i = 1; i <= 1000; i++){
            if (i % 2 != 0){
                tong += i;
            }
        }
        return tong;
    }
    public static int TinhTongHam1den1000chan(){
        int tong = 0;
        for(int i = 1; i <= 1000; i++){
            if (i % 2 == 0){
                tong += i;
            }
        }
        return tong;
    }
    public static int TinhTongHam1den1000(){
        int tong = 0;
        for(int i = 1; i <= 1000; i++){
            tong += i;
        }
        return tong;
    }
}

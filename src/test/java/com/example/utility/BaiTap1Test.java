package com.example.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaiTap1Test { //le
    @Test
    public void TestTongLeThanhCong(){
    int expected = 250000;
    Assertions.assertEquals(expected, BaiTap1.TinhTongHam1den1000le());
    }
    @Test
    public void TestBienThanhCong(){
        int expected = 500 * (999 + 1) / 2; //1000*(1000+1)/2 ko chan ko le ,,chan 500 * (1000 + 2) / 2 ,,le 500 * (999 + 1) / 2
        Assertions.assertEquals(expected, BaiTap1.TinhTongHam1den1000le());
    }
    @Test
    public void TestBienCongThuc(){
    int a = 500;
    int b = 999;
    int c = 1;
    int d = 2;
        int expected = a * (b + c) / d;
        Assertions.assertEquals(expected, BaiTap1.TinhTongHam1den1000le());
    }
    @Test
    public void TestOnDinh(){
        int result1 = BaiTap1.TinhTongHam1den1000le();
        int result2 = BaiTap1.TinhTongHam1den1000le();
        Assertions.assertEquals(result1, result2);
    }


    @Test
    public void TestMaxValue(){
        int result1 = BaiTap1.TinhTongHam1den1000le();
        Assertions.assertTrue(result1 < Integer.MAX_VALUE, "Test failed");
    }
    @Test
    public void TestMinValue(){
        int result1 = BaiTap1.TinhTongHam1den1000le();
        Assertions.assertTrue(result1 > Integer.MIN_VALUE, "Test failed");
    }
}

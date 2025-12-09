package com.example.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaiTap3Test {
    BaiTap1 baiTap1;
    @BeforeEach
    void setUp(){
        baiTap1 = new BaiTap1();
    }
    @Test
    void TinhTongHam1den1000le(){
        int expected = 250000;
        assertEquals(expected, baiTap1.TinhTongHam1den1000le());
    }
    @Test
    void TinhTongHam1den1000le2(){
        int expected = 500 * (999 + 1) / 2;
        assertEquals(expected, baiTap1.TinhTongHam1den1000le());
    }
    @Test
    void TinhTongHam1den1000le3(){
        int a = 500;
        int b = 999;
        int c = 1;
        int d = 2;
        int expected = a * (b + c) / d;
        assertEquals(expected, baiTap1.TinhTongHam1den1000le());
    }
}
package com.example.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaiTap3Test {

    //Test Tong chan thanh cong
    @Test
    public void TestTongChanThanhCong() {
        int expected = 500000;
        assertEquals(expected, BaiTap1.TinhTongHam1den1000chan());
    }
    //Test  bien tong chan thanh cong
    @Test
    public void TestBienTongChanThanhCong() {
        int expected = 500 * (1000 + 2) / 2;
        assertEquals(expected, BaiTap1.TinhTongHam1den1000chan());
    }

    //Test Bien thanh cong
    @Test
    public void TestBienThanhCong() {
        int a = 500;
        int b = 999;
        int c = 1;
        int d = 2;
        int expected = a * (b + c) / d;
        assertEquals(expected, BaiTap1.TinhTongHam1den1000le());
    }

    //Test On dinh
    @Test
    public void TestOnDinh() {
        int result1 = BaiTap1.TinhTongHam1den1000chan();
        int result2 = BaiTap1.TinhTongHam1den1000chan();
        assertEquals(result1, result2);
    }
    //Test Max Value
    @Test
    public void TestMaxValue() {
        int result1 = BaiTap1.TinhTongHam1den1000chan();
        assertTrue(result1 < Integer.MAX_VALUE, "Test failed");
    }
    //Test Min Value
    @Test
    public void TestMinValue() {
        int result1 = BaiTap1.TinhTongHam1den1000chan();
        assertTrue(result1 > Integer.MIN_VALUE, "Test failed");
    }
}
package com.example.final2012;

import com.example.final2012.model.NhanVien;
import com.example.final2012.service.NhanVienService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaiTap2Test {
    protected static NhanVien nhanVien;
    private  static NhanVienService nhanVienService;

    @BeforeAll
    public static void setUp(){
        nhanVienService = new NhanVienService();
    }

    @AfterAll
    public static void tearDown(){
        nhanVienService = null;
    }

    @Test
    public void TestAddThanhCong(){
        NhanVien nhanVien1 = new NhanVien("D111" ,"duc",15,10000000D,"dm1");
        Assertions.assertTrue(nhanVienService.addNhanVien(nhanVien1));
    }

    @Test
    public void TestAddThanhCongkhiluongla1(){
        NhanVien nhanVien1 = new NhanVien("D2" ,"duc",15,1D,"dm1");
        Assertions.assertTrue(nhanVienService.addNhanVien(nhanVien1));
    }

    @Test
    public void TestAddThanhCongkhiluongla99_999_999(){
        NhanVien nhanVien1 = new NhanVien("D3" ,"duc",15,99999999D,"dm1");
        Assertions.assertTrue(nhanVienService.addNhanVien(nhanVien1));
    }
    @Test
    public void TestAddkhongothanhcongkhiluongla0(){
        NhanVien nhanVien1 = new NhanVien("D4" ,"duc",15,0d,"dm1");
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> nhanVienService.addNhanVien(nhanVien1));
        Assertions.assertEquals("Phai trong khoang 1 den 100,000,000", exception.getMessage());
    }
    @Test
    public void TestAddkhongothanhcongkhiluongla100_000_001(){
        NhanVien nhanVien1 = new NhanVien("D5" ,"duc",15,100000001d,"dm1");
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> nhanVienService.addNhanVien(nhanVien1));
        Assertions.assertEquals("Phai trong khoang 1 den 100,000,000", exception.getMessage());
    }
}
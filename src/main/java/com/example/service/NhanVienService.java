package com.example.service;

import com.example.model.NhanVien;

import java.util.ArrayList;

public class NhanVienService {
    ArrayList<NhanVien> ds = new ArrayList<>();

    protected NhanVien nhanVien = new NhanVien("D1" ,"duc",15,10000000D,"dm1");
    public NhanVienService(){
        ds.add(nhanVien);
    }
    public Boolean addNhanVien(NhanVien nhanVien){
        if(nhanVien.getLuong() < 1 || nhanVien.getLuong() > 100000000){
            throw new IllegalArgumentException("Phai trong khoang 1 den 100,000,000");
        }
        for(NhanVien n : ds){
            if(nhanVien.getMaNV().contentEquals(n.getMaNV())){
                throw new IllegalArgumentException("Ma da ton tai");
            }
        }
        ds.add(nhanVien);
        return true;
    }

    public Boolean suaNhanVien(String maNV ,NhanVien nhanVienMoi){
        if (maNV == null || maNV.isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không hợp lệ");
        }

        if (nhanVienMoi == null) {
            throw new IllegalArgumentException("Đối tượng nhân viên mới không được null");
        }

        // Kiểm tra dữ liệu mới hợp lệ
        if (nhanVienMoi.getTenNV().isEmpty() || nhanVienMoi.getPhongban().isEmpty()) {
            throw new IllegalArgumentException("Các trường không được để trống");
        }
        if (nhanVienMoi.getLuong() <= 0 || nhanVienMoi.getLuong() > 100_000_000) {
            throw new IllegalArgumentException("Lương phải > 0 và <= 100,000,000");
        }
        return true;
    }
}

package com.example.foob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class SanPham {
    private String ma;
    private String ten;
    private int namBaoHanh;
    private Float gia;
    private int soLuong;
    private String danhMuc;
}

package com.example.cotrang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class NhanVien {
    private String maNV;
    private String tenNV;
    private int tuoi;
    private double luong;
    private String phongBan;
}

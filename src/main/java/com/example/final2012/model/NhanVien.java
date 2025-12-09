package com.example.final2012.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    private String maNV;
    private String tenNV;
    private Integer tuoi;
    private Double luong;
    private String phongban;
}

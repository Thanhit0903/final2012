package com.example.foob;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    public SanPham sp = new SanPham();
    List<SanPham> spl = new ArrayList<>();

    public boolean add(SanPham spparm) {
        if(
                spparm == null ||
                        spparm.getMa() == null ||
                        spparm.getTen() == null ||
                        spparm.getNamBaoHanh() == 0 ||
                        spparm.getGia() == null ||
                        spparm.getDanhMuc() == null
        ) {
            throw new IllegalArgumentException("Sản phẩm trống");
        }
        for(SanPham sp : spl) {
            if(sp.getMa().equals(spparm.getMa())) {
                throw new IllegalArgumentException("Sản phẩm đã tồn tại");
            }
        }

        if(spparm.getSoLuong() < 1) {
            throw new IllegalArgumentException("Số lượng phải lớn hơn 0");
        }
        if(spparm.getSoLuong() > 100) {
            throw new IllegalArgumentException("Số lượng không được vượt quá 100");
        }
        sp.setMa(spparm.getMa());
        sp.setTen(spparm.getTen());
        sp.setNamBaoHanh(spparm.getNamBaoHanh());
        sp.setGia(spparm.getGia());
        sp.setSoLuong(spparm.getSoLuong());
        sp.setDanhMuc(spparm.getDanhMuc());

        spl.add(sp);
        return true;
    }
}

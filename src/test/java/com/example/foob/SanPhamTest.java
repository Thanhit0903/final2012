package com.example.foob;
// (b + 1) / 2 - a / 2; L
// b/2 - (a-1)/2; C
// 500L * (999 + 1) / 2

import com.example.foob.SanPham;
import com.example.foob.SanPhamService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SanPhamTest {
    private SanPhamService cltest;

    @BeforeEach
    void setUp() {
        cltest = new SanPhamService();
    }

    @Test
    void ThemSanPhamHopLe() {
        SanPham sp = new SanPham(
                "SP1", "Dien thoai", 5, 2000.0F, 10, "Phone"
        );
        assertTrue(cltest.add(sp));
    }

    @Test
    void ThemSanPham_ngoaiBienDuoi() {
        SanPham sp = new SanPham(
                "SP1", "Dien thoai", 5, 2000.0F, 0, "Phone"
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cltest.add(sp);
        });
        assertEquals("Số lượng phải lớn hơn 0", exception.getMessage());
    }

    @Test
    void ThemSanPham_ngoaiBienTren() {
        SanPham sp = new SanPham(
                "SP2", "Dien thoai", 5, 2000.0F, 101, "Phone"
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cltest.add(sp);
        });
        assertEquals("Số lượng không được vượt quá 100", exception.getMessage());
    }

    @Test
    void ThemSanPham_trungMa() {
        SanPham sp = new SanPham(
                "SP1", "Dien thoai", 5, 2000.0F, 20, "Phone"
        );
        cltest.add(sp);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cltest.add(sp);
        });
        assertEquals("Sản phẩm đã tồn tại", exception.getMessage());
    }

    @Test
    void ThemSanPham_rong() {
        SanPham sp = new SanPham();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cltest.add(sp);
        });
        assertEquals("Sản phẩm trống", exception.getMessage());
    }
}
package com.example.foob;

import com.example.foob.SoLe;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SoLeTest {
    private SoLe cltest;

    @BeforeEach
    void setUp() {
        cltest = new SoLe();
    }

    // Tính sum số lẻ
    @Test
    void sum_default() {
        assertEquals(250000, cltest.sumOdd());
    }

    // Tính biên
    @Test
    void sum_checkBien() {
        assertEquals(500L * (999 + 1) / 2, cltest.sumOdd());
    }

    // Kiểm tra không phải 0
    @Test
    void sum_notZero() {
        assertTrue(cltest.sumOdd() != 0);
    }

    // Kiểm tra tính ổn định 2 kết quả bằng nhau
    @Test
    void sum_stable() {
        assertEquals(cltest.sumOdd(), cltest.sumOdd());
    }

    // Kiểm tra giới hạn trên của kiểu int
    @Test
    void sum_longLimit() {
        assertTrue(cltest.sumOdd() < Integer.MAX_VALUE);
    }
}

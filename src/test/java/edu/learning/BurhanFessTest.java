package edu.learning;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import static org.junit.Assert.*;

public class BurhanFessTest {
    @Test
    public void testIsKabisatTrue() {
        assertTrue(BurhanFess.isKabisat(2024));
        assertTrue(BurhanFess.isKabisat(2000));
    }

    @Test
    public void testIsKabisatFalse() {
        assertFalse(BurhanFess.isKabisat(2023));
        assertFalse(BurhanFess.isKabisat(2100));
    }

    @Test
    public void testNamaBulanSemua() {
        String[] bulan = {
                "Januari",
                "Februari",
                "Maret",
                "April",
                "Mei",
                "Juni",
                "Juli",
                "Agustus",
                "September",
                "Oktober",
                "November",
                "Desember"
        };
        for (int i = 1; i <= 12; i++) {
            assertEquals(bulan[i - 1], BurhanFess.namaBulan(i));
        }
    }

    @Test
    public void testGetMaxDaysInMonthAllValids() {
        assertEquals(31, BurhanFess.getMaxDaysInMonth(1, 2024)); // Januari
        assertEquals(29, BurhanFess.getMaxDaysInMonth(2, 2024)); // Februari kabisat
        assertEquals(28, BurhanFess.getMaxDaysInMonth(2, 2023)); // Februari non-kabisat
        assertEquals(31, BurhanFess.getMaxDaysInMonth(3, 2024)); // Maret
        assertEquals(30, BurhanFess.getMaxDaysInMonth(4, 2024)); // April
        assertEquals(31, BurhanFess.getMaxDaysInMonth(5, 2024)); // Mei
        assertEquals(30, BurhanFess.getMaxDaysInMonth(6, 2024)); // Juni
        assertEquals(31, BurhanFess.getMaxDaysInMonth(7, 2024)); // Juli
        assertEquals(31, BurhanFess.getMaxDaysInMonth(8, 2024)); // Agustus
        assertEquals(30, BurhanFess.getMaxDaysInMonth(9, 2024)); // September
        assertEquals(31, BurhanFess.getMaxDaysInMonth(10, 2024)); // Oktober
        assertEquals(30, BurhanFess.getMaxDaysInMonth(11, 2024)); // November
        assertEquals(31, BurhanFess.getMaxDaysInMonth(12, 2024)); // Desember
    }

    @Test
    public void testGetMaxDaysInMonthInvalid() {
        assertEquals(0, BurhanFess.getMaxDaysInMonth(0, 2024)); // Invalid month
        assertEquals(0, BurhanFess.getMaxDaysInMonth(13, 2024)); // Invalid month
        assertEquals(0, BurhanFess.getMaxDaysInMonth(-5, 2024)); // Invalid month
    }

    @Test
    public void testCalculateDelayedDateTimeToNextYear() {
        LocalDateTime now = LocalDateTime.of(2025, 12, 31, 23, 59, 59);
        LocalDateTime result = BurhanFess.calculateDelayedDateTime(now, 2); // cross to 2026
        assertEquals(2026, result.getYear());
        assertEquals(1, result.getMonthValue());
        assertEquals(1, result.getDayOfMonth());
        assertEquals(0, result.getHour());
        assertEquals(0, result.getMinute());
        assertEquals(1, result.getSecond());
    }

    @Test
    public void testInterpretasiVibeIfElseAllRanges() {
        assertTrue(BurhanFess.interpretasiVibe(0, 0).contains("pengagum diam-diam"));
        assertTrue(BurhanFess.interpretasiVibe(6, 0).contains("semi-aktif"));
        assertTrue(BurhanFess.interpretasiVibe(11, 0).contains("suka bikin penasaran"));
        assertTrue(BurhanFess.interpretasiVibe(16, 0).contains("suka bikin drama"));
        assertTrue(BurhanFess.interpretasiVibe(21, 0).contains("suka bikin orang mikir"));
        assertTrue(BurhanFess.interpretasiVibe(30, 0).contains("rahasia"));
    }

    @Test
    public void testInterpretasiVibeSwitchAllCases() {
        assertTrue(BurhanFess.interpretasiVibe(0, 1).contains("pengagum diam-diam"));
        assertTrue(BurhanFess.interpretasiVibe(5, 1).contains("semi-aktif"));
        assertTrue(BurhanFess.interpretasiVibe(10, 1).contains("suka bikin penasaran"));
        assertTrue(BurhanFess.interpretasiVibe(15, 1).contains("suka bikin drama"));
        assertTrue(BurhanFess.interpretasiVibe(20, 1).contains("suka bikin orang mikir"));
        assertTrue(BurhanFess.interpretasiVibe(30, 1).contains("rahasia"));
    }

    @Test
    public void testGetValidInputValidLangsung() {
        Scanner scanner = new Scanner("1\n");
        int[] result = BurhanFess.getValidInput(scanner, "Test: ", 0, 1);
        assertEquals(1, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    public void testGetValidInputWithErrors() {
        Scanner scanner = new Scanner("hello\n3\n1\n");
        int[] result = BurhanFess.getValidInput(scanner, "Test: ", 0, 2);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void testHitungKodeVibeAllYes() {
        Scanner scanner = new Scanner("1\nyA\n1\nya\n1\n");
        int result = BurhanFess.hitungKodeVibe(scanner);
        assertEquals(31, result);
    }

    @Test
    public void testTampilkanWaktuSekarang() {
        LocalDateTime waktu = LocalDateTime.of(2025, 6, 28, 14, 5, 9);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        BurhanFess.tampilkanWaktuSekarang(waktu);

        System.setOut(originalOut);

        String expected = String.format("Fess dikirimkan sekarang pada 28 Juni 2025, pukul 14:05:09\n");
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testRunProgramSekaliLangsungSelesai() {
        String input = String.join("\n",
                "1", // Q1
                "ya", // Q2
                "1", // Q3
                "ya", // Q4
                "1", // Q5
                "0", // mode interpretasi
                "1", // mode kirim (delay)
                "120", // delay
                "tidak" // selesai
        );
        Scanner scanner = new Scanner(new StringReader(input));
        BurhanFess.runProgram(scanner);
    }

    @Test
    public void testRunProgramDenganTampilWaktuSekarang() {
        String input = String.join("\n",
                "1", // Q1
                "ya", // Q2
                "1", // Q3
                "ya", // Q4
                "1", // Q5
                "0", // Mode interpretasi: If-Else
                "0", // Mode kirim: sekarang → tampilkanWaktuSekarang akan dipanggil
                "tidak" // Tidak lanjut
        );
        Scanner scanner = new Scanner(new StringReader(input));
        BurhanFess.runProgram(scanner);
    }
}

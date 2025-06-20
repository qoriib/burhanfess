import java.util.Scanner;
import java.time.LocalDateTime;

public class BurhanFess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int kodeVibe = 0;

        // Tampilan awal: ASCII Art
        System.out.println("###########################################################");
        System.out.println("#                                                         #");
        System.out.println("#                                                         #");
        System.out.println("#   ____             _                 _____              #");
        System.out.println("#  | __ ) _   _ _ __| |__   __ _ _ __ |  ___|__  ___ ___  #");
        System.out.println("#  |  _ \\| | | | '__| '_ \\ / _` | '_ \\| |_ / _ \\/ __/ __| #");
        System.out.println("#  | |_) | |_| | |  | | | | (_| | | | |  _|  __/\\__ \\__ \\ #");
        System.out.println("#  |____/ \\__,_|_|  |_| |_|\\__,_|_| |_|_|  \\___||___/___/ #");
        System.out.println("#                                                         #");
        System.out.println("#                                                         #");
        System.out.println("#                                                         #");
        System.out.println("###########################################################");
        System.out.println("------------------------- PANDUAN -------------------------");
        System.out
                .println("Program ini adalah kuis interaktif yang akan menebak kode kode vibe-mu di dunia BurhanFess.");
        System.out.println("Kamu akan menjawab 5 pertanyaan:");
        System.out.println("- Jawaban berupa angka (1 = ya, 0 = tidak) atau teks ('ya', 'tidak')");
        System.out.println("- Jawaban memengaruhi skor kamu (kodeVibe)");
        System.out.println("Hasil akan diubah menjadi tipe vibe yang cocok denganmu!");
        System.out.println("-----------------------------------------------------------");

        // Pertanyaan 1 - int, jika == 1 maka terwakili (+1)
        System.out.print("1. Apakah kamu sering stalking akun Burhanfess? (angka): ");
        int jawaban1 = input.nextInt();
        if (jawaban1 == 1)
            kodeVibe += 1;

        input.nextLine(); // Buang newline

        // Pertanyaan 2 - String, case-insensitive, "ya" = +2
        System.out.print("2. Apakah kamu pernah mengirim fess? (teks): ");
        String jawaban2 = input.nextLine();
        if (jawaban2.equalsIgnoreCase("ya")) {
            kodeVibe += 2;
        }

        // Pertanyaan 3 - int, jika == 1 maka terwakili (+4)
        System.out.print("3. Apakah kamu pernah gagal move on karena fess? (angka): ");
        int jawaban3 = input.nextInt();
        if (jawaban3 == 1)
            kodeVibe += 4;

        input.nextLine(); // newline lagi

        // Pertanyaan 4 - String, case-sensitive, hanya "ya" huruf kecil (+8)
        System.out.print("4. Apakah kamu punya alter khusus buat Burhanfess? (teks): ");
        String jawaban4 = input.nextLine();
        if (jawaban4.equals("ya")) {
            kodeVibe += 8;
        }

        // Pertanyaan 5 - int, jika == 1 maka terwakili (+16)
        System.out.print("5. Apakah kamu ingin mengirim fess anonim hari ini? (angka): ");
        int jawaban5 = input.nextInt();
        if (jawaban5 == 1)
            kodeVibe += 16;

        // Pilih mode interpretasi
        System.out.println("-----------------------------------------------------------");
        System.out.print("Pilih mode interpretasi hasil (0 = If-Else, 1 = Switch-Case): ");
        int mode = input.nextInt();
        String hasil = "";
        String via = "";

        if (mode == 0) {
            via = "If-Else";
            if (kodeVibe >= 0 && kodeVibe <= 5) {
                hasil = "Kamu tipe 'pengagum diam-diam'. MenFess-mu jarang, tapi kalau muncul bikin kaget.";
            } else if (kodeVibe <= 10) {
                hasil = "Kamu tipe 'semi-aktif'. Kadang muncul dengan kode, kadang ngilang.";
            } else if (kodeVibe <= 15) {
                hasil = "Kamu tipe 'suka bikin penasaran'. MenFess-mu bikin orang mikir, tapi kadang bikin bingung.";
            } else if (kodeVibe <= 20) {
                hasil = "Kamu tipe 'suka bikin drama'. MenFess-mu bikin orang penasaran, tapi terlalu banyak drama.";
            } else if (kodeVibe <= 25) {
                hasil = "Kamu tipe 'suka bikin orang mikir'. MenFess-mu bikin orang penasaran, tapi kadang bikin mereka mikir.";
            } else {
                hasil = "Kamu tipe 'rahasia'. MenFess-mu jarang muncul, tapi kalau muncul bikin orang penasaran siapa yang kirim.";
            }
        } else {
            via = "Switch-Case";
            switch (kodeVibe / 5) {
                case 0:
                    hasil = "Kamu tipe 'pengagum diam-diam'. MenFess-mu jarang, tapi kalau muncul bikin kaget.";
                    break;
                case 1:
                    hasil = "Kamu tipe 'semi-aktif'. Kadang muncul dengan kode, kadang ngilang.";
                    break;
                case 2:
                    hasil = "Kamu tipe 'suka bikin penasaran'. MenFess-mu bikin orang mikir, tapi kadang bikin bingung.";
                    break;
                case 3:
                    hasil = "Kamu tipe 'suka bikin drama'. MenFess-mu bikin orang penasaran, tapi terlalu banyak drama.";
                    break;
                case 4:
                    hasil = "Kamu tipe 'suka bikin orang mikir'. MenFess-mu bikin orang penasaran, tapi kadang bikin mereka mikir.";
                    break;
                default:
                    hasil = "Kamu tipe 'rahasia'. MenFess-mu jarang muncul, tapi kalau muncul bikin orang penasaran siapa yang kirim.";
                    break;
            }
        }

        // Tampilkan hasil akhir
        System.out.println(hasil + " : via " + via);

        // Pilih mode pengiriman
        System.out.println("-----------------------------------------------------------");
        System.out.print("Pilih mode pengiriman fess (0 = sekarang, 1 = masa depan): ");
        int modeKirim = input.nextInt();

        LocalDateTime now = LocalDateTime.now();

        if (modeKirim == 0) {
            // Ambil komponen waktu sekarang
            int tgl = now.getDayOfMonth();
            int bln = now.getMonthValue();
            int thn = now.getYear();
            int jam = now.getHour();
            int menit = now.getMinute();
            int detik = now.getSecond();

            System.out.printf("Fess dikirimkan sekarang pada %d %s %d, pukul %02d:%02d:%02d\n", tgl, namaBulan(bln),
                    thn, jam, menit, detik);
        } else {
            System.out.print("Masukkan jumlah detik dari sekarang hingga fess dikirim: ");
            int tambahDetik = input.nextInt();

            // Ambil komponen waktu sekarang
            int second = now.getSecond() + (tambahDetik % 60);
            int minute = now.getMinute() + ((tambahDetik / 60) % 60);
            int hour = now.getHour() + ((tambahDetik / 3600) % 24);
            int day = now.getDayOfMonth();
            int month = now.getMonthValue();
            int year = now.getYear();

            // Penyesuaian antar satuan waktu
            if (second >= 60) {
                second -= 60;
                minute++;
            }
            if (minute >= 60) {
                minute -= 60;
                hour++;
            }
            if (hour >= 24) {
                hour -= 24;
                day++;
            }

            int[] hariPerBulan = { 31, isKabisat(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

            if (day > hariPerBulan[month - 1]) {
                day = 1;
                month++;
            }
            if (month > 12) {
                month = 1;
                year++;
            }

            System.out.printf("Fess dijadwalkan untuk dikirim pada %d %s %d, pukul %02d:%02d:%02d\n", day,
                    namaBulan(month), year, hour, minute, second);
        }

        input.close();
    }

    // Cek tahun kabisat
    public static boolean isKabisat(int tahun) {
        return (tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0);
    }

    // Nama bulan manual
    public static String namaBulan(int bulan) {
        String[] nama = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        return nama[bulan - 1];
    }
}
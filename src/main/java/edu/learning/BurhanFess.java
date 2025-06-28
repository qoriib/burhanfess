package edu.learning;

import java.util.Scanner;
import java.time.LocalDateTime;

public class BurhanFess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        runProgram(input);
        input.close();
    }

    public static void runProgram(Scanner input) {
        int totalPermainan = 0;
        int totalKesalahan = 0;
        boolean lanjut = true;

        tampilkanAsciiArt();

        while (lanjut) {
            totalPermainan++;

            int kodeVibe = hitungKodeVibe(input);
            int[] modeResult = getValidInput(input,
                    "Pilih mode interpretasi hasil (0 = If-Else, 1 = Switch-Case): ",
                    0,
                    1);
            int mode = modeResult[0];
            totalKesalahan += modeResult[1];

            System.out.println(interpretasiVibe(kodeVibe, mode));

            int[] modeKirimResult = getValidInput(input,
                    "Pilih mode pengiriman fess (0 = sekarang, 1 = masa depan, 2 = simulasi antrian): ",
                    0,
                    2);
            int modeKirim = modeKirimResult[0];
            totalKesalahan += modeKirimResult[1];

            LocalDateTime now = LocalDateTime.now();

            switch (modeKirim) {
                case 0:
                    tampilkanWaktuSekarang(now);
                    break;
                case 1:
                    System.out.print("Masukkan jumlah detik dari sekarang hingga fess dikirim: ");
                    int delay = input.nextInt();
                    LocalDateTime waktuKirim = calculateDelayedDateTime(now, delay);
                    System.out.printf("Fess dijadwalkan untuk dikirim pada %d %s %d, pukul %02d:%02d:%02d\n",
                            waktuKirim.getDayOfMonth(),
                            namaBulan(waktuKirim.getMonthValue()),
                            waktuKirim.getYear(),
                            waktuKirim.getHour(),
                            waktuKirim.getMinute(),
                            waktuKirim.getSecond());
                    break;
                case 2:
                    simulasiAntrianTerjadwal(input);
                    break;
            }

            input.nextLine();
            System.out.print("Ingin bermain lagi? (ya/tidak): ");
            String lagi = input.nextLine();
            if (!lagi.equalsIgnoreCase("ya")) {
                lanjut = false;
            }
        }

        System.out.println("\nPermainan telah berakhir.");
        System.out.println("Anda telah memainkan " + totalPermainan + " kali permainan.");
        System.out.println("Ada " + totalKesalahan + " kali pilihan yang tidak sesuai.");
        tampilkanAsciiThanks();
    }

    public static void simulasiAntrianTerjadwal(Scanner input) {
        System.out.print("Berapa fess yang ingin dijadwalkan? (maks 5): ");
        int jumlah = input.nextInt();
        while (jumlah < 1 || jumlah > 5) {
            System.out.print("Jumlah tidak valid. Masukkan angka 1 - 5: ");
            jumlah = input.nextInt();
        }

        LocalDateTime now = LocalDateTime.now();
        System.out.printf("Waktu sekarang: %d %s %d, %02d:%02d:%02d\n",
                now.getDayOfMonth(),
                namaBulan(now.getMonthValue()),
                now.getYear(),
                now.getHour(),
                now.getMinute(),
                now.getSecond());

        // Variabel delay dan waktu simpan manual
        LocalDateTime t1 = null, t2 = null, t3 = null, t4 = null, t5 = null;

        for (int i = 1; i <= jumlah; i++) {
            System.out.printf("Masukkan delay fess #%d (detik): ", i);
            int delay = input.nextInt();
            LocalDateTime waktu = calculateDelayedDateTime(now, delay);

            if (i == 1) {
                t1 = waktu;
            }
            if (i == 2) {
                t2 = waktu;
            }
            if (i == 3) {
                t3 = waktu;
            }
            if (i == 4) {
                t4 = waktu;
            }
            if (i == 5) {
                t5 = waktu;
            }
        }

        System.out.println("\nMengurutkan dan mengirimkan fess..");

        for (int i = 0; i < jumlah; i++) {
            LocalDateTime min = null;
            int index = -1;

            if (t1 != null && (min == null || t1.isBefore(min))) {
                min = t1;
                index = 1;
            }
            if (t2 != null && (min == null || t2.isBefore(min))) {
                min = t2;
                index = 2;
            }
            if (t3 != null && (min == null || t3.isBefore(min))) {
                min = t3;
                index = 3;
            }
            if (t4 != null && (min == null || t4.isBefore(min))) {
                min = t4;
                index = 4;
            }
            if (t5 != null && (min == null || t5.isBefore(min))) {
                min = t5;
                index = 5;
            }

            if (min != null) {
                System.out.printf("Fess akan dikirim pada: %d %s %d, %02d:%02d:%02d\n",
                        min.getDayOfMonth(),
                        namaBulan(min.getMonthValue()),
                        min.getYear(),
                        min.getHour(),
                        min.getMinute(),
                        min.getSecond());

                // "Hapus" entry terkecil
                if (index == 1)
                    t1 = null;
                if (index == 2)
                    t2 = null;
                if (index == 3)
                    t3 = null;
                if (index == 4)
                    t4 = null;
                if (index == 5)
                    t5 = null;
            }
        }
    }

    public static void tampilkanAsciiArt() {
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
    }

    public static void tampilkanAsciiThanks() {
        System.out.println("######################################");
        System.out.println("#                                    #");
        System.out.println("#                                    #");
        System.out.println("#  _____ _                 _         #");
        System.out.println("# |_   _| |__   __ _ _ __ | | _____  #");
        System.out.println("#   | | | '_ \\ / _` | '_ \\| |/ / __| #");
        System.out.println("#   | | | | | | (_| | | | |   <\\__ \\ #");
        System.out.println("#   |_| |_| |_|\\__,_|_| |_|_|\\_\\___/ #");
        System.out.println("#                                    #");
        System.out.println("#                                    #");
        System.out.println("######################################");
    }

    public static int[] getValidInput(Scanner input, String prompt, int min, int max) {
        int nilai = -1;
        int kesalahan = 0;

        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                nilai = input.nextInt();
                if (nilai >= min && nilai <= max) {
                    break;
                }
            } else {
                input.next();
            }
            System.out.println("Input tidak valid. Coba lagi.");
            kesalahan++;
        }

        return new int[] { nilai, kesalahan };
    }

    public static int hitungKodeVibe(Scanner input) {
        int kodeVibe = 0;

        System.out.print("1. Apakah kamu sering stalking akun Burhanfess?: ");
        int jawaban1 = input.nextInt();
        if (jawaban1 == 1)
            kodeVibe += 1;
        input.nextLine();

        System.out.print("2. Apakah kamu pernah mengirim fess?: ");
        String jawaban2 = input.nextLine();
        if (jawaban2.equalsIgnoreCase("ya"))
            kodeVibe += 2;

        System.out.print("3. Apakah kamu pernah gagal move on karena fess?: ");
        int jawaban3 = input.nextInt();
        if (jawaban3 == 1)
            kodeVibe += 4;
        input.nextLine();

        System.out.print("4. Apakah kamu punya alter khusus buat Burhanfess?: ");
        String jawaban4 = input.nextLine();
        if (jawaban4.equals("ya"))
            kodeVibe += 8;

        System.out.print("5. Apakah kamu ingin mengirim fess anonim hari ini?: ");
        int jawaban5 = input.nextInt();
        if (jawaban5 == 1)
            kodeVibe += 16;

        return kodeVibe;
    }

    public static String interpretasiVibe(int kodeVibe, int mode) {
        String via;
        String hasil;

        if (mode == 0) {
            via = "If-Else";
            if (kodeVibe <= 5) {
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
        return hasil + " : via " + via;
    }

    public static void tampilkanWaktuSekarang(LocalDateTime now) {
        System.out.printf("Fess dikirimkan sekarang pada %d %s %d, pukul %02d:%02d:%02d\n",
                now.getDayOfMonth(),
                namaBulan(now.getMonthValue()),
                now.getYear(),
                now.getHour(),
                now.getMinute(),
                now.getSecond());
    }

    public static LocalDateTime calculateDelayedDateTime(LocalDateTime now, int delaySeconds) {
        int second = now.getSecond() + (delaySeconds % 60);
        int minute = now.getMinute() + ((delaySeconds / 60) % 60);
        int hour = now.getHour() + ((delaySeconds / 3600) % 24);
        int day = now.getDayOfMonth() + (delaySeconds / 86400);
        int month = now.getMonthValue();
        int year = now.getYear();

        while (second >= 60) {
            second -= 60;
            minute++;
        }
        while (minute >= 60) {
            minute -= 60;
            hour++;
        }
        while (hour >= 24) {
            hour -= 24;
            day++;
        }

        while (true) {
            int maxDay = getMaxDaysInMonth(month, year);
            if (day <= maxDay) {
                break;
            }
            day -= maxDay;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        return LocalDateTime.of(year, month, day, hour, minute, second);
    }

    public static int getMaxDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                return isKabisat(year) ? 29 : 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }

    public static boolean isKabisat(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String namaBulan(int bulan) {
        String[] nama = {
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
        return nama[bulan - 1];
    }
}
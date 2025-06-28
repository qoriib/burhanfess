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

        // Pertanyaan 1
        System.out.print("1. Apakah kamu sering stalking akun Burhanfess?: ");
        int jawaban1 = input.nextInt();
        if (jawaban1 == 1) {
            kodeVibe += 1;
        }
        input.nextLine();

        // Pertanyaan 2
        System.out.print("2. Apakah kamu pernah mengirim fess?: ");
        String jawaban2 = input.nextLine();
        if (jawaban2.equalsIgnoreCase("ya")) {
            kodeVibe += 2;
        }

        // Pertanyaan 3
        System.out.print("3. Apakah kamu pernah gagal move on karena fess?: ");
        int jawaban3 = input.nextInt();
        if (jawaban3 == 1) {
            kodeVibe += 4;
        }
        input.nextLine();

        // Pertanyaan 4
        System.out.print("4. Apakah kamu punya alter khusus buat Burhanfess?: ");
        String jawaban4 = input.nextLine();
        if (jawaban4.equals("ya")) {
            kodeVibe += 8;
        }

        // Pertanyaan 5
        System.out.print("5. Apakah kamu ingin mengirim fess anonim hari ini?: ");
        int jawaban5 = input.nextInt();
        if (jawaban5 == 1) {
            kodeVibe += 16;
        }

        // Mode interpretasi hasil
        System.out.print("Pilih mode interpretasi hasil (0 = If-Else, 1 = Switch-Case): ");
        int mode = input.nextInt();
        String hasil = "";
        String via = "";

        if (mode == 0) {
            via = "If-Else";
            if (kodeVibe <= 5)
                hasil = "Kamu tipe 'pengagum diam-diam'. MenFess-mu jarang, tapi kalau muncul bikin kaget.";
            else if (kodeVibe <= 10)
                hasil = "Kamu tipe 'semi-aktif'. Kadang muncul dengan kode, kadang ngilang.";
            else if (kodeVibe <= 15)
                hasil = "Kamu tipe 'suka bikin penasaran'. MenFess-mu bikin orang mikir, tapi kadang bikin bingung.";
            else if (kodeVibe <= 20)
                hasil = "Kamu tipe 'suka bikin drama'. MenFess-mu bikin orang penasaran, tapi terlalu banyak drama.";
            else if (kodeVibe <= 25)
                hasil = "Kamu tipe 'suka bikin orang mikir'. MenFess-mu bikin orang penasaran, tapi kadang bikin mereka mikir.";
            else
                hasil = "Kamu tipe 'rahasia'. MenFess-mu jarang muncul, tapi kalau muncul bikin orang penasaran siapa yang kirim.";
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

        System.out.println(hasil + " : via " + via);

        // Pengiriman fess
        System.out.print("Pilih mode pengiriman fess (0 = sekarang, 1 = masa depan): ");
        int modeKirim = input.nextInt();

        LocalDateTime now = LocalDateTime.now();

        if (modeKirim == 0) {
            System.out.printf("Fess dikirimkan sekarang pada %d %s %d, pukul %02d:%02d:%02d\n",
                    now.getDayOfMonth(),
                    namaBulan(now.getMonthValue()),
                    now.getYear(),
                    now.getHour(),
                    now.getMinute(),
                    now.getSecond());
        } else {
            System.out.print("Masukkan jumlah detik dari sekarang hingga fess dikirim: ");
            int tambahDetik = input.nextInt();

            LocalDateTime waktuKirim = calculateDelayedDateTime(now, tambahDetik);

            System.out.printf("Fess dijadwalkan untuk dikirim pada %d %s %d, pukul %02d:%02d:%02d\n",
                    waktuKirim.getDayOfMonth(),
                    namaBulan(waktuKirim.getMonthValue()),
                    waktuKirim.getYear(),
                    waktuKirim.getHour(),
                    waktuKirim.getMinute(),
                    waktuKirim.getSecond());
        }

        input.close();
    }

    // Hitung waktu kirim menggunakan loop untuk menangani delay sangat besar
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
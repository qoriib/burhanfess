import java.util.Scanner;

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

        // Pertanyaan 1 - int, jika == 1 maka terwakili (+1)
        System.out.print("1. Apakah kamu sering stalking akun Burhanfess?: ");
        int jawaban1 = input.nextInt();
        if (jawaban1 == 1)
            kodeVibe += 1;

        input.nextLine(); // Buang newline

        // Pertanyaan 2 - String, case-insensitive, "ya" = +2
        System.out.print("2. Apakah kamu pernah mengirim fess?: ");
        String jawaban2 = input.nextLine();
        if (jawaban2.equalsIgnoreCase("ya")) {
            kodeVibe += 2;
        }

        // Pertanyaan 3 - int, jika == 1 maka terwakili (+4)
        System.out.print("3. Apakah kamu pernah gagal move on karena fess?: ");
        int jawaban3 = input.nextInt();
        if (jawaban3 == 1)
            kodeVibe += 4;

        input.nextLine(); // newline lagi

        // Pertanyaan 4 - String, case-sensitive, hanya "ya" huruf kecil (+8)
        System.out.print("4. Apakah kamu punya alter khusus buat Burhanfess?: ");
        String jawaban4 = input.nextLine();
        if (jawaban4.equals("ya")) {
            kodeVibe += 8;
        }

        // Pertanyaan 5 - int, jika == 1 maka terwakili (+16)
        System.out.print("5. Apakah kamu ingin mengirim fess anonim hari ini?: ");
        int jawaban5 = input.nextInt();
        if (jawaban5 == 1)
            kodeVibe += 16;

        // Menafsirkan kodeVibe
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

        input.close();
    }
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import threading.ThreadExecutor;
import java.util.*;
import projek_pbo.*;

public class Main {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            List<BendaGeometri> shapes = new ArrayList<>();
            Random random = new Random();
            int pilihan;
            boolean lanjutMenu = true;
            do {
                System.out.println("\n=== Program Perhitungan Benda Geometri ===");
                System.out.println("1. Segitiga ");
                System.out.println("2. Jajar Genjang ");
                System.out.println("3. Belah Ketupat ");
                System.out.println("4. Persegi Panjang ");
                System.out.println("5. Layang-Layang ");
                System.out.println("6. Persegi ");
                System.out.println("7. Trapesium ");
                System.out.println("8. Lingkaran");
                System.out.println("9. Juring Lingkaran");
                System.out.println("10. Tembereng Lingkaran");
                System.out.println("11. Kubus ");
                System.out.println("12. Limas Persegi");
                System.out.println("13. Prisma Persegi");
                System.out.println("14. Limas Belah Ketupat ");
                System.out.println("15. Prisma Belah Ketupat ");
                System.out.println("16. Limas Layang Layang ");
                System.out.println("17. Prisma Layang Layang ");
                System.out.println("18. Limas Segitiga ");
                System.out.println("19. Prisma Segitiga ");
                System.out.println("20. Limas Jajar Genjang ");
                System.out.println("21. Prisma Jajar Genjang ");
                System.out.println("22. Limas Trapesium ");
                System.out.println("23. Prisma Trapesium ");
                System.out.println("24. Balok ");
                System.out.println("25. Limas Persegi Panjang ");
                System.out.println("26. Prisma Persegi Panjang ");
                System.out.println("27. Bola");
                System.out.println("28. Cincin Bola ");
                System.out.println("29. Juring Bola ");
                System.out.println("30. Tembereng Bola ");
                System.out.println("31. Kerucut ");
                System.out.println("32. Kerucut Terpancung ");
                System.out.println("33. Tabung");
                System.out.println("34. Polymorphism");
                System.out.println("35. Exit");
                System.out.println("36. Proses Geometri Acak dengan Thread pool");
                System.out.print("Masukkan pilihan anda : ");

                try {
                    pilihan = input.nextInt();
                    input.nextLine();
                    switch (pilihan) {
                        case 1:
                            Segitiga segitiga = new Segitiga(10, 5);
                            System.out.printf("Luas Segitiga: %.2f\n", segitiga.hitungLuas());
                            System.out.printf("Keliling Segitiga: %.2f\n", segitiga.hitungKeliling());
                            break;
                        case 2:
                            JajarGenjang jajargenjang = new JajarGenjang(10, 12, 8, 6);
                            System.out.printf("Luas JajarGenjang: %.2f\n", jajargenjang.hitungLuas());
                            System.out.printf("Keliling JajarGenjang: %.2f\n", jajargenjang.hitungKeliling());
                            break;
                        case 3:
                            BelahKetupat belahketupat = new BelahKetupat(10, 12, 10);
                            System.out.printf("Luas BelahKetupat: %.2f\n", belahketupat.hitungLuas());
                            System.out.printf("Keliling BelahKetupat: %.2f\n", belahketupat.hitungKeliling());
                            break;
                        case 4:
                            PersegiPanjang persegipanjang = new PersegiPanjang(15, 10);
                            System.out.printf("Luas PersegiPanjang: %.2f\n", persegipanjang.hitungLuas());
                            System.out.printf("Keliling PersegiPanjang: %.2f\n", persegipanjang.hitungKeliling());
                            break;
                        case 5:
                            LayangLayang layanglayang = new LayangLayang(15, 10, 8, 12);
                            System.out.printf("Luas LayangLayang: %.2f\n", layanglayang.hitungLuas());
                            System.out.printf("Keliling LayangLayang: %.2f\n", layanglayang.hitungKeliling());
                            break;
                        case 6:
                            Persegi persegi = new Persegi(5);
                            System.out.printf("Luas Persegi: %.2f\n", persegi.hitungLuas());
                            System.out.printf("Keliling Persegi: %.2f\n", persegi.hitungKeliling());
                            persegi.prosesInputDanValidasi();
                            break;
                        case 7:
                            Trapesium trapesium = new Trapesium(10, 8, 12, 15);
                            System.out.printf("Luas Trapesium: %.2f\n", trapesium.hitungLuas());
                            System.out.printf("Keliling Trapesium: %.2f\n", trapesium.hitungKeliling());
                            break;
                        case 8:
                            Lingkaran lingkaran = new Lingkaran(7);
                            System.out.printf("Luas Lingkaran: %.2f\n", lingkaran.hitungLuas());
                            System.out.printf("Keliling Lingkaran: %.2f\n", lingkaran.hitungKeliling());
                            lingkaran.prosesInputDanValidasi();
                            break;
                        case 9:
                            JuringLingkaran juringLingkaran = new JuringLingkaran(7, 90);
                            System.out.printf("Luas Juring Lingkaran: %.2f\n", juringLingkaran.hitungLuas());
                            System.out.printf("Keliling Juring Lingkaran: %.2f\n", juringLingkaran.hitungKeliling());
                            juringLingkaran.prosesInputDanValidasi();
                            break;
                        case 10:
                            TemberengLingkaran temberengLingkaran = new TemberengLingkaran(7, 90);
                            System.out.printf("Luas Tembereng Lingkaran: %.2f\n", temberengLingkaran.hitungLuas());
                            System.out.printf("Keliling Tembereng Lingkaran: %.2f\n", temberengLingkaran.hitungKeliling());
                            temberengLingkaran.prosesInputDanValidasi();
                            break;
                        case 11:
                            Kubus kubus = new Kubus(10);
                            System.out.printf("Luas Permukaan Kubus: %.2f\n", kubus.hitungLuasPermukaan());
                            System.out.printf("Volume Limas Kubus: %.2f\n", kubus.hitungVolume());
                            break;
                        case 12:
                            LimasPersegi limasPersegi = new LimasPersegi(5, 10);
                            System.out.printf("Luas Permukaan Limas Persegi: %.2f\n", limasPersegi.hitungLuasPermukaan());
                            System.out.printf("Volume Limas Persegi: %.2f\n", limasPersegi.hitungVolume());
                            limasPersegi.prosesInputDanValidasi();
                            break;
                        case 13:
                            PrismaPersegi prismaPersegi = new PrismaPersegi(5, 10);
                            System.out.printf("Luas Permukaan Prisma Persegi: %.2f\n", prismaPersegi.hitungLuasPermukaan());
                            System.out.printf("Volume Prisma Persegi: %.2f\n", prismaPersegi.hitungVolume());
                            prismaPersegi.prosesInputDanValidasi();
                            break;
                        case 14:
                            LimasBelahKetupat limasBelahKetupat = new LimasBelahKetupat(5, 10, 12, 8);
                            System.out.printf("Luas Permukaan Limas BelahKetupat: %.2f\n", limasBelahKetupat.hitungLuasPermukaan());
                            System.out.printf("Volume Limas BelahKetupat: %.2f\n", limasBelahKetupat.hitungVolume());
                            break;
                        case 15:
                            PrismaBelahKetupat prismaBelahKetupat = new PrismaBelahKetupat(8, 10, 8, 12);
                            System.out.printf("Luas Permukaan Prisma BelahKetupat: %.2f\n", prismaBelahKetupat.hitungLuasPermukaan());
                            System.out.printf("Volume Prisma BelahKetupat: %.2f\n", prismaBelahKetupat.hitungVolume());
                            break;
                        case 16:
                            LimasLayangLayang limasLayangLayang = new LimasLayangLayang(5, 10, 12, 8, 14);
                            System.out.printf("Luas Permukaan Limas LayangLayang: %.2f\n", limasLayangLayang.hitungLuasPermukaan());
                            System.out.printf("Volume Limas LayangLayang: %.2f\n", limasLayangLayang.hitungVolume());
                            break;
                        case 17:
                            PrismaLayangLayang prismaLayangLayang = new PrismaLayangLayang(8, 10, 8, 12, 14);
                            System.out.printf("Luas Permukaan Prisma LayangLayang: %.2f\n", prismaLayangLayang.hitungLuasPermukaan());
                            System.out.printf("Volume Prisma LayangLayang: %.2f\n", prismaLayangLayang.hitungVolume());
                            break;
                        case 18:
                            LimasSegitiga limasSegitiga = new LimasSegitiga(5, 10, 12);
                            System.out.printf("Luas Permukaan Limas Segitiga: %.2f\n", limasSegitiga.hitungLuasPermukaan());
                            System.out.printf("Volume Limas Segitiga: %.2f\n", limasSegitiga.hitungVolume());
                            break;
                        case 19:
                            PrismaSegitiga prismaSegitiga = new PrismaSegitiga(8, 10, 14);
                            System.out.printf("Luas Permukaan Prisma Segitiga: %.2f\n", prismaSegitiga.hitungLuasPermukaan());
                            System.out.printf("Volume Prisma Segitiga: %.2f\n", prismaSegitiga.hitungVolume());
                            break;
                        case 20:
                            LimasJajarGenjang limasJajarGenjang = new LimasJajarGenjang(5, 10, 12, 8, 10);
                            System.out.printf("Luas Permukaan Limas JajarGenjang: %.2f\n", limasJajarGenjang.hitungLuasPermukaan());
                            System.out.printf("Volume Limas JajarGenjang: %.2f\n", limasJajarGenjang.hitungVolume());
                            break;
                        case 21:
                            PrismaJajarGenjang prismaJajarGenjang = new PrismaJajarGenjang(8, 10, 14, 8, 12);
                            System.out.printf("Luas Permukaan Prisma JajarGenjang: %.2f\n", prismaJajarGenjang.hitungLuasPermukaan());
                            System.out.printf("Volume Prisma JajarGenjang: %.2f\n", prismaJajarGenjang.hitungVolume());
                            break;
                        case 22:
                            LimasTrapesium limasTrapesium = new LimasTrapesium(5, 10, 12, 8, 10);
                            System.out.printf("Luas Permukaan Limas Trapesium: %.2f\n", limasTrapesium.hitungLuasPermukaan());
                            System.out.printf("Volume Limas Trapesium: %.2f\n", limasTrapesium.hitungVolume());
                            break;
                        case 23:
                            PrismaTrapesium prismaTrapesium = new PrismaTrapesium(8, 10, 14, 8, 12);
                            System.out.printf("Luas Permukaan Prisma Trapesium: %.2f\n", prismaTrapesium.hitungLuasPermukaan());
                            System.out.printf("Volume Prisma Trapesium: %.2f\n", prismaTrapesium.hitungVolume());
                            break;
                        case 24:
                            Balok balok = new Balok(10, 12, 15);
                            System.out.printf("Luas Permukaan Balok: %.2f\n", balok.hitungLuasPermukaan());
                            System.out.printf("Volume Limas Balok: %.2f\n", balok.hitungVolume());
                            break;
                        case 25:
                            LimasPersegiPanjang limasPersegiPanjang = new LimasPersegiPanjang(8, 10, 12);
                            System.out.printf("Luas Permukaan Limas PersegiPanjang: %.2f\n", limasPersegiPanjang.hitungLuasPermukaan());
                            System.out.printf("Volume Limas PersegiPanjang: %.2f\n", limasPersegiPanjang.hitungVolume());
                            break;
                        case 26:
                            PrismaPersegiPanjang prismaPersegiPanjang = new PrismaPersegiPanjang(8, 10, 14);
                            System.out.printf("Luas Permukaan Prisma Persegi Panjang: %.2f\n", prismaPersegiPanjang.hitungLuasPermukaan());
                            System.out.printf("Volume Prisma Persegi Panjang: %.2f\n", prismaPersegiPanjang.hitungVolume());
                            break;
                        case 27:
                            Bola bola = new Bola(7);
                            System.out.printf("Luas Permukaan Bola: %.2f\n", bola.hitungLuasPermukaan());
                            System.out.printf("Volume Bola: %.2f\n", bola.hitungVolume());
                            bola.prosesInputDanValidasi();
                            break;
                        case 28:
                            CincinBola cincinBola = new CincinBola(7, 14);
                            System.out.printf("Luas Permukaan CincinBola: %.2f\n", cincinBola.hitungLuasPermukaan());
                            System.out.printf("Volume CincinBola: %.2f\n", cincinBola.hitungVolume());
                            break;
                        case 29:
                            JuringBola juringBola = new JuringBola(7, 60);
                            System.out.printf("Luas Permukaan JuringBola: %.2f\n", juringBola.hitungLuasPermukaan());
                            System.out.printf("Volume JuringBola: %.2f\n", juringBola.hitungVolume());
                            break;
                        case 30:
                            TemberengBola temberengBola = new TemberengBola(7, 21);
                            System.out.printf("Luas Permukaan TemberengBola: %.2f\n", temberengBola.hitungLuasPermukaan());
                            System.out.printf("Volume TemberengBola: %.2f\n", temberengBola.hitungVolume());
                            break;
                        case 31:
                            Kerucut kerucut = new Kerucut(7, 12);
                            System.out.printf("Luas Permukaan Kerucut: %.2f\n", kerucut.hitungLuasPermukaan());
                            System.out.printf("Volume Kerucut: %.2f\n", kerucut.hitungVolume());
                            break;
                        case 32:
                            KerucutTerpancung kerucutTerpancung = new KerucutTerpancung(7, 7, 14);
                            System.out.printf("Luas Permukaan kerucut Terpancung: %.2f\n", kerucutTerpancung.hitungLuasPermukaan());
                            System.out.printf("Volume Kerucut Terpancung: %.2f\n", kerucutTerpancung.hitungVolume());
                            break;
                        case 33:
                            Tabung tabung = new Tabung(7, 10);
                            System.out.printf("Luas Permukaan Tabung: %.2f\n", tabung.hitungLuasPermukaan());
                            System.out.printf("Volume Tabung: %.2f\n", tabung.hitungVolume());
                            tabung.prosesInputDanValidasi();
                            break;
                        case 34:
                            BangunDatar bd1 = new Lingkaran(7);
                            BangunDatar bd2 = new Bola(14);
                            System.out.println("Luas Lingkaran (bd1): " + bd1.hitungLuas());
                            System.out.println("Luas Bola (bd2): " + bd2.hitungLuas());
                            break;
                        case 35:
                            System.out.println("Terimakasih Telah menggunakan Program ini.");
                            break;
                        case 36:
                             System.out.print("Masukkan jumlah objek per bentuk geometri untuk digenerate: ");
                            int jumlahPerBentuk = input.nextInt();
                            input.nextLine();
                            shapes.clear();
                            for (int i = 1; i <= 33; i++){
                                for (int j = 0; j < jumlahPerBentuk;j++){
                                    try {
                                        shapes.add(generateRandomBendaGeometri(i));
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Error saat generate bentuk geometri: " + e.getMessage());
                                    }
                                }
                            }
                            if (!shapes.isEmpty()) {
                                System.out.println("\nMemulai pemrosesan " + shapes.size() + " objek geometri dengan Thread Pool...");
                                ThreadExecutor.processShapes(shapes);
                                System.out.println("Pemrosesan selesai. Hasil ada di atas (mungkin tercampur karena multithreading).");
                            } else {
                                System.out.println("Tidak ada objek geometri yang digenerate.");
                            }
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                    if (pilihan != 36) {
                        lanjutMenu = tanyaKembaliKeMenu(input);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Harap masukkan angka sesuai pilihan.");
                    input.nextLine();
                    pilihan = 0;
                }
            } while (pilihan != 36);
        }
        System.out.println("Program telah berakhir.");
    }
    
     private static boolean tanyaKembaliKeMenu(Scanner input) {
        while (true) {
            System.out.print("Apakah Anda ingin kembali ke menu utama? (y/n): ");
            String jawaban = input.nextLine().trim().toLowerCase();
            if (jawaban.equals("y") || jawaban.equals("ya")) {
                return true;
            } else if (jawaban.equals("n") || jawaban.equals("tidak")) {
                System.out.println("Program akan keluar...");
                return false;
            } else {
                System.out.println("Input tidak dikenali. Silakan masukkan 'y' atau 'n'.");
            }
        }
    }
    
    
    private static double r(){
        return 1 + Math.random() * 10;
    }
    
    private static double r(double min, double max){
        return min + Math.random() * (max - min);
    }
    
    private static BendaGeometri generateRandomBendaGeometri(int choice) {
        return switch (choice){
            case 1 -> new Segitiga(r(), r());
            case 2 -> new JajarGenjang(r(), r(), r(), r());
            case 3 -> new BelahKetupat(r(), r(), r());
            case 4 -> new PersegiPanjang(r(), r());
            case 5 -> new LayangLayang(r(), r(), r(), r());
            case 6 -> new Persegi(r());
            case 7 -> new Trapesium(r(), r(), r(), r());
            case 8 -> new Lingkaran(r());
            case 9 -> new JuringLingkaran(r(), r(1, 360));
            case 10 -> new TemberengLingkaran(r(), r(1, 360));
            case 11 -> new Kubus(r());
            case 12 -> new LimasPersegi(r(), r());
            case 13 -> new PrismaPersegi(r(), r());
            case 14 -> new LimasBelahKetupat(r(), r(), r(), r());
            case 15 -> new PrismaBelahKetupat(r(), r(), r(), r());
            case 16 -> new LimasLayangLayang(r(), r(), r(), r(), r());
            case 17 -> new PrismaLayangLayang(r(), r(), r(), r(), r());
            case 18 -> new LimasSegitiga(r(), r(), r());
            case 19 -> new PrismaSegitiga(r(), r(), r());
            case 20 -> new LimasJajarGenjang(r(), r(), r(), r(), r());
            case 21 -> new PrismaJajarGenjang(r(), r(), r(), r(), r());
            case 22 -> new LimasTrapesium(r(), r(), r(), r(), r());
            case 23 -> new PrismaTrapesium(r(), r(), r(), r(), r());
            case 24 -> new Balok(r(), r(), r());
            case 25 -> new LimasPersegiPanjang(r(), r(), r());
            case 26 -> new PrismaPersegiPanjang(r(), r(), r());
            case 27 -> new Bola(r());
            case 28 -> new CincinBola(r(), r());
            case 29 -> new JuringBola(r(), r(1, 360));
            case 30 -> new TemberengBola(r(), r());
            case 31 -> new Kerucut(r(), r());
            case 32 -> new KerucutTerpancung(r(), r(), r());
            case 33 -> new Tabung(r(), r());
            default -> throw new IllegalArgumentException("Pilihan bentuk geometri tidak valid untuk generator acak: " + choice);
        };
    }


}
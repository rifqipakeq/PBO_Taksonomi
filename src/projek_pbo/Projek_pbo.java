package projek_pbo;

import java.util.InputMismatchException; 
import java.util.Scanner;
// import projekpbo.BangunRuang.*; // Uncomment jika sudah ada kelas bangun ruang

public class Projek_pbo {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int pilihan;
            do {
                System.out.println("\n=== Program Perhitungan Benda Geometri ===");
                System.out.println("1. Hitung dinamis bangun datar");
                System.out.println("2. Hitung dinamis bangun ruang");
                System.out.println("3. Hitung keseluruhan bangun"); 
                System.out.println("4. Exit");
                System.out.print("Masukkan pilihan anda : ");

                try {
                    pilihan = input.nextInt();

                    switch (pilihan) {
                        case 1:
                            System.out.println("\n=== Bangun Datar ===");
                            System.out.println("1. Segitiga");
                            System.out.println("2. Jajar Genjang");
                            System.out.println("3. Belah Ketupat");
                            System.out.println("4. Persegi Panjang");
                            System.out.println("5. Layang-Layang");
                            System.out.println("6. Persegi");
                            System.out.println("7. Trapesium (Belum Implementasi)");
                            System.out.println("8. Lingkaran (Belum Implementasi)");
                            System.out.println("9. Juring Lingkaran (Belum Implementasi)");
                            System.out.println("10. Tembereng Lingkaran (Belum Implementasi)");
                            System.out.print("Masukkan pilihan bangun datar : ");
                            int pilihanBangunDatar = input.nextInt();

                            switch (pilihanBangunDatar) {
                                case 1:
                                    System.out.println("\n--- Menghitung Segitiga ---");

                                    System.out.print("Masukkan nilai alas segitiga : ");
                                    double alas = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi segitiga : ");
                                    double tinggi = input.nextDouble();

                                    Segitiga segitiga = new Segitiga(alas,tinggi);
                                    System.out.println("Luas Segitiga = " + segitiga.luas);
                                    System.out.println("Keliling Segitiga = " + segitiga.keliling);
                                    break;
                                case 2:
                                    System.out.println("\n--- Menghitung JajarGenjang ---");

                                    System.out.print("Masukkan nilai alas JajarGenjang : ");
                                    double alasJajarGenjang = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi JajarGenjang : ");
                                    double tinggiJajarGenjang = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi A JajarGenjang : ");
                                    double sisiAJajarGenjang = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi B JajarGenjang : ");
                                    double sisiBJajarGenjang = input.nextDouble();

                                    JajarGenjang jajarGenjang = new JajarGenjang(alasJajarGenjang,tinggiJajarGenjang,sisiAJajarGenjang,sisiBJajarGenjang);
                                    System.out.println("Luas JajarGenjang = " + jajarGenjang.luas);
                                    System.out.println("Keliling JajarGenjang = " + jajarGenjang.keliling);
                                case 3:
                                    System.out.println("\n--- Menghitung BelahKetupat ---");

                                    System.out.print("Masukkan nilai alas BelahKetupat : ");
                                    double diagonal1BelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi BelahKetupat : ");
                                    double diagonal2BelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi BelahKetupat : ");
                                    double sisiBelahKetupat = input.nextDouble();

                                    BelahKetupat belahKetupat = new BelahKetupat(diagonal1BelahKetupat,diagonal2BelahKetupat,sisiBelahKetupat);
                                    System.out.println("Luas BelahKetupat = " + belahKetupat.luas);
                                    System.out.println("Keliling BelahKetupat = " + belahKetupat.keliling);
                                case 4:
                                    System.out.println("\n--- Menghitung PersegiPanjang ---");

                                    System.out.print("Masukkan nilai panjang PersegiPanjang : ");
                                    double panjangPersegiPanjang = input.nextDouble();

                                    System.out.print("Masukkan nilai lebar PersegiPanjang : ");
                                    double lebarPersegiPanjang = input.nextDouble();

                                    PersegiPanjang persegiPanjang = new PersegiPanjang(panjangPersegiPanjang,lebarPersegiPanjang);
                                    System.out.println("Luas PersegiPanjang = " + persegiPanjang.luas);
                                    System.out.println("Keliling PersegiPanjang = " + persegiPanjang.keliling);
                                case 5:
                                    System.out.println("\n--- Menghitung LayangLayang ---");

                                    System.out.print("Masukkan nilai alas LayangLayang : ");
                                    double diagonal1LayangLayang = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi LayangLayang : ");
                                    double diagonal2LayangLayang = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi A LayangLayang : ");
                                    double sisiALayangLayang = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi B LayangLayang : ");
                                    double sisiBLayangLayang = input.nextDouble();

                                    LayangLayang layangLayang = new LayangLayang(diagonal1LayangLayang,diagonal2LayangLayang,sisiALayangLayang, sisiBLayangLayang);
                                    System.out.println("Luas LayangLayang = " + layangLayang.luas);
                                    System.out.println("Keliling LayangLayang = " + layangLayang.keliling);
                                case 6:
                                    System.out.println("\n--- Menghitung Persegi ---");
                                    System.out.print("Masukkan nilai sisi persegi : ");
                                    double sisi = input.nextDouble();
                                    Persegi persegi = new Persegi(sisi);
                                    System.out.println("Luas Persegi = " + persegi.luas);
                                    System.out.println("Keliling Persegi = " + persegi.keliling);
                                    break;
                                case 7:
                                    System.out.println("\n--- Menghitung Trapesium ---");
                                    System.out.print("Masukkan nilai alas atas trapesium : ");
                                    double alasAtasTrapesium = input.nextDouble();
                                    System.out.print("Masukkan nilai alas bawah trapesium : ");
                                    double alasBawahTrapesium = input.nextDouble();
                                    System.out.print("Masukkan nilai sisi miring  trapesium : ");
                                    double sisiMiringTrapesium = input.nextDouble();
                                    System.out.print("Masukkan nilai tinggi trapesium : ");
                                    double tinggiTrapesium = input.nextDouble();
                                    Trapesium trapesium = new Trapesium(alasAtasTrapesium, alasBawahTrapesium, sisiMiringTrapesium, tinggiTrapesium);
                                    System.out.println("Luas Trapesium = " + trapesium.luas);
                                    System.out.println("Keliling Trapesium = " + trapesium.keliling);
                                    break;
                                case 8:
                                    System.out.println("\n--- Menghitung Lingkaran ---");
                                    System.out.print("Masukkan nilai jari-jari Lingkaran : ");
                                    double jariJariLingkaran = input.nextDouble();
                                    
                                    Lingkaran lingkaran = new Lingkaran(jariJariLingkaran);
                                    System.out.println("Luas Lingkaran = " + lingkaran.luas);
                                    System.out.println("Keliling Lingkaran = " + lingkaran.keliling);
                                    break;
                                case 9:
                                    System.out.println("\n--- Menghitung Juring Lingkaran ---");
                                    System.out.print("Masukkan nilai jari-jari Lingkaran : ");
                                    double jariJariLingkaran_juring = input.nextDouble();
                                    
                                    System.out.print("Masukkan nilai sudut Juring Lingkaran : ");
                                    double sudutJuring = input.nextDouble();
                                    
                                    JuringLingkaran juringLingkaran = new JuringLingkaran(jariJariLingkaran_juring, sudutJuring);
                                    System.out.println("Luas Juring Lingkaran = " + juringLingkaran.luas);
                                    System.out.println("Keliling Juring Lingkaran = " + juringLingkaran.keliling);
                                    break;
                                case 10:
                                    System.out.println("\n--- Menghitung Tembereng Lingkaran ---");
                                    System.out.print("Masukkan nilai jari-jari Lingkaran : ");
                                    double jariJariLingkaran_tembereng = input.nextDouble();
                                    
                                    System.out.print("Masukkan nilai sudut Tembereng Lingkaran : ");
                                    double sudutTembereng = input.nextDouble();
                                    
                                    TemberengLingkaran temberengLingkaran = new TemberengLingkaran(jariJariLingkaran_tembereng, sudutTembereng);
                                    System.out.println("Luas Tembereng Lingkaran = " + temberengLingkaran.luas);
                                    System.out.println("Keliling Tembereng Lingkaran = " + temberengLingkaran.keliling);
                                    break;
                                default:
                                    System.out.println("Pilihan bangun datar tidak valid.");
                            }
                            break; 
                        case 2:
                            System.out.println("=== Bangun Ruang ===");
                            System.out.println("1. Kubus"); 
                            System.out.println("2. Limas Persegi"); 
                            System.out.println("3. Prisma Persegi"); 
                            System.out.println("4. Limas Belah Ketupat");
                            System.out.println("5. Prisma Belah Ketupat"); 
                            System.out.print("Masukkan pilihan bangun ruang : ");
                            int pilihanBangunRuang = input.nextInt();

                            switch (pilihanBangunRuang) {
                                case 1:
                                    System.out.println("\n--- Menghitung Kubus ---");

                                    System.out.print("Masukkan nilai sisi kubus : ");
                                    double sisiKubus = input.nextDouble();

                                    Kubus kubus = new Kubus(sisiKubus);
                                    System.out.println("Volume Kubus = " + kubus.volume);
                                    System.out.println("Luas Permukaan Kubus = " + kubus.luasPermukaan);
                                    break;
                                case 2:
                                    System.out.println("\n--- Menghitung Limas Persegi ---");

                                    System.out.print("Masukkan nilai sisi limas persegi : ");
                                    double sisiLimasPersegi = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi limas persegi: ");
                                    double tinggiLimasPersegi = input.nextDouble();

                                    LimasPersegi limasPersegi = new LimasPersegi(sisiLimasPersegi,tinggiLimasPersegi);
                                    System.out.println("Volume LimasPersegi = " + limasPersegi.volume);
                                    System.out.println("Luas Permukaan LimasPersegi = " + limasPersegi.luasPermukaan);
                                    break;
                                case 3:
                                    System.out.println("\n--- Menghitung Prisma Persegi ---");

                                    System.out.print("Masukkan nilai sisi prisma persegi : ");
                                    double sisiPrismaPersegi = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi prisma persegi: ");
                                    double tinggiPrismaPersegi = input.nextDouble();

                                    PrismaPersegi prismaPersegi = new PrismaPersegi(sisiPrismaPersegi,tinggiPrismaPersegi);
                                    System.out.println("Volume PrismaPersegi = " + prismaPersegi.volume);
                                    System.out.println("Luas Permukaan PrismaPersegi = " + prismaPersegi.luasPermukaan);
                                    break;
                                case 4:
                                    System.out.println("\n--- Menghitung Limas Belah Ketupat ---");

                                    System.out.print("Masukkan nilai diagonal 1 limas belah ketupat : ");
                                    double diagonal1BelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai diagonal 2 limas belah ketupat : ");
                                    double diagonal2BelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi limas belah ketupat : ");
                                    double sisiBelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi limas belah ketupat : ");
                                    double tinggiBelahKetupat = input.nextDouble();

                                    LimasBelahKetupat limasBelahKetupat = new LimasBelahKetupat(diagonal1BelahKetupat, diagonal2BelahKetupat, sisiBelahKetupat, tinggiBelahKetupat);
                                    System.out.println("Volume LimasBelahKetupat = " + limasBelahKetupat.volume);
                                    System.out.println("Luas Permukaan LimasBelahKetupat = " + limasBelahKetupat.luasPermukaan);
                                    break;
                                case 5:
                                    System.out.println("\n--- Menghitung Prisma  Belah Ketupat ---");

                                    System.out.print("Masukkan nilai diagonal 1 prisma belah ketupat : ");
                                    double diagonal1BelahKetupatP = input.nextDouble();

                                    System.out.print("Masukkan nilai diagonal 2 prisma belah ketupat : ");
                                    double diagonal2BelahKetupatP = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi prisma belah ketupat : ");
                                    double sisiBelahKetupatP = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi prisma belah ketupat : ");
                                    double tinggiBelahKetupatP = input.nextDouble();

                                    PrismaBelahKetupat prismaBelahKetupat = new PrismaBelahKetupat(diagonal1BelahKetupatP, diagonal2BelahKetupatP, sisiBelahKetupatP, tinggiBelahKetupatP);
                                    System.out.println("Volume PrismaBelahKetupat = " + prismaBelahKetupat.volume);
                                    System.out.println("Luas Permukaan PrismaBelahKetupat = " + prismaBelahKetupat.luasPermukaan);
                                    break;
                                default:
                                    System.out.println("Pilihan bangun ruang tidak valid.");
                            }
                            break;
                        case 3:
                            System.out.println("=== Hitung Keseluruhan ===");
                            System.out.println("\n=== Bagun Datar ===");
                            
                            try{
                                JajarGenjang jajarGenjang = new JajarGenjang(10,7,5,6);
                                System.out.println("\n-> Jajar Genjang \nalas = 10 & tinggi = 7 & sisi A = 5 & sisi B = 6");
                                System.out.println("Luas Jajar Genjang : " + jajarGenjang.luas); 
                                System.out.println("Keliling Jajar Genjang : " + jajarGenjang.keliling);
                            } catch(Exception e){
                                System.out.println("Jajar Genjang tidak bisa dibuat dengan nilai alas dan tinggi bernilai 0 dan negatif!");
                            }
                            
                            // Belah Ketupat
                            try{
                                BelahKetupat belahKetupat = new BelahKetupat(3,4,5);
                                System.out.println("\n-> Belah Ketupat \nsisi = 3 & diagonal= 4.2");
                                System.out.println("Luas Belah Ketupat : " + belahKetupat.luas); 
                                System.out.println("Keliling Belah Ketupat : " + belahKetupat.keliling);
                            } catch(Exception e){
                                System.out.println("Belah Ketupat tidak bisa dibuat dengan nilai diagonal dan sisi yang kurang dari 0 dan negatif! ");
                            }
                            
                            // Layang-Layang
                            try{
                                LayangLayang layangLayang = new LayangLayang(20,10,12,22);
                                System.out.println("\n-> Layang-layang\ndiagonal1 = 20 & diagonal2 = 10 & sisi pendek = 12 & sisi pendek 22");
                                System.out.println("Luas Layang-layang : " + layangLayang.luas); 
                                System.out.println("Keliling Layang-layang : " + layangLayang.keliling);
                            } catch(Exception e){
                                System.out.println("Layang-layang tidak bisa dibuat dengan nilai diagonal dan sisi yang kurang dari 0 dan negatif!");
                            }
                            
                            // Persegi
                            try{
                                Persegi persegi = new Persegi(10);
                                System.out.println("\n-> Persegi\nsisi = 22");
                                System.out.println("Luas Persegi : " + persegi.luas); 
                                System.out.println("Keliling Persegi: " + persegi.keliling);
                            } catch(Exception e){
                                System.out.println("Persegi tidak bisa dibuat dengan nilai sisi yang kurang dari 0 dan negatif!");
                            }
                            
                            // Persegi Panjang
                            try{
                                PersegiPanjang persegiPanjang = new PersegiPanjang(12,10);
                                System.out.println("\n-> Persegi Panjang \npanjang= 12 & lebar = 10");
                                System.out.println("Luas Persegi Panjang : " + persegiPanjang.luas); 
                                System.out.println("Keliling Persegi Panjang: " + persegiPanjang.keliling);
                            } catch(Exception e){
                                System.out.println("Persegi Panjang tidak bisa dibuat dengan nilai panjang dan lebar yang kurang dari 0 dan negatif!");
                            }
                            
                            // Segitiga
                            try{
                                Segitiga segitiga = new Segitiga(12,10);
                                System.out.println("\n-> Segitiga \n alas= 12 & tinggi= 10");
                                System.out.println("Luas Segitiga : " + segitiga.luas); 
                                System.out.println("Keliling Segitiga: " + segitiga.keliling);
                            } catch(Exception e){
                                System.out.println("Segitiga tidak bisa dibuat dengan nilai alas dan tinggi yang kurang dari 0 dan negatif!");
                            }
                            
                            // Trapesium
                            try{
                                Trapesium trapesium = new Trapesium(10,14,8,6);
                                System.out.println("\n-> Trapesium \n alas atas = 10 & alas bawah = 14 & sisi miring = 8 & tinggi = 6");
                                System.out.println("Luas Trapesium : " + trapesium.luas); 
                                System.out.println("Keliling Trapesium : " + trapesium.keliling);
                            } catch(Exception e){
                                System.out.println("Trapesium tidak bisa dibuat dengan nilai alas atas, alas bawah, sisi miring dan  tinggi yang kurang dari 0 dan negatif!");
                            }
                            
                            // Lingkaran
                            try{
                                Lingkaran lingkaran = new Lingkaran(7);
                                System.out.println("\n-> Lingkaran \n jari-jari = 14");
                                System.out.println("Luas Lingkaran : " + lingkaran.luas); 
                                System.out.println("Keliling Lingkaran : " + lingkaran.keliling);
                            } catch(Exception e){
                                System.out.println("Lingkaran tidak bisa dibuat dengan nilai jari- jari yang kurang dari 0 dan negatif!");
                            }
                            
                            // Juring Lingkaran
                            try{
                                JuringLingkaran juring = new JuringLingkaran(7, 90);
                                System.out.println("\n-> JuringLingkaran\n jari-jari = 7 & sudut 90 derajat");
                                System.out.println("Luas JuringLingkaran: " + juring.luas); 
                                System.out.println("Keliling JuringLingkaran: " + juring.keliling);
                            } catch(Exception e){
                                System.out.println("Juring Lingkaran tidak bisa dibuat dengan nilai jari- jari  yang kurang dari 0 dan negatif!");
                            }
                            
                            // Tembereng Lingkaran
                            try{
                                TemberengLingkaran tembereng = new TemberengLingkaran(7, 90);
                                System.out.println("\n->Tembereng Lingkaran\n jari-jari = 7 & sudut 90 derajat");
                                System.out.println("Luas Tembereng Lingkaran: " + tembereng.luas); 
                                System.out.println("Keliling Tembereng Lingkaran: " + tembereng.keliling);
                            } catch(Exception e){
                                System.out.println("Tembereng Lingkaran tidak bisa dibuat dengan nilai jari- jari  yang kurang dari 0 dan negatif!");
                            }
                            break;
                        case 4:
                            System.out.println("Keluar dari program. Terima kasih!");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Harap masukkan angka sesuai pilihan.");
                    input.nextLine(); // Membersihkan buffer scanner dari input yang salah
                    pilihan = 0; // Reset pilihan agar loop berlanjut
                }
            } while (pilihan != 4);

        } // Scanner akan otomatis ditutup di sini
        System.out.println("Program telah berakhir.");
    }
}
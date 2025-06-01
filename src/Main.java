import java.util.InputMismatchException; 
import java.util.Scanner;
import projek_pbo.*;

public class Main {

   public static void main(String[] args) {
       try (Scanner input = new Scanner(System.in)) {
           int pilihan;
           do {
               System.out.println("\n=== Program Perhitungan Benda Geometri ===");
                           System.out.println("1. Segitiga (Belum)");
                           System.out.println("2. Jajar Genjang (Belum)");
                           System.out.println("3. Belah Ketupat (Belum)");
                           System.out.println("4. Persegi Panjang (Belum)");
                           System.out.println("5. Layang-Layangv (Belum)");
                           System.out.println("6. Persegi ");
                           System.out.println("7. Trapesium (Belum)");
                           System.out.println("8. Lingkaran");
                           System.out.println("9. Juring Lingkaran");
                           System.out.println("10. Tembereng Lingkaran");
                           System.out.println("11. Kubus (Belum)");
                           System.out.println("12. Limas Persegi"); 
                           System.out.println("13. Prisma Persegi"); 
                           System.out.println("14. Limas Belah Ketupat (Belum)");
                           System.out.println("15. Prisma Belah Ketupat (Belum)"); 
                           System.out.println("16. Limas Layang Layang (Belum)"); 
                           System.out.println("17. Prisma Layang Layang (Belum)"); 
                           System.out.println("18. Limas Segitiga (Belum)"); 
                           System.out.println("19. Prisma Segitiga (Belum)"); 
                           System.out.println("20. Limas Jajar Genjang (Belum)");
                           System.out.println("21. Prisma Jajar Genjang (Belum)"); 
                           System.out.println("22. Limas Trapesium (Belum)");
                           System.out.println("23. Prisma Trapesium (Belum)");
                           System.out.println("24. Balok (Belum)");
                           System.out.println("25. Limas Persegi Panjang (Belum)");
                           System.out.println("26. Prisma Persegi Panjang (Belum)");
                           System.out.println("27. Bola");
                           System.out.println("28. Cincin Bola (Belum)");
                           System.out.println("29. Juring Bola (Belum)");
                           System.out.println("30. Tembereng Bola (Belum)");
                           System.out.println("31. Kerucut (Belum)");
                           System.out.println("32. Kerucut Terpancung (Belum)");
                           System.out.println("33. Tabung");
                           System.out.println("34. Exit");
               System.out.print("Masukkan pilihan anda : ");

               try {
                   pilihan = input.nextInt();

                   switch (pilihan) {
                       case 1:

                           break; 
                       case 2:
                       

                           break;
                       case 3:
                
                           break;
                       case 4:

                           break;
                       case 5:
                           break;
                       case 6:
                           Persegi persegi = new Persegi(5);
                           System.out.printf("Luas Persegi: %.2f\n", persegi.hitungLuas());
                           System.out.printf("Keliling Persegi: %.2f\n", persegi.hitungKeliling());
                           persegi.prosesInputDanValidasi();
                           break;
                       case 7:
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
                           break;
                       case 15:
                           break;
                       case 16:
                           break;
                       case 17:
                           break;
                       case 18:
                           break;
                       case 19:
                           break;
                       case 20:
                           break;
                       case 21:
                           break;
                       case 22:
                           break;
                       case 23:
                           break;
                       case 24:
                           break;
                       case 25:
                           break;
                       case 26:
                           break;
                       case 27:
                           Bola bola = new Bola(7);
                           System.out.printf("Luas Permukaan Bola: %.2f\n", bola.hitungLuasPermukaan());
                           System.out.printf("Volume Bola: %.2f\n", bola.hitungVolume());
                           bola.prosesInputDanValidasi();
                           break;
                       case 28:
                           break;
                       case 29:
                           break;
                       case 30:
                           break;
                       case 31:
                           break;
                       case 32:
                           break;
                       case 33:
                           Tabung tabung = new Tabung(7, 10);
                           System.out.printf("Luas Permukaan Tabung: %.2f\n", tabung.hitungLuasPermukaan());
                           System.out.printf("Volume Tabung: %.2f\n", tabung.hitungVolume());
                           tabung.prosesInputDanValidasi();
                           break;
                       case 34:
                           System.out.println("Terima kasih telah menggunakan program ini.");
                           break;
                       default:
                           System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                   }
               } catch (InputMismatchException e) {
                   System.out.println("Input tidak valid. Harap masukkan angka sesuai pilihan.");
                   input.nextLine(); 
                   pilihan = 0; 
               }
           } while (pilihan != 34);
       } 
       System.out.println("Program telah berakhir.");
   }
}




      // Konsep Polimorfisme
        // Dibuat sebuah array dengan tipe BangunDatar yang merupakan super class dari package bangun datar
        // Kemudian dibuat objek baru Lingkaran dimana akan menggunakan methdod dari Lingkaran meskipun bertipe BangunDatar
    //    BangunDatar[] objekGeometri = new BangunDatar[2];
    //    objekGeometri[0] = new Lingkaran(7);
    //    System.out.printf("Luas Lingkaran: %.2f\n", objekGeometri[0].hitungLuas());
    //    System.out.printf("Keliling Lingkaran: %.2f\n", objekGeometri[0].hitungKeliling());

    //    objekGeometri[1] = new Persegi(5);
    //    System.out.printf("Luas Persegi: %.2f\n", objekGeometri[1].hitungLuas());
    //    System.out.printf("Keliling Persegi: %.2f\n", objekGeometri[1].hitungKeliling());
       
    //    Lingkaran turunanLingkaran = new JuringLingkaran(7, 90);
    //     System.out.printf("Luas Juring Lingkaran: %.2f\n", turunanLingkaran.hitungLuas());
    //     System.out.printf("Keliling Juring Lingkaran: %.2f\n", turunanLingkaran.hitungKeliling());
    //     turunanLingkaran.prosesInputDanValidasi();
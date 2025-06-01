import java.util.InputMismatchException; 
import java.util.Scanner;
import projek_pbo.*;

public class Main {

    public static void main(String[] args) {
        Lingkaran lingkaran = new Lingkaran(7);
        System.out.printf("\nLuas Lingkaran: %.2f\n", lingkaran.hitungLuas());
        System.out.printf("Keliling Lingkaran: %.2f\n", lingkaran.hitungKeliling());
        lingkaran.prosesInputDanValidasi();

        Persegi persegi = new Persegi(5);
        System.out.printf("\nLuas Persegi: %.2f\n", persegi.hitungLuas());
        System.out.printf("Keliling Persegi: %.2f\n", persegi.hitungKeliling());
        persegi.prosesInputDanValidasi();

//
//         JuringLingkaran juringLingkaran = new JuringLingkaran(lingkaran.getJariJari(), 90);
//         System.out.printf("\nLuas Juring Lingkaran: %.2f\n", juringLingkaran.hitungLuas());
//         System.out.printf("Keliling Juring Lingkaran: %.2f\n", juringLingkaran.hitungKeliling());
//         juringLingkaran.prosesInputDanValidasi();
//
//        TemberengLingkaran temberengLingkaran = new TemberengLingkaran(lingkaran.getJariJari(), 90);
//        System.out.printf("\nLuas Tembereng Lingkaran: %.2f\n", temberengLingkaran.hitungLuas());
//        System.out.printf("Keliling Tembereng Lingkaran: %.2f\n", temberengLingkaran.hitungKeliling());
//        temberengLingkaran.prosesInputDanValidasi();
//
//        Bola bola = new Bola(lingkaran.getJariJari());
//        System.out.printf("\nLuas Permukaan Bola: %.2f\n", bola.hitungLuasPermukaan());
//        System.out.printf("Volume Bola: %.2f\n", bola.hitungVolume());
//        bola.prosesInputDanValidasi();

        Tabung tabung = new Tabung(lingkaran.getJariJari(), 10);
        System.out.printf("\nLuas Permukaan Tabung: %.2f\n", tabung.hitungLuasPermukaan());
        System.out.printf("Volume Tabung: %.2f\n", tabung.hitungVolume());
        tabung.prosesInputDanValidasi();

        PrismaPersegi prisma = new PrismaPersegi(5, 10);
        System.out.printf("\nLuas Permukaan Prisma Persegi: %.2f\n", prisma.hitungLuasPermukaan());
        System.out.printf("Volume Prisma Persegi: %.2f\n", prisma.hitungVolume());
        prisma.prosesInputDanValidasi();

        System.out.println("\nProgram selesai.");
    }
}
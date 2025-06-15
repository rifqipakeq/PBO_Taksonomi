package projek_pbo;

import java.util.Scanner;
import java.util.InputMismatchException;


public class JajarGenjang extends BangunDatar {
    private double alas;
    private double tinggi;
    private double sisiA;
    private double sisiB;

    public JajarGenjang(double alas, double tinggi, double sisiA, double sisiB) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.hitungKeliling();
        this.hitungLuas();
    }

    @Override
    public double hitungKeliling() {
        this.keliling = 2 * (sisiA + sisiB);
        return keliling;
    }

    @Override
    public double hitungLuas() {
        this.luas = alas * tinggi;
        return luas;
    } 

    public double hitungLuas(double alasBaru, double tinggiBaru) {
        luas = alasBaru * tinggiBaru;
        return luas;
    }

    public double hitungKeliling(double sisiABaru, double sisiBBaru) {
        keliling = 2 * (sisiABaru + sisiBBaru);
        return keliling;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai sisi A dan B? (Y/N): ");
            String jawab = inp.nextLine();
            
            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukan alas baru: ");
                        double newAlas = inp.nextDouble();
                        System.out.print("Masukan tinggi baru: ");
                        double newTinggi = inp.nextDouble();
                        System.out.print("Masukan sisi A baru: ");
                        double newSisiA = inp.nextDouble();
                        System.out.print("Masukan sisi B baru: ");
                        double newSisiB = inp.nextDouble();
                        inp.nextLine();
                        
                        if (newAlas <= 0 || newTinggi <= 0 || newSisiA <= 0 || newSisiB <= 0) {
                            System.out.println("Alas, tinggi, sisi A, dan sisi B harus lebih dari nol.\n");
                            continue;
                        }
                        
                        alas = newAlas;
                        tinggi = newTinggi;
                        sisiA = newSisiA;
                        sisiB = newSisiB;
                        
                        luas = hitungLuas(newAlas, newTinggi);
                        keliling = hitungKeliling(newSisiA, newSisiB);
                        
                        System.out.printf("\nLuas Jajar Genjang: %.2f\n", luas);
                        System.out.printf("Keliling Jajar Genjang: %.2f\n", keliling);
                        break;
                    } catch (Exception e) {
                        System.out.println("Input tidak valid. Silakan coba lagi.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                luas = hitungLuas();
                keliling = hitungKeliling();
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    public double getAlas() {
        return alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiA(){
        return sisiA;
    }

    public double getSisiB(){
        return sisiB;
    }
}
package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PersegiPanjang extends BangunDatar {
    private double panjang;
    private double lebar;
    protected double luas;
    protected double keliling;

    public PersegiPanjang(double panjang, double lebar) {   
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
        this.luas = panjang * lebar;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        this.keliling =  2 * (panjang + lebar);   
        return keliling;
    }

    public double hitungKeliling(double panjangBaru,double lebarBaru){
        keliling = 2 * (panjangBaru + lebarBaru);
        return keliling;
    }

    public double hitungLuas(double panjangBaru, double lebarBaru) {
        luas = panjangBaru * lebarBaru;
        return luas;
    }

    public void prosesInputDanValidasi() {
        java.util.Scanner inp = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai panjang dan lebar persegi panjang? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan panjang baru: ");
                        double newPanjang = inp.nextDouble();
                        System.out.print("Masukkan lebar baru: ");
                        double newLebar = inp.nextDouble();
                        inp.nextLine();
                        if (newPanjang <= 0 || newLebar <= 0) {
                            System.out.println("Panjang dan lebar harus lebih dari nol.\n");
                            continue;
                        }
                        panjang = newPanjang;
                        lebar = newLebar;
                        luas = hitungLuas(newPanjang, newLebar);
                        keliling = hitungKeliling(newPanjang, newLebar);
                        System.out.printf("\nLuas Persegi Panjang: %.2f\n", luas);
                        System.out.printf("Keliling Persegi Panjang: %.2f\n", keliling);
                        break;
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); 
                    }
                }
            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    public double getPanjang() {
        return panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }
}

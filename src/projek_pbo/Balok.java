package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Balok extends PersegiPanjang {
    private double tinggi;
    protected double volume;
    protected double luasPermukaan;

    public Balok(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = super.luas * tinggi;
        return volume;  
    }

    public double hitungLuasPermukaan() {
        double p = super.getPanjang();
        double l = super.getLebar();
        luasPermukaan = 2 * ((p * l) + (p * tinggi) + (l * tinggi));
        return luasPermukaan;
    }

    public double hitungVolume(double panjangBaru, double lebarBaru, double tinggiBaru){
        volume = super.hitungLuas(panjangBaru,lebarBaru) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double panjangBaru, double lebarBaru, double tinggiBaru) {
        luasPermukaan = 2 * ((panjangBaru * lebarBaru) + (panjangBaru * tinggiBaru) + (lebarBaru * tinggiBaru));
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        java.util.Scanner inp = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai panjang, lebar, dan tinggi balok? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan panjang baru: ");
                        double newPanjang = inp.nextDouble();
                        System.out.print("Masukkan lebar baru: ");
                        double newLebar = inp.nextDouble();
                        System.out.print("Masukkan tinggi baru: ");
                        double newTinggi = inp.nextDouble();
                        inp.nextLine();
                        if (newPanjang <= 0 || newLebar <= 0 || newTinggi <= 0) {
                            System.out.println("Panjang, lebar, dan tinggi harus lebih dari nol.\n");
                            continue;
                        }

                        luas = hitungLuas(newPanjang, newLebar);
                        keliling = hitungKeliling(newPanjang, newLebar);
                        volume = hitungVolume(newPanjang, newLebar, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newPanjang, newLebar, newTinggi);
                        System.out.printf("\nLuas Balok: %.2f\n", luas);
                        System.out.printf("Keliling Balok: %.2f\n", keliling);
                        System.out.printf("Volume Balok: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Balok: %.2f\n", luasPermukaan);
                        break;
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }
}

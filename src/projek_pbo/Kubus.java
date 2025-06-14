package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;       

public class Kubus extends Persegi{
    private double volume;
    private double luasPermukaan;

    public Kubus(double sisi) {
        super(sisi);
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume =  super.luas * super.sisi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = super.luas * 6;
        return luasPermukaan;
    }

    public double hitungVolume(double sisiBaru) {
        volume = super.hitungLuas(sisiBaru) * sisiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double sisiBaru) {
        luasPermukaan = super.hitungLuas(sisiBaru) * 6;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai sisi kubus? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan sisi baru: ");
                        double newSisi = inp.nextDouble();
                        inp.nextLine();
                        if (newSisi <= 0) {
                            System.out.println("Sisi harus lebih dari nol.\n");
                            continue;
                        }
                        volume = hitungVolume(newSisi);
                        luasPermukaan = hitungLuasPermukaan(newSisi);
                        System.out.printf("\nVolume Kubus: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Kubus: %.2f\n", luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
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

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

}

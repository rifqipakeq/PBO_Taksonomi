package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kerucut extends Lingkaran {
    private double tinggi;
    protected double volume;
    protected double luasPermukaan;

    public Kerucut(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        double r = super.getJariJari();
        volume = (1.0 / 3.0) * super.getPI() * r * r * tinggi;
        return volume;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public double hitungLuasPermukaan() {
        double r = super.getJariJari();
        double s = Math.sqrt(r * r + tinggi * tinggi); 
        luasPermukaan = super.getPI() * r * (r + s);
        return luasPermukaan;
    }

    public double hitungVolume(double jariJariBaru, double tinggiBaru) {
        volume = (1.0 / 3.0) * super.getPI() * jariJariBaru * jariJariBaru * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double jariJariBaru, double tinggiBaru) {
        double s = Math.sqrt(jariJariBaru * jariJariBaru + tinggiBaru * tinggiBaru);
        luasPermukaan = super.getPI() * jariJariBaru * (jariJariBaru + s);
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari dan tinggi kerucut? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        System.out.print("Masukkan tinggi baru: ");
                        double newTinggi = inp.nextDouble();
                        inp.nextLine();
                        if (newJariJari <= 0 || newTinggi <= 0) {
                            System.out.println("Jari-jari dan tinggi harus lebih dari nol.\n");
                            continue;
                        }
                        volume = hitungVolume(newJariJari, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newJariJari, newTinggi);
                        System.out.printf("\nVolume Kerucut: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Kerucut: %.2f\n", luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }
}

package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemberengBola extends Bola {
    private double tinggiTembereng;
    private double volume;
    private double luasPermukaan;

    public TemberengBola(double jariJari, double tinggiTembereng) {
        super(jariJari);
        this.tinggiTembereng = tinggiTembereng;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        double r = super.getJariJari();
        double h = tinggiTembereng;
        volume = (1.0 / 6.0) * super.getPI() * h * (3 * r * r + h * h);
        return volume;
    }

    public double hitungLuasPermukaan() {
        double r = super.getJariJari();
        double h = tinggiTembereng;
        luasPermukaan = 2 * super.getPI() * r * h;
        return luasPermukaan;
    }

    public double hitungVolume(double jariJariBaru, double tinggiTemberengBaru) {
        volume = (1.0 / 6.0) * super.getPI() * tinggiTemberengBaru * (3 * jariJariBaru * jariJariBaru + tinggiTemberengBaru * tinggiTemberengBaru);
        return volume;
    }

    public double hitungLuasPermukaan(double jariJariBaru, double tinggiTemberengBaru) {
        luasPermukaan = 2 * super.getPI() * jariJariBaru * tinggiTemberengBaru;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari dan tinggi tembereng? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        inp.nextLine();
                        if (newJariJari <= 0) {
                            System.out.println("Jari-jari harus lebih dari nol.\n");
                            continue;
                        }
                        System.out.print("Masukkan tinggi tembereng baru: ");
                        double newTinggiTembereng = inp.nextDouble();
                        inp.nextLine();
                        if (newTinggiTembereng <= 0) {
                            System.out.println("Tinggi tembereng harus lebih dari nol.\n");
                            continue;
                        }
                        volume = hitungVolume(newJariJari, newTinggiTembereng);
                        luasPermukaan = hitungLuasPermukaan(newJariJari, newTinggiTembereng);

                        System.out.printf("\nVolume Tembereng Bola Baru: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Tembereng Bola Baru: %.2f\n", luasPermukaan);
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

    public double getTinggiTembereng() {
        return tinggiTembereng;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

}

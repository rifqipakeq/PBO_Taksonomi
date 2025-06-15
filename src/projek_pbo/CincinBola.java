package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CincinBola extends Bola {
    private double tinggiCincin;
    private double volume;
    private double luasPermukaan;

    public CincinBola(double jariJari, double tinggiCincin) {
        super(jariJari);
        this.tinggiCincin = tinggiCincin;
    }

    public double hitungVolume() {
        double h = tinggiCincin;
        double r = super.getJariJari();
        volume = super.getPI() * h * h * (r - h / 3.0);
        return volume;
    }

    public double hitungLuasPermukaan() {
        double h = tinggiCincin;
        double r = super.getJariJari();
        luasPermukaan = 2 * super.getPI() * r * h;
        return luasPermukaan;
    }

    public double hitungVolume(double jariJariBaru, double tinggiCincinBaru) {
        volume = super.getPI() * tinggiCincinBaru * tinggiCincinBaru * (jariJariBaru - tinggiCincinBaru / 3.0);
        return volume;
    }

    public double hitungLuasPermukaan(double jariJariBaru, double tinggiCincinBaru) {
        luasPermukaan = 2 * super.getPI() * jariJariBaru * tinggiCincinBaru;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari dan tinggi cincin? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        System.out.print("Masukkan tinggi cincin baru: ");
                        double newTinggiCincin = inp.nextDouble();
                        inp.nextLine();
                        if (newJariJari <= 0 || newTinggiCincin <= 0) {
                            System.out.println("Jari-jari dan tinggi cincin harus lebih dari nol.\n");
                            continue;
                        }
                        volume = hitungVolume(newJariJari, newTinggiCincin);
                        luasPermukaan = hitungLuasPermukaan(newJariJari, newTinggiCincin);
                        System.out.printf("\nVolume Cincin Bola: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Cincin Bola: %.2f\n", luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
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
}

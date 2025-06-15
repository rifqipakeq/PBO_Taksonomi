package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KerucutTerpancung extends Kerucut {
    private double jariJariAtas;
    private double tinggiTerpancung;

    public KerucutTerpancung(double jariJariBawah, double jariJariAtas, double tinggiTerpancung) {
        super(jariJariBawah, hitungTinggiKerucutUtuh(jariJariBawah, jariJariAtas, tinggiTerpancung));
        this.jariJariAtas = jariJariAtas;
        this.tinggiTerpancung = tinggiTerpancung;
    }

    private static double hitungTinggiKerucutUtuh(double rBawah, double rAtas, double tTerpancung) {
        return (rBawah * tTerpancung) / (rBawah - rAtas);
    }

    public double hitungVolume() {
        double r1 = super.getJariJari();
        double r2 = jariJariAtas;
        double t = tinggiTerpancung;
        return (1.0 / 3.0) * super.getPI() * t * (r1 * r1 + r1 * r2 + r2 * r2);
    }

    public double hitungLuasPermukaan() {
        double r1 = super.getJariJari();
        double r2 = jariJariAtas;
        double s = Math.sqrt(Math.pow(tinggiTerpancung, 2) + Math.pow(r1 - r2, 2));
        double selimut = super.getPI() * (r1 + r2) * s;
        double alasBawah = super.getPI() * r1 * r1;
        double alasAtas = super.getPI() * r2 * r2;
        return selimut + alasBawah + alasAtas;
    }

    public double hitungVolume(double jariJariAtasBaru, double tinggiTerpancungBaru) {
        this.jariJariAtas = jariJariAtasBaru;
        this.tinggiTerpancung = tinggiTerpancungBaru;
        return hitungVolume();
    }

    public double hitungLuasPermukaan(double jariJariAtasBaru, double tinggiTerpancungBaru) {
        this.jariJariAtas = jariJariAtasBaru;
        this.tinggiTerpancung = tinggiTerpancungBaru;
        return hitungLuasPermukaan();
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari atas dan tinggi terpancung? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari atas baru: ");
                        double newJariAtas = inp.nextDouble();
                        System.out.print("Masukkan tinggi terpancung baru: ");
                        double newTinggiTerpancung = inp.nextDouble();
                        inp.nextLine();
                        if (newJariAtas <= 0 || newTinggiTerpancung <= 0) {
                            System.out.println("Jari-jari atas dan tinggi terpancung harus lebih dari nol.\n");
                            continue;
                        }
                        double volume = hitungVolume(newJariAtas, newTinggiTerpancung);
                        double luasPermukaan = hitungLuasPermukaan(newJariAtas, newTinggiTerpancung);
                        System.out.printf("\nVolume Kerucut Terpancung: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Kerucut Terpancung: %.2f\n", luasPermukaan);
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
                System.out.println("Pilihan tidak valid. Silakan masukkan 'Y' atau 'N'.");
            }
        }
    }
}

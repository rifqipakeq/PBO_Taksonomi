package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;


public class LimasBelahKetupat extends BelahKetupat {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggi) {
        super(diagonal1, diagonal2, sisi);
        this.tinggi = tinggi;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungLuasPermukaan() {
        double luasAlas = super.luas;
        double setengahDiagonal1 = super.diagonal1 / 2.0;
        double setengahDiagonal2 = super.diagonal2 / 2.0;
        double tinggiSegitiga = Math.sqrt(tinggi * tinggi + setengahDiagonal1 * setengahDiagonal2);
        double luasSegitiga = 0.5 * super.sisi * tinggiSegitiga;
        luasPermukaan =  luasAlas + 4 * luasSegitiga;
        return luasPermukaan;
    }

    public double hitungVolume() {
        volume =  (1.0 / 3.0) * super.luas * tinggi;
        return volume;
    }

    public double hitungVolume(double diagonal1Baru, double diagonal2Baru, double tinggiBaru) {
        volume = (1.0 / 3.0) * (diagonal1Baru * diagonal2Baru) / 2 * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double diagonal1Baru, double diagonal2Baru, double tinggiBaru) {
        double luasAlas = (diagonal1Baru * diagonal2Baru) / 2;
        double setengahDiagonal1 = diagonal1Baru / 2.0;
        double setengahDiagonal2 = diagonal2Baru / 2.0;
        double tinggiSegitiga = Math.sqrt(tinggiBaru * tinggiBaru + setengahDiagonal1 * setengahDiagonal2);
        double luasSegitiga = 0.5 * super.sisi * tinggiSegitiga;
        luasPermukaan = luasAlas + 4 * luasSegitiga;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai diagonal dan tinggi? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan diagonal 1 baru: ");
                        double newDiagonal1 = inp.nextDouble();
                        System.out.print("Masukkan diagonal 2 baru: ");
                        double newDiagonal2 = inp.nextDouble();
                        System.out.print("Masukkan tinggi baru: ");
                        double newTinggi = inp.nextDouble();
                        inp.nextLine();
                        if (newDiagonal1 <= 0 || newDiagonal2 <= 0 || newTinggi <= 0) {
                            System.out.println("Diagonal dan tinggi harus lebih dari nol.\n");
                            continue;
                        }
                        diagonal1 = newDiagonal1;
                        diagonal2 = newDiagonal2;
                        tinggi = newTinggi;
                        volume = hitungVolume(newDiagonal1, newDiagonal2, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newDiagonal1, newDiagonal2, newTinggi);
                        System.out.printf("\nVolume Limas Baru: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Limas Baru: %.2f\n", luasPermukaan);
                        break; // keluar dari loop input
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // bersihkan input buffer
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                break; // keluar dari loop jika tidak ingin mengubah nilai
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
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
    public double getDiagonal1() {
        return super.diagonal1;
    }

    public double getDiagonal2() {
        return super.diagonal2;
    }
    public double getSisi() {
        return super.sisi;
    }
}
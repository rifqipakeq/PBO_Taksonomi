package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaBelahKetupat extends BelahKetupat {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public PrismaBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggi) {
        super(diagonal1, diagonal2, sisi);
        this.tinggi = tinggi;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume =  super.luas * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan =  2 * super.luas + super.keliling * tinggi;
        return luasPermukaan;
    }

    public double hitungVolume(double diagonal1Baru, double diagonal2Baru, double tinggiBaru) {
        volume = (diagonal1Baru * diagonal2Baru / 2) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double diagonal1Baru, double diagonal2Baru, double tinggiBaru) {
        double luasAlas = (diagonal1Baru * diagonal2Baru) / 2;
        double kelilingBaru = 2 * (diagonal1Baru + diagonal2Baru);
        luasPermukaan = 2 * luasAlas + kelilingBaru * tinggiBaru;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai diagonal 1, diagonal 2, dan tinggi? (Y/N): ");
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
                        inp.nextLine(); // Clear the buffer
                        
                        volume = hitungVolume(newDiagonal1, newDiagonal2, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newDiagonal1, newDiagonal2, newTinggi);
                        System.out.printf("\nVolume Prisma Baru: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Prisma Baru: %.2f\n", luasPermukaan);
                        
                        break; // Exit the loop if input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                break; // Exit the loop if user does not want to change values
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

    public double getTinggi() {
        return tinggi;
    }
    
}

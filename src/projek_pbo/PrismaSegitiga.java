package projek_pbo;

import java.util.Scanner;
import java.util.InputMismatchException;

public class PrismaSegitiga extends Segitiga {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaSegitiga(double alas, double tinggi, double tinggiPrisma) {
        super(alas, tinggi);
        this.tinggiPrisma = tinggiPrisma;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume =  super.luas * tinggiPrisma;
        return volume;  
    }

    public double hitungLuasPermukaan() {
        double kelilingAlas = super.keliling;
        double luasAlas = super.luas;
        luasPermukaan =  (2 * luasAlas) + (kelilingAlas * tinggiPrisma);
        return luasPermukaan;
    }

    public double hitungVolume(double alasBaru, double tinggiBaru, double tinggiPrismaBaru) {
        volume = (0.5 * alasBaru * tinggiBaru) * tinggiPrismaBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double alasBaru, double tinggiBaru, double tinggiPrismaBaru) {
        double kelilingAlas = 3 * alasBaru; 
        double luasAlas = 0.5 * alasBaru * tinggiBaru;
        luasPermukaan = (2 * luasAlas) + (kelilingAlas * tinggiPrismaBaru);
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai alas, tinggi, dan tinggi prisma? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan alas baru: ");
                        double newAlas = inp.nextDouble();
                        System.out.print("Masukkan tinggi baru: ");
                        double newTinggi = inp.nextDouble();
                        System.out.print("Masukkan tinggi prisma baru: ");
                        double newTinggiPrisma = inp.nextDouble();
                        inp.nextLine();
                        if (newAlas <= 0 || newTinggi <= 0 || newTinggiPrisma <= 0) {
                            System.out.println("Nilai harus lebih dari nol.\n");
                            continue;
                        }
                        super.setAlas(newAlas);
                        super.setTinggi(newTinggi);
                        tinggiPrisma = newTinggiPrisma;
                        volume = hitungVolume(newAlas, newTinggi, newTinggiPrisma);
                        luasPermukaan = hitungLuasPermukaan(newAlas, newTinggi, newTinggiPrisma);
                        System.out.printf("\nVolume Prisma Baru: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Prisma Baru: %.2f\n", luasPermukaan);
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

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

}

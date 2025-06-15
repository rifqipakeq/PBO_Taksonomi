package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaJajarGenjang extends JajarGenjang {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaJajarGenjang(double alas, double tinggiAlas, double sisiA, double sisiB, double tinggiPrisma) {
        super(alas, tinggiAlas, sisiA, sisiB);
        this.tinggiPrisma = tinggiPrisma;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume =  super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + super.keliling * tinggiPrisma;
        return luasPermukaan;
    }

    public double hitungVolume(double alasBaru, double tinggiAlasBaru, double tinggiPrismaBaru) {
        volume = alasBaru * tinggiAlasBaru * tinggiPrismaBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double alasBaru, double tinggiAlasBaru, double tinggiPrismaBaru) {
        double luasAlas = alasBaru * tinggiAlasBaru;
        double kelilingBaru = 2 * (alasBaru + tinggiAlasBaru);
        luasPermukaan = 2 * luasAlas + kelilingBaru * tinggiPrismaBaru;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai alas, tinggi alas, dan tinggi prisma? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan alas baru: ");
                        double newAlas = inp.nextDouble();
                        System.out.print("Masukkan tinggi alas baru: ");
                        double newTinggiAlas = inp.nextDouble();
                        System.out.print("Masukkan tinggi prisma baru: ");
                        double newTinggiPrisma = inp.nextDouble();
                        inp.nextLine(); // Clear the buffer

                        volume = hitungVolume(newAlas, newTinggiAlas, newTinggiPrisma);
                        luasPermukaan = hitungLuasPermukaan(newAlas, newTinggiAlas, newTinggiPrisma);

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
                System.out.println("Pilihan tidak valid. Silakan masukkan 'Y' atau 'N'.");
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

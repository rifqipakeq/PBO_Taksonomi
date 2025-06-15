package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaPersegiPanjang extends PersegiPanjang{
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        volume = super.luas * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasAlas = super.luas;
        double kelilingAlas = super.keliling;
        luasPermukaan =  2 * super.luas + super.keliling * tinggi;
        return luasPermukaan;
    }

    public double hitungVolume(double panjangBaru, double lebarBaru, double tinggiBaru) {
        volume = super.hitungLuas(panjangBaru, lebarBaru) * tinggiBaru;
        return volume;
    }
    public double hitungLuasPermukaan(double panjangBaru, double lebarBaru, double tinggiBaru) {
        luasPermukaan = 2 * super.hitungLuas(panjangBaru, lebarBaru) + super.hitungKeliling(panjangBaru, lebarBaru) * tinggiBaru;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai panjang, lebar, dan tinggi? (Y/N): ");
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
                        inp.nextLine(); // Clear the buffer
                        
                        if (newPanjang <= 0 || newLebar <= 0 || newTinggi <= 0) {
                            System.out.println("Panjang, lebar, dan tinggi harus lebih dari nol.\n");
                            continue;
                        }
                        
                        volume = hitungVolume(newPanjang, newLebar, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newPanjang, newLebar, newTinggi);
                        System.out.printf("\nVolume Prisma Baru: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Prisma Baru: %.2f\n", luasPermukaan);
                        break; // Exit the loop if input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
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
    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;

        hitungVolume();
        hitungLuasPermukaan();
}

}
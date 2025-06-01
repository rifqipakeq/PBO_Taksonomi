package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasPersegi extends Persegi {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public LimasPersegi(double sisi, double tinggi) {
        super(sisi);
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        volume =  (1.0 / 3.0) * super.luas * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double tinggiSegitiga = Math.sqrt(Math.pow((super.sisi / 2), 2) + Math.pow(tinggi, 2));
        double luasSegitiga = 0.5 * super.sisi * tinggiSegitiga;
        luasPermukaan =  super.luas + 4 * luasSegitiga;
        return luasPermukaan;
    }

    public double hitungVolume(double sisiBaru, double tinggiBaru) {
        volume = (1.0 / 3.0) * super.hitungLuas(sisiBaru) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double sisiBaru, double tinggiBaru) {
        double tinggiSegitiga = Math.sqrt(Math.pow((sisiBaru / 2), 2) + Math.pow(tinggiBaru, 2));
        double luasSegitiga = 0.5 * sisiBaru * tinggiSegitiga;
        luasPermukaan = super.hitungLuas(sisiBaru) + 4 * luasSegitiga;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai sisi limas? (Y/N): ");
            String jawab = inp.nextLine();
            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukan Sisi Baru: ");
                        double newSisi = inp.nextDouble();
                        inp.nextLine();
                        if (newSisi <= 0) {
                            System.out.println("Sisi harus lebih dari nol.\n");
                            continue;
                        }
                        System.out.print("Masukan Tinggi Baru: ");
                        double newTinggi = inp.nextDouble();
                        inp.nextLine();
                        if (newTinggi <= 0) {
                            System.out.println("Tinggi harus lebih dari nol.\n");
                            continue;
                        }
                        volume = hitungVolume(newSisi, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newSisi, newTinggi);
                        System.out.printf("\nVolume Limas Persegi: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Limas Persegi: %.2f\n", luasPermukaan);
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
}

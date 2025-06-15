package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasPersegiPanjang extends PersegiPanjang {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume =  (1.0 / 3.0) * super.luas * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double panjang = super.getPanjang();
        double lebar = super.getLebar();

        double tinggiSegitigaPanjang = Math.sqrt(Math.pow(tinggi, 2) + Math.pow(lebar / 2, 2));
        double tinggiSegitigaLebar = Math.sqrt(Math.pow(tinggi, 2) + Math.pow(panjang / 2, 2));

        double luasSisiPanjang = panjang * tinggiSegitigaPanjang;
        double luasSisiLebar = lebar * tinggiSegitigaLebar;

        luasPermukaan =  super.luas + 2 * (0.5 * luasSisiPanjang) + 2 * (0.5 * luasSisiLebar);
        return luasPermukaan;
    }

    public double hitungVolume(double panjangBaru, double lebarBaru, double tinggiBaru) {
        volume = (1.0 / 3.0) * panjangBaru * lebarBaru * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double panjangBaru, double lebarBaru, double tinggiBaru) {
        double tinggiSegitigaPanjang = Math.sqrt(Math.pow(tinggiBaru, 2) + Math.pow(lebarBaru / 2, 2));
        double tinggiSegitigaLebar = Math.sqrt(Math.pow(tinggiBaru, 2) + Math.pow(panjangBaru / 2, 2));

        double luasSisiPanjang = panjangBaru * tinggiSegitigaPanjang;
        double luasSisiLebar = lebarBaru * tinggiSegitigaLebar;

        luasPermukaan = (panjangBaru * lebarBaru) + 2 * (0.5 * luasSisiPanjang) + 2 * (0.5 * luasSisiLebar);
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
                        inp.nextLine();

                        if (newPanjang <= 0 || newLebar <= 0 || newTinggi <= 0) {
                            System.out.println("Panjang, lebar, dan tinggi harus lebih dari nol.\n");
                            continue;
                        }

                        volume = hitungVolume(newPanjang, newLebar, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newPanjang, newLebar, newTinggi);
                        System.out.printf("\nVolume Limas Baru: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Limas Baru: %.2f\n", luasPermukaan);
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

    public double getTinggi() {
        return tinggi;
    }

}

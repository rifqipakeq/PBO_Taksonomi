package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasJajarGenjang extends JajarGenjang {
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasJajarGenjang(double alas, double tinggi, double sisiA, double sisiB, double tinggiLimas) {
        super(alas, tinggi, sisiA, sisiB);
        this.tinggiLimas = tinggiLimas;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double a = super.getSisiA();
        double b = super.getSisiB();
        double tinggiSegitigaA = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow((b / 2), 2));
        double tinggiSegitigaB = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow((a / 2), 2));
        double luasSisiA = a * tinggiSegitigaA / 2;
        double luasSisiB = b * tinggiSegitigaB / 2;
        luasPermukaan =  super.luas + 2 * (luasSisiA + luasSisiB);
        return luasPermukaan;
    }

    public double hitungVolume(double alasBaru, double tinggiBaru, double tinggiLimasBaru) {
        volume = (1.0 / 3.0) * alasBaru * tinggiBaru * tinggiLimasBaru;
        return volume;
    }   

    public double hitungLuasPermukaan(double alasBaru, double tinggiBaru, double tinggiLimasBaru) {
        double a = super.getSisiA();
        double b = super.getSisiB();
        double tinggiSegitigaA = Math.sqrt(Math.pow(tinggiLimasBaru, 2) + Math.pow((b / 2), 2));
        double tinggiSegitigaB = Math.sqrt(Math.pow(tinggiLimasBaru, 2) + Math.pow((a / 2), 2));
        luasPermukaan = (alasBaru * tinggiBaru) + 2 * (a * tinggiSegitigaA / 2 + b * tinggiSegitigaB / 2);
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai alas, tinggi, dan tinggi limas? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan alas baru: ");
                        double newAlas = inp.nextDouble();
                        System.out.print("Masukkan tinggi baru: ");
                        double newTinggi = inp.nextDouble();
                        System.out.print("Masukkan tinggi limas baru: ");
                        double newTinggiLimas = inp.nextDouble();
                        inp.nextLine();
                        if (newAlas <= 0 || newTinggi <= 0 || newTinggiLimas <= 0) {
                            System.out.println("Alas, tinggi, dan tinggi limas harus lebih dari nol.\n");
                            continue;
                        }
                        volume = hitungVolume(newAlas, newTinggi, newTinggiLimas);
                        luasPermukaan = hitungLuasPermukaan(newAlas, newTinggi, newTinggiLimas);
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

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public double getAlas() {
        return super.getAlas();
    }

    public double getTinggi() {
        return super.getTinggi();
    }

    public double getSisiA() {
        return super.getSisiA();
    }

    public double getSisiB() {
        return super.getSisiB();
    }
}

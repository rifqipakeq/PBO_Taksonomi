package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasSegitiga extends Segitiga {
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasSegitiga(double alas,double tinggi, double tinggiLimas) {
        super(alas, tinggi);    
        this.tinggiLimas = tinggiLimas;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungLuasPermukaan() {
        double s = super.getSisi(); 
        luasPermukaan = 4 * ((Math.sqrt(3) / 4.0) * Math.pow(s, 2));
        return luasPermukaan;
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungVolume(double alasBaru, double tinggiBaru, double tinggiLimasBaru) {
        volume = (1.0 / 3.0) * super.hitungLuas(alasBaru, tinggiBaru) * tinggiLimasBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double alasBaru, double tinggiBaru, double tinggiLimasBaru) {
        double s = super.getSisi();
        luasPermukaan = 4 * ((Math.sqrt(3) / 4.0) * Math.pow(s, 2));
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
                        inp.nextLine(); // Clear the buffer

                        volume = hitungVolume(newAlas, newTinggi, newTinggiLimas);
                        luasPermukaan = hitungLuasPermukaan(newAlas, newTinggi, newTinggiLimas);

                        System.out.printf("\nVolume Limas Baru: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Limas Baru: %.2f\n", luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan coba lagi.");
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

}
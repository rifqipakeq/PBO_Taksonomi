package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tabung extends Lingkaran {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public Tabung(double jariJari, double tinggi) {
        super(jariJari);
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

    public double hitungVolume(double jariJariBaru, double tinggiBaru) {
        volume = super.hitungLuas(jariJariBaru) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double jariJariBaru, double tinggiBaru) {
        luasPermukaan = 2 * super.hitungLuas(jariJariBaru) + super.hitungKeliling(jariJariBaru) * tinggiBaru;
        return luasPermukaan;
    }
    
     public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari tabung? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        inp.nextLine();
                        if (newJariJari <= 0) {
                            System.out.println("Jari-jari harus lebih dari nol.\n");
                            continue;
                        }
                        System.out.print("Masukkan tinggi baru: ");
                        double newTinggi = inp.nextDouble();
                        inp.nextLine();
                        if (newTinggi <= 0) {
                            System.out.println("Tinggi harus lebih dari nol.\n");
                            continue;
                        }
                        volume = hitungVolume(newJariJari, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newJariJari, newTinggi);
                        System.out.printf("\nVolume Tabung: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Tabung: %.2f\n", luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input jari-jari harus berupa angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                volume = hitungVolume();
                luasPermukaan = hitungLuasPermukaan();
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N.\n");
            }
        }
    }
}

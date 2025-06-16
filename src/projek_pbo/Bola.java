package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bola extends Lingkaran {
    protected double volume;
    protected double luasPermukaan;

    public Bola(double jariJari) {
        super(jariJari);
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        double r = super.getJariJari();
        volume = (4.0 / 3.0) * super.luas * r;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 4 * super.luas;
        return luasPermukaan;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
    
    public double hitungVolume(double jariJariBaru) {
        volume = (4.0 / 3.0) * PI * super.hitungLuas(jariJariBaru) * jariJariBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double jariJariBaru) {
        luasPermukaan = 4 * super.hitungLuas(jariJariBaru);
        return luasPermukaan;
    }
    
     public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari bola? (Y/N): ");
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
                        volume = hitungVolume(newJariJari);
                        luasPermukaan = hitungLuasPermukaan(newJariJari);
                        System.out.printf("\nVolume Bola: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Bola: %.2f\n", luasPermukaan);
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



package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JuringBola extends Bola {
    private double sudutDerajat;
    private double volume;
    private double luasPermukaan;

    public JuringBola(double jariJari, double sudutDerajat) {
        super(jariJari);
        this.sudutDerajat = sudutDerajat;
    }

    public double hitungVolume() {
        double Vbola = super.hitungVolume();
        volume = (sudutDerajat / 360.0) * Vbola;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double Lbola = super.hitungLuasPermukaan();
        luasPermukaan = (sudutDerajat / 360.0) * Lbola;
        return luasPermukaan;
    }

    public double hitungVolume(double jariJariBaru, double sudutDerajatBaru) {
        volume = (sudutDerajatBaru / 360.0) * super.hitungVolume(jariJariBaru);
        return volume;
    }

    public double hitungLuasPermukaan(double jariJariBaru, double sudutDerajatBaru) {
        luasPermukaan = (sudutDerajatBaru / 360.0) * super.hitungLuasPermukaan(jariJariBaru);
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari dan sudut derajat? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        System.out.print("Masukkan sudut derajat baru: ");
                        double newSudutDerajat = inp.nextDouble();
                        inp.nextLine();
                        if (newJariJari <= 0 || newSudutDerajat <= 0) {
                            System.out.println("Jari-jari dan sudut derajat harus lebih dari nol.\n");
                            continue;
                        }
                        volume = hitungVolume(newJariJari, newSudutDerajat);
                        luasPermukaan = hitungLuasPermukaan(newJariJari, newSudutDerajat);
                        System.out.printf("\nVolume Juring Bola: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Juring Bola: %.2f\n", luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan 'Y' atau 'N'.");
            }
        }
    }

}

package projek_pbo;

import java.util.Scanner;
import java.util.InputMismatchException;

public class PrismaPersegi extends Persegi {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public PrismaPersegi(double sisi, double tinggi) {
        super(sisi);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = super.hitungLuas() * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.hitungLuas() + super.hitungKeliling() * tinggi;
        return luasPermukaan;
    }

    public double hitungVolume(double sisiBaru, double tinggiBaru){
        volume = super.hitungLuas(sisiBaru) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double sisiBaru, double tinggiBaru) {
        luasPermukaan = 2 * super.hitungLuas(sisiBaru) + super.hitungKeliling(sisiBaru) * tinggiBaru;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi(){
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai sisi prisma? (Y/N): ");
            String jawab = inp.nextLine();
            if (jawab.equalsIgnoreCase("Y")) {
                while (true){
                    try {
                        System.out.print("Masukan Sisi Baru : ");
                        double newSisi = inp.nextDouble();
                        inp.nextLine();
                        if (newSisi <= 0) {
                            System.out.println("Sisi harus lebih dari nol.\n");
                            continue;
                        }
                        System.out.print("Masukan Tinggi Baru : ");
                        double newTinggi = inp.nextDouble();
                        inp.nextLine();
                        if (newTinggi <= 0) {
                            System.out.println("Tinggi harus lebih dari nol.\n");
                            continue;
                        }
                        // Update nilai sisi dan tinggi pada objek
                        super.setSisi(newSisi);
                        this.tinggi = newTinggi;
                        volume = hitungVolume();
                        luasPermukaan = hitungLuasPermukaan();
                        System.out.printf("\nLuas Permukaan Prisma Persegi: %.2f\n", luasPermukaan);
                        System.out.printf("Volume Prisma Persegi: %.2f\n", volume);
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
                        inp.nextLine();
                    }
                    break;
                }
            } else if (jawab.equalsIgnoreCase("N")) {
                luasPermukaan = hitungLuasPermukaan();
                volume = hitungVolume();
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N\n");
            } 

        }
    }
    

}

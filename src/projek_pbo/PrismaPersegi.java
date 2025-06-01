package projek_pbo;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PrismaPersegi extends Persegi {
    private Persegi alas;
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public PrismaPersegi(double sisi, double tinggi) {
        super(sisi);
        this.tinggi = tinggi;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume  =  super.luas * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + super.keliling * tinggi;
        return luasPermukaan;
    }

    public double hitungVolume(double sisiBaru, double tinggiBaru){
        volume = super.hitungLuas(sisiBaru) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double sisiBaru, double tinggiBaru) {
        luasPermukaan = 2 * super.hitungLuas(sisiBari) + super.hitungKeliling(sisibaru) * tinggiBaru;
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
                        volume = hitungVolume(newSisi, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newSisi, newTinggi);
                        System.out.printf("\nLuas Permukaan Prisma Persegi: %.2f\n", luasPermukaan);
                        System.out.printf("Volume Prisma Persegi: %.2f\n", volume);
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
                        inp.nextLine();
                    }
                    break;
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

}

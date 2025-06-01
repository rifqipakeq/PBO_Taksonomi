package projek_pbo;

import java.util.*;

public class Persegi extends BangunDatar {
    protected double sisi;
    protected double luas;
    protected double keliling;

    public Persegi(double sisi) {
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
 
    @Override
    public double hitungLuas() {
        luas = sisi * sisi;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling =  4 * sisi;   
        return keliling;
    }

    public double hitungLuas(double sisiBaru){
        luas = sisiBaru * sisiBaru;
        return luas;
    }

    public double hitungKeliling(double sisiBaru){
        keliling = 4 * sisiBaru;
        return keliling;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApkah ingin mengubah nilai sisi persegi? (Y/N): ");
            String jawab = inp.nextLine();
            
            if (jawab.equalsIgnoreCase("Y")) {
                while (true){
                    try {
                        System.out.print("Masukan sisi baru:");
                        double newSisi = inp.nextDouble();
                        inp.nextLine();
                        if (newSisi <= 0) {
                            System.out.println("Sisi harus lebih dari nol.\n");
                            continue;
                        }
                        sisi = newSisi;
                        luas = hitungLuas(newSisi);
                        keliling = hitungKeliling(newSisi);
                        System.out.printf("\nLuas Persegi: %.2f\n", luas);
                        System.out.printf("Keliling Persegi: %.2f\n", keliling);
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")){
                luas = hitungLuas();
                keliling = hitungKeliling();
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N. \n");
            }
        }
    }


}                                   

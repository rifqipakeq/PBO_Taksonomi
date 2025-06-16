package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Segitiga extends BangunDatar implements Runnable {
    private double alas;
    private double tinggi;

    public Segitiga(double alas, double tinggi) {   
        this.alas = alas;
        this.tinggi = tinggi;
        this.hitungKeliling();  
        this.hitungLuas();
    }

    @Override
    public double hitungLuas() {
        this.luas = 0.5 * alas * tinggi; 
        return luas;
    }

    @Override
    public double hitungKeliling() {
        this.keliling =  3 * alas;   
        return keliling;
    }

    public double hitungLuas(double alasBaru, double tinggiBaru) {
        luas = 0.5 * alasBaru * tinggiBaru;
        return luas;
    }

    public double hitungKeliling(double alasBaru){
        keliling = 3 * alasBaru;
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
                        System.out.print("Masukan alas baru:");
                        double newAlas = inp.nextDouble();
                        System.out.print("Masukan tinggi baru:");
                        double newTinggi = inp.nextDouble();
                        inp.nextLine();
                        if (newAlas <= 0 || newTinggi <= 0) {
                            System.out.println("Alas dan tinggi harus lebih dari nol.\n");
                            continue;
                        }
                        alas = newAlas;
                        tinggi = newTinggi;
                        luas = hitungLuas(newAlas, newTinggi);
                        keliling = hitungKeliling(newAlas);
                        System.out.printf("\nLuas Segitiga: %.2f\n", luas);
                        System.out.printf("Keliling Segitiga: %.2f\n", keliling);
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


    public double getSisi(){
        return alas;
    }
    public void setSisi(double alas) {
        this.alas = alas;
        this.hitungKeliling();
        this.hitungLuas();
}
    public double getTinggi() {
        return tinggi;
    }
    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
        this.hitungKeliling();
        this.hitungLuas();
    }
    public double getLuas() {
        return luas;
    }
    public double getKeliling() {
        return keliling;
    }
    public double getAlas() {
        return alas;
    }
    public void setAlas(double alas) {
        this.alas = alas;
        this.hitungKeliling();
        this.hitungLuas();
    }
    public double getTinggiSegitiga() {
        return tinggi;
    }
    public void setTinggiSegitiga(double tinggi) {
        this.tinggi = tinggi;
        this.hitungKeliling();
        this.hitungLuas();
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("--- Thread [%s] sedang memproses objek Segitiga ---\n", threadName);
        try {
            System.out.printf("[%s] Menghitung properti Segitiga (alas: %.2f, tinggi: %.2f)...\n", threadName, this.alas, this.tinggi);
            Thread.sleep(1500);
            double luasDihitung = this.hitungLuas();
            double kelilingDihitung = this.hitungKeliling();
            System.out.printf("[%s] Hasil Segitiga -> Luas: %.2f, Keliling: %.2f\n", threadName, luasDihitung, kelilingDihitung);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Thread [%s] diinterupsi.\n", threadName);
        }
        System.out.printf("Thread [%s] selesai.\n", threadName);
    }
    
}
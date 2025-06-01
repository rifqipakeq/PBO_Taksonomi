package projek_pbo;

public class Persegi extends BangunDatar {
    protected double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
        this.hitungLuas();
        this.hitungKeliling();
    }
 
    @Override
    public double hitungLuas() {
        this.luas = sisi * sisi;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        this.keliling =  4 * sisi;   
        return keliling;
    }
}                                   

package projek_pbo;

public class PrismaSegitiga extends Segitiga {
    private double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaSegitiga(double alas, double tinggi, double tinggiPrisma) {
        super(alas, tinggi);
        this.tinggiPrisma = tinggiPrisma;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume =  super.luas * tinggiPrisma;
        return volume;  
    }

    public double hitungLuasPermukaan() {
        double kelilingAlas = super.keliling;
        double luasAlas = super.luas;
        luasPermukaan =  (2 * luasAlas) + (kelilingAlas * tinggiPrisma);
        return luasPermukaan;
    }
}

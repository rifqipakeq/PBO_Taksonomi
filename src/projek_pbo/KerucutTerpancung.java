package projekpbo.BangunRuang;

import projekpbo.BangunDatar.Lingkaran;

public class KerucutTerpancung extends Kerucut {
    private double jariJariAtas;
    private double tinggiTerpancung;

    public KerucutTerpancung(double jariJariBawah, double jariJariAtas, double tinggiTerpancung) {
        super(jariJariBawah, hitungTinggiKerucutUtuh(jariJariBawah, jariJariAtas, tinggiTerpancung));
        this.jariJariAtas = jariJariAtas;
        this.tinggiTerpancung = tinggiTerpancung;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    private static double hitungTinggiKerucutUtuh(double rBawah, double rAtas, double tTerpancung) {
        return (rBawah * tTerpancung) / (rBawah - rAtas);
    }

    @Override
    public double hitungVolume() {
        double r1 = getJariJari();
        double r2 = jariJariAtas;
        double t = tinggiTerpancung;
        return (1.0 / 3.0) * Math.PI * t * (r1 * r1 + r1 * r2 + r2 * r2);
    }

    @Override
    public double hitungLuasPermukaan() {
        double r1 = getJariJari();
        double r2 = jariJariAtas;
        double s = Math.sqrt(Math.pow(tinggiTerpancung, 2) + Math.pow(r1 - r2, 2));
        double selimut = Math.PI * (r1 + r2) * s;
        double alasBawah = Math.PI * r1 * r1;
        double alasAtas = Math.PI * r2 * r2;
        return selimut + alasBawah + alasAtas;
    }

    public double getJariJariAtas() {
        return jariJariAtas;
    }

    public double getTinggiTerpancung() {
        return tinggiTerpancung;
    }
}

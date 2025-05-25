package projek_pbo;

public class TemberengLingkaran extends Lingkaran {
    private double sudut; 

    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.hitungKeliling();
        this.hitungLuas();
    }

    @Override
    public double hitungLuas() {
        double sudutRadian = Math.toRadians(sudut);
        double luasJuring = (sudut / 360.0) * super.PI * super.jariJari * super.jariJari;
        double luasSegitiga = 0.5 * super.jariJari * super.jariJari * Math.sin(sudutRadian);
        this.luas = luasJuring - luasSegitiga;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        double sudutRadian = Math.toRadians(sudut);
        double panjangBusur = sudutRadian * super.jariJari;
        double taliBusur = 2 * super.jariJari * Math.sin(sudutRadian / 2);
        this.keliling = panjangBusur + taliBusur;
        return keliling;
    }
}

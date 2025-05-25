package projekpbo.BangunRuang;

public class CincinBola extends BangunRuang {
    private Bola bola;
    private double tinggiCincin;
    private double volume;
    private double luasPermukaan;

    public CincinBola(Bola bola, double tinggiCincin) {
        this.bola = bola;
        this.tinggiCincin = tinggiCincin;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public double hitungVolume() {
        double h = tinggiCincin;
        double r = bola.getJariJari();
        volume = Math.PI * h * h * (r - h / 3.0);
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        double h = tinggiCincin;
        double r = bola.getJariJari();
        luasPermukaan = 2 * Math.PI * r * h;
        return luasPermukaan;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
}

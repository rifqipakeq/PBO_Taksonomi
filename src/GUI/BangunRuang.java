package GUI;

import javax.swing.JOptionPane;
import projek_pbo.*;

public class BangunRuang extends javax.swing.JPanel {

    private Bola bola;
    private CincinBola cincinBola;
    private JuringBola juringBola;
    private TemberengBola temberengBola;
    private Kerucut kerucut;
    private KerucutTerpancung kerucutTerpancung;
    private Tabung tabung;
    private Kubus kubus;
    private Balok balok;
    private LimasPersegi limasPersegi;
    private PrismaPersegi prismaPersegi;
    private LimasBelahKetupat limasBelahKetupat;
    private PrismaBelahKetupat prismaBelahKetupat;
    private LimasLayangLayang limasLayangLayang;
    private PrismaLayangLayang prismaLayangLayang;
    private LimasSegitiga limasSegitiga;
    private PrismaSegitiga prismaSegitiga;
    private LimasTrapesium limasTrapesium;
    private PrismaTrapesium prismaTrapesium;
    private LimasJajarGenjang limasJajarGenjang;
    private PrismaJajarGenjang prismaJajarGenjang;
    private LimasPersegiPanjang limasPersegiPanjang;
    private PrismaPersegiPanjang prismaPersegiPanjang;
    
    
    public BangunRuang() {
        initComponents();
        inisialisasiBangunRuang();
        tambahkanListener();
    }

    private void inisialisasiBangunRuang() {
        // Inisialisasi semua bangun ruang dengan nilai default
        this.kubus = new Kubus(5.0);
        this.balok = new Balok(4.0, 6.0, 8.0);
        this.bola = new Bola(7.0);
        this.cincinBola = new CincinBola(7.0, 3.0);
        this.juringBola = new JuringBola(7.0, 45.0);
        this.temberengBola = new TemberengBola(7.0, 2.0);
        this.tabung = new Tabung(5.0, 10.0);
        this.kerucut = new Kerucut(5.0, 12.0);
        this.kerucutTerpancung = new KerucutTerpancung(5.0, 3.0, 8.0);
        this.prismaSegitiga = new PrismaSegitiga(3.0, 4.0, 5.0);
        this.limasSegitiga = new LimasSegitiga(3.0, 4.0, 5.0);
        this.limasPersegi = new LimasPersegi(6.0, 8.0);
        this.prismaPersegi = new PrismaPersegi(6.0, 10.0);
        this.limasBelahKetupat = new LimasBelahKetupat(5.0, 7.0, 8.0, 9.0);
        this.prismaBelahKetupat = new PrismaBelahKetupat(5.0, 7.0, 10.0, 9.0);
        this.limasLayangLayang = new LimasLayangLayang(5.0, 7.0, 8.0, 10.0, 12.0);
        this.prismaLayangLayang = new PrismaLayangLayang(5.0, 7.0, 8.0, 10.0, 12.0);
        this.limasTrapesium = new LimasTrapesium(5.0, 7.0, 8.0, 10.0, 12.0);
        this.prismaTrapesium = new PrismaTrapesium(5.0, 7.0, 4.0, 10.0, 12.0);
        this.limasJajarGenjang = new LimasJajarGenjang(5.0, 7.0, 8.0, 10.0, 12.0);
        this.prismaJajarGenjang = new PrismaJajarGenjang(5.0, 7.0, 10.0, 12.0, 14.0);
        this.limasPersegiPanjang = new LimasPersegiPanjang(6.0, 8.0, 10.0);
        this.prismaPersegiPanjang = new PrismaPersegiPanjang(6.0, 8.0, 12.0);
    }
    
    private void tambahkanListener() {
        // Listener untuk tombol Hitung
        btnHitung.addActionListener(e -> hitungBangunRuang());

        // Listener untuk tombol Ya (ubah nilai)
        // jButton2.addActionListener(e -> tampilkanFormUbahNilai());

        // Listener untuk tombol Tidak
        jButton3.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Perhitungan selesai", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void hitungBangunRuang() {
        String pilihan = (String) btnBangunRuang.getSelectedItem();
        if(pilihan == null || pilihan.trim().isEmpty() || pilihan.equals(" ")) {
            JOptionPane.showMessageDialog(this, "Pilih bangun ruang yang valid", "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        String hasil = "";
    
        try {
            switch (pilihan) {
                case "Kubus":
                    hasil = String.format("Volume: %.2f\nLuas Permukaan: %.2f", 
                            kubus.hitungVolume(), kubus.hitungLuasPermukaan());
                    break;
                case "Balok":
                    hasil = String.format("Volume: %.2f\nLuas Permukaan: %.2f", 
                            balok.hitungVolume(), balok.hitungLuasPermukaan());
                    break;
                case "Bola":
                    hasil = String.format("Volume: %.2f\nLuas Permukaan: %.2f", 
                            bola.hitungVolume(), bola.hitungLuasPermukaan());
                    break;
                case "Cincin Bola":
                    hasil = String.format("Volume: %.2f\nLuas Permukaan: %.2f", 
                            cincinBola.hitungVolume(), cincinBola.hitungLuasPermukaan());
                    break;
                case "Juring Bola":
                    hasil = String.format("Volume: %.2f\nLuas Permukaan: %.2f", 
                            juringBola.hitungVolume(), juringBola.hitungLuasPermukaan());
                    break;
                case "Tembereng Bola":
                    hasil = String.format("Volume: %.2f\nLuas Permukaan: %.2f", 
                            temberengBola.hitungVolume(), temberengBola.hitungLuasPermukaan());
                    break;
                case "Tabung":
                    hasil = String.format("Volume: %.2f\nLuas Permukaan: %.2f", 
                            tabung.hitungVolume(), tabung.hitungLuasPermukaan());
                    break;
                case "Kerucut":
                    hasil = String.format("Volume: %.2f\nLuas Permukaan: %.2f", 
                            kerucut.hitungVolume(), kerucut.hitungLuasPermukaan());
                    break;
                case "Kerucut Terpancung":
                    hasil = String.format("Volume: %.2f\nLuas Permukaan: %.2f", 
                            kerucutTerpancung.hitungVolume(), kerucutTerpancung.hitungLuasPermukaan());
                    break;
                // Add cases for all other shapes following the same pattern
                default:
                    hasil = "Pilih bangun ruang yang valid";
            }   
    
            HasilAwal.setText(hasil);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // private void tampilkanFormUbahNilai() {
    //     String pilihan = (String) jComboBox1.getSelectedItem();
    //     javax.swing.JTabbedPane tabbedPane = (javax.swing.JTabbedPane) this.getParent();

    //     try {
    //         switch (pilihan) {
    //             case "Kubus":
    //                 PilihKubus panelKubus = new PilihKubus();
    //                 panelKubus.setKubus(kubus);
    //                 panelKubus.sisiBaru.setText(String.valueOf(kubus.getSisi()));
    //                 tabbedPane.addTab("Ubah Kubus", panelKubus);
    //                 tabbedPane.setSelectedComponent(panelKubus);
    //                 break;
    //             case "Balok":
    //                 PilihBalok panelBalok = new PilihBalok();
    //                 panelBalok.setBalok(balok);
    //                 panelBalok.panjangBaru.setText(String.valueOf(balok.getPanjang()));
    //                 panelBalok.lebarBaru.setText(String.valueOf(balok.getLebar()));
    //                 panelBalok.tinggiBaru.setText(String.valueOf(balok.getTinggi()));
    //                 tabbedPane.addTab("Ubah Balok", panelBalok);
    //                 tabbedPane.setSelectedComponent(panelBalok);
    //                 break;
    //             case "Bola":
    //                 PilihBola panelBola = new PilihBola();
    //                 panelBola.setBola(bola);
    //                 panelBola.jariJariBaru.setText(String.valueOf(bola.getJariJari()));
    //                 tabbedPane.addTab("Ubah Bola", panelBola);
    //                 tabbedPane.setSelectedComponent(panelBola);
    //                 break;
    //             case "Tabung":
    //                 PilihTabung panelTabung = new PilihTabung();
    //                 panelTabung.setTabung(tabung);
    //                 panelTabung.jariJariBaru.setText(String.valueOf(tabung.getJariJari()));
    //                 panelTabung.tinggiBaru.setText(String.valueOf(tabung.getTinggi()));
    //                 tabbedPane.addTab("Ubah Tabung", panelTabung);
    //                 tabbedPane.setSelectedComponent(panelTabung);
    //                 break;
    //             case "Kerucut":
    //                 PilihKerucut panelKerucut = new PilihKerucut();
    //                 panelKerucut.setKerucut(kerucut);
    //                 panelKerucut.jariJariBaru.setText(String.valueOf(kerucut.getJariJari()));
    //                 panelKerucut.tinggiBaru.setText(String.valueOf(kerucut.getTinggi()));
    //                 panelKerucut.garisPelukisBaru.setText(String.valueOf(kerucut.getGarisPelukis()));
    //                 tabbedPane.addTab("Ubah Kerucut", panelKerucut);
    //                 tabbedPane.setSelectedComponent(panelKerucut);
    //                 break;
    //             default:
    //                 JOptionPane.showMessageDialog(this, "Fitur ubah nilai belum tersedia untuk " + pilihan, 
    //                         "Info", JOptionPane.INFORMATION_MESSAGE);
    //         }
    //     } catch (Exception e) {
    //         JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    //     }
    // }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        btnBangunRuang = new javax.swing.JComboBox<>();
        btnHitung = new javax.swing.JButton();
        HasilAwal = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel43.setText("Menghitung Bangun 3 Dimensi");

        jLabel44.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel44.setText("Silahkan Pilih Bangun");

        btnBangunRuang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnBangunRuang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bola", "Tabung", "Kerucut", "Kerucut Terpancung", "Kubus", "Balok", "Cincin Bola", "Juring Bola", "Tembereng Bola", "Prisma Segitiga", "Limas Segitiga", "Limas Persegi", "Prisma Persegi", "Limas Belah Ketupat", "Prisma Belah Ketupat", "Limas Layang-Layang", "Prisma Layang-Layang", "Limas Trapesium", "Prisma Trapesium", "Limas Jajar Genjang", "Prisma Jajar Genjang", "Limas Persegi Panjang", "Prisma Persegi Panjang" }));
        btnBangunRuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBangunRuangActionPerformed(evt);
            }
        });

        btnHitung.setText("Hitung");

        jLabel45.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel45.setText("Hasil Perhitungan");

        jButton2.setText("Ya");

        jLabel46.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel46.setText("Ingin Mengubah Nilai ?");

        jButton3.setText("Tidak");

        btnBack.setText("back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HasilAwal)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(18, 18, 18)
                                .addComponent(btnBangunRuang, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel43)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBangunRuang, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HasilAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Kembali ke Menu Utama?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            javax.swing.JTabbedPane tabbedPane = (javax.swing.JTabbedPane) this.getParent();
            if (tabbedPane != null) {
                tabbedPane.remove(this);
            }
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBangunRuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBangunRuangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBangunRuangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HasilAwal;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> btnBangunRuang;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    // End of variables declaration//GEN-END:variables
}

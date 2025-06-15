package GUI;

import javax.swing.*;
import projek_pbo.PersegiPanjang;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PilihPersegiPanjang extends javax.swing.JPanel {

    private PersegiPanjang persegipanjang;

    public PilihPersegiPanjang() {
        initComponents();
        this.persegipanjang = new PersegiPanjang(5, 5);
        tambahkanListener();
        btnHitung.setEnabled(false);
    }

    public void setPersegiPanjang(PersegiPanjang persegipanjang) {
        this.persegipanjang = persegipanjang;
    }

    private void tambahkanListener() {
        panjangBaru.addActionListener(e -> updateButtonState());
        panjangBaru.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }

            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }
        });

        btnHitung.addActionListener(e -> updatePerhitungan());
        btnBatal.addActionListener(e -> tutupTab());
    }

    private void updateButtonState() {
        // Aktifkan tombol hanya jika text field tidak kosong
        btnHitung.setEnabled(!panjangBaru.getText().trim().isEmpty());
    }

    private void updatePerhitungan() {
        System.out.println("[DEBUG] Status persegipanjang: " + (persegipanjang != null ? "Ada" : "Null"));
        try {
            double panjang = Double.parseDouble(panjangBaru.getText());
            double lebar = Double.parseDouble(lebarBaru.getText());
            if (panjang <= 0 || lebar <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Panjang dan lebar harus lebih dari nol",
                        "Input Tidak Valid",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            double luas = persegipanjang.hitungLuas(panjang, lebar);
            double keliling = persegipanjang.hitungKeliling(panjang, lebar);
            HasilBaru.setText(String.format("Luas: %.2f\nKeliling: %.2f", luas, keliling));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Input harus:\n- Berupa angka\n- Lebih besar dari 0",
                    "Format Salah",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void tutupTab() {
        javax.swing.JTabbedPane tabbedPane = (javax.swing.JTabbedPane) this.getParent();
        if (tabbedPane != null) {
            tabbedPane.remove(this);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panjangBaru = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        HasilBaru = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lebarBaru = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Masukkan Panjang Baru :");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Hasil :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Ubah Nilai Persegi Panjang");

        btnHitung.setText("Hitung Nilai Baru");

        btnBatal.setText("Batal");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Masukkan Lebar Baru :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBatal)
                                .addGap(26, 26, 26)
                                .addComponent(btnHitung))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(HasilBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lebarBaru)
                                        .addComponent(panjangBaru))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(panjangBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lebarBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(HasilBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung)
                    .addComponent(btnBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HasilBaru;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHitung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JTextField lebarBaru;
    public javax.swing.JTextField panjangBaru;
    // End of variables declaration//GEN-END:variables
}

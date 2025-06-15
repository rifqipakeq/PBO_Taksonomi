package GUI;

import javax.swing.*;
import projek_pbo.BelahKetupat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PilihBelahKetupat extends javax.swing.JPanel {

    private BelahKetupat belahketupat;

    public PilihBelahKetupat() {
        initComponents();
        this.belahketupat = new BelahKetupat(10, 12, 10);
        tambahkanListener();
        btnHitung.setEnabled(false);
    }

    public void setBelahKetupat(BelahKetupat belahketupat) {
        this.belahketupat = belahketupat;
    }

    private void tambahkanListener() {
        diagonal1Baru.addActionListener(e -> updateButtonState());
        diagonal1Baru.getDocument().addDocumentListener(new DocumentListener() {
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
        btnHitung.setEnabled(!diagonal1Baru.getText().trim().isEmpty());
    }

    private void updatePerhitungan() {
        System.out.println("[DEBUG] Status belahketupat: " + (belahketupat != null ? "Ada" : "Null"));
        try {
            double diagonal1 = Double.parseDouble(diagonal1Baru.getText());
            double diagonal2 = Double.parseDouble(diagonal2Baru.getText());
            if (diagonal1 <= 0 || diagonal2 <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Setiap nilai harus lebih dari nol",
                        "Input Tidak Valid",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            double luas = belahketupat.hitungLuas(diagonal1, diagonal2);
            double keliling = belahketupat.hitungKeliling(diagonal1, diagonal2);
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
        diagonal1Baru = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        HasilBaru = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        diagonal2Baru = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Masukkan Diagonal 1 Baru :");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Hasil :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Ubah Nilai Belah Ketupat");

        btnHitung.setText("Hitung Nilai Baru");

        btnBatal.setText("Batal");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Masukkan Diagonal 2 Baru :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(diagonal2Baru, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(diagonal1Baru)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(HasilBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBatal)
                                .addGap(18, 18, 18)
                                .addComponent(btnHitung)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(diagonal1Baru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diagonal2Baru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HasilBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnHitung))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HasilBaru;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHitung;
    public javax.swing.JTextField diagonal1Baru;
    public javax.swing.JTextField diagonal2Baru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}

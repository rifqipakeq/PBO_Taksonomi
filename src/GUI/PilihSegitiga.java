package GUI;

import javax.swing.JOptionPane;
import projek_pbo.Segitiga;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PilihSegitiga extends javax.swing.JPanel {

    private Segitiga segitiga;

    public PilihSegitiga() {
        initComponents();
        this.segitiga = new Segitiga(3,4);
        tambahkanListener();
        updateButtonState();
    }

    public void setSegitiga(Segitiga segitiga) {
        this.segitiga = segitiga;
    }

    private void tambahkanListener() {
        DocumentListener docListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }
            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }
        };

        tinggiBaru.getDocument().addDocumentListener(docListener);
        alasBaru.getDocument().addDocumentListener(docListener);

        btnHitung.addActionListener(e -> updatePerhitungan());
        btnBatal.addActionListener(e -> tutupTab());
    }

    private void updateButtonState() {
        btnHitung.setEnabled(!tinggiBaru.getText().trim().isEmpty() && 
                           !alasBaru.getText().trim().isEmpty());
    }

    private void updatePerhitungan() {
        try {
            double tinggi = Double.parseDouble(tinggiBaru.getText());
            double alas = Double.parseDouble(alasBaru.getText());
            
            if (alas <= 0 || tinggi <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "Alas dan tinggi harus lebih dari nol", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            double luas = segitiga.hitungLuas(alas, tinggi);
            double keliling = segitiga.hitungKeliling(alas);
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
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        tinggiBaru = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        HasilBaru = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        alasBaru = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14));
        jLabel1.setText("Masukkan tinggi Baru :");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14));
        jLabel2.setText("Hasil :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14));
        jLabel3.setText("Ubah Nilai Segitiga");

        btnHitung.setText("Hitung Nilai Baru");
        btnBatal.setText("Batal");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14));
        jLabel4.setText("Masukkan alas Baru :");

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
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tinggiBaru))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(HasilBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(alasBaru)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel3)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tinggiBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(alasBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(HasilBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung)
                    .addComponent(btnBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    // Variables declaration
    public javax.swing.JTextField alasBaru;
    private javax.swing.JTextField HasilBaru;
    public javax.swing.JTextField tinggiBaru;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHitung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
}
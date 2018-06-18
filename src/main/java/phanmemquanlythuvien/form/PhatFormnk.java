package phanmemquanlythuvien.form;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.PieChart;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.joda.time.Days;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.BanDocDao;
import phanmemquanlythuvien.dao.ChiTietMuonTraDao;
import phanmemquanlythuvien.dao.MuonTraDao;
import phanmemquanlythuvien.dao.PhatDao;
import phanmemquanlythuvien.dto.ChiTietMuonTra;
import phanmemquanlythuvien.dto.MuonTra;
import phanmemquanlythuvien.dto.Phat;
import phanmemquanlythuvien.form.validator.InputError;
import phanmemquanlythuvien.form.validator.MyValidator;
import phanmemquanlythuvien.form.validator.RequireValidator;
import phanmemquanlythuvien.qdto.QChiTietMuonTra;

public class PhatFormnk extends javax.swing.JFrame {

    Phat item;
    
    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    
    List<MyValidator> validators = new ArrayList<MyValidator>();
    
    ChiTietMuonTraDao ctMuonTra = App.ctx.getBean(ChiTietMuonTraDao.class);
    BanDocDao bandocDao = App.ctx.getBean(BanDocDao.class);
    
    DefaultListModel<ChiTietMuonTra> listModel;    
    List<ChiTietMuonTra> chiTietDaSua = new ArrayList<>();    
    
    public PhatFormnk(MuonTra tra) {
        initComponents();
        this.item = phat;
    //    this.item2Form();
        validators.add(new RequireValidator(txtMaMuonTra, "Mã phạt"));
    }

    public void item2Form(){
        if(item.getMaPhat()== null){
            deleteText();
            return;
        }

        txtNgayPhat.setText(LocalDate.now().toString());
        txtSoNgay.setText(item.getSoNgay().toString());
        txtSoTien.setText(item.getSoTien().toString());
        String banDoc = bandocDao.findById(item.getMaMT()).getTenBD();
        txtBanDoc.setText(banDoc);
    }
    
    public void form2Item(){
        
        
        item.setMaCTMT(ctMuonTra.findById(Integer.parseInt(txtMaMuonTra.getText())).getMaCTMT());
        item.setMaSach(ctMuonTra.findById(Integer.parseInt(txtMaMuonTra.getText())).getMaSach());
        item.setMaMT(Integer.parseInt(txtMaMuonTra.getText()));
        item.setSoNgay(Integer.parseInt(txtSoNgay.getText()));
        item.setNgayPhat(Date.valueOf(txtNgayPhat.getText()));
        item.setSoTien(Integer.parseInt(txtSoTien.getValue().toString()));
    }
    
    public boolean check(){
        try {
            for(MyValidator validator: validators){
                validator.run();
            }
        } catch (InputError e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.field.grabFocus();
            return false;
        }
        return true;
    }
    
    public void saveData(){
        if(!check()) return;
        form2Item();
        PhatDao phatDao = App.ctx.getBean(PhatDao.class);
        phatDao.save(item);
        // TODO show popup
        JOptionPane.showMessageDialog(this, MSG_LUU_THANH_CONG);
        dispose();
    }
    
    public void deleteText()
    {
        txtMaMuonTra.setText("");
        txtMaMuonTra.grabFocus();
        txtBanDoc.setText("");
        txtNgayPhat.setText("");
        txtSoNgay.setText("");
        txtSoTien.setText("");
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaMuonTra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgayPhat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnDatLai = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBanDoc = new javax.swing.JTextField();
        txtSoNgay = new javax.swing.JFormattedTextField();
        txtSoTien = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSach = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mã mượn trả");

        jLabel2.setText("Số ngày");

        txtMaMuonTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaMuonTraActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày phạt");

        jLabel4.setText("Số tiền");

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnDatLai.setText("Đặt lại");
        btnDatLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLaiActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên sách");

        jLabel6.setText("Tên bạn đọc");

        txtSoNgay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtSoNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNgayActionPerformed(evt);
            }
        });

        listSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDatLai, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(228, 228, 228))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1)
                            .addComponent(txtMaMuonTra)
                            .addComponent(txtNgayPhat)
                            .addComponent(txtBanDoc)
                            .addComponent(txtSoNgay)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtSoTien))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaMuonTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBanDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnDatLai))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLaiActionPerformed
        item2Form();
    }//GEN-LAST:event_btnDatLaiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
       saveData();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void txtMaMuonTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaMuonTraActionPerformed

        MuonTraDao muonTra = App.ctx.getBean(MuonTraDao.class);
        //ChiTietMuonTra chitiet = ;
     //   if(ctMuonTra.findAll().stream().filter(f -> txtMaMuonTra.getText().)){
            JOptionPane.showMessageDialog(this, "Mã mượn trả hợp lệ");
    //        txtSoNgay.grabFocus();
            List<ChiTietMuonTra> chiTietList = ctMuonTra.findAll(
                QChiTietMuonTra.ChiTietMuonTra.maMT.eq(item.getMaMT())
            );
            
            for(ChiTietMuonTra chitiet: chiTietList){
                listModel.addElement(chitiet);
            }
            listSach.setModel(listModel);            
            txtNgayPhat.setText(LocalDate.now().toString());
            txtSoNgay.setValue(item.getSoNgay());
            int mBanDoc = muonTra.findById(Integer.parseInt(txtMaMuonTra.getText())).getMaBD();
            txtBanDoc.setText(bandocDao.findById(mBanDoc).getTenBD());
        }else{
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã mượn trả");
        }
    }//GEN-LAST:event_txtMaMuonTraActionPerformed

    private void txtSoNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNgayActionPerformed
       if(txtSoNgay.getValue() != null){
            txtSoTien.setValue(((Number)txtSoNgay.getValue()).intValue()*5000);
       }
    }//GEN-LAST:event_txtSoNgayActionPerformed

    private void listSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSachMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listSachMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhatForm(new Phat()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLai;
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<ChiTietMuonTra> listSach;
    private javax.swing.JTextField txtBanDoc;
    private javax.swing.JTextField txtMaMuonTra;
    private javax.swing.JTextField txtNgayPhat;
    private javax.swing.JFormattedTextField txtSoNgay;
    private javax.swing.JFormattedTextField txtSoTien;
    // End of variables declaration//GEN-END:variables
}

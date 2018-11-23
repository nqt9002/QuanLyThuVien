/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.BanDocDao;
import phanmemquanlythuvien.dao.ChiTietMuonTraDao;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.MuonTraDao;
import phanmemquanlythuvien.dao.PhatDao;
import phanmemquanlythuvien.dao.SachDao;
import phanmemquanlythuvien.dto.Phat;
import phanmemquanlythuvien.form.validator.GreaterValidator;
import phanmemquanlythuvien.form.validator.InputError;
import phanmemquanlythuvien.form.validator.MyValidator;
import phanmemquanlythuvien.form.validator.NumberValidator;
import phanmemquanlythuvien.form.validator.RequireValidator;

/**
 *
 * @author tainguyen
 */
public class PhatForm extends javax.swing.JFrame {

    Phat item;
    
    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    
    private static final Logger LOGGER = Logger.getLogger(SachForm.class);    
    
    static BanDocDao banDocDao = App.ctx.getBean(BanDocDao.class);
    
    MuonTraDao muonTraDao = App.ctx.getBean(MuonTraDao.class);
    ChiTietMuonTraDao ctmtDao= App.ctx.getBean(ChiTietMuonTraDao.class);
    SachDao sachDao = App.ctx.getBean(SachDao.class);
    DauSachDao dauSachDao = App.ctx.getBean(DauSachDao.class);
    
    List<MyValidator> validators = new ArrayList<>();

    
    public PhatForm(Phat phat) {
        initComponents();
        this.item = phat;  
        this.item2Form();
        validators.add(new RequireValidator(txtSoTien, "Số tiền"));
        validators.add(new NumberValidator(txtSoTien, "Số tiền"));
        validators.add(new GreaterValidator(txtSoTien, "Số tiền", (item.getSoNgay()*5000)));
    }

    public final void item2Form(){
        if(item.getMaPhat() == null){
            deleteText();
            return;
        }
        
        txtBanDoc.setText(banDocDao.findById(muonTraDao.findById(item.getMaMT()).getMaBD()).getTenBD());
        txtBanDoc.setEditable(false);
        txtNgayPhat.setText(item.getNgayPhat().toString());
        txtNgayPhat.setEditable(false);
        txtSoNgayQuaHan.setText(item.getSoNgay().toString());
        txtSoNgayQuaHan.setEditable(false);
        txtSoTien.setText(item.getSoTien().toString());
        txtSoTien.grabFocus();
        txtTenSach.setText(item.getTieuDe());
        txtTenSach.setEditable(false);
    }
    
    public void form2Item(){
        // bring data from txt to obj
        item.setSoTien(Integer.parseInt(txtSoTien.getText()));
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
        txtBanDoc.setText(banDocDao.findById(muonTraDao.findById(item.getMaMT()).getMaBD()).getTenBD());
        txtBanDoc.setEditable(false);
        txtNgayPhat.setText(item.getNgayPhat().toString());
        txtNgayPhat.setEditable(false);
        txtSoNgayQuaHan.setText(item.getSoNgay().toString());
        txtSoNgayQuaHan.setEditable(false);
        txtSoTien.setText(item.getSoTien().toString());
        txtSoTien.grabFocus();
        txtTenSach.setText(item.getTieuDe());
        txtTenSach.setEditable(false);
        
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtBanDoc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNgayPhat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoNgayQuaHan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoTien = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTenSach = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(139, 157, 195));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tên bạn đọc");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên sách");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày phạt");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số ngày quá hạn");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Số tiền");

        btnLuu.setBackground(new java.awt.Color(139, 157, 195));
        btnLuu.setForeground(new java.awt.Color(0, 0, 157));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setForeground(new java.awt.Color(0, 0, 157));
        btnHuy.setText("Đặt lại");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        txtTenSach.setColumns(20);
        txtTenSach.setRows(5);
        jScrollPane1.setViewportView(txtTenSach);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBanDoc)
                    .addComponent(txtNgayPhat)
                    .addComponent(txtSoNgayQuaHan)
                    .addComponent(txtSoTien)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBanDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSoNgayQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        saveData();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        deleteText();
    }//GEN-LAST:event_btnHuyActionPerformed

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
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBanDoc;
    private javax.swing.JTextField txtNgayPhat;
    private javax.swing.JTextField txtSoNgayQuaHan;
    private javax.swing.JTextField txtSoTien;
    private javax.swing.JTextArea txtTenSach;
    // End of variables declaration//GEN-END:variables
}

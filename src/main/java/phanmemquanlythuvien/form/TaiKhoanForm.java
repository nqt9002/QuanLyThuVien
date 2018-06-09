/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.TaikhoanDao;
import phanmemquanlythuvien.dto.TaiKhoan;
import phanmemquanlythuvien.form.validator.InputError;
import phanmemquanlythuvien.form.validator.MaxValidator;
import phanmemquanlythuvien.form.validator.MyValidator;
import phanmemquanlythuvien.form.validator.RequireValidator;
import phanmemquanlythuvien.permission.ChucVu;

/**
 *
 * @author tainguyen
 */
public class TaiKhoanForm extends javax.swing.JFrame {

    TaiKhoan item;
    
    private static final Logger LOGGER = Logger.getLogger(TacGiaForm.class);

    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    
    List<MyValidator> validators = new ArrayList<MyValidator>();
    
    public TaiKhoanForm(TaiKhoan taikhoan) {
        initComponents();
        this.item = taikhoan;
        this.item2Form();
        
        cboChucVu.setModel(new DefaultComboBoxModel(ChucVu.available()));
        
        validators.add(new MaxValidator(60, txtTen, "Tên"));
        validators.add(new RequireValidator(txtTen, "Tên"));
        validators.add(new RequireValidator(txtTaiKhoan, "Tài khoản"));
        validators.add(new MaxValidator(60, txtTaiKhoan, "Tài khoản"));
        
    }
    
    public final void item2Form(){
        if(item.isNew()){
            deleteText();
            return;            
        }
        txtTen.setText(item.getTen());
        txtTaiKhoan.setText(item.getTaiKhoan());
        cbxKichHoat.setSelected(item.getTrangThai());
    }
    
    public void form2Item(){
        // bring data from txt to obj
        item.setTen(txtTen.getText());
        item.setTaiKhoan(txtTaiKhoan.getText());
        item.setTrangThai(cbxKichHoat.isSelected());
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
        TaikhoanDao tgD = App.ctx.getBean(TaikhoanDao.class);
//        tgD.save(item);
        // TODO show popup
        JOptionPane.showMessageDialog(this, MSG_LUU_THANH_CONG);
        dispose();
    }
    
    public void deleteText()
    {
        txtTen.setText("");
        txtTen.grabFocus();
        txtTaiKhoan.setText("");
        cbxKichHoat.setSelected(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnDatLai = new javax.swing.JButton();
        cbxKichHoat = new javax.swing.JCheckBox();
        cboChucVu = new javax.swing.JComboBox<>();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnMatKhau = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnMaBaoMat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setText("Tên");

        jLabel13.setText("Tài khoản");

        jLabel14.setText("Chức vụ");

        jLabel1.setText("Trạng thái");

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

        cbxKichHoat.setText("Kích hoạt");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Mật khẩu");

        btnMatKhau.setText("Đổi mật khẩu");

        jLabel3.setText("Mã bảo mật");

        btnMaBaoMat.setText("Đổi mã bảo mật");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMaBaoMat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addComponent(cboChucVu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTaiKhoan)
                            .addComponent(txtTen)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLuu)
                                        .addGap(1, 1, 1)
                                        .addComponent(btnDatLai))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxKichHoat)))
                                .addGap(0, 151, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaBaoMat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxKichHoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnDatLai))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnDatLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLaiActionPerformed
        item2Form();
    }//GEN-LAST:event_btnDatLaiActionPerformed

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
            java.util.logging.Logger.getLogger(TaiKhoanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaiKhoanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaiKhoanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaiKhoanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaiKhoanForm(new TaiKhoan()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLai;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnMaBaoMat;
    private javax.swing.JButton btnMatKhau;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JCheckBox cbxKichHoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}

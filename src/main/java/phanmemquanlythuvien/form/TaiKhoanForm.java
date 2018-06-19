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
import phanmemquanlythuvien.form.validator.MinValidator;
import phanmemquanlythuvien.form.validator.MyValidator;
import phanmemquanlythuvien.form.validator.RequireValidator;
import phanmemquanlythuvien.enums.ChucVu;
import phanmemquanlythuvien.form.validator.NumberValidator;
import phanmemquanlythuvien.form.validator.UniqueValidator;
import phanmemquanlythuvien.qdto.QTaiKhoan;

/**
 *
 * @author tainguyen
 */
public class TaiKhoanForm extends javax.swing.JFrame {

    TaiKhoan item;
    
    private static final Logger LOGGER = Logger.getLogger(TacGiaForm.class);

    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    
    List<MyValidator> validators = new ArrayList<>();
    List<MyValidator> createValidators = new ArrayList<>();
    
    DefaultComboBoxModel<String> cboModel = new DefaultComboBoxModel<>();
    
    public TaiKhoanForm(TaiKhoan taikhoan) {
        initComponents();
        this.item = taikhoan;
        cboChucVu.setModel(new DefaultComboBoxModel(ChucVu.available()));
        this.item2Form();
        validators.add(new MaxValidator(40, txtMatKhau, "Mật khẩu"));
        validators.add(new MinValidator(6, txtMatKhau, "Mật khẩu")); 
        validators.add(new MaxValidator(40, txtMaBaoMat, "Mã bảo mật"));
        validators.add(new MinValidator(6, txtMaBaoMat, "Mã bảo mật")); 
        validators.add(new NumberValidator(txtMaBaoMat, "Mã bảo mật"));
        validators.add(new MaxValidator(60, txtTen, "Tên"));
        validators.add(new RequireValidator(txtTen, "Tên"));
        validators.add(new RequireValidator(txtTaiKhoan, "Tài khoản"));
        validators.add(new MaxValidator(60, txtTaiKhoan, "Tài khoản"));
        TaikhoanDao tkD = App.ctx.getBean(TaikhoanDao.class);
        validators.add(new UniqueValidator(txtTaiKhoan, "tài khoản", tkD, QTaiKhoan.TaiKhoan.taiKhoan));
        
        createValidators.add(new RequireValidator(txtMatKhau, "Mật khẩu"));
        createValidators.add(new RequireValidator(txtMaBaoMat, "Mã bảo mật"));
        
    }
    
    public final void item2Form(){
        if(item.isNew()){
            deleteText();
            return;            
        }
        txtTen.setText(item.getTen());
        txtTaiKhoan.setText(item.getTaiKhoan());
        cboChucVu.setSelectedItem(item.getChucVu());
        cbxKichHoat.setSelected(item.getTrangThai());
    }
    
    public void form2Item(){
        // bring data from txt to obj
        item.setTen(txtTen.getText());
        item.setTaiKhoan(txtTaiKhoan.getText());
        item.setTrangThai(cbxKichHoat.isSelected());
        item.setChucVu((ChucVu)cboChucVu.getSelectedItem());
        if(txtMatKhau.getText().length() > 0){
            item.setMatKhau(txtMatKhau.getText());
        }
        if(txtMaBaoMat.getText().length() > 0){
            item.setMaBaoMat(txtMaBaoMat.getText());
        }
    }
    
    public boolean check(){
        try {
            for(MyValidator validator: validators){
                validator.run();
            }
            
            if(item.isNew()){
                for(MyValidator validator: createValidators){
                    validator.run();
                }
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
        tgD.save(item);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnDatLai = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        cbxKichHoat = new javax.swing.JCheckBox();
        cboChucVu = new javax.swing.JComboBox<>();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        txtMaBaoMat = new javax.swing.JPasswordField();
        cbxMatKhau = new javax.swing.JCheckBox();
        cbxMaBaoMat = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(139, 157, 195));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tên");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tài khoản");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Chức vụ");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trạng thái");

        btnDatLai.setBackground(new java.awt.Color(139, 157, 195));
        btnDatLai.setForeground(new java.awt.Color(0, 0, 157));
        btnDatLai.setText("Đặt lại");
        btnDatLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLaiActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(139, 157, 195));
        btnLuu.setForeground(new java.awt.Color(0, 0, 157));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        cbxKichHoat.setForeground(new java.awt.Color(255, 255, 255));
        cbxKichHoat.setText("Kích hoạt");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý","Thủ kho","Thủ thư" }));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mật khẩu");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã bảo mật");

        cbxMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        cbxMatKhau.setText("Hiện mật khẩu");
        cbxMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMatKhauActionPerformed(evt);
            }
        });

        cbxMaBaoMat.setForeground(new java.awt.Color(255, 255, 255));
        cbxMaBaoMat.setText("Hiện mã bảo mật");
        cbxMaBaoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMaBaoMatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMatKhau)
                        .addComponent(txtTaiKhoan)
                        .addComponent(txtTen)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnLuu)
                                    .addGap(1, 1, 1)
                                    .addComponent(btnDatLai))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxKichHoat)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(txtMaBaoMat)
                        .addComponent(jLabel2)
                        .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMatKhau)
                        .addComponent(jLabel3)
                        .addComponent(cbxMaBaoMat))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
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
                    .addGap(9, 9, 9)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cbxMatKhau)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtMaBaoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cbxMaBaoMat)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbxKichHoat))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLuu)
                        .addComponent(btnDatLai))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void cbxMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMatKhauActionPerformed
        // TODO add your handling code here:
        if(cbxMatKhau.isSelected()){
            txtMatKhau.setEchoChar((char) 0);
        } else {
            txtMatKhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cbxMatKhauActionPerformed

    private void cbxMaBaoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMaBaoMatActionPerformed
        // TODO add your handling code here:
        if(cbxMaBaoMat.isSelected()){
            txtMaBaoMat.setEchoChar((char)0);
        } else{
            txtMaBaoMat.setEchoChar('*');
        }
    }//GEN-LAST:event_cbxMaBaoMatActionPerformed

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
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JCheckBox cbxKichHoat;
    private javax.swing.JCheckBox cbxMaBaoMat;
    private javax.swing.JCheckBox cbxMatKhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtMaBaoMat;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}

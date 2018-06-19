/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.NxbDao;
import phanmemquanlythuvien.dto.Nxb;
import phanmemquanlythuvien.form.validator.InputError;
import phanmemquanlythuvien.form.validator.MaxValidator;
import phanmemquanlythuvien.form.validator.MyValidator;
import phanmemquanlythuvien.form.validator.RequireValidator;
import phanmemquanlythuvien.form.validator.UniqueValidator;
import phanmemquanlythuvien.qdto.QNxb;

/**
 *
 * @author tainguyen
 */
public class NXBForm extends javax.swing.JFrame {

    Nxb item;
    
    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    
    List<MyValidator> validators = new ArrayList<MyValidator>();
    
    public NXBForm(Nxb nxb) {
        initComponents();
        this.item = nxb;
        this.item2Form();
        
        NxbDao nxbDao = App.ctx.getBean(NxbDao.class);
        validators.add(new MaxValidator(60, txtTen, "Tên"));
        validators.add(new RequireValidator(txtTen, "Tên"));
        validators.add(new UniqueValidator(txtTen, "tên nxb", nxbDao, QNxb.nxb.tenNXB));
    }

    public void item2Form(){
        if(item.getMaNXB() == null){
            deleteText();
            return;
        }

        txtTen.setText(item.getTenNXB());
        cbxKichHoat.setSelected(item.getTrangThai());
        
    }
    
    public void form2Item(){
        // bring data from txt to obj
        item.setTenNXB(txtTen.getText());
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
        NxbDao cdD = App.ctx.getBean(NxbDao.class);
        cdD.save(item);
        // TODO show popup
        JOptionPane.showMessageDialog(this, MSG_LUU_THANH_CONG);
        dispose();
    }
    
    public void deleteText()
    {
        txtTen.setText("");
        txtTen.grabFocus();
        cbxKichHoat.setSelected(true);
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnDatLai = new javax.swing.JButton();
        cbxKichHoat = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(139, 157, 195));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tên NXB");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trạng thái");

        btnLuu.setBackground(new java.awt.Color(139, 157, 195));
        btnLuu.setForeground(new java.awt.Color(0, 0, 157));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnDatLai.setBackground(new java.awt.Color(139, 157, 195));
        btnDatLai.setForeground(new java.awt.Color(0, 0, 157));
        btnDatLai.setText("Đặt lại");
        btnDatLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLaiActionPerformed(evt);
            }
        });

        cbxKichHoat.setForeground(new java.awt.Color(255, 255, 255));
        cbxKichHoat.setText("Kích hoạt");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbxKichHoat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLuu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDatLai)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxKichHoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnDatLai))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(NXBForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NXBForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NXBForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NXBForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NXBForm(new Nxb()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLai;
    private javax.swing.JButton btnLuu;
    private javax.swing.JCheckBox cbxKichHoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}

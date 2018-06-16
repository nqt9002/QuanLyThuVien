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
import phanmemquanlythuvien.dao.ChuDeDao;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.NxbDao;
import phanmemquanlythuvien.dao.SachDao;
import phanmemquanlythuvien.dao.TacgiaDao;
import phanmemquanlythuvien.dto.DauSach;
import phanmemquanlythuvien.dto.Sach;
import phanmemquanlythuvien.enums.TrangThaiSach;
import phanmemquanlythuvien.form.validator.GreaterValidator;
import phanmemquanlythuvien.form.validator.InputError;
import phanmemquanlythuvien.form.validator.MyValidator;
import phanmemquanlythuvien.form.validator.NumberValidator;
import phanmemquanlythuvien.form.validator.RequireValidator;

/**
 *
 * @author tainguyen
 */
public class SachForm extends javax.swing.JFrame {

    public Sach item = new Sach();
    
    static SachForm instanceSach;
 
    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    
    private static final Logger LOGGER = Logger.getLogger(SachForm.class);    
    
    List<MyValidator> validators = new ArrayList<MyValidator>();
    static DauSachDao dausachDao = App.ctx.getBean(DauSachDao.class);
    DefaultComboBoxModel<DauSach> cboModel = new DefaultComboBoxModel<>();    
    
    public SachForm() {
        initComponents();

        validators.add(new RequireValidator(txtSoLuong, "Số lượng"));
        validators.add(new NumberValidator(txtSoLuong, "Số lượng"));
        validators.add(new GreaterValidator(txtSoLuong, "Số lượng"));
        cboDauSach();
    }
    
    public static SachForm getInstance(){
        if(instanceSach == null)
            instanceSach = new SachForm();
        
        instanceSach.setVisible(true);
        return instanceSach;
    }

    public void setItem(Sach sach){
        item = sach;
        item2Form();
    }
    
    public final void cboDauSach(){
        dausachDao.findAll().stream().forEach(dausach -> {
            cboModel.addElement(dausach);
        });
    }

    public final void item2Form(){
        if(item.getMaSach() == null){
            deleteText();
            return;
        }
        cboDauSach.setSelectedItem(dausachDao.getTenDauSach(item.getMaDS()));
        cboTrangThai.setSelectedItem(item.getTrangThaiEnum());

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
    
    public Object[] data2Array(Sach item){
        return new Object[]{
            item.getMaSach(),
            dausachDao.getTenDauSach(item.getMaDS()),
            item.getTrangThaiEnum()
        };
    }    
    
    public void saveData(){
        if(!check()) return; 
        SachDao sD = App.ctx.getBean(SachDao.class);
        ChuDeDao chudeDao = App.ctx.getBean(ChuDeDao.class);
        TacgiaDao tacgiaDao = App.ctx.getBean(TacgiaDao.class);
        NxbDao nxbDao = App.ctx.getBean(NxbDao.class);
        DauSach dauSach = (DauSach) cboDauSach.getSelectedItem();
        int i = Integer.parseInt(txtSoLuong.getText());
        
        for(int j = 0; j < i;j++){
            Sach sach = new Sach();
            sach.setMaDS(dauSach.getMaDS());
            sach.setTieuDe(dauSach.getTen() 
                    +" - "+chudeDao.getTenChuDe(dauSach.getMaCD())
                    +" - "+tacgiaDao.getTenTacGia(dauSach.getMaTG())
                    +" - "+nxbDao.getTenNXB(dauSach.getMaNXB()));
            sach.setTrangThai((TrangThaiSach) cboTrangThai.getSelectedItem());
            sD.save(sach);
        }

        dauSach.setSoLuong(sD.countDS(dauSach.getMaDS()));
        dausachDao.save(dauSach); 
                
        JOptionPane.showMessageDialog(this, MSG_LUU_THANH_CONG);
        dispose();
    }
    
    public void deleteText()
    {
        txtSoLuong.setText("1");
        txtSoLuong.grabFocus();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnDatLai = new javax.swing.JButton();
        cboDauSach = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        cboTrangThai = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setText("Tên đầu sách");

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

        cboDauSach.setModel(cboModel);

        jLabel2.setText("Số lượng");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new TrangThaiSach[] { TrangThaiSach.SAN_SANG, TrangThaiSach.KHOA }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong)
                            .addComponent(cboDauSach, 0, 243, Short.MAX_VALUE)
                            .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLuu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDatLai)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cboDauSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnDatLai)))
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
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SachForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLai;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<DauSach> cboDauSach;
    private javax.swing.JComboBox<TrangThaiSach> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}

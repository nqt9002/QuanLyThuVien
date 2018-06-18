/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.ChuDeDao;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.NxbDao;
import phanmemquanlythuvien.dao.TacgiaDao;
import phanmemquanlythuvien.dto.ChuDe;
import phanmemquanlythuvien.dto.DauSach;
import phanmemquanlythuvien.dto.Nxb;
import phanmemquanlythuvien.dto.TacGia;
import phanmemquanlythuvien.form.validator.InputError;
import phanmemquanlythuvien.form.validator.MaxValidator;
import phanmemquanlythuvien.form.validator.MyValidator;
import phanmemquanlythuvien.form.validator.NumberValidator;
import phanmemquanlythuvien.form.validator.RequireValidator;
import phanmemquanlythuvien.form.validator.UniqueValidator;
import phanmemquanlythuvien.qdto.QDauSach;

/**
 *
 * @author tainguyen
 */
public class DauSachForm extends javax.swing.JFrame {

    DauSach item;
    
    private static final Logger LOGGER = Logger.getLogger(TacGiaForm.class);
    
    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    
    List<MyValidator> validators = new ArrayList<>();
    
    TacgiaDao tacgiaDao = App.ctx.getBean(TacgiaDao.class);
    NxbDao nxbDao = App.ctx.getBean(NxbDao.class);
    ChuDeDao chudeDao = App.ctx.getBean(ChuDeDao.class); 
    
    DefaultComboBoxModel<TacGia> cboTacGiaModel = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<ChuDe> cboChuDeModel = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<Nxb> cboNXBModel = new DefaultComboBoxModel<>();
    
    public DauSachForm(DauSach dausach) {
        initComponents();
        
        buildComboBox();
        
        this.item = dausach;
        DauSachDao dauSachDao = App.ctx.getBean(DauSachDao.class);
        validators.add(new MaxValidator(60, txtTenDauSach, "Tên đầu sách"));
        validators.add(new RequireValidator(txtTenDauSach, "Tên đầu sách"));
        validators.add(new UniqueValidator(txtTenDauSach, "tên đầu sách", dauSachDao, QDauSach.DauSach.ten));
        validators.add(new RequireValidator(txtLanTaiBan, "Lần tái bản"));
        validators.add(new NumberValidator(txtLanTaiBan, "Lần tái bản"));
        validators.add(new MaxValidator(1000, txtTomTat, "Tóm tắt nội dung"));
        validators.add(new RequireValidator(txtTomTat, "Tóm tắt nội dung"));
        
        this.item2Form();
    }   
    
    public final void buildComboBox(){
        tacgiaDao.findAll().stream().filter(tg -> tg.getTrangThai() == true).forEach(tacgia -> {
            cboTacGiaModel.addElement(tacgia);
        });
        
        nxbDao.findAll().stream().filter(nxb -> nxb.getTrangThai() == true).forEach(nxb -> {
            cboNXBModel.addElement(nxb);
        });
        
        chudeDao.findAll().stream().filter(cd ->cd.getTrangThai() == true).forEach(chude -> {
            cboChuDeModel.addElement(chude);
        });
    }
    
    public void item2Form(){
        if(item.getMaDS()== null){
            deleteText();
            return;
        }

        txtTenDauSach.setText(item.getTen());
        
        for(int i = 0; i < cboChuDeModel.getSize();i++){
            if(Objects.equals(cboChuDeModel.getElementAt(i).getMaCD(), item.getMaCD()))
                cboChuDe.setSelectedIndex(i);
        }
        
        for(int i = 0; i < cboTacGiaModel.getSize();i++){
            if(Objects.equals(cboTacGiaModel.getElementAt(i).getMaTG(), item.getMaCD()))
                cboTacGia.setSelectedIndex(i);
        }
        
        for(int i = 0; i < cboNXBModel.getSize();i++){
            if(Objects.equals(cboNXBModel.getElementAt(i).getMaNXB(), item.getMaCD()))
                cboNXB.setSelectedIndex(i);
        }
        
        
//        cboTacGia.setSelectedItem(tacgiaDao.getTenTacGia(item.getMaTG()));
//        cboNXB.setSelectedItem(nxbDao.getTenNXB(item.getMaNXB()));
//        cboChuDe.setSelectedItem(chudeDao.getTenChuDe(item.getMaCD()));
        txtSoLuong.setText(item.getSoLuong().toString());
        txtSoLuong.setEnabled(false);
        txtLanTaiBan.setText(item.getLanTaiBan().toString());
        txtTomTat.setText(item.getTtnd());
        cbxTrangThai.setSelected(item.getTrangThai());
    }
    
    public void form2Item(){
        // bring data from txt to obj
        item.setTen(txtTenDauSach.getText());
        item.setMaTG(((TacGia) cboTacGia.getSelectedItem()).getMaTG());
        item.setMaNXB(((Nxb) cboNXB.getSelectedItem()).getMaNXB());
        item.setMaCD(((ChuDe) cboChuDe.getSelectedItem()).getMaCD());
        item.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        item.setLanTaiBan(Integer.parseInt(txtLanTaiBan.getText()));
        item.setTtnd(txtTomTat.getText());
        item.setTrangThai(cbxTrangThai.isSelected());
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
        DauSachDao dsD = App.ctx.getBean(DauSachDao.class);
        dsD.save(item);
        // TODO show popup
        JOptionPane.showMessageDialog(this, MSG_LUU_THANH_CONG);
        dispose();
    }
    
    public void deleteText()
    {
        txtTenDauSach.setText("");
        txtTenDauSach.grabFocus();
        txtTomTat.setText("");
        txtLanTaiBan.setText("");
        txtSoLuong.setText("0");
        txtSoLuong.setEnabled(false);
        cbxTrangThai.setSelected(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtTomTat = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtTenDauSach = new javax.swing.JTextField();
        txtLanTaiBan = new javax.swing.JTextField();
        cboTacGia = new javax.swing.JComboBox<TacGia>();
        cboNXB = new javax.swing.JComboBox<Nxb>();
        cboChuDe = new javax.swing.JComboBox<ChuDe>();
        btnLuu = new javax.swing.JButton();
        btnDatLai = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxTrangThai = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel21.setText("Tóm tắt nội dung");

        txtTomTat.setColumns(20);
        txtTomTat.setRows(5);
        jScrollPane6.setViewportView(txtTomTat);

        jLabel22.setText("Chủ đề");

        jLabel23.setText("Tác giả");

        jLabel24.setText("NXB");

        jLabel25.setText("Tên đầu sách");

        jLabel26.setText("Số lượng");

        jLabel27.setText("Lần tái bản");

        cboTacGia.setModel(cboTacGiaModel);

        cboNXB.setModel(cboNXBModel);

        cboChuDe.setModel(cboChuDeModel);

        btnLuu.setBackground(new java.awt.Color(139, 157, 195));
        btnLuu.setForeground(new java.awt.Color(0, 0, 157));
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

        jLabel1.setText("Trạng thái");

        cbxTrangThai.setText("Kích hoạt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtLanTaiBan, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cboTacGia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboNXB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboChuDe, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTenDauSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24)
                    .addComponent(jLabel22)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDatLai, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTrangThai)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenDauSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboChuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLanTaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxTrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnDatLai))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
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
            java.util.logging.Logger.getLogger(DauSachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DauSachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DauSachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DauSachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DauSachForm(new DauSach()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLai;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<ChuDe> cboChuDe;
    private javax.swing.JComboBox<Nxb> cboNXB;
    private javax.swing.JComboBox<TacGia> cboTacGia;
    private javax.swing.JCheckBox cbxTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField txtLanTaiBan;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenDauSach;
    private javax.swing.JTextArea txtTomTat;
    // End of variables declaration//GEN-END:variables
}

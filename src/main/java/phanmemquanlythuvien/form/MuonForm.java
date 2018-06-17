/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.BanDocDao;
import phanmemquanlythuvien.dao.ChiTietMuonTraDao;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.MuonTraDao;
import phanmemquanlythuvien.dao.SachDao;
import phanmemquanlythuvien.dto.BanDoc;
import phanmemquanlythuvien.dto.ChiTietMuonTra;
import phanmemquanlythuvien.dto.MuonTra;
import phanmemquanlythuvien.dto.Sach;
import phanmemquanlythuvien.enums.TrangThaiSach;
import phanmemquanlythuvien.form.validator.InputError;
import phanmemquanlythuvien.form.validator.MyValidator;

/**
 *
 * @author tainguyen
 */
public class MuonForm extends javax.swing.JFrame {

    MuonTra item;
 
    static MuonForm instance;
    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    
    private static final Logger LOGGER = Logger.getLogger(SachForm.class);    
    
    List<MyValidator> validators = new ArrayList<>();
    
    static BanDocDao bandocDao = App.ctx.getBean(BanDocDao.class);
    
    MuonTraDao muontraDao = App.ctx.getBean(MuonTraDao.class);
    ChiTietMuonTraDao ctmtDao= App.ctx.getBean(ChiTietMuonTraDao.class);
    SachDao sachDao = App.ctx.getBean(SachDao.class);
    DauSachDao dausachDao = App.ctx.getBean(DauSachDao.class);    
    
    DefaultListModel<Sach> listModel = new DefaultListModel<>();
    int idBanDoc;
    
    public MuonForm(MuonTra muon) {
        initComponents();
        this.item = muon;  
        listSach.setModel(listModel);
    }
    
    public static MuonForm getInstance(){
        if (instance == null){
            instance = new MuonForm(new MuonTra());
        }
        return instance;
    }
    
    public void setBanDoc(BanDoc bandoc){
        txtBanDoc.setText(bandoc.toString());
        txtBanDoc.setEditable(false);
        txtNgayMuon.setText(LocalDate.now().toString());
        txtNgayMuon.setEditable(false);
        idBanDoc = bandoc.getMaBD();
    }
    
    public void addSach(Sach sach){
        for(int i = 0; i < listModel.getSize(); i++){
            if(Objects.equals(listModel.getElementAt(i).getMaSach(), sach.getMaSach()))
                return;
        }
        listModel.addElement(sach);
        txtNgayMuon.setText(LocalDate.now().toString());
        txtNgayMuon.setEditable(false);
        txtNgayPhaiTra.setText(LocalDate.now().plusDays(7).toString());
    }
    
    public void removeSach(){
        int index = listSach.getSelectedIndex();
        if(index >= 0){
            listModel.removeElementAt(index);
        }
    }

    
    public void form2Item(){
        item.setMaBD(idBanDoc);
        item.setNgayMuon(Date.valueOf(txtNgayMuon.getText()));
        item.setNgayPhaiTra(Date.valueOf(txtNgayPhaiTra.getText()));
        item.setTongSoMuon(listModel.size());
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
        muontraDao.save(item);
        int size = listSach.getModel().getSize();
        
        Set<Integer> idSachChoMuon = new HashSet<>();
        Set<Integer> idDauSachChoMuon = new HashSet<>();
        
        for(int i = 0;i<size;i++){
            Sach sach = listSach.getModel().getElementAt(i);
            idSachChoMuon.add(sach.getMaSach());
            idDauSachChoMuon.add(sach.getMaDS());
                        
            ChiTietMuonTra chitiet = new ChiTietMuonTra();
            chitiet.setMaMT(item.getMaMT());
            chitiet.setMaSach(sach.getMaSach());
            chitiet.setTieuDe(sach.getTieuDe());
            ctmtDao.save(chitiet);
        }
        
        // O(2*n) => O(1)
        sachDao.doiTrangThai(idSachChoMuon, TrangThaiSach.CHO_MUON);
        
        // 3*O(n) => 2*O(logn)
        for(int maDauSach: idDauSachChoMuon){
            int soluong = (int)(sachDao.countDS(maDauSach, TrangThaiSach.SAN_SANG.ordinal()));
            dausachDao.updateSoLuong(maDauSach, soluong);  
        }

        JOptionPane.showMessageDialog(this, MSG_LUU_THANH_CONG);
        item = new MuonTra();
        // resetForm();
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSach = new javax.swing.JList<>();
        btnMuonSach = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtBanDoc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgayPhaiTra = new javax.swing.JTextField();

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        listSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSach);

        btnMuonSach.setText("Mượn sách");
        btnMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonSachActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel12.setText("Tên bạn đọc");

        jLabel1.setText("Tên Sách");

        jLabel2.setText("Ngày mượn");

        jLabel3.setText("Ngày phải trả");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBanDoc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNgayMuon)
                    .addComponent(txtNgayPhaiTra)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMuonSach)
                    .addComponent(btnHuy))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonSachActionPerformed
        saveData();
    }//GEN-LAST:event_btnMuonSachActionPerformed

    private void listSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSachMouseClicked
        if(evt.getClickCount() == 2){
            removeSach();
        }
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
            java.util.logging.Logger.getLogger(MuonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MuonForm(new MuonTra()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnMuonSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Sach> listSach;
    private javax.swing.JTextField txtBanDoc;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtNgayPhaiTra;
    // End of variables declaration//GEN-END:variables
}

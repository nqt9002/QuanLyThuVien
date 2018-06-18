/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.BanDocDao;
import phanmemquanlythuvien.dao.ChiTietMuonTraDao;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.MuonTraDao;
import phanmemquanlythuvien.dao.SachDao;
import phanmemquanlythuvien.dto.ChiTietMuonTra;
import phanmemquanlythuvien.dto.DauSach;
import phanmemquanlythuvien.dto.MuonTra;
import phanmemquanlythuvien.dto.Sach;
import phanmemquanlythuvien.enums.TrangThaiSach;
import phanmemquanlythuvien.form.validator.DateValidator;
import phanmemquanlythuvien.form.validator.InputError;
import phanmemquanlythuvien.form.validator.MyValidator;
import phanmemquanlythuvien.form.validator.RequireValidator;
import phanmemquanlythuvien.qdto.QChiTietMuonTra;

/**
 *
 * @author tainguyen
 */
public class PhatForm extends javax.swing.JFrame {

    MuonTra item;
    
    List<ChiTietMuonTra> allCTMT;
    
    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    
    private static final Logger LOGGER = Logger.getLogger(SachForm.class);    
    
    List<MyValidator> validators = new ArrayList<>();
    
    static BanDocDao bandocDao = App.ctx.getBean(BanDocDao.class);
    
    MuonTraDao muontraDao = App.ctx.getBean(MuonTraDao.class);
    ChiTietMuonTraDao ctmtDao= App.ctx.getBean(ChiTietMuonTraDao.class);
    SachDao sachDao = App.ctx.getBean(SachDao.class);
    DauSachDao dausachDao = App.ctx.getBean(DauSachDao.class);   
        
    DefaultListModel<ChiTietMuonTra> listModel;    
    List<ChiTietMuonTra> chiTietDaSua = new ArrayList<>();
    
    public PhatForm(MuonTra tra) {
        initComponents();
        this.item = tra;  
        listModel = new DefaultListModel();
        this.item2Form();
        
        validators.add(new RequireValidator(txtNgayTra, "Ngày trả"));
        validators.add(new DateValidator(txtNgayTra, "Ngày trả"));
    }
    
    
    public void item2Form(){
        if(item.getMaMT() == null){
            return;
        }
        
        List<ChiTietMuonTra> chiTietList = ctmtDao.findAll(
            QChiTietMuonTra.ChiTietMuonTra.maMT.eq(item.getMaMT())
        );
        
        for(ChiTietMuonTra chitiet: chiTietList){
            listModel.addElement(chitiet);
            LOGGER.info(chitiet.getNgayTra() == null);
        }
        
        txtBanDoc.setText(bandocDao.getTenBanDoc(item.getMaBD()));
     //   txtNgayMuon.setText(item.getNgayMuon().toString());
        listSach.setModel(listModel);
        txtNgayPhaiTra.setText(item.getNgayPhaiTra().toString());
        txtNgayTra.setText(LocalDate.now().toString());
        txtBanDoc.setEditable(false);
     //   txtNgayMuon.setEditable(false);
        txtNgayPhaiTra.setEditable(false);
    }
    
    public void traSach(){
        int index = listSach.getSelectedIndex();
        if(index >= 0){
            ChiTietMuonTra chitiet = listModel.getElementAt(index);
            if(!chitiet.isDaTra()){
                chitiet.setNgayTra(Date.valueOf(LocalDate.now()));
                listSach.setModel(listModel);
                chiTietDaSua.add(chitiet);
            }
                
        }
    }    
    
    public void form2Item(){
        item.traThemSach(chiTietDaSua.size());
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
        for(ChiTietMuonTra chitiet: chiTietDaSua){
            ctmtDao.save(chitiet);
            Sach sach = sachDao.findById(chitiet.getMaSach());
            sach.setTrangThai(TrangThaiSach.SAN_SANG);
            sachDao.save(sach);
            DauSach dauSach = dausachDao.findById(sach.getMaDS());
            int soluong = sachDao.countDS(dauSach.getMaDS());
            dauSach.setSoLuong(soluong);
            dausachDao.save(dauSach);       
        }
        JOptionPane.showMessageDialog(this, MSG_LUU_THANH_CONG);
        item = new MuonTra();
        dispose();
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSach = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        txtBanDoc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNgayPhaiTra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoNgayQuaHan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoTien = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        listSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSach);

        jLabel12.setText("Tên bạn đọc");

        jLabel1.setText("Tên Sách");

        jLabel3.setText("Ngày phải trả");

        jLabel4.setText("Ngày trả");

        jLabel5.setText("Số ngày quá hạn");

        jLabel6.setText("Số tiền");

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBanDoc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNgayPhaiTra)
                    .addComponent(txtNgayTra)
                    .addComponent(txtSoNgayQuaHan)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtSoTien)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSachMouseClicked
        if(evt.getClickCount() == 2){
            traSach();
        }
    }//GEN-LAST:event_listSachMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        saveData();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        dispose();
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
                new PhatForm(new MuonTra()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<ChiTietMuonTra> listSach;
    private javax.swing.JTextField txtBanDoc;
    private javax.swing.JTextField txtNgayPhaiTra;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtSoNgayQuaHan;
    private javax.swing.JTextField txtSoTien;
    // End of variables declaration//GEN-END:variables
}

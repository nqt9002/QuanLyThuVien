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
import phanmemquanlythuvien.dao.BanDocDao;
import phanmemquanlythuvien.dao.ChiTietMuonTraDao;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.MuonTraDao;
import phanmemquanlythuvien.dao.PhatDao;
import phanmemquanlythuvien.dao.SachDao;
import phanmemquanlythuvien.dto.ChiTietMuonTra;
import phanmemquanlythuvien.dto.DauSach;
import phanmemquanlythuvien.dto.MuonTra;
import phanmemquanlythuvien.dto.Phat;
import phanmemquanlythuvien.dto.Sach;
import phanmemquanlythuvien.enums.TrangThaiSach;
import phanmemquanlythuvien.form.validator.DateValidator;
import phanmemquanlythuvien.form.validator.InputError;
import phanmemquanlythuvien.form.validator.MyValidator;
import phanmemquanlythuvien.form.validator.RequireValidator;
import phanmemquanlythuvien.qdto.QChiTietMuonTra;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.enums.Quyen;


/**
 *
 * @author tainguyen
 */
public class TraForm extends javax.swing.JFrame {

    MuonTra item;
    
    List<ChiTietMuonTra> allCTMT;
    
    static final String MSG_LUU_THANH_CONG = "Lưu thành công.";
    static final String MSG_KIEM_TRA_NGAY = "Ngày trả không được nhỏ hơn ngày mượn.";
    static final String MSG_KIEM_TRA_NGAY_HIEN_TAI = "Ngày trả không được lớn hơn ngày hiện tại.";
    
    private static final Logger LOGGER = Logger.getLogger(SachForm.class);    
    
    List<MyValidator> validators = new ArrayList<>();
    
    static BanDocDao bandocDao = App.ctx.getBean(BanDocDao.class);
    
    MuonTraDao muontraDao = App.ctx.getBean(MuonTraDao.class);
    ChiTietMuonTraDao ctmtDao= App.ctx.getBean(ChiTietMuonTraDao.class);
    SachDao sachDao = App.ctx.getBean(SachDao.class);
    DauSachDao dausachDao = App.ctx.getBean(DauSachDao.class); 
    PhatDao phatDao = App.ctx.getBean(PhatDao.class);
        
    DefaultListModel<ChiTietMuonTra> listModel;    
    List<ChiTietMuonTra> chiTietDaSua = new ArrayList<>();
    
    public TraForm(MuonTra tra) {
        initComponents();
        this.item = tra;  
        listModel = new DefaultListModel();
        this.item2Form();
        
        validators.add(new RequireValidator(txtNgayTra, "Ngày trả"));
        validators.add(new DateValidator(txtNgayTra, "Ngày trả"));
        btnMuonSach.setVisible(Quyen.MUON.kiemTra(App.activeUser));
        btnHuy.setVisible(Quyen.MUON.kiemTra(App.activeUser));
    }
    
    public final void item2Form(){
        if(item.getMaMT() == null){
            return;
        }
        
        List<ChiTietMuonTra> chiTietList = ctmtDao.findAll(
            QChiTietMuonTra.ChiTietMuonTra.maMT.eq(item.getMaMT())
        );
        
        for(ChiTietMuonTra chitiet: chiTietList){
            listModel.addElement(chitiet);
        }
        
        txtBanDoc.setText(bandocDao.getTenBanDoc(item.getMaBD()));
        txtNgayMuon.setText(item.getNgayMuon().toString());
        listSach.setModel(listModel);
        txtNgayPhaiTra.setText(item.getNgayPhaiTra().toString());
        txtNgayTra.setText(Date.valueOf(LocalDate.now()).toString());
        txtBanDoc.setEditable(false);
        txtNgayMuon.setEditable(false);
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
    
    public static long daysBetween(Date d1, Date d2){
        return (int) ((d1.getTime() - d2.getTime())/86400000);
    }
    
    public boolean checkDate(){
        for(ChiTietMuonTra chitiet: chiTietDaSua){
            long soNgay = daysBetween(Date.valueOf(txtNgayTra.getText()),item.getNgayMuon());
            if(soNgay < 0){
                JOptionPane.showMessageDialog(this, MSG_KIEM_TRA_NGAY);
                return false;
            }
            else{
                long soNgay2 = daysBetween(Date.valueOf(LocalDate.now()),Date.valueOf(txtNgayTra.getText()));
                if(soNgay2 < 0){
                    JOptionPane.showMessageDialog(this, MSG_KIEM_TRA_NGAY_HIEN_TAI);
                    return false;
                }
            }
        }
        return true;
    }
    
    public void saveData(){
        if(!check()) return;
        if(checkDate() == false) return;
        form2Item();
        muontraDao.save(item);
        for(ChiTietMuonTra chitiet: chiTietDaSua){
            ctmtDao.save(chitiet);
            if(Date.valueOf(txtNgayTra.getText()).compareTo(item.getNgayPhaiTra()) > 0 ){
                Phat phat = new Phat();
                phat.setMaMT(chitiet.getMaMT());
                phat.setMaCTMT(chitiet.getMaCTMT());
                phat.setMaSach(chitiet.getMaSach());
                phat.setTieuDe(chitiet.getTieuDe());
                phat.setMaDauSach(sachDao.findById(chitiet.getMaSach()).getMaDS());
                long soNgay = daysBetween(Date.valueOf(txtNgayTra.getText()),item.getNgayPhaiTra());
                phat.setSoNgay((int)(soNgay));
                phat.setNgayPhat(Date.valueOf(txtNgayTra.getText()));
                phat.setSoTien(((int)(soNgay))*5000);
                phatDao.save(phat);
            }
            
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
        btnMuonSach = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtBanDoc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgayPhaiTra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(139, 157, 195));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        listSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSach);

        btnMuonSach.setForeground(new java.awt.Color(0, 0, 157));
        btnMuonSach.setText("Trả sách");
        btnMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonSachActionPerformed(evt);
            }
        });

        btnHuy.setForeground(new java.awt.Color(0, 0, 157));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tên bạn đọc");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên Sách");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ngày mượn");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ngày phải trả");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày trả");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBanDoc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(txtNgayMuon)
                    .addComponent(txtNgayPhaiTra)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNgayTra))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMuonSach)
                    .addComponent(btnHuy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonSachActionPerformed
        saveData();
    }//GEN-LAST:event_btnMuonSachActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void listSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSachMouseClicked
        if(evt.getClickCount() == 2){
            traSach();
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
            java.util.logging.Logger.getLogger(TraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TraForm(new MuonTra()).setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<ChiTietMuonTra> listSach;
    private javax.swing.JTextField txtBanDoc;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtNgayPhaiTra;
    private javax.swing.JTextField txtNgayTra;
    // End of variables declaration//GEN-END:variables
}

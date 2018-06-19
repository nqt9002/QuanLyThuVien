/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.chitiet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.ChuDeDao;
import phanmemquanlythuvien.dao.NxbDao;
import phanmemquanlythuvien.dao.TacgiaDao;
import phanmemquanlythuvien.dto.ChuDe;
import phanmemquanlythuvien.dto.DauSach;
import phanmemquanlythuvien.dto.Nxb;
import phanmemquanlythuvien.dto.TacGia;
import phanmemquanlythuvien.form.TacGiaForm;
import phanmemquanlythuvien.form.validator.MyValidator;
/**
 *
 * @author tainguyen
 */
public class DauSachCT extends javax.swing.JFrame {

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
    
    public DauSachCT(DauSach dausach) {
        initComponents();
        
        this.item = dausach;
        this.item2Form();
    }   
    
    
    public void item2Form(){
        if(item.getMaDS()== null){
            return;
        }

        txtTenDauSach.setText(item.getTen());
        txtTenDauSach.setEditable(false);
        txtTacGia.setText(tacgiaDao.findById(item.getMaTG()).getTen());
        txtTacGia.setEditable(false);
        txtNXB.setText(nxbDao.findById(item.getMaNXB()).getTenNXB());
        txtNXB.setEditable(false);
        txtChuDe.setText(chudeDao.findById(item.getMaCD()).getTenChuDe());
        txtChuDe.setEditable(false);
        txtSoLuong.setText(item.getSoLuong().toString());
        txtSoLuong.setEditable(false);
        txtLanTaiBan.setText(item.getLanTaiBan().toString());
        txtLanTaiBan.setEditable(false);
        txtTomTat.setText(item.getTtnd());
        txtTomTat.setEditable(false);
        cbxTrangThai.setSelected(item.getTrangThai());
        cbxTrangThai.setEnabled(false);
       
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTenDauSach = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtNXB = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtChuDe = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtLanTaiBan = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtTomTat = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        cbxTrangThai = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(139, 157, 195));

        jPanel1.setBackground(new java.awt.Color(139, 157, 195));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Tên đầu sách");

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Tác giả");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("NXB");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Chủ đề");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Số lượng");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Lần tái bản");

        jScrollPane6.setBackground(new java.awt.Color(139, 157, 195));

        txtTomTat.setColumns(20);
        txtTomTat.setRows(5);
        jScrollPane6.setViewportView(txtTomTat);

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Tóm tắt nội dung");

        cbxTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        cbxTrangThai.setText("Kích hoạt");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trạng thái");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLanTaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNXB, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenDauSach)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel24)
                            .addComponent(jLabel22)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(txtChuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTrangThai)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenDauSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLanTaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTrangThai)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DauSachCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DauSachCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DauSachCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DauSachCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DauSachCT(new DauSach()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbxTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField txtChuDe;
    private javax.swing.JTextField txtLanTaiBan;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenDauSach;
    private javax.swing.JTextArea txtTomTat;
    // End of variables declaration//GEN-END:variables
}

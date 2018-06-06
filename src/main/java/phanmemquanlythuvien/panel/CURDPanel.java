/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.panel;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import phanmemquanlythuvien.QuanLyMaBaoMat;
import phanmemquanlythuvien.QuanLyMatKhau;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.TaikhoanDao;
import phanmemquanlythuvien.dto.TaiKhoan;

/**
 *
 * @author tainguyen
 */
public class CURDPanel extends CommonViewImpl implements CommonView{
    // permission
    static {
        quyenThem = TaiKhoan.Quyen.THEM_TAI_KHOAN;
        quyenXem = TaiKhoan.Quyen.XEM_TAI_KHOAN;
    }
    
    static TaikhoanDao tkDao = App.ctx.getBean(TaikhoanDao.class);
    
    static final HashMap<TaiKhoan.ChucVu, String> CHUC2TEXT = new HashMap();
    
    List<TaiKhoan> danhSachTaiKhoan;
    
    static {
        CHUC2TEXT.put(TaiKhoan.ChucVu.THU_THU, "Thủ Thư");
        CHUC2TEXT.put(TaiKhoan.ChucVu.THU_KHO, "Thủ Kho");
        CHUC2TEXT.put(TaiKhoan.ChucVu.QUAN_LY, "Quản Lý");
    }
    
    Vector header, data,row;
    DefaultTableModel taikhoanModel;
    DefaultComboBoxModel chucvuModel;
    Hashtable htTenChucVu,htMaChucVu;
    static String matkhau, mabaomat;
    String temp,ten,chucvu,sql,taikhoan;
    int dong,mataikhoan,machucvu;
    
    /**
     * Creates new form TaiKhoanPanel
     */
    public CURDPanel() {
        initComponents();
        
        chucvuModel = new DefaultComboBoxModel();
        htTenChucVu = new Hashtable();
        htMaChucVu = new Hashtable();
        taikhoanModel = new DefaultTableModel();
        prepareTable();
        data = new Vector();
        showCBOChucVu();
        showRecord();
        taikhoanModel.setDataVector(data, header);
        mainTable.setModel(taikhoanModel);
        hideColumQLTK();
//        setButtonOnOff(false);
        toggleActionButton();
        setSecureButtonOnOff(false);
        setTextOnOff(false);
        deleteText();
    }
    
    public void prepareTable(){
        header = new Vector();
        header.add("Mã tài khoản");
        header.add("Tên");
        header.add("Chức vụ");
        header.add("Tài khoản");
        header.add("Mã tài khoản");
        header.add("Mã bảo mật");
    }
    
    public void showCBOChucVu()
    {
        CHUC2TEXT.forEach((chucVu, chucVuText) -> {
            chucvuModel.addElement(chucVuText);
            htTenChucVu.put(chucVuText, chucVu);
            htMaChucVu.put(chucVu, chucVuText);
        });
        
        cboChucVuQLTK.setModel(chucvuModel);
    }
    
    public void hideColumQLTK()
    {
       //hide chuc vu
       mainTable.getColumnModel().getColumn(2).setMaxWidth(0);
       mainTable.getColumnModel().getColumn(2).setMinWidth(0);
       mainTable.getColumnModel().getColumn(2).setWidth(0);
       mainTable.getColumnModel().getColumn(2).setPreferredWidth(0);
       //hide Tai Khoan
       mainTable.getColumnModel().getColumn(3).setMaxWidth(0);
       mainTable.getColumnModel().getColumn(3).setMinWidth(0);
       mainTable.getColumnModel().getColumn(3).setWidth(0);
       mainTable.getColumnModel().getColumn(3).setPreferredWidth(0);       
       //hide mat khau
       mainTable.getColumnModel().getColumn(4).setMaxWidth(0);
       mainTable.getColumnModel().getColumn(4).setMinWidth(0);
       mainTable.getColumnModel().getColumn(4).setWidth(0);
       mainTable.getColumnModel().getColumn(4).setPreferredWidth(0);       
       //hide ma bao mat
       mainTable.getColumnModel().getColumn(5).setMaxWidth(0);
       mainTable.getColumnModel().getColumn(5).setMinWidth(0);
       mainTable.getColumnModel().getColumn(5).setWidth(0);
       mainTable.getColumnModel().getColumn(5).setPreferredWidth(0);       
    }
    
    public void setButtonOnOff(boolean check)
    {
        btnSuaQLTK.setEnabled(check);
        btnXoaQLTK.setEnabled(check);
    }
    
    public void toggleActionButton(){
        btnThemQLTK.setEnabled(canWrite());
        btnSuaQLTK.setEnabled(canWrite());
        btnXoaQLTK.setEnabled(canWrite());
    }
    
    public void setSecureButtonOnOff(boolean check)
    {
        btnDoiMatKhau.setEnabled(check);
        btnDoiMaBaoMat.setEnabled(check);
    }
    
    public void setTextOnOff(boolean check)
    {
        txtMaTaiKhoanQLTK.setEditable(check);
        txtTenQLTK.setEditable(check);
        txtTaiKhoanQLTK.setEditable(check);
    }
    
    public void deleteText()
    {
        txtTimQLTK.setText("");
        txtMaTaiKhoanQLTK.setText("");
        txtTenQLTK.setText("");
        txtTaiKhoanQLTK.setText("");
        cboChucVuQLTK.setSelectedIndex(0);
    }
    
    public Vector dataToVector(TaiKhoan item){
        // place holder method
        return new Vector();
    }
    
    public void loadData(){
        danhSachTaiKhoan = tkDao.findAll();
    }
    
    public void showRecord()
    {
        loadData();
        
        danhSachTaiKhoan.stream()
            .map(consumer -> dataToVector(consumer))
            .forEach(item -> data.add(item));
        
        taikhoanModel.setDataVector(data, header);
        updateMainTable();
    }
    
    protected void updateMainTable(){
        mainTable.setModel(taikhoanModel);
    }
    
    public void setSecureNullOnOff(boolean check)
    {
        matkhau = null;
        mabaomat = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtTimQLTK = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboChucVuQLTK = new javax.swing.JComboBox<>();
        txtMaTaiKhoanQLTK = new javax.swing.JTextField();
        txtTenQLTK = new javax.swing.JTextField();
        txtTaiKhoanQLTK = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        btnDoiMatKhau = new javax.swing.JButton();
        btnDoiMaBaoMat = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btnThemQLTK = new javax.swing.JButton();
        btnSuaQLTK = new javax.swing.JButton();
        btnXoaQLTK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Quản lý tài khoản");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setPreferredSize(new java.awt.Dimension(321, 532));

        jButton1.setText("Tim");

        jLabel2.setText("Mã tài khoản");

        jLabel3.setText("Tên");

        jLabel4.setText("Chức vụ");

        jLabel5.setText("Tài khoản");

        jLabel6.setText("Mật khẩu");

        cboChucVuQLTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel50.setText("Mã bảo mật");

        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        btnDoiMaBaoMat.setText("Đổi mã bảo mật");
        btnDoiMaBaoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMaBaoMatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtTimQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel50))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDoiMaBaoMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaTaiKhoanQLTK)
                            .addComponent(txtTenQLTK)
                            .addComponent(cboChucVuQLTK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTaiKhoanQLTK)
                            .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaTaiKhoanQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboChucVuQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTaiKhoanQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnDoiMatKhau))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(btnDoiMaBaoMat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThemQLTK.setText("Thêm");
        btnThemQLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemQLTKActionPerformed(evt);
            }
        });

        btnSuaQLTK.setText("Sửa");
        btnSuaQLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaQLTKActionPerformed(evt);
            }
        });

        btnXoaQLTK.setText("Xóa");
        btnXoaQLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaQLTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemQLTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSuaQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnThemQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuaQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaQLTK, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        mainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mainTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 140, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        QuanLyMatKhau QLMK = new QuanLyMatKhau();
        QLMK.setVisible(true);
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnDoiMaBaoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMaBaoMatActionPerformed
        QuanLyMaBaoMat QLMBM = new QuanLyMaBaoMat();
        QLMBM.setVisible(true);
    }//GEN-LAST:event_btnDoiMaBaoMatActionPerformed

    private void btnThemQLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemQLTKActionPerformed
        if(!canWrite()) return;
            

//        if(btnThemQLTK.getText().equalsIgnoreCase("Thêm"))
//        {
//            deleteText();
//            setTextOnOff(true);
//            txtMaTaiKhoanQLTK.setEditable(false);
//            txtTenQLTK.grabFocus();
//            setButtonOnOff(false);
//            setSecureButtonOnOff(true);
//            btnThemQLTK.setText("Lưu");
//            btnDoiMatKhau.setText("Thêm mật khẩu");
//            btnDoiMaBaoMat.setText("Thêm mã bảo mật");
//            setSecureNullOnOff(true);
//        }
//        else
//        {
//            ten = txtTenQLTK.getText();
//            if(ten.isEmpty())
//            {
//                JOptionPane.showMessageDialog(this, "Tên tài khoản không được để trống.");
//                txtTenQLTK.grabFocus();
//                return;
//            }
//            taikhoan = txtTaiKhoanQLTK.getText();
//            if(taikhoan.isEmpty())
//            {
//                JOptionPane.showMessageDialog(this, "Tài khoản không được để trống.");
//                txtTaiKhoanQLTK.grabFocus();
//                return;
//            }
//
//            if(matkhau == null)
//            {
//                JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống.");
//                btnDoiMatKhau.doClick();
//                return;
//            }
//            if(mabaomat == null)
//            {
//                JOptionPane.showMessageDialog(this, "Mã bảo mật không được để trống.");
//                btnDoiMaBaoMat.doClick();
//                return;
//            }
//
//            chucvu = (String)cboChucVuQLTK.getSelectedItem();
//            machucvu = (int)htTenChucVu.get(chucvu);
//            try {
//                sql = "insert into TaiKhoan values(N'"+ten+"',"+machucvu+",N'"+taikhoan+"',N'"+matkhau+"',N'"+mabaomat+"')";
//                stmt.executeUpdate(sql);
//                JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công.");
//            }
//            catch(SQLException e)
//            {
//                JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại. Vui lòng thử lại.");
//                txtTaiKhoanQLTK.setText("");
//                txtTaiKhoanQLTK.grabFocus();
//                return;
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//            taikhoanModel.setRowCount(0);
//            showRecord();
//            deleteText();
//            setTextOnOff(false);
//            setButtonOnOff(false);
//            setSecureButtonOnOff(false);
//            btnThemQLTK.setText("Thêm");
//            btnDoiMatKhau.setText("Đổi mật khẩu");
//            btnDoiMaBaoMat.setText("Đổi mã bảo mật");
//        }
    }//GEN-LAST:event_btnThemQLTKActionPerformed

    private void btnSuaQLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaQLTKActionPerformed
//        if(btnSuaQLTK.getText().equalsIgnoreCase("Sửa"))
//        {
//            setTextOnOff(true);
//            txtMaTaiKhoanQLTK.setEditable(false);
//            btnSuaQLTK.setText("Lưu");
//            setSecureButtonOnOff(true);
//            dong = tblQLTK.getSelectedRow();
//            mataikhoan = Integer.parseInt(txtMaTaiKhoanQLTK.getText());
//            matkhau = (String)taikhoanModel.getValueAt(dong, 4);
//            mabaomat = (String)taikhoanModel.getValueAt(dong, 5);
//        }
//        else
//        {
//            try {
//                ten = txtTenQLTK.getText();
//                chucvu = (String)cboChucVuQLTK.getSelectedItem();
//                machucvu = (int)htTenChucVu.get(chucvu);
//                taikhoan = txtTaiKhoanQLTK.getText();
//                if(ten.isEmpty())
//                {
//                    JOptionPane.showMessageDialog(this, "Tên tài khoản không được để trống.");
//                    txtTenQLTK.grabFocus();
//                    return;
//                }
//
//                if(taikhoan.isEmpty())
//                {
//                    JOptionPane.showMessageDialog(this, "Tài khoản không được để trống.");
//                    txtTaiKhoanQLTK.grabFocus();
//                    return;
//                }
//
//                sql = "update TaiKhoan set Ten = N'"+ten+"',MaChucVu = "+machucvu+",TaiKhoan = N'"+taikhoan+"',MatKhau = N'"+matkhau+"',MaBaoMat = N'"+mabaomat+"' where MaTaiKhoan = "+mataikhoan+"";
//                stmt.executeUpdate(sql);
//                JOptionPane.showMessageDialog(this, "Lưu thay đổi thành công.");
//            }
//            catch (SQLException e)
//            {
//                JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tài. Vui lòng thử lại.");
//                txtTaiKhoanQLTK.setText("");
//                txtTaiKhoanQLTK.grabFocus();
//                return;
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//            taikhoanModel.setRowCount(0);
//            showRecord();
//            deleteText();
//            setTextOnOff(false);
//            setButtonOnOff(false);
//            setSecureButtonOnOff(false);
//            btnSuaQLTK.setText("Sửa");
//        }
    }//GEN-LAST:event_btnSuaQLTKActionPerformed

    private void btnXoaQLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaQLTKActionPerformed
//        mataikhoan = Integer.parseInt(txtMaTaiKhoanQLTK.getText());
//        Object [] luachon = {"Có","Không"};
//        Object  macdinh = luachon[0];
//        int result = JOptionPane.showOptionDialog(this, "Bạn có chắc muốn xóa tài khoản này không?","Cảnh báo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,luachon,macdinh);
//        if(result == JOptionPane.YES_OPTION)
//        {
//            sql = "delete from TaiKhoan where MaTaiKhoan = "+mataikhoan;
//            try {
//                stmt.executeUpdate(sql);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            taikhoanModel.setRowCount(0);
//            showRecord();
//            deleteText();
//            setTextOnOff(false);
//            setButtonOnOff(false);
//            setSecureButtonOnOff(false);
//        }
    }//GEN-LAST:event_btnXoaQLTKActionPerformed

    @Override
    public void doEdit(){
        // TODO - refactor
        dong = mainTable.getSelectedRow();
        mataikhoan = (Integer)taikhoanModel.getValueAt(dong, 0);
        ten = (String)taikhoanModel.getValueAt(dong, 1);
        machucvu = (int)taikhoanModel.getValueAt(dong, 2);
        taikhoan = (String)taikhoanModel.getValueAt(dong, 3);
        matkhau  = (String)taikhoanModel.getValueAt(dong, 4);
        mabaomat = (String)taikhoanModel.getValueAt(dong, 5);
        txtMaTaiKhoanQLTK.setText(String.valueOf(mataikhoan));
        txtTenQLTK.setText(ten);
        txtTaiKhoanQLTK.setText(taikhoan);
        chucvu = (String)htMaChucVu.get(machucvu);
        cboChucVuQLTK.setSelectedItem(chucvu);
        setButtonOnOff(true);
        setTextOnOff(false);
        setSecureButtonOnOff(false);
    }
    
    private void mainTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTableMouseClicked
        if(canWrite()) doEdit();
    }//GEN-LAST:event_mainTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMaBaoMat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnSuaQLTK;
    private javax.swing.JButton btnThemQLTK;
    private javax.swing.JButton btnXoaQLTK;
    private javax.swing.JComboBox<String> cboChucVuQLTK;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mainTable;
    private javax.swing.JTextField txtMaTaiKhoanQLTK;
    private javax.swing.JTextField txtTaiKhoanQLTK;
    private javax.swing.JTextField txtTenQLTK;
    private javax.swing.JTextField txtTimQLTK;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.danhsach;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.BanDocDao;
import phanmemquanlythuvien.dao.ChiTietMuonTraDao;
import phanmemquanlythuvien.dao.MuonTraDao;
import phanmemquanlythuvien.dao.PhatDao;
import phanmemquanlythuvien.dto.Phat;
import phanmemquanlythuvien.enums.Quyen;

/**
 *
 * @author tainguyen
 */
public class PhatPanel extends SubPanel{

    List<Phat> allPhat;
    private static final Logger LOGGER = Logger.getLogger(TaiKhoanPanel.class);
    
    MuonTraDao muonTraDao = App.ctx.getBean(MuonTraDao.class);
    BanDocDao banDocDao = App.ctx.getBean(BanDocDao.class);
    ChiTietMuonTraDao ctMuonTraDao = App.ctx.getBean(ChiTietMuonTraDao.class);
    
    String[] header = new String[] {"Mã Phạt", "Mã Mượn Trả","Tên Bạn Đọc","Tên Sách", "Số Ngày Quá Hạn"};    
    
    public PhatPanel(){
        txtLabel.setText("Quản lý phạt");
        quyenThem = Quyen.THEM_PHAT;
        quyenXem = Quyen.XEM_PHAT;
        quyenXoa = Quyen.XOA_PHAT;
        tabName = "Phạt";
    }
    
    public static PhatPanel create(){
        return new PhatPanel();
    }
    
    public Object[] data2Array(Phat item){
        int mBanDoc = muonTraDao.findById(item.getMaMT()).getMaBD();
        return new Object[]{
            item.getMaPhat(),
            item.getMaMT(),
            "#"+String.format("%05d", mBanDoc) +" "+banDocDao.findById(mBanDoc).getTenBD(),
            item.getTieuDe(),
            item.getSoNgay(),
        };
    }
      
    @Override
    public void showData(){
        this.showData(null);
    }
    
    @Override
    public void tim(){
        showData(txtTim.getText().toLowerCase());
    }
    
    public void showData(String filterValue){
        
        PhatDao phatDao = App.ctx.getBean(PhatDao.class);
        allPhat = phatDao.findAll();
        
        Object[][] data;
        data = allPhat.stream()
            .filter(phat -> filterValue == null )
//                    || phat.getMaMT().toString().contains(filterValue)
//                    || phat.getMaPhat().toString().contains(filterValue)
//                    || banDocDao.findById(muonTraDao.findById(phat.getMaMT()).getMaBD()).getTenBD().toLowerCase().contains(filterValue) 
//                    || ctMuonTraDao.findById(phat.getMaMT()).getTieuDe().toLowerCase().contains(filterValue)
//                    || ctMuonTraDao.findById(phat.getMaMT()).getMaSach().toString().contains(filterValue)
//                    || muonTraDao.findById(phat.getMaMT()).getMaBD().toString().contains(filterValue) )
            .map(phat -> data2Array(phat))
            .toArray(size -> new Object[size][]);
        
        table.setModel(new DefaultTableModel(data, header));
    }
    
//    @Override
//    public void them(){
//        sua(new Phat());
//    }
//
//    @Override
//    public void sua() {
//        PhatDao phatDao = App.ctx.getBean(PhatDao.class);
//        Phat selectedPhat = phatDao.findById(getSelectedId());
//        sua(selectedPhat);
//    }
    
//    public void sua(Phat phat){
//        PhatFormnk form = new PhatFormnk(phat);
//        form.setVisible(true);
//        //check if dispose
//        form.addWindowListener(new java.awt.event.WindowAdapter() {
//            @Override
//            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
//                showData();
//            }
//        });
//    }
    
}

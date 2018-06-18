/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form.validator;

import com.querydsl.core.types.dsl.StringPath;
import javax.swing.text.JTextComponent;
import phanmemquanlythuvien.dao.CommonDao;

/**
 *
 * @author tainguyen
 */
public class UniqueValidator implements MyValidator{
    JTextComponent field;
    String label;
    CommonDao dao; 
    StringPath path;
    
    public UniqueValidator(JTextComponent field, String label, CommonDao dao, StringPath path){
        this.field = field;
        this.label = label;
        this.dao = dao;
        this.path = path;
    }
    @Override
    public void run() throws InputError {
        if(dao.count2(path.eq(this.field.getText())) > 0)
            throw new InputError("Tên " + label + " đang tồn tại. Vui lòng chọn tên khác", this.field);
    }
    
}

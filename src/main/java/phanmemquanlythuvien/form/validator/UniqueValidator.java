/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form.validator;

import com.google.common.base.Objects;
import com.querydsl.core.types.dsl.StringPath;
import java.util.List;
import javax.swing.text.JTextComponent;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.dao.CommonDao;
import phanmemquanlythuvien.dto.MyObject;

/**
 *
 * @author tainguyen
 */
public class UniqueValidator implements MyValidator{
    JTextComponent field;
    String label;
    CommonDao dao; 
    StringPath path;
    public MyObject item;
    
    private static final Logger LOGGER = Logger.getLogger(UniqueValidator.class);
    
    public UniqueValidator(JTextComponent field, String label, CommonDao dao, StringPath path, MyObject item){
        this.field = field;
        this.label = label;
        this.dao = dao;
        this.path = path;
        this.item = item;
    }
    @Override
    public void run() throws InputError {
        
        List<MyObject> items = dao.findAll2(path.eq(this.field.getText()));
        
        if(items.size() > 1)
            throw new InputError(label + " đang tồn tại. Vui lòng chọn "+label+" khác", this.field);
        
        if(items.size() == 1){

            if(!Objects.equal(item.getID(), items.get(0).getID()))
                throw new InputError(label + " đang tồn tại. Vui lòng chọn "+label+" khác", this.field);
        }
            
        
//        if(dao.count2(path.eq(this.field.getText())) > 0)
//            throw new InputError("Tên " + label + " đang tồn tại. Vui lòng chọn tên khác", this.field);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form.validator;

import javax.swing.text.JTextComponent;

/**
 *
 * @author tainguyen
 */
public class DateValidator implements MyValidator{
    
    JTextComponent field;
    String label;
    
    public DateValidator(JTextComponent field, String label){
        this.field = field;
        this.label = label;
    }
    
    @Override
    public void run() throws InputError{
        try{
            java.sql.Date.valueOf(field.getText());
        } catch (Exception e){
            throw new InputError(label + " cần theo mẫu YYYY-MM-DD", this.field);
        }
    }

}

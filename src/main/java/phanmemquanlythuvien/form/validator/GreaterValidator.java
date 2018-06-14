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
public class GreaterValidator implements MyValidator{
    JTextComponent field;
    String label;
    
    public GreaterValidator(JTextComponent field, String label){
        this.field = field;
        this.label = label;
    }
    
    @Override
    public void run() throws InputError{
        if(Integer.parseInt(this.field.getText()) == 0){
            throw new InputError(label + " phải lớn hơn 0", this.field);
        }
    }    
}

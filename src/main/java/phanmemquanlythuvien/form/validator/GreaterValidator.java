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
    Integer num;
    
    public GreaterValidator(JTextComponent field, String label, Integer num){
        this.field = field;
        this.label = label;
        this.num = num;
    }
    
    @Override
    public void run() throws InputError{
        if(Integer.parseInt(this.field.getText()) == 0){
            throw new InputError(label + " phải lớn hơn 0", this.field);
        }
        else if(Integer.parseInt(this.field.getText()) < num){
            throw new InputError(label + " phải lớn hơn " + num, this.field);
        }
    }    
}

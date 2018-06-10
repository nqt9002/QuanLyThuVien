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
public class NumberValidator implements MyValidator{

    JTextComponent field;
    String label;
    
    public NumberValidator(JTextComponent field, String label){
        this.field = field;
        this.label = label;
    }
    
    @Override
    public void run() throws InputError{
        try{
            Integer.parseInt(this.field.getText());
        } 
        catch (NumberFormatException e){
            throw new InputError(label + " phải là số.", this.field);
        }
    }
    
}

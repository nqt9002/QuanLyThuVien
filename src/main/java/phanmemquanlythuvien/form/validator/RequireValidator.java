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
public class RequireValidator implements MyValidator{

    JTextComponent field;
    String label;
    
    public RequireValidator(JTextComponent field, String label){
        this.field = field;
        this.label = label;
    }
    
    @Override
    public void run() throws InputError{
        if(this.field.getText().isEmpty()){
            throw new InputError(label + " không được để trống", this.field);
        }
    }
    
}

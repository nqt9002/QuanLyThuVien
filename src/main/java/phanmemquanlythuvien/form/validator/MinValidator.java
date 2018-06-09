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
public class MinValidator implements MyValidator{

    int min;
    JTextComponent field;
    String label;
    
    public MinValidator(int min, JTextComponent field, String label){
        this.min = min;
        this.field = field;
        this.label = label;
    }
    
    @Override
    public void run() throws InputError{
        if(this.field.getText().length() < min){
            throw new InputError(label + " không đạt độ dài tối thiểu: "+min, this.field);
        }
    }
    
}

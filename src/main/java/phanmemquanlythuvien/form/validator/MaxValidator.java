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
public class MaxValidator implements MyValidator{
    int max;
    JTextComponent field;
    String label;
    
    public MaxValidator(int max, JTextComponent field, String label){
        this.max = max;
        this.field = field;
        this.label = label;
    }
    
    @Override
    public void run() throws InputError{
        if(this.field.getText().length() == 0)
        {
            return;
        }
        if(this.field.getText().length() > max){
            throw new InputError(label + " vượt quá giớ hạn ký tự tối đa: "+max, this.field);
        }
    }
}

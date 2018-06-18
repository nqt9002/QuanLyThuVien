/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form.validator;

import java.util.regex.Pattern;
import javax.swing.text.JTextComponent;

/**
 *
 * @author tainguyen
 */
public class EmailValidator implements MyValidator{
    JTextComponent field;
    String label;
    
    public EmailValidator(JTextComponent field, String label){
        this.field = field;
        this.label = label;
    }
    
    @Override
    public void run() throws InputError{
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", this.field.getText()))){
            throw new InputError(label + " không chính xác.", this.field);
        }
    }    
}

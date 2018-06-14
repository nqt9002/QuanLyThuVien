/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form.validator;

import java.math.BigInteger;
import java.util.regex.Pattern;
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
         if (!(Pattern.matches("\\d+", this.field.getText()))){
            throw new InputError(label + " phải là số.", this.field);
        }       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.form.validator;

import javax.swing.JTable;
import javax.swing.text.JTextComponent;

/**
 *
 * @author tainguyen
 */
public class InputError extends Exception {
        
    public JTextComponent field;

    public InputError(String msg, JTextComponent field) {
        super(msg);
        this.field = field;
    }
    
}

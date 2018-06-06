/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.panel;

/**
 *
 * @author tainguyen
 */
public interface CommonView {
    boolean canRead();
    boolean canWrite();
    boolean canDelete();
    void doEdit();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dto;

/**
 *
 * @author tainguyen
 */
public interface MyObject {
    boolean isNew();
    Integer getID();
    boolean isMatch(String searchText);
    boolean isMatch(String[] arrString);
    
}

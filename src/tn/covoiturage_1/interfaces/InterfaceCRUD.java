/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.covoiturage_1.interfaces;

import java.sql.SQLException;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Nihel
 */
public interface InterfaceCRUD <T> {
    public void create(T t) throws SQLException ;
    public boolean delete(int id) throws SQLException ;
    public List <T> selectAll() throws SQLException;
    
}

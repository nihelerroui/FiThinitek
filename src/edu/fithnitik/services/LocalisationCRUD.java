/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fithnitik.services;

import edu.fithnitik.utils.MyConnection;
import java.sql.Connection;

/**
 *
 * @author Nadhem
 */
public class LocalisationCRUD {

    private final Connection cnx;

    public LocalisationCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wallejr
 */
public class MyDefaultTableModel extends DefaultTableModel
{
    public MyDefaultTableModel() 
    {
        super();
    }
    
    public boolean isCellEditable(int row, int col) 
    {
        return false;
    }
}

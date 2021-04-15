/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IhkeyA.MODELS;

/**
 *
 * @author ASUS
 */

//untuk masukin item ke table

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class ShowItem extends AbstractTableModel {
    
    private String[] columns;
    private Object[][] rows;
    
    public ShowItem(){}
    
    public ShowItem(Object[][] data, String[] columnsName){
        this.columns = columnsName;
        this.rows = data;
    }
    
    public Class getColumnClass(int col)
    {
        //sesuai dengan index column
        if(col == 7 ){
            return Icon.class;
        }else{
            return getValueAt(0, col).getClass();
        }
    }

    @Override
    public int getRowCount() {
       return this.rows.length;
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return this.rows[rowIndex][columnIndex];
        
    }
    
    @Override
    public String getColumnName(int col){
        return this.columns[col];
    }
    
}

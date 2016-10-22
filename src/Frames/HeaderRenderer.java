/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ubit
 */
class HeaderRenderer extends JLabel implements TableCellRenderer {

    

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean hasFocus,
            boolean isSelected,
            int row,
            int col) {
        setText(value.toString());
        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        //setHorizontalAlignment();
        setBackground(new Color(51, 102, 255));
        setForeground(Color.WHITE);
        setOpaque(true);

        return this;
    }
    

   

}
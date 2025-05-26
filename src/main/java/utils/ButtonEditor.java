package utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import UI.administrator.events.ModifyEvent;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.util.EventObject;

/**
 *
 * @author kevin
 */

public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private int row;
    private JTable table;
    private ModifyEvent modifyEventForm;

    public ButtonEditor(JCheckBox checkBox, ModifyEvent modifyEventForm) {
        super(checkBox);
        this.modifyEventForm = modifyEventForm;
        button = new JButton("Modificar");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int eventId = (int) table.getValueAt(row, 0); // asume que el ID está en la columna 0
                modifyEventForm.loadEventData(eventId);
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        return button;
    }

    public boolean isCellEditable(EventObject e) {
        return true;
    }

    public Object getCellEditorValue() {
        return "Modificar";
    }
}

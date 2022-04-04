/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package sql.projet;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author DerSon
 */
public class View_list_ue extends javax.swing.JPanel {

    Color color1 = new Color(230, 230, 230);

    /**
     * Creates new form view_list_etudiant
     */
    public View_list_ue() {
        initComponents();

        addUe(BddHelper.selectallUE());

    }

    public void addUe(UE[] etulist) {
        Object[][] listobj = new Object[etulist.length][4];
        for (int i = 0; i < etulist.length; i++) {
            UE etu = etulist[i];
            listobj[i][0] = i + 1;
            listobj[i][1] = etu.getIntitule();
            listobj[i][2] = etu.getCredit();
            listobj[i][3] = etu.getSemestre();
        }
        table.setModel(
                new javax.swing.table.DefaultTableModel(
                        listobj,
                        new String[]{
                            "N°", "Intitulé", "Crédit", "Semestre"
                        }
                ));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < 4; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){
public Component prepareRenderer(TableCellRenderer renderer, 
         int row, int column) 
         {
            Component c = super.prepareRenderer(renderer, row, column);

            Color color2 = Color.WHITE;
            if(!c.getBackground().equals(getSelectionBackground())) {
               Color coleur = (row % 2 == 0 ? color1 : color2);
               c.setBackground(coleur);
//c.setForeground((row % 2 == 0 ? color2 : color1));
if(column==1)
c.setFont(new java.awt.Font("Segoe UI", 1, 14));
else
c.setFont(new java.awt.Font("Segoe UI", 0, 14));
               coleur = null;
            }
            return c;
         }
};
        jLabel2 = new javax.swing.JLabel();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Intitulé", "Crédit", "Semestre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setEnabled(false);
        table.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(table);

        jLabel2.setBackground(new java.awt.Color(0, 136, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Liste des UEs");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

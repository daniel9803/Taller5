/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciaviajes.presentacion;

import agenciaviajes.negocio.Cliente;
import agenciaviajes.negocio.GestorClientes;
import agenciaviajes.utils.Utilidades;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import mvcf.AModel;
import mvcf.AView;

/**
 *
 * @author Personal
 */
public class GUIClientesGrafica extends javax.swing.JFrame implements AView {

      /**
     * Constructor
     */
    public GUIClientesGrafica() {
        initComponents();
        setSize(450, 300);
        setLocation(920, 200);
        //inicializarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barHombres = new javax.swing.JProgressBar();
        barMujeres = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lblHombres = new javax.swing.JLabel();
        lblMujeres = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barHombres.setOrientation(1);

        barMujeres.setOrientation(1);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel1.setText("Grafica Hombres y Mujeres");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Hombres");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Mujeres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(barHombres, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblHombres, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(barMujeres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMujeres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(barMujeres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barHombres, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHombres)
                    .addComponent(lblMujeres))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void consultar(ArrayList<Cliente> clientes) {
        int cantMujeres=0;
        int cantHombres=0;
        
        for (Cliente cli : clientes) {
            if("Femenino".equals(cli.getSexo())){
                cantMujeres++;
            }
            else{
                cantHombres++;
            }
        }
        graficar(cantHombres, cantMujeres);
    }

    private void graficar(int hombres, int mujeres) {
        int total=hombres + mujeres;
        int porHom= (hombres*100)/total;
        int porMuj=(mujeres*100)/total;
        barHombres.setValue(porHom);
        barMujeres.setValue(porMuj);
        lblHombres.setText(porHom+"%");
        lblMujeres.setText(porMuj+"%");
    }
    @Override
    public void actualizar(AModel amodel) {
        try {
            this.setTitle("Porcentaje hombres y mujeres clientes");
            GestorClientes gestor = (GestorClientes) amodel;
            ArrayList<Cliente> listado = gestor.consultarClientes();
            consultar(listado);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUIClientesVer.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeError("Error al consultar clientes", "Atención");
        }
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barHombres;
    private javax.swing.JProgressBar barMujeres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblHombres;
    private javax.swing.JLabel lblMujeres;
    // End of variables declaration//GEN-END:variables
}

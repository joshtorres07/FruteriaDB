
package Compras;

import Ventas.*;
import java.awt.Frame;
import javax.swing.table.DefaultTableModel;
import Clases.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import Productos.*;
import Proveedores.*;

public class NuevaCompra extends javax.swing.JDialog{

    AdminVentasCompras acv;
    Productos[] productos;
    Proveedores[] proveedores;
    DefaultTableModel table;   
    int cantidad[]=new int[20];
    Validar validar = new Validar();
    float total;
    Frame parent;
    String id;
    float ganancia = .84f;
    
    /**
     * Creates new form NuevaVenta
     * @param parent
     * @param md
     */
    public NuevaCompra(AdminVentasCompras acv,Frame parent, boolean md) {
        super(parent, md);
        this.acv=acv;
        this.parent = parent;                      
        initComponents();  
        this.setLocationRelativeTo(null);
        table=(DefaultTableModel) tablaProducto.getModel();
        tablaProducto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);         
        tablaProducto.changeSelection(tablaProducto.getRowCount(), 1, false, false);        
        proveedores=acv.consultarProveedores("select id_Prov,Nom_Prov from Proveedores order by Nom_Prov ASC");
        try{
            for(int x=0; x<proveedores.length;x++)
                listaNombres.addItem((String)proveedores[x].getNombre());            
        }catch(Exception e){}
        productos=acv.consultarProductos("id");
        try{
            for(int x=0; x<productos.length;x++)
            listProductos.addItem((String)productos[x].getNombre()); 
        }catch(Exception e){}
            total = 0;    
        this.acv.setNumproductos(0);
        this.acv.setOp("compras");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegresar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listaNombres = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        listProductos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnRealizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 0, 255));

        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3643764-back-backward-left-reply-turn_113415.png"))); // NOI18N
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sales_sale_supermarket_stock_market_icon_153849 (1).png"))); // NOI18N
        jLabel1.setText("PUNTO DE COMPRA FRUTERIA LUGO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar1)
                    .addComponent(jLabel1))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Realizar Compra"));

        jLabel2.setText("Cliente: ");

        listaNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaNombresActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(204, 255, 0));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_circle_create_expand_new_plus_icon_123218.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        listProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listProductosActionPerformed(evt);
            }
        });

        jLabel3.setText("Producto:");

        txtCantidad.setText("1");

        jLabel4.setText("Cantidad:");

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio", "Cantidad", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        jLabel6.setText("Total: ");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        btnRealizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check_ok_accept_apply_1582.png"))); // NOI18N
        btnRealizar.setText("Realizar Compra");
        btnRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancel_icon-icons.com_73703.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(listaNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(listProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 85, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRealizar)
                .addGap(130, 130, 130))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(listProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Finalizar transaccion de Compra"
                , "Finalizar Compra", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {   
            String idCliente;            
            Calendar fecha = Calendar.getInstance();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            idCliente= proveedores[listaNombres.getSelectedIndex()].getId();
            id = acv.generarID("compras_detalladas");   
            JOptionPane.showMessageDialog(this, "Compra realizada, el numero de id de la compra es: "+id
                +"\nFecha: " +dia+"/"+mes+"/"+año,"compra realizada", JOptionPane.INFORMATION_MESSAGE);                     
            acv.setDetalladas(id, idCliente, total, dia, mes ,año);                        
            
            acv.actualizarUnidades(cantidad);                                      
            
            acv.guardar();            
        }
    }//GEN-LAST:event_btnRealizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(acv.getNumproductos()<20){
            int indice, cant;
            float subtotal;
            String  idP;
            String scant;
            String row[];
            scant=txtCantidad.getText();              
            subtotal=0;
            if(validar.cantidad(scant)){
                int indexCV;
                indice=(int)listProductos.getSelectedIndex();  
                idP=productos[indice].getId();  
                cant=Integer.parseInt(scant);                                
                indexCV = acv.buscarCompraVenta(idP);
                if(indexCV==-1){                    
                    if(productos[indice].getStock()>=cant){      
                        cantidad[acv.getNumproductos()]=cant;
                        productos[indice].setExistencia(productos[indice].getExistencia()-cant);
                        subtotal= productos[indice].getPrecio()*ganancia*cant;
                        //to add new row: new Object[] {String, float,String,int, float}
                        table.insertRow(table.getRowCount(), new Object[] { 
                            productos[indice].getNombre() , productos[indice].getPrecio()
                             ,cant , subtotal });                  
                        total+=subtotal;                             
                        acv.agregarCompraVenta(id, idP, cant ,subtotal);
                    }else
                        JOptionPane.showMessageDialog(this, "Ha superado el limite de stock para"
                                + "completar esta compra"
                            , "Stock Rebasado", JOptionPane.ERROR_MESSAGE);
                }else{
                    cant+=acv.getCantidadCV(indexCV);
                    if(productos[indice].getStock()>=cant-1){                                                           
                        subtotal= productos[indice].getPrecio()*ganancia*cant;
                        cantidad[indexCV]=cant;
                        table.setValueAt(cant, indexCV, 3);
                        table.setValueAt(subtotal, indexCV, 4);                           
                        total+=productos[indice].getPrecio()*(cant-acv.getCantidadCV(indexCV));                             
                        acv.agregarCompraVenta(indexCV,id, idP, cant ,subtotal);
                    }else
                        JOptionPane.showMessageDialog(this, "Ha superado el limite de stock para"
                                + "completar esta compra"
                            , "Existencias insuficientes", JOptionPane.ERROR_MESSAGE);
                }
                
            }else
                    JOptionPane.showMessageDialog(this, "Favor de no dejar el campo Cantidad vacio"
                            , "Campo Vacio", JOptionPane.ERROR_MESSAGE);
            txtTotal.setText("$"+total);
            btnRealizar.setEnabled(true);                                    
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Se ha alcanzado la cantidad maxima de productos por venta"
                        , "Carrito lleno", JOptionPane.ERROR_MESSAGE);
        }
    }                                           

    private void opc1TablaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ///////////////////////////////////////////////////////////////////////////////
        try{
            int index = tablaProducto.getSelectedRow();  
            total-=(float) table.getValueAt(index, 5);          
            for(int x=index; x<acv.getNumproductos()-1;x++){
                cantidad[x]=cantidad[x+1];                
            }
            table.removeRow(index);          
            txtTotal.setText("$"+total);            
            acv.quitarCompraVenta(index);
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("error:"+e);
        }
        if(tablaProducto.getRowCount()==0){
            btnRealizar.setEnabled(false);           
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la compra actual?"
                , "Cancelar compra", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {            
            JOptionPane.showMessageDialog(null, "Venta cancelada");
            if(acv.getNumproductos()>0){                
                for (int i = 0; i < acv.getNumproductos(); i++) {
                    table.removeRow(0);
                }
                acv.setNumproductos(0);
            }
            txtCantidad.setText("");
            txtTotal.setText("");
            listProductos.setSelectedIndex(0);
            listaNombres.setSelectedIndex(0);            
        } 
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void listaNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaNombresActionPerformed
       proveedores[listaNombres.getSelectedIndex()].getNombre();
    }//GEN-LAST:event_listaNombresActionPerformed

    private void listProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listProductosActionPerformed
        productos[listProductos.getSelectedIndex()].getNombre();
    }//GEN-LAST:event_listProductosActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void tablaProductoMousePressed(java.awt.event.MouseEvent evt) {                                           
        if ((evt.getModifiers() & 4) !=0)
            {//pop.show(this,evt.getX()+37, evt.getY()+298);
        }
    }                                          

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {                                     
        tablaProducto.clearSelection();
    }                                    

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {                                       
        listProductos.removeAllItems();
        productos=acv.consultarProductos("nombre");
        for (Productos producto : productos) {
            listProductos.addItem((String) producto.getNombre());        
        }
    }                                      
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRealizar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listProductos;
    private javax.swing.JComboBox<String> listaNombres;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

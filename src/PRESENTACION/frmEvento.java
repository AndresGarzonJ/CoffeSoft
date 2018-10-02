/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;

import NEGOCIO.Administrador;
import com.itextpdf.text.Font;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author NELCY
 */
public class frmEvento extends javax.swing.JFrame {
    Administrador miAdmin; 
    
    long vEmpCedula;
    int vLotCodigo;
    long vCodigoEvento;
    String vNombreEncargado;
    String vNombreLote;
    
    Toolkit t;
    Dimension screenSize;
    ImageIcon fot;
    ImageIcon fot2;
    Icon icono;
    Icon icono2;
    
    
    /**
     * Creates new form frmEvento
     */
    public frmEvento() {
        miAdmin = new Administrador();
        vEmpCedula = 0;
        vLotCodigo = 0;
        vCodigoEvento = 0;
        vNombreEncargado = "";
        vNombreLote = "";
        
        initComponents();
        
        this.lblNoEncargado.setVisible(false);
        this.lblNoLote.setVisible(false);
        //https://linuxgx.blogspot.com.co/2014/07/obtener-fecha-del-sistema-y-colocarlo.html
        Calendar c2 = new GregorianCalendar();
        this.cldFecha.setCalendar(c2);
        sololetras(this.txtEncargado);
        solonumeros(this.txtCantidad);
        solonumeros(this.txtValor);
        
        setLocationRelativeTo(frmEvento.this);        // Centering on screen...
        setTitle("GESTION DE ACTIVIDADES"); 
        //setSize(1370, 600);                  // Setting dimensions...
        this.setExtendedState(frmEvento.MAXIMIZED_BOTH);
        setIcon();
        
        
        t = Toolkit.getDefaultToolkit();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        
        fot = new ImageIcon("src/PRESENTACION/imagenes/coffe_wall3.jpg");
        icono = new ImageIcon(fot.getImage().getScaledInstance(this.lblFondo.getWidth(), this.lblFondo.getHeight(), Image.SCALE_DEFAULT));
        this.lblFondo.setIcon(icono);
        this.repaint();
        
        
        
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrincipal = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListarEmplados = new javax.swing.JButton();
        btnListarLotes = new javax.swing.JButton();
        btnBuscarPorActividad = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        lblActividad = new javax.swing.JLabel();
        lblLote = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblEncargado = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblNoLote = new javax.swing.JLabel();
        lblNoEncargado = new javax.swing.JLabel();
        cldFecha = new com.toedter.calendar.JDateChooser();
        txtEncargado = new javax.swing.JTextField();
        txtLote = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        cbxActividad = new javax.swing.JComboBox<>();
        cbxBuscarActividad = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBuscar = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListar = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaDescrpcion = new javax.swing.JTextArea();
        lblFondo = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblEscondida = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PRESENTACION/imagenes/logoFinalRecortado.png"))); // NOI18N
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseClicked(evt);
            }
        });
        getContentPane().add(btnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, 90));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PRESENTACION/imagenes/guardar.png"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 110, 80));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PRESENTACION/imagenes/update_48.png"))); // NOI18N
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 110, 80));

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PRESENTACION/imagenes/listar_48.png"))); // NOI18N
        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMouseClicked(evt);
            }
        });
        getContentPane().add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 110, 80));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PRESENTACION/imagenes/delete_48.png"))); // NOI18N
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 110, 80));

        btnListarEmplados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnListarEmplados.setText("Listar Empleados");
        btnListarEmplados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarEmpladosMouseClicked(evt);
            }
        });
        getContentPane().add(btnListarEmplados, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, -1, -1));

        btnListarLotes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnListarLotes.setText("Listar Lotes");
        btnListarLotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarLotesMouseClicked(evt);
            }
        });
        getContentPane().add(btnListarLotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, -1, -1));

        btnBuscarPorActividad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscarPorActividad.setText("Buscar Actividad");
        btnBuscarPorActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarPorActividadMouseClicked(evt);
            }
        });
        getContentPane().add(btnBuscarPorActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 170, -1));

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha:");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        lblActividad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblActividad.setForeground(new java.awt.Color(255, 255, 255));
        lblActividad.setText("Actividad:");
        getContentPane().add(lblActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        lblLote.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLote.setForeground(new java.awt.Color(255, 255, 255));
        lblLote.setText("Lote*:");
        getContentPane().add(lblLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad*:");
        getContentPane().add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        lblEncargado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEncargado.setForeground(new java.awt.Color(255, 255, 255));
        lblEncargado.setText("Encargado*:");
        getContentPane().add(lblEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        lblDescripcion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("Descripción:");
        getContentPane().add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 120, -1));

        lblValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblValor.setForeground(new java.awt.Color(255, 255, 255));
        lblValor.setText("Valor*:");
        getContentPane().add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        lblNoLote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PRESENTACION/imagenes/exit.png"))); // NOI18N
        getContentPane().add(lblNoLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 40, 40));

        lblNoEncargado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PRESENTACION/imagenes/exit.png"))); // NOI18N
        getContentPane().add(lblNoEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 40, 40));

        cldFecha.setToolTipText("");
        cldFecha.setDateFormatString("dd/MM/yyyy");
        cldFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(cldFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 160, 30));
        cldFecha.getAccessibleContext().setAccessibleName("");

        txtEncargado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEncargado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEncargadoKeyReleased(evt);
            }
        });
        getContentPane().add(txtEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 350, -1));

        txtLote.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoteKeyReleased(evt);
            }
        });
        getContentPane().add(txtLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 350, -1));

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 350, -1));

        txtValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 350, -1));

        cbxActividad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abonar", "Construir/Arreglar", "Cosechar", "Enchapolar", "Escoger café", "Fumigar", "Huequear", "Preparar Abono", "Sembrar", "Soquear", "Venta de café" }));
        getContentPane().add(cbxActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 350, -1));

        cbxBuscarActividad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxBuscarActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abonar", "Construir/Arreglar", "Cosechar", "Enchapolar", "Escoger café", "Fumigar", "Huequear", "Preparar Abono", "Sembrar", "Soquear", "Venta de café" }));
        getContentPane().add(cbxBuscarActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 200, -1));

        tblBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBuscar);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 720, 290));

        tblListar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblListar);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 1260, 250));

        txtaDescrpcion.setColumns(20);
        txtaDescrpcion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtaDescrpcion.setRows(5);
        jScrollPane1.setViewportView(txtaDescrpcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 350, 80));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        tblEscondida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblEscondida);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 720, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //<editor-fold defaultstate="collapsed" desc="EVENTOS">
    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        
        int veriCampos = verificarCampos();
        
        if (veriCampos == 0){
            //La variable codigo..es generada por una secuencia en la base de datos
            String fechaEvento = new SimpleDateFormat("dd/MM/yyyy").format(this.cldFecha.getDate());
            String actividad = this.cbxActividad.getSelectedItem().toString();
            String descricion = this.txtaDescrpcion.getText();
            long cantidad = Long.parseLong(this.txtCantidad.getText());
            long costo = Long.parseLong(this.txtValor.getText());
            

            int res = miAdmin.registrarEvento(vEmpCedula, vLotCodigo,fechaEvento, actividad.toLowerCase(), descricion.toLowerCase(), costo, cantidad);
            //res = 2 ...Es por que falta empleado
            //res = 3 ...Es por que falta lote
            if (res == 1) {
                JOptionPane.showMessageDialog(this, "Registro exitoso");
                limpiar();
                listarEventos();
                vCodigoEvento =0;
                vEmpCedula =  0;
                vLotCodigo = 0;
                
            }
            else if (res == 2){
                JOptionPane.showMessageDialog(this, "Error...Empleado no registrado");
            }else if (res == 3){
                JOptionPane.showMessageDialog(this, "Error...Lote no registrado");
            }else{
                JOptionPane.showMessageDialog(this, "Registro no exitoso");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Datos Obligatorios (**) sin llenar");
        }
        
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        // TODO add your handling code here:

        int veriCampos = verificarCampos();
        
        if (veriCampos == 0){
            String fechaEvento = new SimpleDateFormat("dd/MM/yyyy").format(this.cldFecha.getDate());
            String actividad = this.cbxActividad.getSelectedItem().toString();
            String descricion = this.txtaDescrpcion.getText();
            long cantidad = Long.parseLong(this.txtCantidad.getText());
            long costo = Long.parseLong(this.txtValor.getText());
            
            
            int res = miAdmin.actualizarEvento(vEmpCedula, vLotCodigo, vCodigoEvento, fechaEvento, actividad.toLowerCase(), descricion.toLowerCase(), costo, cantidad);

            if (res == 1) {
                JOptionPane.showMessageDialog(this, "Evento Actualizado");
                limpiar();
                listarEventos();  
                vCodigoEvento =0;
                vEmpCedula =  0;
                vLotCodigo = 0;
            }
            else {
            JOptionPane.showMessageDialog(this, "Evento NO Actualizado");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Datos Obligatorios (**) sin llenar");
        }
       
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked
        // TODO add your handling code here:
        listarEventos();   
    }//GEN-LAST:event_btnListarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        int fila = this.tblListar.getSelectedRow();
        if(fila != -1){
            
            vCodigoEvento = Long.parseLong(this.tblListar.getValueAt(fila,0).toString());
            int res = miAdmin.eliminarEvento(vCodigoEvento);
            if(res!=0){
                JOptionPane.showMessageDialog(rootPane, "Evento eliminado con éxito");
                listarEventos();
                limpiar();
                vCodigoEvento =0;
                vEmpCedula =  0;
                vLotCodigo = 0;
            }
            else
            JOptionPane.showMessageDialog(rootPane, "Evento no eliminado");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro para eliminar");
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void tblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarMouseClicked
        // TODO add your handling code here:
        String valor = this.tblBuscar.getColumnName(0);
        int fila = this.tblBuscar.getSelectedRow();
        
        if ("Cedula".equalsIgnoreCase(valor.toLowerCase())){
            this.txtEncargado.setText(this.tblBuscar.getValueAt(fila,1).toString() +" "+this.tblBuscar.getValueAt(fila,2).toString());
            if(this.tblBuscar.getValueAt(fila,0).toString().length() == 0)
                vEmpCedula = 0;
            else
                vEmpCedula = Long.parseLong(this.tblBuscar.getValueAt(fila,0).toString());
            
        }    
        else if("Codigo".equalsIgnoreCase(valor.toLowerCase())){
            this.txtLote.setText(this.tblBuscar.getValueAt(fila,1).toString());
            vLotCodigo = Integer.parseInt(this.tblBuscar.getValueAt(fila,0).toString());
        
        }else{
            this.txtLote.setText(this.txtLote.getText());
            
            //this.txtLote.setText(valor.toLowerCase());
            this.txtEncargado.setText(this.txtEncargado.getText());
            vEmpCedula = vEmpCedula;    
            vLotCodigo = vLotCodigo;
        }
        
        
    }//GEN-LAST:event_tblBuscarMouseClicked

    private void tblListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListarMouseClicked
        // TODO add your handling code here:
        
        limpiar();
        int fila = this.tblListar.getSelectedRow();
        vCodigoEvento = Long.parseLong(this.tblListar.getValueAt(fila,0).toString());
        vEmpCedula =  Long.parseLong(this.tblListar.getValueAt(fila,1).toString());
        vLotCodigo = Integer.parseInt(this.tblListar.getValueAt(fila,2).toString());
        //EveFecha
        this.cbxActividad.setSelectedIndex(valoresCbxActividad(this.tblListar.getValueAt(fila,4).toString().toLowerCase()));
        this.txtaDescrpcion.setText(this.tblListar.getValueAt(fila,5).toString());this.txtCantidad.setText(this.tblListar.getValueAt(fila,7).toString().toLowerCase());
        this.txtValor.setText(this.tblListar.getValueAt(fila,6).toString());
        this.txtCantidad.setText(this.tblListar.getValueAt(fila,7).toString());
        
        
        this.tblEscondida.setVisible(false);
        ///NOMBRE Y APELLIDOS EMPLEADO////////////////
        listarEmpleadosCedula(vEmpCedula);
        this.txtEncargado.setText(this.tblEscondida.getValueAt(0 , 1).toString() +" "+ this.tblEscondida.getValueAt(0, 2).toString());
        
        ///NOMBRE LOTE///////////////////////////////
        listarLotesCodigo(vLotCodigo);
        this.txtLote.setText(this.tblEscondida.getValueAt(0 , 1).toString());
        this.tblEscondida.setVisible(false);
        
        
    }//GEN-LAST:event_tblListarMouseClicked

    private void txtEncargadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEncargadoKeyReleased
        // TODO add your handling code here:
        String bNombre = this.txtEncargado.getText();
        listarEmpleadosNombre(bNombre.toLowerCase());
        
    }//GEN-LAST:event_txtEncargadoKeyReleased

    private void txtLoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoteKeyReleased
        // TODO add your handling code here:
        String bNombreL = this.txtLote.getText();
        listarLotesNombre(bNombreL.toLowerCase());
        
    }//GEN-LAST:event_txtLoteKeyReleased

    private void btnListarEmpladosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarEmpladosMouseClicked
        // TODO add your handling code here:
        listarEmpleado();       
    }//GEN-LAST:event_btnListarEmpladosMouseClicked

    private void btnListarLotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarLotesMouseClicked
        // TODO add your handling code here:
        listarLotes();
    }//GEN-LAST:event_btnListarLotesMouseClicked

    private void btnBuscarPorActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarPorActividadMouseClicked
        // TODO add your handling code here:
        String actividad = this.cbxBuscarActividad.getSelectedItem().toString();
        buscarEventosPorActividad(actividad.toLowerCase());
    }//GEN-LAST:event_btnBuscarPorActividadMouseClicked

    private void btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseClicked
        // TODO add your handling code here:
        frmPrincipal myPrincipal = new frmPrincipal();
        myPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPrincipalMouseClicked
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Nombrar Columnas Tabla Buscar">
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Excepciones">
    public  void  solonumeros(JTextField a){
       a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c=e.getKeyChar();
            if(Character.isLetter(c)){
                getToolkit().beep();
                e.consume();
            }
        }  
           
       });
    }
    
    public  void  sololetras(JTextField a){
       a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c=e.getKeyChar();
            if(Character.isDigit(c)){
                getToolkit().beep();
                e.consume();
            }
        }  
           
       });
    }
    
    //</editor-fold>    
        
    /*//////////
        int veriCampos = verificarCampos();
        
        if (veriCampos == 0){
        
        }
        else{
            JOptionPane.showMessageDialog(this, "Datos Obligatorios (**) sin llenar");
        }
    */
    
    //<editor-fold defaultstate="collapsed" desc="Metodos Propios">        
    
    private void setIcon() {
    
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconProgram.png")));
        
    }
    
    private int verificarCampos(){
        int retVerificar = 0;
        
        if(this.txtCantidad.getText().length()==0)
            retVerificar = 1;
        if(this.txtValor.getText().length()==0)
            retVerificar = 1;
        if(this.txtEncargado.getText().length()==0)
            retVerificar = 1;
        if(this.txtLote.getText().length()==0)
            retVerificar = 1;
        
        return retVerificar;    
    }
    private int valoresCbxActividad (String valor){
        int posicion = -1;
        if ("Abonar".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 0;
        else if ("Construir/Arreglar".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 1;
        else if ("Cosechar".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 2;
        else if ("Enchapolar".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 3;
        else if ("Escoger café".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 4;
        else if ("Fumigar".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 5;
        else if ("Huequear".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 6;
        else if ("Preparar Abono".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 7;
        else if ("Sembrar".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 8;
        else if ("Soquear".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 9;
        else if ("Venta de café".equalsIgnoreCase(valor.toLowerCase()))
            posicion = 10;
        else 
            posicion = -1;
        
        return posicion;
    }
    private void limpiar(){
        this.txtEncargado.setText("");
        this.txtaDescrpcion.setText("");        
        this.txtCantidad.setText("");
        this.txtValor.setText("");
        this.txtLote.setText("");
        
        //this.cldFechaSiembra.cleanup();
    }
    private void buscarEventosPorActividad(String bActividadd) {
        //Se creo una tabla que estara escondida .. con el fin de desplegar los datos ahi .. y hacer 
        //las posteriores asignaciones
        
        ArrayList<Object[]> eventos = miAdmin.buscarEventosActividad(bActividadd.toLowerCase());    
        DefaultTableModel datos = new DefaultTableModel();
        this.tblListar.setModel(datos);

        Object[] columnas = eventos.get(0);
        for (int i = 0; i < columnas.length; i++) {
            datos.addColumn(columnas[i]);
        }
        for (int i = 1; i < eventos.size(); i++) {
            datos.addRow(eventos.get(i));
        }
        
        if (tblListar.getRowCount() == 0)
            JOptionPane.showMessageDialog(this, "No existen eventos registrados");
                       
    }
    private void listarEventos(){   
        
        ArrayList<Object[]> eventos = miAdmin.listarEventos();
        DefaultTableModel datos = new DefaultTableModel();
        this.tblListar.setModel(datos);
        
        Object[] columnas = eventos.get(0);
        
        for(int i=0; i<columnas.length; i++)
            datos.addColumn(columnas[i]);
        for(int i=1; i<eventos.size(); i++)
            datos.addRow(eventos.get(i));
        
        if (tblListar.getRowCount() == 0)
            JOptionPane.showMessageDialog(this, "No existen eventos registrados");
    }
    
    private void listarLotes(){   
        
        ArrayList<Object[]> lotes = miAdmin.listarLotes();
        DefaultTableModel datos = new DefaultTableModel();
        this.tblBuscar.setModel(datos);
        
        Object[] columnas = lotes.get(0);
        for(int i=0; i<columnas.length; i++)
            datos.addColumn(columnas[i]);
        for(int i=1; i<lotes.size(); i++)
            datos.addRow(lotes.get(i));
        
        if (tblBuscar.getRowCount() == 0)
            JOptionPane.showMessageDialog(this, "No existen lotes registrados");
        
    }
    private void listarEmpleado() {

        ArrayList<Object[]> empleados = miAdmin.listarEmpleados();
        DefaultTableModel datos = new DefaultTableModel();
        this.tblBuscar.setModel(datos);
        
        Object[] columnas = empleados.get(0);
        for (int i = 0; i < columnas.length; i++) {
            datos.addColumn(columnas[i]);
        }
        for (int i = 1; i < empleados.size(); i++) {
            datos.addRow(empleados.get(i));
        }
        if (tblBuscar.getRowCount() == 0)
            JOptionPane.showMessageDialog(this, "No existen empleados registrados");
    }
    private void listarEmpleadosNombre(String bNombre) {

        ArrayList<Object[]> empleados = miAdmin.buscarEmpleadosNombre(bNombre.toLowerCase());
        DefaultTableModel datos = new DefaultTableModel();
        this.tblBuscar.setModel(datos);

        Object[] columnas = empleados.get(0);
        for (int i = 0; i < columnas.length; i++) {
            datos.addColumn(columnas[i]);
        }
        for (int i = 1; i < empleados.size(); i++) {
            datos.addRow(empleados.get(i));
        }
        
        if (tblBuscar.getRowCount() == 0){
            this.lblNoEncargado.setVisible(true);
            this.btnGuardar.setEnabled(false);
            
        }else{
            this.lblNoEncargado.setVisible(false);
            this.btnGuardar.setEnabled(true);
        }
            
        
    }
    private void listarLotesNombre(String bNombree) {
        
        ArrayList<Object[]> lotess = miAdmin.buscarLotesNombre(bNombree.toLowerCase());
        DefaultTableModel datos = new DefaultTableModel();
        this.tblBuscar.setModel(datos);

        Object[] columnas = lotess.get(0);
        for (int i = 0; i < columnas.length; i++) {
            datos.addColumn(columnas[i]);
        }
        for (int i = 1; i < lotess.size(); i++) {
            datos.addRow(lotess.get(i));
        }
        if (tblBuscar.getRowCount() == 0){
            this.lblNoLote.setVisible(true);
            this.btnGuardar.setEnabled(false);
        }else{
            this.lblNoLote.setVisible(false);
            this.btnGuardar.setEnabled(true);
        }
        
    }
    private void listarLotesCodigo(int bCodigo) {
        //Se creo una tabla que estara escondida .. con el fin de desplegar los datos ahi .. y hacer 
        //las posteriores asignaciones
        ArrayList<Object[]> lotes = miAdmin.buscarlotesCodigo(bCodigo);
        DefaultTableModel datos = new DefaultTableModel();
        this.tblEscondida.setModel(datos);

        Object[] columnas = lotes.get(0);
        for (int i = 0; i < columnas.length; i++) {
            datos.addColumn(columnas[i]);
        }
        for (int i = 1; i < lotes.size(); i++) {
            datos.addRow(lotes.get(i));
        }
                       
    }        
    private void listarEmpleadosCedula(long bCedula) {
        //Se creo una tabla que estara escondida .. con el fin de desplegar los datos ahi .. y hacer 
        //las posteriores asignaciones
        ArrayList<Object[]> empleados = miAdmin.buscarEmpleadosCedula(bCedula);
        DefaultTableModel datos = new DefaultTableModel();
        this.tblEscondida.setModel(datos);

        Object[] columnas = empleados.get(0);
        for (int i = 0; i < columnas.length; i++) {
            datos.addColumn(columnas[i]);
        }
        for (int i = 1; i < empleados.size(); i++) {
            datos.addRow(empleados.get(i));
        }
                       
    }  
    
    
    //</editor-fold>
  
    
    //<editor-fold defaultstate="collapsed" desc="Main & Variables">
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscarPorActividad;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnListarEmplados;
    private javax.swing.JButton btnListarLotes;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JComboBox<String> cbxActividad;
    private javax.swing.JComboBox<String> cbxBuscarActividad;
    private com.toedter.calendar.JDateChooser cldFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblActividad;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEncargado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLote;
    private javax.swing.JLabel lblNoEncargado;
    private javax.swing.JLabel lblNoLote;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tblBuscar;
    private javax.swing.JTable tblEscondida;
    private javax.swing.JTable tblListar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtEncargado;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextArea txtaDescrpcion;
    // End of variables declaration//GEN-END:variables

//</editor-fold>
}
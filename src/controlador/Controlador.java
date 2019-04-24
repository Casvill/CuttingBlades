package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Producto;
import vista.Vista;

public class Controlador implements ActionListener {

    private Vista vista;
    private Producto producto;

    public Controlador(Vista vista, Producto producto) {
        this.vista = vista;
        this.producto = producto;
        
        this.vista.jtBusquedaPorCodigo.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    
    
}

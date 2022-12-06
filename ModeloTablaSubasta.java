package practica7;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pablo
 */
public class ModeloTablaSubasta extends AbstractTableModel {

    private ArrayList<Subasta> subastas;

    public ModeloTablaSubasta() {
        this.subastas = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return subastas.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Libro";
                break;
            case 1:
                nombre = "Precio Inicial";
                break;

            case 2:
                nombre = "Precio Actual";
                break;
            case 3:
                nombre = "Ganador Actual";
                break;

        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.String.class;
                break;
            case 1:
                clase = java.lang.Float.class;
                break;
            case 2:
                clase = java.lang.Float.class;
                break;
            case 3:
                clase = java.lang.String.class;
                break;

        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;
        if (row < subastas.size()) {
            switch (col) {
                case 0:
                    resultado = subastas.get(row).getNombreLibro();
                    break;

                case 1:
                    resultado = subastas.get(row).getPrecioInicial();
                    break;
                case 2:
                    resultado = subastas.get(row).getPrecioActual();
                    break;

                case 3:
                    if (subastas.get(row).getGanadorProvisional()!=null) {
                        resultado = subastas.get(row).getGanadorProvisional().getName().split("@")[0];
                    }
                    else {
                        resultado = " ";
                    }
                    
                    
                    
                    break;

            }
        }
        return resultado;
    }

    public void setFilas(ArrayList<Subasta> subasta) {
        this.subastas.clear();
        for (Subasta aux : subasta) {
            this.subastas.add(aux);
        }
        fireTableDataChanged();
    }

    public void borrarTabla() {
        this.subastas.clear();
        fireTableDataChanged();
    }

    public void borrarFila(int indice) {
        this.subastas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public void anadirFila(Subasta subasta) {
        this.subastas.add(subasta);
        fireTableRowsInserted(this.subastas.size() - 1, this.subastas.size() - 1);
    }

}

package Formulario;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ConjuntoRegistros {
    
    public LinkedList<Registro> obtener() {
        LinkedList<Registro> registros = null;
        Archivo archivo = new Archivo("form.txt");
        LinkedList<String> lineas = archivo.getText();
        if (lineas != null) {
            registros = new LinkedList();
            for (int i=0; i< lineas.size(); i++) {
                String linea = lineas.get(i);
                StringTokenizer tokens = new StringTokenizer(linea, ";");
                String nombre = tokens.nextToken();
                String telefono = tokens.nextToken();
                String correo = tokens.nextToken();
                registros.add(new Registro(nombre,telefono,correo));
            }
        }
        return registros;
    }
    
    public boolean registrarRegistro(Registro p) {
        Archivo archivo = new Archivo("form.txt");
        return archivo.registrar(p.getNombre()+";"+
        p.getTelefono()+";"+p.getCorreo()+";");
    }
    public void guardarEnArchivo(){
        
    }
    public void borrarTodo(){
        Archivo archivo = new Archivo("form.txt");
        archivo.borrarContenido();
    }
}

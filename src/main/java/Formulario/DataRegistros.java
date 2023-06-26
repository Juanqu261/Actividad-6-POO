package Formulario;
import java.util.LinkedList;

public class DataRegistros {
    public LinkedList<Registro> registros;
    
    public void agg(Registro registro){
        registros.add(registro);
    }
    public void eliminar(int indice){
        ConjuntoRegistros cr = new ConjuntoRegistros();
        registros = cr.obtener();
        registros.remove(indice);
    }
    public int total() {
        return registros.size();
    }
    public Registro obtener(int indice){
        return registros.get(indice);
    }
    public void cargarRegistros() {
        ConjuntoRegistros cr = new ConjuntoRegistros();
        registros = cr.obtener();
    }
    public void guardar(){
        ConjuntoRegistros cr = new ConjuntoRegistros();
        cr.borrarTodo();
        for(int i=0;i<registros.size();i++){
            cr.registrarRegistro(registros.get(i));
        }
        cr.guardarEnArchivo();
    }
}

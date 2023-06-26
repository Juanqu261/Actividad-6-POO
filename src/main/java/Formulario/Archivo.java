package Formulario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Archivo {
    public String nombre;

    public Archivo(String nombre) {
        this.nombre = nombre;
    }
    
    public LinkedList<String> getText() {
        LinkedList<String> text=null;
        try {
            File archivo = getData();
            if (archivo.exists()) {
                text = new LinkedList();
                BufferedReader br = new BufferedReader(new FileReader("form.txt"));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    text.add(linea);
                }
                br.close();
            }
            else {
                JOptionPane.showMessageDialog(null, "Archivo inexistente");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return text;
    }
    
    private File getData() {
        try {
            URL url = getClass().getClassLoader().getResource("archivo\\"+nombre);
            return new File(url.toURI());
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean registrar(String linea) {
        File archivo = getData();
        try {
            if (archivo.exists()) {
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(linea);
                pw.flush();
                pw.close();
                return true;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public void borrarContenido(){
        File archivo = new File("form.txt");
        archivo.delete();
    }
}

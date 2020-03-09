/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciaconciertos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW102
 */
public class Reportero {

    protected long id; //atributo que sirve para identificar a la actuacion // valores validos numero entero mayor que 0
    private String nombre; // atributo que almacena el nombre del reportero // una cadena de caracteres de 20 caractarese como maximo no pudiendo contener caracteres numericos 
    private String apellidos; // atributo que almacena los apellidos del reportero // una cadena de caracteres de 35 caractares como maximo no pudiendo contener caracteres numericos
    private String nif; // atributo que alamcena el niof del reportero // seran 8 numeros y una letra al final ej 12345678A
    private String numero; // atributo que guarda el numero de telefono del reportero // una cadena de 9 caracteres siempre ademas de ser numeros. ej 123456789

    //getters y setters
    /*
    public Reportero getReporterobyid (long id) {
        for (int i=0;i<listaobjetos;i++){
            Reportero aux=listaobjetos.get(i);
            if (aux.getID()==id){
                return aux;
         }
    }
     */
 /*public ArrayList<Reportero> getAllReportero(){
        ArrayList<Reportero> LRP = new ArrayList<Reportero>();
        for (int i=0;i<listaobjetos.size();i++){
            Reportero aux=listaobjetos.get(i);
            LRP.add(aux);
        }
        return LRP;
    }*/
    /**
     * metodo que devuelve el id del reportero
     *
     * @return el id del reportero.
     */
    public long getId() {
        return id;
    }

    /**
     * metodo que establece el id al valor aportado
     *
     * @param id el nuevo id que se va establecer
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * metodo que devuelve el nombre del reportero
     *
     * @return el nombre del reportero
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo que establece el nombre del reportero
     *
     * @param nombre el nombre del reportero
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo que sirve para obtener los apellidos del reportero
     *
     * @return los apellidos del reportero.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * establece los apellidos del reportero.
     *
     * @param apellidos el nuevo apellido del reportero.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * metodo que sirve para obtener el nif.
     *
     * @return el nif del reportero.
     */
    public String getNif() {
        return nif;
    }

    /**
     * metodo que sirve para establecer el nif del reportero.
     *
     * @param nif el nuevo nif
     */
    public void setNIF(String nif) {
        this.nif = nif;
    }

    /**
     * metodo que sirve para devolver el numero del reportero.
     *
     * @return el nombre del reportero.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * metodo que sirve para devolver el numero del reportero
     *
     * @param numero el numero del reportero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    //constructores
    /**
     * metodo constructor de reportero que recibe el nombre,apellidos,nif,numero
     *
     * @param nombre el nombre del reportero
     * @param apellidos los apellidos del reportero
     * @param nif el nif del reportero
     * @param numero el numero del reportero
     */
    public Reportero(String nombre, String apellidos, String nif, String numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.numero = numero;
    }

    /**
     * metodo constructor privado que es utilizado en la recuperacion de objetos
     * de uin fichero de caracteres.
     *
     * @param id el id del reportero.
     * @param nombre el nombre del reportero
     * @param apellidos los apellidos del reportero
     * @param nif el nif del reportero
     * @param numero el numero del reportero
     */
    private Reportero(long id, String nombre, String apellidos, String nif, String numero) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.numero = numero;
    }

    /**
     * constructor de copia que crea una copia del reportero que se pasa como
     * argumento
     *
     * @param reportero el reportero a copiar
     */
    public Reportero(Reportero reportero) {
        this.nombre = reportero.getNombre();
        this.apellidos = reportero.getApellidos();
        this.nif = reportero.getNif();
        this.numero = reportero.getNif();
    }

    /**
     * el constructor por defecto.
     */
    public Reportero() {
    }
    //otros metodos
    /**
     * metodo que devuelve un string con los datos de reportero serados por |
     * con el siguiente formato. id|nombre|apellidos|nif|numero
     *
     * @return un string con los datos de la clase y el siguiente formato
     * id|nombre|apellidos|nif|numero
     */
    public String data() {
        return this.getId() + "|" + this.getNombre() + "|" + this.getApellidos() + "|" + this.getNif() + "|" + this.getNumero();
    }

    @Override
    public String toString() {
        return "Reportero" + "identificador=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", NIF=" + nif + ", Numero=" + numero + '}';
    }

    /*
    public Reportero getReporteroById (long id){
       for (Reportero reportero : listaReporteros) {
            if (reportero.getId() == id) {
                return reportero;
            }
        }
        return null;
    }
     */
 /*
    public ArrayList<Reportero> getAllReportero (){
        ArrayList<Reportero> nuevaListaReportero=new ArrayList<Reportero>();
            for(Reportero reportero:listaReportero) {
            nuevaListaReportero.add(reportero);
        } 
          
        return nuevaListaReportero;
    }*/
    /**
     * metodo que permite crear un reportero mediante el teclado
     * @return devuelve el reportero creado por teclado.
     */
    public static Reportero nuevoReportero() {
        Reportero reportero=null;
        Scanner in = new Scanner(System.in);
        boolean confirmacion = false;
        String nombre, apellidos, NIF, numTelefono;
        try {
            do {

                System.out.println("¿Cual es el nombre del reportero?");
                nombre = in.next();
                ReporteroException.validaNombre(nombre);
                System.out.println("¿Cuales son los apellidos del reportero?");
                apellidos = in.next();
                ReporteroException.validaApellidos(apellidos);
                System.out.println("¿Que NIF tiene el reportero?");
                NIF = in.next();
                ReporteroException.validaNIF(NIF);
                System.out.println("¿Cual es el numero de telefono del reportero?");
                numTelefono = in.next();
                ReporteroException.validanNumero(numTelefono);
                //Artista a=Artista.buscaPorNombreArtistico;
                //actuacion.setListaArtistas(a);
                confirmacion = ToolBox.readBoolean();

            } while (confirmacion != true);
            reportero = new Reportero(nombre, apellidos, NIF, numTelefono);
        } catch (ReporteroException ex) {
            Logger.getLogger(Reportero.class.getName()).log(Level.SEVERE, null, ex);
        } 
        in.close();
        return reportero;
    }
     /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaReporteroCaracteres(String rutaFichero) {
        FileWriter escritura = null;
        BufferedWriter bW = null;
        try {
            escritura = new FileWriter(rutaFichero, true);
            bW = new BufferedWriter(escritura);
            bW.write(data() + "\n");
            bW.flush();
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } finally {

            if (bW != null) {
                try {
                    bW.close();
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex.getMessage());
                }
            }
            if (escritura != null) {
                try {
                    escritura.close();
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex.getMessage());
                }
            }
        }
    }
    /**
     * metodo que sirve para recuperar los valores de un fichero y reconstruir los objetos con los datos guardados
     * @param rutaFichero la ruta del fichero del que se va a  los recuperar datos 
     * @return la lista con todos los reporteros guardados en el fichero
     */
    public static ArrayList<Reportero> importaReporteroCaracter(String rutaFichero) {
        ArrayList<Reportero> listaReportero = new ArrayList<Reportero>();
        FileReader fR = null;
        BufferedReader bR = null;
        try {            
            fR = new FileReader(rutaFichero);
            bR = new BufferedReader(fR);
            String lineaActual = "";
            long id;
            String nombre;
            String apellidos;
            String nif;
            String numero;
            while ((lineaActual = bR.readLine()) != null) {
                ArrayList<String> atributos = ToolBox.separaPorCampos(lineaActual);
                id=Long.parseLong(atributos.get(0));
                nombre=atributos.get(1);
                apellidos=atributos.get(2);
                nif=atributos.get(3);
                numero=atributos.get(4);
                Reportero repo = new Reportero(id,nombre,apellidos,nif,numero);
                listaReportero.add(repo);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } finally {
            if (fR != null) {
                try {
                    fR.close();
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex.getMessage());
                }
            }
            if (bR != null) {
                try {
                    bR.close();
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex.getMessage());
                }
            }       
        }
        return listaReportero;
    }
     /**
     * metodo que permite preservar en un fichero binario la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaReporteroBinario(String rutaFichero) {
        FileOutputStream fOS = null;
        ObjectOutputStream escribeObjeto = null;
        try {
            fOS = new FileOutputStream(rutaFichero);
            escribeObjeto = new ObjectOutputStream(fOS);
            escribeObjeto.writeObject(this);
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } finally {
            if (fOS != null) {
                try {
                    fOS.close();
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex.getMessage());
                }
            }
            if (escribeObjeto != null) {
                try {
                    escribeObjeto.close();
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex.getMessage());
                }
            }
        }
    }
    /**
     * metodo que sirve para recuperar las instancias de un fichero binario, que devuelve en una lista 
     * @param rutaFichero la ruta del fichero que se va a utilizar para recuperar la instancia.
     * @return la lista de objetos que estaban guardados en la lista
     */
    public static ArrayList<Reportero> importaReporteroBinario(String rutaFichero) {
        ArrayList<Reportero> listaReporteros = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Reportero repo;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((repo = (Reportero) oIS.readObject()) != null) {
                listaReporteros.add(repo);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        } catch (EOFException ex) {
            // System.out.println("FileNotFoundException: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        } finally {
            if (fIS != null) {
                try {
                    fIS.close();
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex.getMessage());
                }
            }
            if (oIS != null) {
                try {
                    oIS.close();
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex.getMessage());
                }
            }
        }
        return listaReporteros;
    }
}

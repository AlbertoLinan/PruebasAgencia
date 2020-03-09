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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 * @version 1.01
 */
public class Concierto implements Serializable {

    protected long id; //atributo que sirve para identificar al concierto //  valores validos numero entero mayor que 0
    private Date fechaHora; //atributo que sirve para idenfiticar la fechaHora y la hora del concierto// valores validos cadena de caracteres de 20 caracteres
    protected ArrayList<Actuacion> listaActuaciones;//lista que contiene las actuaciones de un concierto //minimo 5 y maximo 10.
    protected String nombreConcierto; //el nombre del concierto // una cadena de caracteres de tamaño maximo 20
    protected long idGira;//el id de la gira a la que pertenece el concierto // un id de gira

    public String getNombreConcierto() {
        return nombreConcierto;
    }

    public void setNombreConcierto(String nombreConcierto) {
        this.nombreConcierto = nombreConcierto;
    }

    public long getIdGira() {
        return idGira;
    }

    public void setIdGira(long idGira) {
        this.idGira = idGira;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public ArrayList<Actuacion> getListaActuaciones() {
        return listaActuaciones;
    }

    public void setListaArtistas(ArrayList<Actuacion> listaActuaciones) {
        this.listaActuaciones = listaActuaciones;
    }

    public void anadeActuacion(Actuacion actuacion) {
        listaActuaciones.add(actuacion);
    }
    /**
     * @param i
     * @return 
     */
    public Actuacion getActuacionByPos(int i) {
        return listaActuaciones.get(i);
    }
    /**
     * metodo constructor de concierto que recibe fecha y hora de comienzo y una lista de actuaciones
     * @param fechaHora fecha y hora de comienzo
     * @param nombreConcierto el nombre del concierto
     * @param listaActuaciones una lista de actuaciones
     * @deprecated sustituido por {@link #Concierto(java.util.Date, java.lang.String, long) }
     */
    protected Concierto(Date fechaHora, ArrayList<Actuacion> listaActuaciones) {
        this.fechaHora = fechaHora;
        this.listaActuaciones = listaActuaciones;
    }
    /**
     * metodo constructor de concierto que recibe la fecha y hora de comienzo, el nombre del concierto y el id de la gira
     * @param fechaHora la fecha y hora de comienzo
     * @param nombreConcierto el nombre del concierto 
     * @param idGira el id de la gira
     */
    protected Concierto(Date fechaHora, String nombreConcierto, long idGira) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.nombreConcierto = nombreConcierto;
        this.idGira = idGira;
    }
    /**
     * metodo constructor privado que es utilizado en la recuperacion de objetos
     * de un fichero de caracteres.
     * @param id el id del cocierto
     * @param fechaHora la fecha y hora de comienzo
     * @param nombreConcierto el nombre del concierto 
     * @param idGira el id de la gira
     */
    protected Concierto(long id, Date fechaHora, String nombreConcierto, long idGira) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.nombreConcierto = nombreConcierto;
        this.idGira = idGira;
    }
    /**
     * constructor que copia una instancia
     * @param c la instancia a copiar
     */
    protected Concierto(Concierto c) {
        this.fechaHora = c.getFechaHora();
        listaActuaciones = c.getListaActuaciones();
    }
    /**
     * constructor por defecto
     */
    protected Concierto() {
        listaActuaciones = new ArrayList<Actuacion>();
    }
    
    @Override
    public String toString() {
        return "Concierto{" + "identificador=" + id + ", fecha=" + fechaHora + '}';
    }
    /**
     * 
     * metodo que devuelve un string con los datos de momentos serados por | con el siguiente formato.
     *                      id|fechahora|nombreconcierto|idgira
     * @return un string con los datos de la clase y el siguiente formato id|nombreArtistico|generoMusica
     */
    public String data() {

        return this.getId() + "|" + this.getFechaHora() + "|" + this.getNombreConcierto() + "|" + this.getIdGira();
    }
    /*
    public Concierto getConciertoById(long id) {
       
        for(Concierto concierto:listaConciertos) {
            if (concierto.getId()==id) {
                return concierto;
            }
        }    
         
        return null;
    }*/
    /*
    public ArrayList<Concierto> getAllConciertos() {
        ArrayList<Concierto> nuevaListaConciertos = new ArrayList<Concierto>();
        for(Concierto concierto:listaConcierto) {
            nuevaListaconciertos.add(concierto);
        } 
         
        return nuevaListaConciertos;
    }*/
    /**
     * metodo que permite crear un concierto mediante el teclado
     * @return devuelve el concierto creado por teclado.
     */
    public static Concierto nuevoConcierto() {
        Concierto concierto = new Concierto();
        Scanner in = new Scanner(System.in);
        boolean confirmacion;
        do {
            System.out.println("Es un concierto invidual o colaborativo");
            String aux = in.next().trim().toLowerCase();
            if (aux == "individual") {
                concierto = new CColaboracion();
            } else if (aux == "colaborativo") {
                concierto = new CIndividual();
            }
            System.out.println("¿Qué día tienes el concierto?");
            Date fecha = ToolBox.readDate();
            concierto.setFechaHora(fecha);

            confirmacion = ToolBox.readBoolean();
        } while (confirmacion != true);
        in.close();
        return concierto;

    }
    /**
     * metodo que permite crear un concierto mediante el teclado usado por las subclases
     * @return devuelve el concierto creado por teclado.
     */
    protected static Concierto nuevoConcierto(Concierto c) {

        Scanner in = new Scanner(System.in);
        boolean confirmacion;
        do {

            System.out.println("cuantas actuaciones tiene el concierto");
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                c.anadeActuacion(Actuacion.nuevaActuacion());
            }

            System.out.println("¿Qué día tienes el concierto?");
            Date fecha = ToolBox.readDate();
            c.setFechaHora(fecha);

            confirmacion = ToolBox.readBoolean();
        } while (confirmacion != true);
        in.close();
        return c;
    }
    
    /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaConciertoCaracteres(String rutaFichero) {
        FileWriter escritura = null;
        BufferedWriter bW = null;
        try {
            escritura = new FileWriter(rutaFichero, true);
            bW = new BufferedWriter(escritura);
            bW.write(data() + "\n");
            bW.flush();

        } catch (IOException ex) {
            Logger.getLogger(Concierto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (bW != null) {
                try {
                    bW.close();
                } catch (IOException ex) {
                    Logger.getLogger(Concierto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (escritura != null) {
                try {
                    escritura.close();
                } catch (IOException ex) {
                    Logger.getLogger(Concierto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    /**
     * metodo que sirve para recuperar los valores de un fichero y reconstruir los objetos con los datos guardados
     * @param rutaFichero la ruta del fichero del que se va a  los recuperar datos 
     * @return la lista con todos los concierto guardados en el fichero
     */
    public static ArrayList<Concierto> importaConciertoCaracter(String rutaFichero) {
        ArrayList<Concierto> listaConciertos = new ArrayList<>();
        FileReader fR = null;
        BufferedReader bR = null;
        try {

            fR = new FileReader(rutaFichero);
            bR = new BufferedReader(fR);
            String lineaActual = "";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            long id;
            Date fechaHora;
            String nombreConcierto;
            long idGira;
            while ((lineaActual = bR.readLine()) != null) {
                ArrayList<String> atributos = ToolBox.separaPorCampos(lineaActual);
                id=Long.parseLong(atributos.get(0));
                fechaHora=df.parse(atributos.get(1));
                nombreConcierto=atributos.get(2);
                idGira=Long.parseLong(atributos.get(3));
                Concierto con = new Concierto(id,fechaHora,nombreConcierto ,idGira);
                listaConciertos.add(con);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("fichero no encontrado");
        } catch (IOException ex) {
            Logger.getLogger(Concierto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fR != null) {
                try {
                    fR.close();
                } catch (IOException ex) {
                    Logger.getLogger(Concierto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bR != null) {
                try {
                    bR.close();
                } catch (IOException ex) {
                    Logger.getLogger(Concierto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return listaConciertos;
        }
    }
     /**
     * metodo que permite preservar en un fichero binario la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaConciertoBinario(String rutaFichero) {
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
     * metodo que sirve para recuperar las instancias de un fichero binario que devuelve en una lista 
     * @param rutaFichero la ruta del fichero que se va a utilizar para recuperar la instancia.
     * @return la lista de objetos que estaban guardados en la lista
     */
    public static ArrayList<Concierto> importaConciertoBinario(String rutaFichero) {
        ArrayList<Concierto> listaConciertos = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Concierto con;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((con = (Concierto) oIS.readObject()) != null) {
                listaConciertos.add(con);
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
                    Logger.getLogger(Concierto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (oIS != null) {
                try {
                    oIS.close();
                } catch (IOException ex) {
                    Logger.getLogger(Concierto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return listaConciertos;
    }
}

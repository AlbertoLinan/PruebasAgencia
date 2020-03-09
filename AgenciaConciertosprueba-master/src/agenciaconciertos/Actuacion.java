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
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author DAW113,DAW102
 * @version 1.00
 */
public class Actuacion {

    protected long id; //atributo que sirve para identificar a la actuacion // valores validos numero entero mayor que 0
    private int numeroSecuencia; // numero de actuacion que forma parte del concierto // valores validos hasta el numero maximo de actuaciones en el concierto
    private int duracion; //numero de minutos que dura la actuacion // valores validos hasta el numero maximo de minutos que dura la actuacion
    private ArrayList<Artista> listaArtistas;//lista de artistas que actuan en la actuacion// valores permitidos minimo 1 y maximo 2
    private long idConcierto;// guarda el concierto de la actuacion
    private Reportero reportero = null;// Guarda el reportero que cubre esa actuacion.//valores validos un objeto reportero cuando se le asigne un reportero y antes de eso null
    private ArrayList<Long> idArtistas=new ArrayList<>();
    private long idReportero;

    //metodos getters y setters
    
    public Reportero getReportero() {
        return reportero;
    }

    public void setReportero(Reportero reportero) {
        this.reportero = reportero;
    }
 
    public long getId() {
        return id;
    }

    public int getNumeroSecuencia() {
        return numeroSecuencia;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdconcierto() {
        return idConcierto;
    }

    public void setIdconcierto(long idConcierto) {
        this.idConcierto = idConcierto;
    }

    public ArrayList<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }

    public void setNumeroSecuencia(int numeroSecuencia) {
        this.numeroSecuencia = numeroSecuencia;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public long getIdConcierto() {
        return idConcierto;
    }

    public void setIdConcierto(long idConcierto) {
        this.idConcierto = idConcierto;
    }

    public ArrayList<Long> getIdArtistas() {
        return idArtistas;
    }

    public void setIdArtistas(ArrayList<Long> idArtistas) {
        this.idArtistas = idArtistas;
    }

    public long getIdReportero() {
        return idReportero;
    }

    public void setIdReportero(long idReportero) {
        this.idReportero = idReportero;
    }
    
    /**
     * metodo constructor de la clase actuacion
     * @param numeroSecuencia el numero de secuencia de la actuacion
     * @param duracion la duracion de la actuacion
     * @param idArtistas la lista de artistas que participan en la actuacion
     * @param idConcierto  el concierto de la actucion
     */
    public Actuacion(int numeroSecuencia, int duracion, long idConcierto,ArrayList<Long> idArtistas,long idReportero) {
        this.numeroSecuencia = numeroSecuencia;
        this.duracion = duracion;
        this.idConcierto = idConcierto;
        this.idArtistas=idArtistas;
        this.idReportero=idReportero;
    }
    /**
     * metodo que se utiliza en la clase baseDatos para la generacion de actuaciones.
     * @param id el id de la actuacion
     * @param numeroSecuencia el numero de la secuencien de la actuacion
     * @param duracion la duracion de la actuacion en minutos
     * @param listaArtistas los artitas que participan en la actuacion
     */
    public Actuacion(long id, int numeroSecuencia, int duracion, ArrayList<Artista> listaArtistas) {
        this.id = id;
        this.numeroSecuencia = numeroSecuencia;
        this.duracion = duracion;
        this.listaArtistas = listaArtistas;
    }

    /**
     * metodo constructor que usaran los metodos para recuperar los objetos.
     * @param id el id de la actuacion
     * @param numeroSecuencia el numero de la secuencia de la actuacion
     * @param duracion la duracion en minutos 
     * @param idArtistas la lista de id de los artistas
     * @param idReportero el id del reportero
     * @param idConcierto el id del concierto
     */
    private Actuacion(long id, int numeroSecuencia, int duracion,ArrayList<Long> idArtistas, long idReportero, long idConcierto) {
        this.id = id;
        this.numeroSecuencia = numeroSecuencia;
        this.duracion = duracion;
        this.idArtistas = idArtistas;
        this.idConcierto = idConcierto;
        this.idReportero = idReportero;
    }
    /**
     * metodo de copia de la clase Actuacion.
     * @param a la actuacion a copiar.
     */
    public Actuacion(Actuacion a) {
        this.numeroSecuencia = a.getNumeroSecuencia();
        this.duracion = a.getDuracion();
        this.listaArtistas = a.getListaArtistas();
        this.idArtistas=a.getIdArtistas();
        this.idConcierto = a.getIdconcierto();
        this.idReportero=a.getIdReportero();
    }
    /**
     * constructor por defecto
     */
    public Actuacion() {
    }

    @Override
    public String toString() {
        return "Actuacion{" + "identificador=" + id + ", numeroSecuencia=" + numeroSecuencia + ", duracion=" + duracion + '}';
    }
     /**
     * metodo que devuelve un string con los datos de momentos serados por | con el siguiente formato.
     *                      id|numeroSecuencia|duracion|idartistas|idReportero|idConcierto 
     * @return un string con los datos de la clase y el siguiente formato id|numeroSecuencia|duracion|idartistas|idReportero|idConcierto 
     */
    public String data() {
        return this.getId() + "|"+this.getNumeroSecuencia()+"|"+ this.getDuracion()+"|"+ this.getIdArtistas() + "|" + this.getIdReportero()+ "|" + this.getIdConcierto();
    }
    /*
    public Actuacion getActuacionById(long id) {
        for (Actuacion actuacion : listaActuaciones) {
            if (actuacion.getId() == id) {
                return actuacion;
            }
        }
        return null;
    }*/
    /*
    public ArrayList<Actuacion> getAllActuacion() {
        ArrayList<Actuacion> nuevaListaActuacion = new ArrayList<Actuacion>();
        for(Actuacion actuacion:listaActuaciones) {
            nuevaListaDescuentos.add(descuento);
        } 
        
        return nuevaListaActuacion;
    } */
    /**
     * metodo que permite crear un actuacion mediante el teclado
     * @return devuelve el actuacion creado por teclado.
     */
    public static Actuacion nuevaActuacion() {
        Actuacion actuacion = new Actuacion();
        Scanner in = new Scanner(System.in);
        boolean confirmacion;
        do {
            System.out.println("¿En qué posicion es la actuacion?");
            actuacion.setNumeroSecuencia(in.nextInt());
            System.out.println("¿Cuánto dura la actuacion?");
            actuacion.setDuracion(in.nextInt());
            System.out.println("Dame nombre Artistico");
            //Artista a=Artista.buscaPorNombreArtistico();
            //actuacion.setListaArtistas(a);
            confirmacion = ToolBox.readBoolean();
        } while (confirmacion != true);
        in.close();
        return actuacion;
    }

    /**
     * Metodo que Asigna el reportero a esta actuacion.
     */
    public void asignaReporteroActuacion() { //throws formatoNifIncorrecto,reporteroNoExiste
        if (reportero != null) {
            //throw new ActuacionYaTieneReporteroAsignado();
        }
        Scanner in = new Scanner(System.in);
        System.out.println("introduzca el nif del reportero: NNNNL N numero L letra");
        String nif = in.nextLine().trim().toLowerCase();
        char letra = nif.charAt(nif.length() - 1);
        //he puesto tamano 5 por poner uno.
        if (nif.length() != 5 && "0123456789".indexOf(letra) != -1) {
            //throw new formatoNifIncorrecto();
        }//compruebo el resto de caracteres
        for (int i = 0; i < nif.length() - 1; i++) {
            letra = nif.charAt(i);
            if ("0123456789".indexOf(letra) == -1) {
                //throw new formatoNifIncorrecto();
            }
        }
        Reportero rep = BaseDatos.buscaReporteroByNIF(nif);
        if (rep == null) {
            //throw new reporteroNoExiste
        }
        reportero = rep;
    }
    /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaActuacionCaracteres(String rutaFichero) {
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
     * @return la lista con todos los reportero guardados en el fichero
     */
    public static ArrayList<Actuacion> importaActuacionCaracter(String rutaFichero) {
        ArrayList<Actuacion> listaActuaciones = new ArrayList<Actuacion>();
        FileReader fR = null;
        BufferedReader bR = null;
        try {

            fR = new FileReader(rutaFichero);
            bR = new BufferedReader(fR);
            String lineaActual = "";
            long id;
            int numeroSecuencia; 
            int duracion;
            ArrayList<Long> idArtistas;
            long idReportero;
            long idConcierto;
            while ((lineaActual = bR.readLine()) != null) {
                ArrayList<String> atributos = ToolBox.separaPorCampos(lineaActual);
                id=Long.parseLong(atributos.get(0));
                numeroSecuencia=Integer.parseInt(atributos.get(1));
                duracion=Integer.parseInt(atributos.get(2));
                //para meter una lista de idartistas separados por ","  
                String[] listaIdArtistas=atributos.get(3).split(",");
                // creo una nueva lista vacia a cada iteracion
                idArtistas=new ArrayList<>();
                //recorro la lista de String y la convierto en Long.
                for(String idArtista:listaIdArtistas){     
                    idArtistas.add(Long.parseLong(idArtista));
                }
                idReportero=Long.parseLong(atributos.get(4));
                idConcierto=Long.parseLong(atributos.get(5));
                Actuacion act = new Actuacion(id,numeroSecuencia,duracion ,idArtistas,idReportero,idConcierto );
                listaActuaciones.add(act);
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
            return listaActuaciones;
        }
    }
    /**
     * metodo que permite preservar en un fichero binario la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaActuacionBinario(String rutaFichero) {
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
    public static ArrayList<Actuacion> importaActuacionBinario(String rutaFichero) {
        ArrayList<Actuacion> listaActuaciones = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Actuacion act;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((act = (Actuacion) oIS.readObject()) != null) {
                listaActuaciones.add(act);
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
        return listaActuaciones;
    }
}

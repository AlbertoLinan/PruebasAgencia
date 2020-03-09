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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Jairo
 * @version 1.0
 */
public class Gira {

    protected long id;//atributo que sirve para identificar a la gira //  valores validos numero entero mayor que 0
    public Date fechaApertura;//atributo que sirve para identificar la fecha de apertura// valores validos cadena de caracteres de 20 caracteres
    public Date fechaCierre;//atributo que sirve para identificar la fecha de cierre // valores validos cadena de caracteres de 20 caracteres
    private String nombre;// atributo que sirve para identificar el nombre de la gira // valores validos "" si no se ha aportado ningun codigo y un codigo si se ha aportad
    private ArrayList<Concierto> listaConciertos;//lista de conciertos que hay en la gira// valores permitidos minimo 1 y maximo N
    private Informe informe;//objeto que guardara el informe asociado a la gira
    private long idInforme;//atributo que sirve para identificar al informe

    // getters y setters 
    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombreNegociar(String nombreNegociar) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public ArrayList<Concierto> getListaConciertos() {
        return listaConciertos;
    }

    public void setListaConciertos(ArrayList<Concierto> listaConciertos) {
        this.listaConciertos = listaConciertos;
    }

    // Constructor con argumentos
    /**
     * Crea una instancia de Gira con los siguientes atributos
     *
     * @param id id de la gira
     * @param fechaApertura fecha de apertura de la gira
     * @param fechaCierre fecha de cierre de la gira
     * @param nombre nombre de la gira
     * @param listaConciertos lista de conciertos de la gira
     */
    public Gira(long id, Date fechaApertura, Date fechaCierre, String nombre, ArrayList<Concierto> listaConciertos) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.nombre = nombre;
        this.listaConciertos = listaConciertos;
    }
    
    /**
     * metodo constructor privado que es utilizado en la recuperacion de objetos de un fichero de caracteres.
     * @param id id del objeto
     * @param idInforme id del informe asociado a la gira
     * @param nombre nombre de la gira
     * @param fechaApertura fecha de apertura de la gira
     * @param fechaCierre fecha de cierre de la gira
     */
    private Gira(long id,long idInforme,String nombre, Date fechaApertura, Date fechaCierre) {
        this.id = id;
        this.idInforme=idInforme;
        this.nombre = nombre;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
    }
    
    //constructor de copia
    /**
     * Crea una instancia de Gira a partir de otra, copiando cada atributo
     * @param g la gira que se va a copiar
     */
    public Gira(Gira g) {
        this.fechaApertura = g.getFechaApertura();
        this.fechaCierre = g.getFechaCierre();
        this.listaConciertos = g.getListaConciertos();
    }
    
    //constructor por defecto
    /**
     * Crea una instancia de Gira con los valores por defecto para los atributos
     */
    public Gira() {
        listaConciertos = new ArrayList<Concierto>();
    }

    //getAll, getById, data y toString
    /**
     * Devuelve un <code>String</code> con los datos de la instancia de gira
     * que llama al metodo
     *
     * @return un <code>String</code> con los atributos del objeto en este
     * orden: <code>id</code>, <code>fechaApertura</code>, <code>fechaCierre</code>,
     * <code>nombre</code>, <code>listaConciertos</code>, <code>informe</code>
     */
    @Override
    public String toString() {
        return "Gira{" + "id=" + id + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", nombre=" + nombre + ", listaConciertos=" + listaConciertos + ", informe=" + informe + '}';
    }

    /**
     * Devuelve un <code>String</code> con los atributos formateados para exportar a un fichero de texto
     * @return un <code>String</code> con los atributos del objeto en este orden: <code>id</code>, <code>idInforme</code>, <code>nombre</code>, <code>fechaApertura</code>, <code>fechaCierrepertura</code>, <code>fechaRecogida</code>, <code>relieve</code>, separados por una barra vertical
     */
    public String data() {
        return this.getId() + "|"+this.idInforme+"|"+this.nombre + this.getFechaApertura() + "|" + this.getFechaCierre();

    }

    public Gira getGiraById(long id) {
        /*for (Gira gira : listaGiras) {
           if (gira.getId() == id) {
               return gira;
           }
        }*/
        return null;
    }

    public ArrayList<Gira> getAllGira() {
        ArrayList<Gira> nuevaListaGiras = new ArrayList<Gira>();
        /*
        for(Gira gira:listaGira) {
            nuevaListaGira.add(gira);
        }
         */
    /*Este método recorrerá un ArrayList con todas las giras comparando con el id 
        que le introduzcamos, y devolverá esa gira si es que existe o 
        nulo si es que no existe*/
        return nuevaListaGiras;
    }

    /**
     * Crea una nueva instancia de la clase <code>Gira</code> pidiendo
     * al usuario por pantalla que introduzca los datos
     * @return el <code>Gira</code> que se crea con el método
     */
    public Gira nuevoGira() {
        Gira gira = new Gira();

        Scanner in = new Scanner(System.in);
        boolean confirmacion;
        do {
            System.out.println(" ¿Cuándo empieza la gira?");
            Date fecha = ToolBox.readDate();
            gira.setFechaApertura(fecha);
            System.out.println(" ¿Cuándo acaba la gira?");
            fecha = ToolBox.readDate();
            gira.setFechaCierre(fecha);
            confirmacion = ToolBox.readBoolean();
        } while (confirmacion != true);
        in.close();
        return gira;
    }

    /**
     * Metodo que recorre la lista de conciertos en la gira
     * @return el concierto de la lista
     */
    public Concierto getConciertoByPos(int i) {
        return listaConciertos.get(i);
    }
    
    /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaGiraCaracteres(String rutaFichero) {
        FileWriter escritura = null;
        BufferedWriter bW = null;
        try {
            escritura = new FileWriter(rutaFichero, true);
            bW = new BufferedWriter(escritura);
            bW.write(data()+"\n");
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
    public static ArrayList<Gira> importaGiraCaracter(String rutaFichero) {
        ArrayList<Gira> listaGira = new ArrayList<Gira>();
        FileReader fR = null;
        BufferedReader bR = null;
        try {

            fR = new FileReader(rutaFichero);
            bR = new BufferedReader(fR);
            String lineaActual = "";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            while ((lineaActual = bR.readLine()) != null) {
                ArrayList<String> atributos = ToolBox.separaPorCampos(lineaActual);
                Gira gira = new Gira(Long.parseLong(atributos.get(0)),Long.parseLong(atributos.get(1)),atributos.get(2),df.parse(atributos.get(3)),df.parse(atributos.get(4)));
                listaGira.add(gira);
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
                return listaGira;
        }
    }

    /**
     * metodo que permite preservar en un fichero binario la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */

    public void exportaGiraBinario(String rutaFichero) {
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
    public static ArrayList<Gira> importaGiraBinario(String rutaFichero) {
        ArrayList<Gira> listaGira = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Gira gira;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((gira = (Gira) oIS.readObject()) != null) {
                listaGira.add(gira);
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
        return listaGira;
    }
}

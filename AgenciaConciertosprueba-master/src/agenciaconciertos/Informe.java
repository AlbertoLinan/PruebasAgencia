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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jairo
 * @version 1.0
 */
public class Informe {

    protected long id;//atributo que sirve para identificarel ID //  valores validos numero entero mayor que 0
    private boolean revisado = false;//Campo para indicar si está revisado o no // valores validos true o false. 
    private String descripcion;//atributo que sirve para guardar la descripcion del informe// valores validos cadena de caracteres de 20 caracteres
    private Gira gira;//objeto que guardara la gira asociada al informe

    //getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        try {
            InformeException.validaDescripcion(descripcion);
            this.descripcion = descripcion;
        } catch (InformeException ex) {
            System.out.println("La descripcion no es correcta" + ex.getMessage());
            this.descripcion = "";
        }
    }

    public Gira getGira() {
        return gira;
    }

    public void setGira(Gira gira) {
        this.gira = gira;
    }

    //constructores con argumentos
    /**
     * Crea una instancia de Informe con los atributos propios de la clase
     * @param id el id del informe
     * @param descripcion la descripcion del informe
     * @throws InformeException si la descripcion esta vacia o tiene mas de 200 caracteres
     * @param gira
     */
    public Informe(long id, String descripcion, Gira gira) {
        this.id = id;
        this.revisado = false;
        try {
            InformeException.validaDescripcion(descripcion);
            this.descripcion = descripcion;
        } catch (InformeException ex) {
            System.out.println("La descripcion no es correcta" + ex.getMessage());
            this.descripcion = "";
        }
    }
    
    /**
     * metodo constructor privado que es utilizado en la recuperacion de objetos de un fichero de caracteres.
     * @param id id del objeto
     * @param revisado estado del informe
     * @param descripcion la descripcion del informe
     */
    private Informe(long id, boolean revisado, String descripcion) {
        this.id = id;
        this.revisado = revisado;
        this.descripcion = descripcion; 
    }
    
    //constructor de copia
    /**
     * Crea una instancia de Informe a partir de otra, copiando cada atributo
     * @param i el Informe que se va a copiar
     * @throws InformeException si la descripcion esta vacia o tiene mas de 200 caracteres
     */
    public Informe(Informe i) {
        this.id = i.getId();
        this.revisado = i.isRevisado();
        try {
            InformeException.validaDescripcion(descripcion);
            this.descripcion = i.getDescripcion();
        } catch (InformeException ex) {
            System.out.println("La descripcion no es correcta" + ex.getMessage());
            this.descripcion = "";
        }
    }
    
    //constructor por defecto
    /**
     * Crea una instancia de Informe con los valores por defecto para los atributos
     */
    public Informe() {
    }

    //getAll, getById, data y toString
    /**
     * Devuelve un <code>String</code> con los datos de la instancia de cliente que llama al metodo
     * @return un <code>String</code> con los atributos del objeto en este orden: <code>id</code>, <code>revisado</code>, <code>descripcion</code>, <code>gira</code>
     */
    @Override
    public String toString() {
        return "Informe{" + "identificador=" + id + ", revisado=" + revisado + ", descripcion=" + descripcion + ",gira=" + gira + '}';
    }

    /**
     * Devuelve un <code>String</code> con los atributos formateados para exportar a un fichero de texto
     * @return un <code>String</code> con los atributos del objeto en este orden: <code>id</code>, <code>revisado</code>, <code>descripcion</code>,separados por una barra vertical
     */
    public String data() {
        return this.getId() + "|" + this.isRevisado() + "|" + this.getDescripcion();

    }

    /**
     * Prueba para recorrer informe en la base de datos
     */
    public Informe getInformeById(long id) {
        /*for (Informe informe : listaInformes) {
            if (informe.getId() == id) {
                return informe;
            }
        }*/
        return null;
    }

    public ArrayList<Informe> getAllInforme() {
        ArrayList<Informe> nuevaListaInforme = new ArrayList<Informe>();
        /*
        for (Informe informe:listaInformes) {
              nuevaListaInformes.add(informe);
          } 
         */
    /*Este método recorrerá un ArrayList con todos los informes, comparando 
        con el id que le introduzcamos, y devolverá el informe si es que existe o 
        nulo si es que no existe*/
        return nuevaListaInforme;
    }

    /**
     * Crea una nueva instancia de la clase <code>Informe</code> pidiendo
     * al usuario por pantalla que introduzca los datos
     *
     * @return el <code>Informe</code> que se crea con el método
     */
    public Informe nuevoInforme() {
        Informe informe = new Informe();
        Scanner in = new Scanner(System.in);
        boolean confirmacion;
        do {
            System.out.println("¿Se ha revisado el informe?");
            informe.setRevisado(ToolBox.readBoolean());
            System.out.println("Añade descripción");
            String descrUser = in.nextLine();

            try {
                InformeException.validaDescripcion(descrUser);
                informe.setDescripcion(descrUser);
            } catch (InformeException ex) {
                informe.setDescripcion("");
            }

            System.out.println("Introduzca el nombre de la gira");
            String nombreGira = in.nextLine();
            Gira g = BaseDatos.buscaGiraByNombre(nombreGira);
            confirmacion = ToolBox.readBoolean();
        } while (confirmacion != true);
        in.close();
        return informe;
    }

    /**
     * Metodo para ver si esta revisado el informe
     * @return devuelve true si esta revisado o null si no existe el informe
     */
    public boolean revisarInforme() {
        boolean ret = false;
        if (this != null) {
            if (this.isRevisado() == false) {
                this.setRevisado(true);
            }
            System.out.println("El informe " + this.getId() + " ha sido revisado correctamente.");
            ret = true;
        } else {
            System.out.println("No existe el informe.");
            ret = false;
        }
        return ret;
    }
    
    /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaInformeCaracteres(String rutaFichero) {
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
    public static ArrayList<Informe> importaInformeCaracter(String rutaFichero) {
            ArrayList<Informe> listaInforme = new ArrayList<Informe>();
        FileReader fR = null;
        BufferedReader bR = null;
        try {

            fR = new FileReader(rutaFichero);
            bR = new BufferedReader(fR);
            String lineaActual = "";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            while ((lineaActual = bR.readLine()) != null) {
                ArrayList<String> atributos = ToolBox.separaPorCampos(lineaActual);
                Informe informe = new Informe(Long.parseLong(atributos.get(0)),Boolean.valueOf(atributos.get(1)),atributos.get(2));
                listaInforme.add(informe);
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
                return listaInforme;
        }
    }
    
    /**
     * metodo que permite preservar en un fichero binario la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaInformeBinario(String rutaFichero) {
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
    public static ArrayList<Informe> importaInformeBinario(String rutaFichero) {
        ArrayList<Informe> listaInforme = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Informe informe;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((informe = (Informe) oIS.readObject()) != null) {
                listaInforme.add(informe);
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
        return listaInforme;
    }
}

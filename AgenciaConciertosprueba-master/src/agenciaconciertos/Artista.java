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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW102
 * @version 1.00
 */
public class Artista implements Serializable {

    
    protected long id;//atributo que sirve para identificar al artista |  valores validos numero entero mayor que 0
    private String  nombreArtistico; //nombre artistico del artista | valores validos cadena de caracteres de 20 caracteres pudiendo tener simbolos y numeros
    private String generoMusica; //genero de musica del artista | valores validos cadena de caracteres de 20 caracteres pudiendo tener simbolos y numeros
    
    public long getId() {
        return id;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public String getGeneroMusica() {
        return generoMusica;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public void setGeneroMusica(String generoMusica) {
        this.generoMusica = generoMusica;
    }
    /**
     * metodo contructor de la clase Artista
     * @param nombreArtistico el nombre artistisco del artista
     * @param generoMusica el genero de musica del artsta
     */
    public Artista(String nombreArtistico, String generoMusica) {
        this.nombreArtistico = nombreArtistico;
        this.generoMusica = generoMusica;
    }
    /**
     * metodo constructor privado que es utilizado en la recuperacion de objetos de uin fichero de caracteres.
     * @param id el id del artista
     * @param nombreArtistico el nombre artistisco del artista
     * @param generoMusica el genero de musica del artsta
     */
    private Artista (long id, String nombreArtistico, String generoMusica) {
        this.id = id;
        this.nombreArtistico = nombreArtistico;
        this.generoMusica = generoMusica;
    }
    /**
     * metodo constructor que copia una instancia
     * @param a la instacia a copiar
     */
     public Artista(Artista a) {
        this.nombreArtistico = a.getNombreArtistico();
        this.generoMusica = a.getGeneroMusica();
    }
    /**
     * metodo constructor por defecto
     */
    public Artista(){
       
    }
    @Override
    public String toString() {
        return "Artista{" + "identificador=" + id + ", nombreArtistico=" + nombreArtistico + ", generoMusica=" + generoMusica + '}';
    }
    /**
     * 
     * metodo que devuelve un string con los datos de momentos serados por | con el siguiente formato.
     *                      id|nombreArtistico|generoMusica
     * @return un string con los datos de la clase y el siguiente formato id|nombreArtistico|generoMusica
     */
     
    public String data() { 
        return this.getId()+"|"+this.getNombreArtistico()+"|"+this.getGeneroMusica();
    }/*
    public Artista getArtistaById (long id){
      
        for(Artista artista:listaArtista){
            if(artista.getId()==id){
                return artista;
            }
        }
        
        return null;
    }*/
    /*
    public  ArrayList<Artista> getAllArtista (){
        ArrayList<Artista> nuevaLista=new ArrayList<Artista>();
        for(Artista artista:listaArtista){
            if(artista.getId()==id){
                nuevaLista.add(artista);
            }
        }
        return nuevaLista;
    }
    */
    /**
     * metodo que permite crear un Artista mediante el teclado
     * @return devuelve el Artista creado por teclado.
     */
    public static Artista nuevoArtista() { 
        Artista artista=new Artista();
        Scanner in=new Scanner(System.in);
        boolean confirmacion; 
        do{    
        System.out.println("¿Cuál es el nombre artistico del artista?"); 
        artista.setNombreArtistico(in.next());
        System.out.println(" ¿Cuál es el genero musical del artista?");
        artista.setGeneroMusica(in.next());
        confirmacion=ToolBox.readBoolean();
        }while (confirmacion!=true);
        in.close();
        return artista; 
    }
    /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaArtistaCaracteres(String rutaFichero) {
        FileWriter escritura = null;
        BufferedWriter bW = null;
        try {
            escritura = new FileWriter(rutaFichero, true);
            bW = new BufferedWriter(escritura);
            bW.write(data()+"\n");
            bW.flush();

        } catch (IOException ex) {
            Logger.getLogger(Artista.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (bW != null) {
                try {
                    bW.close();
                } catch (IOException ex) {
                    Logger.getLogger(Artista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (escritura != null) {
                try {
                    escritura.close();
                } catch (IOException ex) {
                    Logger.getLogger(Artista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    /**
     * metodo que sirve para recuperar los valores de un fichero y reconstruir los objetos con los datos guardados
     * @param rutaFichero la ruta del fichero del que se va a  los recuperar datos 
     * @return la lista con todos los artistas guardados en el fichero
     */
    public static ArrayList<Artista> importaArtistaCaracter(String rutaFichero) {
        ArrayList<Artista> listaArtistas = new ArrayList<Artista>();
        FileReader fR = null;
        BufferedReader bR = null;
        try {

            fR = new FileReader(rutaFichero);
            bR = new BufferedReader(fR);
            String lineaActual = "";
            long id;
            String nombreArtistico; 
            String generoMusica;
            while ((lineaActual = bR.readLine()) != null) {
                ArrayList<String> atributos = ToolBox.separaPorCampos(lineaActual);
                id=Long.parseLong(atributos.get(0));
                nombreArtistico=atributos.get(1);
                generoMusica=atributos.get(2);
                Artista art = new Artista(id,nombreArtistico ,generoMusica );
                listaArtistas.add(art);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("fichero no encontrado");
        } catch (IOException ex) {
            Logger.getLogger(Artista.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fR != null) {
                try {
                    fR.close();
                } catch (IOException ex) {
                    Logger.getLogger(Artista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bR != null) {
                try {
                    bR.close();
                } catch (IOException ex) {
                    Logger.getLogger(Artista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return listaArtistas;
        }
    }
     /**
     * metodo que permite preservar en un fichero binario la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaArtistaBinario(String rutaFichero) {
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
    public static ArrayList<Artista> importaArtistaBinario(String rutaFichero) {
        ArrayList<Artista> listaArtistas = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Artista art = null;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((art = (Artista) oIS.readObject()) != null) {
                listaArtistas.add(art);
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
                    Logger.getLogger(Artista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (oIS != null) {
                try {
                    oIS.close();
                } catch (IOException ex) {
                    Logger.getLogger(Artista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return listaArtistas;
    }
}

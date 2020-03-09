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
 * @author DAW113 DAW101
 * @version 1.00
 */
public class Descuento implements Serializable {
    protected long id;
    private String codigoDescuento; // identificar el código de descuento // valores validos cadena de caracteres de 20 caracteres no pudiendo tener simbolos y numeros
    public Date fechaValidez; // Cuando va a caducar el codigo descuento // valores validos cadena de caracteres de 20 caracteres no pudiendo tener simbolos y numeros
    private double cantidadDescontada; // Cantidad que se descontará, se calculará restando el precio total menos el codigo descuento // valores validos un numero entero mayor que 0
    
    public String getCodigoDescuento() {
        return codigoDescuento;
    }

    public long getId() {
        return id;
    }
    
    public Date getFechaValidez() {
       return fechaValidez;
    }
    
    public double getCantidadDescontada() {
        return cantidadDescontada;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setCodigoDescuento(String codigoDescuento) {
        this.codigoDescuento = codigoDescuento;
    }

    public void setFechaValidez(Date fechaValidez) {
        this.fechaValidez = fechaValidez;
    }

    public void setCantidadDescontada(double cantidadDescontada) {
        this.cantidadDescontada = cantidadDescontada;
    }       
/**
 * 
 * @param codigoDescuento código de descuento
 * @param fechaValidez Cuando va a caducar el codigo descuento
 * @param cantidadDescontada Cantidad que se descontará, se calculará restando el precio total menos el codigo descuento
 */
    public Descuento(String codigoDescuento, Date fechaValidez, double cantidadDescontada) {
        this.codigoDescuento = codigoDescuento;
        this.fechaValidez = fechaValidez;
        this.cantidadDescontada = cantidadDescontada;
    }
    /**
     * recibe un descuento y establece los valores que le pasas por el argumento
     * @param d es el descuento que quieres copiar
     */
    public Descuento(Descuento d) {
        this.codigoDescuento = d.getCodigoDescuento();
        this.fechaValidez = d.getFechaValidez();
        this.cantidadDescontada = d.getCantidadDescontada();
    }
    public Descuento() {
    }
    /**
     * 
     * @param id id del descuento
     * @param codigoDescuento identificar el código de descuento
     * @param fechaValidez fecha de validez del codigo de descuento
     * @param cantidadDescontada cantidad que te descuenta el codigo de descuento.
     */
    private Descuento(long id, String codigoDescuento, Date fechaValidez, double cantidadDescontada) {
        this.id = id;
        this.codigoDescuento = codigoDescuento;
        this.fechaValidez = fechaValidez;
        this.cantidadDescontada = cantidadDescontada;
    }
    
    @Override
    public String toString() {
        return "Descuento{" + "codigoDescuento=" + codigoDescuento + ", fechaValidez=" + fechaValidez + ", cantidadDescontada=" + cantidadDescontada + '}';
    }
    
    public String data() {
    
        return this.getId()+"|"+this.getFechaValidez()+"|"+this.getCantidadDescontada()+"|"+this.getCodigoDescuento();
    }
    public Descuento getDescuentoById (long id){
        /*
        for(Descuento descuento:listaDescuentos) {
            if (descuento.getId()==id) {
                return descuento;
            }
        }    
        */
        return null;
    }
    public ArrayList<Descuento> getAllDescuento (){
        ArrayList<Descuento> nuevaListaDescuentos=new ArrayList<Descuento>();
        /*for(Descuento descuento:listaDescuentos) {
            nuevaListaDescuentos.add(descuento);
        } 
        */  
        return nuevaListaDescuentos;
    }
    /**
 * 
 * @return devuelve fun nuevo descuento introducido por teclado
 */
    public static Descuento nuevoDescuento (){
        Descuento descuento= new Descuento();
        boolean confirmacion;
        Scanner sc= new Scanner(System.in);
        do{            
            System.out.println("¿cuál es el codigo de descuento?");
            descuento.setCodigoDescuento(sc.next());
            System.out.println("¿Hasta cuando es la fecha de validez? formato:dd/MM/yyyy hh:mm");
            descuento.setFechaValidez(ToolBox.readDate());
            System.out.println("¿Cuál es la cantidad descontada?");
            descuento.setCantidadDescontada(sc.nextDouble());
            System.out.println("Pulse s para confirmar:");
            confirmacion=ToolBox.readBoolean();
        } while (!confirmacion);
        return descuento;
    } 
    
    /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    
        public void exportaDescuentoCaracteres(String rutaFichero) {
        FileWriter escritura = null;
        BufferedWriter bW = null;
        try {
            escritura = new FileWriter(rutaFichero, true);
            bW = new BufferedWriter(escritura);
            bW.write(data()+"\n");
            bW.flush();

        } catch (IOException ex) {
            Logger.getLogger(Descuento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (bW != null) {
                try {
                    bW.close();
                } catch (IOException ex) {
                    Logger.getLogger(Descuento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (escritura != null) {
                try {
                    escritura.close();
                } catch (IOException ex) {
                    Logger.getLogger(Descuento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

/**       
     * metodo que sirve para recuperar los valores de un fichero y reconstruir los objetos con los datos guardados
     * @param rutaFichero la ruta del fichero del que se va a  los recuperar datos 
     * @return la lista con todos los descuentos guardados en el fichero
     */
     
    public static ArrayList<Descuento> importaDescuentoCaracter(String rutaFichero) {
        ArrayList<Descuento> listaDescuentos = new ArrayList<Descuento>();
        FileReader fR = null;
        BufferedReader bR = null;
        try {

            fR = new FileReader(rutaFichero);
            bR = new BufferedReader(fR);
            String lineaActual = "";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            while ((lineaActual = bR.readLine()) != null) {
                ArrayList<String> atributos = ToolBox.separaPorCampos(lineaActual);
                long id = Long.parseLong(atributos.get(0));
                String codigoDescuento = atributos.get(1);
                Date fecha = df.parse(atributos.get(2));
                double precioTotal = Double.parseDouble(atributos.get(3));
                Descuento des= new Descuento (id, codigoDescuento, fecha, precioTotal);
                listaDescuentos.add(des);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("fichero no encontrado");
        } catch (IOException ex) {
            Logger.getLogger(Descuento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fR != null) {
                try {
                    fR.close();
                } catch (IOException ex) {
                    Logger.getLogger(Descuento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bR != null) {
                try {
                    bR.close();
                } catch (IOException ex) {
                    Logger.getLogger(Descuento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return listaDescuentos;
        }
    }
/**
     * metodo que permite preservar en un fichero binario la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaDescuentoBinario(String rutaFichero) {
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
    
    public static ArrayList<Descuento> importaDescuentoBinario(String rutaFichero) {
        ArrayList<Descuento> listaDescuentos = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Descuento des;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((des= (Descuento) oIS.readObject()) != null) {
                listaDescuentos.add(des);
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
                    Logger.getLogger(Descuento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (oIS != null) {
                try {
                    oIS.close();
                } catch (IOException ex) {
                    Logger.getLogger(Descuento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return listaDescuentos;
    }
}
        
  




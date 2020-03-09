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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase contiene los atributos y metodos de la clase compra
 *
 * @author Daw101
 * @version 1.00
 * @see Descuento
 * @see Usuario
 * @see Entrada
 * @see Reserva
 */
public class Compra implements Serializable{

    protected long id;//atributo que sirve para identificar a la compra |  valores validos numero entero mayor que 0
    private int numEntradas;//numero de entradas de la compra | valores validos hasta el maximo numero de entradas del concierto.
    private double precioTotal;//precio que se pagara , se calculara a partir del precio de la entrada y numEntradas de la compra
    //valores validos de precio un numero entero o real mayor que 0
    private String metodoPago;//atributo que guarda el metodo de pago | valores validos podran ser en efectivo y con tarjeta
    private long idDescuento;
    private Date fechaCompra;
    //private Usuario usuarioCompra;
    private long idUsuario;
    private long idEntrada;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(long idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getNumEntradas() {
        return numEntradas;
    }

    public long getId() {
        return id;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public long getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(long idDescuento) {
        this.idDescuento = idDescuento;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setNumEntradas(int numEntradas) {
        this.numEntradas = numEntradas;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * 
     * @param numEntradas numero de entradas de la compra.
     * @param precioTotal precio total de la compra.
     * @param metodoPago metodo de pago que se empleará en la compra.
     * @param codigoDescuento codigo de descuento que se puede emplear o no en la compra.
     * @param usuarioCompra usuario que compra la entrada.
     */
    public Compra(int numEntradas, double precioTotal, String metodoPago, String codigoDescuento, Usuario usuarioCompra) {
        this.numEntradas = numEntradas;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        // this.usuarioCompra=usuarioCompra;

    }
/**
 * 
 * @param id identificador de la compra
 * @param numEntradas numero de entradas de la compra.
 * @param precioTotal precio total de la compra.
 * @param metodoPago metodo de pago que se empleará en la compra.
 * @param idDescuento codigo de descuento que se puede emplear o no en la compra.
 * @param fechaCompra fecha de la compra de la entrada
 * @param idUsuario id del usuario que compra la entrada
 * @param idEntrada id de la entrada que se ha comprado
 */
    public Compra(long id, int numEntradas, double precioTotal, String metodoPago, long idDescuento, Date fechaCompra, long idUsuario, long idEntrada) {
        this.id = id;
        this.numEntradas = numEntradas;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.idDescuento = idDescuento;
        this.fechaCompra = fechaCompra;
        this.idUsuario = idUsuario;
        this.idEntrada = idEntrada;
    }
    /**
     * recibe una compra y establece los valores que le pasas por el argumento
     * @param c es la compra que quieres copiar
     */

    public Compra(Compra c) {
        this.numEntradas = c.getNumEntradas();
        this.precioTotal = c.getPrecioTotal();
        this.metodoPago = c.getMetodoPago();
        this.idDescuento = c.getIdDescuento();
        this.fechaCompra = c.getFechaCompra();
        this.idUsuario = c.getIdUsuario();
        this.idEntrada = c.getIdEntrada();
    }

    public Compra() {
    }

    @Override
    public String toString() {
        return "Compra{" + "numEntradas=" + numEntradas + ", identificador=" + id + ", precioTotal=" + precioTotal + ", metodoPago=" + metodoPago + '}';
    }

    /**
     * 
     * @return devuelve los datos que obtiene con el get."" separados con el caracter "|".
     */
    public String data() {
        return this.getId() + "|" + this.getNumEntradas() + "|" + this.getPrecioTotal() + "|" + this.getMetodoPago() + "|" + this.getIdDescuento() + "|" + this.getFechaCompra() + "|" + this.getIdUsuario() + "|" + this.getIdEntrada();

    }

    public Compra getCompraById(long id) {
        /*
        for(Compra compra:listacompras) {
            if (compra.getId()==id) {
                return compra;
            }
        }    
         */
        return null;
    }

    public ArrayList<Compra> getAllCompra() {

        ArrayList<Compra> nuevaListaCompras = new ArrayList<Compra>();
        /*
        for(Compra compra:listaCompra) {
            nuevaListaCompra.add(compra);
        } 
        for(int i=0;i<listaCompra.size();i++){
            nuevaListaCompra.add(listaCompra.get(i));
        }
         */
        return nuevaListaCompras;
    }
/**
 * 
 * @return devuelve una nueva compra introducida por teclado 
 */
    public Compra nuevoCompra() {
        Compra compra = new Compra();
        boolean confirmacion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("¿Cuantas entradas has comprado?");
            compra.setNumEntradas(sc.nextInt());
            System.out.println("¿Hasta cuando es la fecha de validez? formato:dd/MM/yyyy hh:mm");
            compra.setFechaCompra(ToolBox.readDate());
            System.out.println("¿Cuál es el metodo de pago?");
            compra.setMetodoPago(sc.next());
            System.out.println("¿precio total de las entradas?");
            compra.setPrecioTotal(sc.nextDouble());
            System.out.println("Pulse s para confirmar:");
            confirmacion = ToolBox.readBoolean();
        } while (!confirmacion);
        return compra;
    }

    /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaCompraCaracteres(String rutaFichero) {
        FileWriter escritura = null;
        BufferedWriter bW = null;
        try {
            escritura = new FileWriter(rutaFichero, true);
            bW = new BufferedWriter(escritura);
            bW.write(data() + "\n");
            bW.flush();

        } catch (IOException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (bW != null) {
                try {
                    bW.close();
                } catch (IOException ex) {
                    Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (escritura != null) {
                try {
                    escritura.close();
                } catch (IOException ex) {
                    Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
     /**
     * metodo que sirve para recuperar los valores de un fichero y reconstruir los objetos con los datos guardados
     * @param rutaFichero la ruta del fichero del que se va a  los recuperar datos 
     * @return la lista con todas las compras guardadas en el fichero
     */
    public static ArrayList<Compra> importaCompraCaracter(String rutaFichero) {
        ArrayList<Compra> listaCompras = new ArrayList<Compra>();
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
                int numEntradas = Integer.parseInt(atributos.get(1));
                double precioTotal = Double.parseDouble(atributos.get(2));
                String metodoPago = atributos.get(3);
                long idDescuento = Long.parseLong(atributos.get(4));
                Date fecha = df.parse(atributos.get(5));
                long idUsuario = Long.parseLong (atributos.get(6));
                long idEntrada = Long.parseLong (atributos.get(7));
                Compra com = new Compra(id, numEntradas, precioTotal , metodoPago, idDescuento, fecha, idUsuario,idEntrada);
                listaCompras.add(com);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("fichero no encontrado");
        } catch (IOException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            if (fR != null) {
                try {
                    fR.close();
                } catch (IOException ex) {
                    Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bR != null) {
                try {
                    bR.close();
                } catch (IOException ex) {
                    Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listaCompras;
    }
     /**
     * metodo que permite preservar en un fichero binario la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaCompraBinario(String rutaFichero) {
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
    public static ArrayList<Compra> importaCompraBinario(String rutaFichero) {
        ArrayList<Compra> listaCompras = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Compra com;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((com = (Compra) oIS.readObject()) != null) {
                listaCompras.add(com);
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
        return listaCompras;
    }

}

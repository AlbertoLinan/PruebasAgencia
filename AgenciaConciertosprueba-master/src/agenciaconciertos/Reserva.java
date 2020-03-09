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
 * @author DAW113
 * @version 1.01
 */
public class Reserva {

    protected long id; //atributo que sirve para identificar a la compra |  valores validos numero entero mayor que 0.
    private int numEntradas; //numero de entradas de la compra | valores validos hasta el maximo numero de entradas del concierto.
    private Date fechaMaxima; // Limite para reservar la entrada // valores validos cadena de caracteres de 20 caracteres no pudiendo tener simbolos y numeros
    private Date fechaCanjeo; // fecha en la que se hace efefctiva la reserva y se trata como una compra "" valores vaalidos fecha con hora.
    private String codigoDescuento; //contiene un codigo de descuento que puede ser valido| valores validos "" si no se ha aportado ningun codigo y un codigo si se ha aportado
    private long idCompra;
    private long idUsuario;

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(long idCompra) {
        this.idCompra = idCompra;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public int getNumEntradas() {
        return numEntradas;
    }

    public long getId() {
        return id;
    }

    public Date getFechaMaxima() {
        return fechaMaxima;
    }

    public String getCodigoDescuento() {
        return codigoDescuento;
    }

    public Date getFechaCanjeo() {
        return fechaCanjeo;
    }

    public void setFechaCanjeo(Date fechaCanjeo) {
        this.fechaCanjeo = fechaCanjeo;
    }

    public void setNumEntradas(int numEntradas) {
        this.numEntradas = numEntradas;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFechaMaxima(Date fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
    }

    public void setCodigoDescuento(String codigoDescuento) {
        this.codigoDescuento = codigoDescuento;
    }
/**
 * 
 * @param numEntradas numero de entradas de la compra
 * @param fechaMaxima limite para reservar la entrada
 * @param codigoDescuento contiene un codigo de descuento que puede ser valido 
 */
    public Reserva(int numEntradas, Date fechaMaxima, String codigoDescuento) {
        this.numEntradas = numEntradas;
        this.fechaMaxima = fechaMaxima;
        this.codigoDescuento = codigoDescuento;
    }
    /**
     * 
     * @param id atributo que sirve para identificar a la compra
     * @param idCompra identificador de la compra
     * @param idUsuario identificador del usuario que realiza la reserva
     * @param numEntradas numero de entradas de la compra
     * @param fechaMaxima Limite para reservar la entrada
     * @param FechaCanjeo fecha en la que se hace efefctiva la reserva y se trata como una compra
     */
    private Reserva(long id,long idCompra,long idUsuario,int numEntradas, Date fechaMaxima,Date FechaCanjeo) {
        this.id=id;
        this.idCompra=idCompra;
        this.idUsuario=idUsuario;
        this.numEntradas = numEntradas;
        this.fechaMaxima = fechaMaxima;
        this.fechaCanjeo = FechaCanjeo;
    }
    /**
 * 
 * @param r reserva que quieres copiar
 */
    public Reserva(Reserva r) {
        this.numEntradas = r.getNumEntradas();
        this.id = r.getId();
        this.fechaMaxima = r.getFechaMaxima();
        this.codigoDescuento = r.getCodigoDescuento();
    }

    public Reserva() {
    }

    @Override
    public String toString() {
        return "Reserva{" + "numEntradas=" + numEntradas + ", identificador=" + id + ", fechaMaxima=" + fechaMaxima + ", codigoDescuento=" + codigoDescuento + '}';
    }

    public String data() {
        return this.getId()+"|"+this.idCompra+"|"+this.idUsuario+this.getNumEntradas() + "|" 
                + this.getFechaMaxima() +  "|" + this.getFechaCanjeo();
    }

    public Reserva getReservaById(long id) {
        /*for (Reserva reserva : listaReserva) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }*/
        return null;
    }

    public ArrayList<Reserva> getAllReserva() {
        ArrayList<Reserva> nuevaListaReserva = new ArrayList<Reserva>();
        /*for(Reserva reserva:listaReserva) {
            nuevaListaReserva.add(reserva);
        } 
         */
        return nuevaListaReserva;
    }
/**
 * 
 * @return devuelve una nueva reserva introducida por teclado
 */
    public Reserva nuevoReserva() {
        Reserva reserva = new Reserva();
        Scanner in = new Scanner(System.in);
        boolean confirmacion;
        do {
            System.out.println("¿Cuantas entradas se han reservado?");
            reserva.setNumEntradas(in.nextInt());
            System.out.println("¿?");
            reserva.setFechaMaxima(ToolBox.readDate());
            System.out.println("¿?");
            // reserva.setNIF(in.next());
            System.out.println("¿?");
            // reserva.setNumero(in.next());
            //Artista a=Artista.buscaPorNombreArtistico;
            //actuacion.setListaArtistas(a);
            confirmacion = ToolBox.readBoolean();
        } while (confirmacion != true);
        in.close();
        return reserva;
/**
 * 
 * @return devuelve un nuevo reportero introducido por teclado
 */
    }
    public static Reportero nuevoReportero() throws ReporteroException{
        Reportero reportero;
        Scanner in=new Scanner(System.in);
        boolean confirmacion; 
        String nombre,apellidos,NIF,numTelefono;
        do{    
        System.out.println("¿Cual es el nombre del reportero?");
        nombre=in.next();
        ReporteroException.validaNombre(nombre);       
        System.out.println("¿Cuales son los apellidos del reportero?");
        apellidos=in.next();
        ReporteroException.validaApellidos(apellidos);     
        System.out.println("¿Que NIF tiene el reportero?");
        NIF=in.next();
        ReporteroException.validaNIF(NIF);   
        System.out.println("¿Cual es el numero de telefono del reportero?");
        numTelefono=in.next();
        ReporteroException.validanNumero(numTelefono);
        //Artista a=Artista.buscaPorNombreArtistico;
        //actuacion.setListaArtistas(a);
        confirmacion=ToolBox.readBoolean();
        }while (confirmacion!=true);
        reportero = new Reportero(nombre, apellidos, NIF, numTelefono);
        in.close();
        return reportero;
    }
    
    /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaReservaCaracteres(String rutaFichero) {
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
     * @return la lista con todas las reservas guardadas en el fichero
     */
    
    public static ArrayList<Reserva> importaReporteroCaracter(String rutaFichero) {
            ArrayList<Reserva> listaReportero = new ArrayList<Reserva>();
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
                long idcompra = Long.parseLong(atributos.get(1));
                long idusuario = Long.parseLong(atributos.get(2));
                int numentradas = Integer.parseInt(atributos.get(3));
                Date fechamaxima = df.parse(atributos.get(4));
                Date fechacanjeo = df.parse(atributos.get(5));
                Reserva repo = new Reserva(id, idcompra, idusuario, numentradas,fechamaxima,fechacanjeo);
                        
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
            return listaReportero;
        }
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
     * metodo que sirve para recuperar las instancias de un fichero binario que devuelve en una lista 
     * @param rutaFichero la ruta del fichero que se va a utilizar para recuperar la instancia.
     * @return la lista de objetos que estaban guardados en la lista
     */
    
    public static ArrayList<Reserva> importaReservaBinario(String rutaFichero) {
        ArrayList<Reserva> listaReserva = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Reserva reser;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((reser = (Reserva) oIS.readObject()) != null) {
                listaReserva.add(reser);
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
        return listaReserva;
    }
}

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
 * clase que modela un momento
 * @author DAW102
 * @version 1.00
 */
public class Momento {
    protected  long id;// atributo que sirve para identificar a la momento //  valores validos numero entero mayor que 0.
    private Date hora;// Fecha de tipo util.date que guarda la fecha en la que el reportero documenta la actuacion // los valores validos para este campo seran posteriores a la fecha del concierto pero no mas de un dia.
    private String descripcion;// descripcion del momento que rellenara el reportero// los valores validos seran una cadena de 150 caracteres como maximo. 
    private Reportero reportero; // Objeto que guardara que reportero ha documentado el momento // valores validos un objeto del reportero que captura el momento.
    private Actuacion actuacion; // la actuacion a la cual se esta documentando // valores validos un objeto de la actuacion.
    private long idActuacion; // id de la actucion del momento // valores validos un id de actuacion.
    private long idReportero; // id del reportero // valores validos un id de reportero.
   
    //getters y setters 

    public long getIdActuacion() {
        return idActuacion;
    }

    public void setIdActuacion(long idActuacion) {
        this.idActuacion = idActuacion;
    }

    public long getIdReportero() {
        return idReportero;
    }

    public void setIdReportero(long idReportero) {
        this.idReportero = idReportero;
    }
    

    public Actuacion getActuacion() {
        return actuacion;
    }

    public void setActuacion(Actuacion actuacion) {
        this.actuacion = actuacion;
    }
   

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Reportero getReportero() {
        return reportero;
    }

    public void setReportero(Reportero reportero) {
        this.reportero = reportero;
    }
    /**
     * metodo que devuelve un string con los datos de momentos serados por | con el siguiente formato.
     *                      id|idActuacion|idReportero|descripcion|hora 
     * @return un string con los datos de la clase y el siguiente formato id|idActuacion|idReportero|descripcion|hora 
     */
    public String data(){
        return this.id+"|"+this.idActuacion+"|"+this.idReportero+"|"+
                this.getDescripcion()+"|"+this.getHora();
    }
    /*public Momento getMomentobyid (long id) {
        for (int i=0;i<listaobjetos;i++){
            Momento aux=listaobjetos.get(i);
            if (aux.getID()==id){
                return aux;
    */
    
    /*public ArrayList<Momento> getAllMomento(){
        ArrayList<Momento> LMM = new ArrayList<Momento>();
        for (int i=0;i<listaobjetos.size();i++){
            Momento aux=listaobjetos.get(i);
            LMM.add(aux);
        }
        return LMM;
    }*/
    // constructores 
    /**
     * metodo constructor de momento que recibe la hora,la descripcion,un objeto de  tipo reportero y un objeto de tipo actuacion
     * @param hora la hora de a la que es generado el momento
     * @param descripcion la descripcion del momento
     * @param reportero el reportero que genera el momento
     * @param actuacion la actuacion que se documenta 
     * @deprecated cambiado por otro metodo que recibe los id de reportero y actucion en lugar de objetos
     */
    public Momento(Date hora, String descripcion, Reportero reportero,Actuacion actuacion) {
        this.hora = hora;
        this.descripcion = descripcion;
        this.reportero= reportero;
        this.actuacion=actuacion;
    }
    /**
     * metodo constructor de momento que recibe la hora,la descripcion,un id del reportero que captura el momento y un id de la actuacion que cubre
     * @param hora la hora de a la que es generado el momento
     * @param descripcion la descripcion del momento
     * @param idReportero el id del reportero que genera el momento
     * @param idActuacion el id de la actuacion que se documenta
     */
    public Momento(Date hora, String descripcion, long idReportero,long idActuacion) {
        this.hora = hora;
        this.descripcion = descripcion;
        this.reportero= reportero;
        this.actuacion=actuacion;
    }    /**
     * metodo que copia un momento pero con otro id 
     * @param m el objeto de momento a copiar
     */
    public Momento(Momento m) {
        this.hora = m.getHora();
        this.descripcion = m.getDescripcion();
        this.idReportero= m.getIdReportero();
        this.idActuacion=m.getIdActuacion();
    }
    /**
     * metodo constructor privado que es utilizado en la recuperacion de objetos de un fichero de caracteres.
     * @param id id del objeto
     * @param idActuacion hora del momento
     * @param idReportero id del reportero que captura ese momento
     * @param descripcion la descripcion del momento
     * @param hora la hora a la que sucede el momento
     */
    private Momento(long id,long idActuacion,long idReportero,String descripcion,Date hora) {
        this.id=id;
        this.idActuacion=idActuacion;
        this.idReportero=idReportero;
        this.hora = hora;
        this.descripcion = descripcion;
    } 
    /**
     * constructor por defecto
     */
    public Momento(){}
    //otros metodos
    
    /**
     * metodo que permite crear un momento mediante el teclado
     * @return devuelve el momento creado por teclado.
     */
    public Momento nuevoMomento(){
         
        Momento momento= new Momento();
        boolean confirmacion;
        Scanner sc= new Scanner(System.in);
        do{            
            System.out.println("¿a qué hora ocurrió el momento? formato:dd/MM/yyyy hh:mm");
            momento.setHora(ToolBox.readDate());
            System.out.println("Descibe el momento");
            momento.setDescripcion(sc.next());
            System.out.println("Dime el DNI del reportero que hizo el momento");
            Reportero rep=BaseDatos.buscaReporteroByNIF(sc.nextLine());
            if(rep!=null){
                momento.setReportero(rep);
            }else{
                //el reportero con el nif aportado no existe
            }
            confirmacion=ToolBox.readBoolean();
        } while (!confirmacion);
        return momento;
     
    }
    /**
     * metodo que permite preservar en un fichero de texto los valores de la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaMomentoCaracteres(String rutaFichero) {
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
    public static ArrayList<Momento> importaReporteroCaracter(String rutaFichero) {
            ArrayList<Momento> listaMomentos = new ArrayList<Momento>();
        FileReader fR = null;
        BufferedReader bR = null;
        try {

            fR = new FileReader(rutaFichero);
            bR = new BufferedReader(fR);
            String lineaActual = "";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Momento momento;
            long id;
            long idActuacion;
            long idReportero;
            String descripcion;
            Date hora;
            while ((lineaActual = bR.readLine()) != null) {
                ArrayList<String> atributos = ToolBox.separaPorCampos(lineaActual);
                id=Long.parseLong(atributos.get(0));
                idActuacion=Long.parseLong(atributos.get(1));
                idReportero=Long.parseLong(atributos.get(2));
                descripcion=atributos.get(3);
                hora=df.parse(atributos.get(4));
                //long id,long idActuacion,long idReportero,String descripcion,Date hora
                momento = new Momento(id,idActuacion,idReportero,descripcion,hora);
                listaMomentos.add(momento);
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
                return listaMomentos;
        }
    }
    /**
     * metodo que permite preservar en un fichero binario la instancia que llama al metodo
     * @param rutaFichero la ruta del fichero que se va a utilizar para guardar.
     */
    public void exportaMomentoBinario(String rutaFichero) {
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
    public static ArrayList<Momento> importaMomentoBinario(String rutaFichero) {
        ArrayList<Momento> listaMomentos = new ArrayList<>();
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        Momento momento;
        try {
            fIS = new FileInputStream(rutaFichero);
            oIS = new ObjectInputStream(fIS);
            while ((momento = (Momento) oIS.readObject()) != null) {
                listaMomentos.add(momento);
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
        return listaMomentos;
    }
}

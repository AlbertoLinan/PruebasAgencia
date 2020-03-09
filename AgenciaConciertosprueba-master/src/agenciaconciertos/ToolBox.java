/*
 *
 */
package agenciaconciertos;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * clase que contiene  metodos utiles para otras clases
 * @author DAW102
 */
public class ToolBox {
    
    public static Date readDate(){
        try {
            Scanner sc=new Scanner(System.in);
            String fechaTexto = sc.nextLine();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date fecha = (Date) df.parse(fechaTexto);
            
        return fecha;
           
                   
        } catch (Exception e) {
            return null;
        }
    }
    public static boolean readBoolean(){
        Scanner sc=new Scanner(System.in);
        char confirmacion;
        do{
            confirmacion = sc.next().toLowerCase().charAt(0);
            if(confirmacion == 's'||confirmacion=='n'){
                return confirmacion=='s';
            }
        }while(true);
    }
    /**
     * metodo equivalente al metodo split de la clase String.Genera un Arraylist de Strings 
     * con la cadena que se le pasa, la cual usa como separadores el caracter '|' 
     * @param linea el string a separar
     * @return un arrayList de strings con el string que se le pasa con su contenido separado en varias posiciones.
     */
    public static ArrayList<String> separaPorCampos(String linea){
        ArrayList<String> listaAtributos=new ArrayList<>();
        //String que va a acumular un campo.
        String atributo = "";
        //caracter actual del String linea 
        char caracter;
        //bucle for que recorre la linea caracter a caracter 
        for(int i =0 ;i<linea.length();i++){
            caracter=linea.charAt(i);
            //comprueba si el caracter es el separador.Si no lo es acumula en atributo la letra.
            //En caso contrario añade el atributo a la lista y vacia el atributo 
            if(caracter!='|'){
                atributo+=caracter;
            }else{
                listaAtributos.add(atributo);
                atributo="";
            }
        }
        // devuelve la lista.
        return listaAtributos;
    }
}

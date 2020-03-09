/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciaconciertos;

/**
 *
 * @author DAW102
 */
public class ReporteroException extends Exception {

    public ReporteroException() {
    }

    public ReporteroException(String message) {
        super(message);
    }
    
    public static void validaNombre(String nombre) throws ReporteroException{
       if(nombre.length()>20){
          throw new ReporteroException("El nombre ocupa mas de 20 carateres");
       }
       for(int i=0;i<nombre.length();i++){
           if("0123456789".indexOf(nombre.charAt(i))!=-1){
           throw new ReporteroException("El nombre contiene algun caracter numerico");
           }
       }
    }
    
    public static void validaApellidos(String apellidos) throws ReporteroException{
       if(apellidos.length()>35){
          throw new ReporteroException("Los apellidos ocupan mas de 35 carateres");
       }
       for(int i=0;i<apellidos.length();i++){
           if("0123456789".indexOf(apellidos.charAt(i))!=-1){
           throw new ReporteroException("Los apellidos contienen algun caracter numerico");
           }
       } 
    }
    
    public static void validaNIF(String NIF) throws ReporteroException{
       if(NIF.length()==9){
          throw new ReporteroException("El NIF no cumple el formato 12345678A");
       }
       for(int i=0;i<NIF.length()-1;i++){
           if("0123456789".indexOf(NIF.charAt(i))==-1){
           throw new ReporteroException("Los apellidos contienen algun caracter numerico");
           }
       } 
       char letra=NIF.charAt(NIF.length()-1);
       if ("0123456789".indexOf(letra)!=-1){
           throw new ReporteroException("El ultimo caracter no es una letra");
       }
    }
    
    public  static void validanNumero(String numTelefono) throws ReporteroException{
       if(numTelefono.length()==9){
          throw new ReporteroException("El numero de telefono no cumple");
       }
       for(int i=0;i<numTelefono.length();i++){
           if("0123456789".indexOf(numTelefono.charAt(i))==-1){
           throw new ReporteroException("El numero de telefono contiene algun caracter no permitido");
           }
       } 
    }
    
}

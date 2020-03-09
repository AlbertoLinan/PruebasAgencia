/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciaconciertos;

/**
 *
 * @author DAW113
 */
public class InformeException extends Exception {

    public InformeException(String message) {
        super(message);
    }

    public static void validaDescripcion(String descripcion) throws InformeException {
        if (descripcion.isEmpty()) {
            throw new InformeException("La descripcion esta vacia.");

        }
        if (descripcion.length() > 200) {
            throw new InformeException("La descripcion ocupa mas de 200 caracteres");
        }
    }

}

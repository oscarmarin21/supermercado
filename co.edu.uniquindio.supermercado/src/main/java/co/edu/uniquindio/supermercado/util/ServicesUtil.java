package co.edu.uniquindio.supermercado.util;

import javax.swing.*;

public class ServicesUtil {

    //LECTOR DE VENTANA ----------------------------------------------------------------

    /**
     * Metodo para leer un int con JOption
     * @param mensaje
     * @return int
     */
    public static int leerEnteroVentana(String mensaje) {
        boolean bucle = true;
        int dato = 0;
        do {
            try {
                dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                bucle = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid: Ingresa solo numeros");
            }
        } while (bucle);
        return dato;
    }

    /**
     * Metodo para leer un double con JOption
     * @param mensaje
     * @return double
     */
    public static double leerDoubleVentana(String mensaje) {
        boolean bucle = true;
        double dato = 0.0;
        do {
            try {
                dato = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                bucle = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid: Ingresa solo numeros");
            }
        } while (bucle);
        return dato;
    }

    /**
     * Metodo para leer un String con JOption
     * @param mensaje
     * @return String
     */
    public static String leerStringVentana(String mensaje) {
        String respuesta = "";
        respuesta = JOptionPane.showInputDialog(mensaje);
        return respuesta;
    }

    //MENSAJES ----------------------------------------------------------------

    /**
     * Metodo para mostrar un mensaje segun el boolean
     * @param event
     * @param mensajeCorrecto
     * @param mensajeError
     */
    public static void mostrarMensajeRespuesta(boolean event, String mensajeCorrecto, String mensajeError){
        if (event) {
            JOptionPane.showMessageDialog(null, mensajeCorrecto, "Correct", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensajeError, "Information", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Metodo para incrementar el id
     * @param id
     * @return String
     */
    public static String nextId(String id) {
        int maxId = Integer.parseInt(id);
        String nextId = String.format("%03d", maxId + 1);
        return nextId;
    }
}

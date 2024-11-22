/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imagenes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtileria {
    public static String guardarImagen(byte[] bytes, String nombreArchivo, String rutaDirectorio) throws IOException {
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        File archivo = new File(directorio, nombreArchivo);
        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            fos.write(bytes);
        }
        return archivo.getAbsolutePath();
    }
}

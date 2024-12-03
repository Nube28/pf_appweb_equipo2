package excepciones;

/**
 *
 * @author USER
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por defecto
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que recibe un mensaje.
     *
     * @param message el mensaje que describe el error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y una causa del error.
     *
     * @param message el mensaje que describe el error.
     * @param cause la causa original del error (otra excepción).
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe solo una causa del error.
     *
     * @param cause la causa original del error (otra excepción).
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor completo que permite personalizar el comportamiento de la
     * excepción.
     *
     * @param message el mensaje que describe el error.
     * @param cause la causa original del error (otra excepción).
     * @param enableSuppression
     * @param writableStackTrace
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

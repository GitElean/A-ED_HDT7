/***
 * Universidad del Valle de Guatemala
 * Estructuras de datos
 * Hoja de trabajo #7
 * Abril 2021
 * @Author: Elean Rivas 19062
 * Associations class
 */


package traductorArbol;

public class Associations <S, F, E>{

    /***
     * S: palabra en español
     * F: Palabra en francés
     * E: palabra en inglés
     */
    private S spanish;
    private F french;
    private E english;

    public Associations(S spanish, F french, E english){
        this.english = english;
        this.spanish = spanish;
        this.french = french;
    }

    /***
     * Getters y setters
     * @return el idioma requerido
     */
    public S getSpanish() {
        return spanish;
    }

    public void setSpanish(S spanish) {
        this.spanish = spanish;
    }

    public F getFrench() {
        return french;
    }

    public void setFrench(F french) {
        this.french = french;
    }

    public E getEnglish() {
        return english;
    }

    public void setEnglish(E english) {
        this.english = english;
    }


}

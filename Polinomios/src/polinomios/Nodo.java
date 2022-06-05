
package polinomios;


public class Nodo {
    float coef;
    int expo;
    Nodo liga;

    public Nodo(float coef, int expo) {
        this.coef = coef;
        this.expo = expo;
        liga = null;
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public int getExpo() {
        return expo;
    }

    public void setExpo(int expo) {
        this.expo = expo;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

   
}

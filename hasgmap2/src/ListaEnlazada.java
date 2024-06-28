public class ListaEnlazada {
    Business valorAnterior;
    Business nuevoValor;

    public ListaEnlazada(Business valorAnterior, Business nuevoValor) {
        this.valorAnterior = valorAnterior;
        this.nuevoValor = nuevoValor;
    }

    public Business getValorAnterior() {
        return valorAnterior;
    }

    public Business getNuevoValor() {
        return nuevoValor;
    }

    public void setValorAnterior(Business valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public void setNuevoValor(Business nuevoValor) {
        this.nuevoValor = nuevoValor;
    }

}

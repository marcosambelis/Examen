public class Orden {
    private int numeroOrden;
    private String cliente;
    private Pizza pizza;
    private String estado;

    public Orden(int numeroOrden, String cliente, Pizza pizza) {
        this.numeroOrden = numeroOrden;
        this.cliente = cliente;
        this.pizza = pizza;
        this.estado = "Pendiente";
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void mostrarResumen() {
        System.out.println("----------------------------------------------");
        System.out.println("Orden #" + numeroOrden + " - Cliente: " + cliente + " (Estado: " + estado + ")");
        if (pizza != null) {
            System.out.print("Pizza: ");
            pizza.mostrarPizza();
        } else {
            System.out.println("Pizza: No asignada");
        }
        System.out.println("----------------------------------------------");
    }
}
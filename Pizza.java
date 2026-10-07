import java.util.ArrayList;

public class Pizza {
    private TipoMasa tipoMasa;
    private TipoSalsa tipoSalsa;
    private ArrayList<TipoTopping> toppings;

    public Pizza(TipoMasa tipoMasa, TipoSalsa tipoSalsa) {
        this.tipoMasa = tipoMasa;
        this.tipoSalsa = tipoSalsa;
        this.toppings = new ArrayList<TipoTopping>();
    }

    public void agregarTopping(TipoTopping topping) {
        this.toppings.add(topping);
    }

    public void agregarTopping(TipoTopping topping, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            this.toppings.add(topping);
        }
    }

    public void agregarTopping(TipoTopping[] arregloToppings) {
        for (int i = 0; i < arregloToppings.length; i++) {
            this.toppings.add(arregloToppings[i]);
        }
    }

    public TipoMasa getTipoMasa() {
        return tipoMasa;
    }

    public void setTipoMasa(TipoMasa tipoMasa) {
        this.tipoMasa = tipoMasa;
    }

    public TipoSalsa getTipoSalsa() {
        return tipoSalsa;
    }

    public void setTipoSalsa(TipoSalsa tipoSalsa) {
        this.tipoSalsa = tipoSalsa;
    }

    public ArrayList<TipoTopping> getToppings() {
        return toppings;
    }

    public void mostrarPizza() {
        System.out.println("Masa: " + tipoMasa + " | Salsa: " + tipoSalsa + " | Toppings: " + toppings);
    }
}

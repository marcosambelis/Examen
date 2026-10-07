import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Main {
    static Cocina cocina = new Cocina();
    static int contadorOrden = 1;
    static TipoMasa masaActual = TipoMasa.CLASICA;
    static TipoSalsa salsaActual = TipoSalsa.NORMAL;
    static Pizza pizzaActual = new Pizza(masaActual, salsaActual);

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Jack Pizza Place");
        ventana.setSize(800, 520);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new GridLayout(1, 2, 10, 10));

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));

        JPanel panelDerecho = new JPanel(new BorderLayout(5, 5));
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Registro"));

        JPanel panelCliente = new JPanel(new BorderLayout());
        panelCliente.setBorder(BorderFactory.createTitledBorder("Cliente"));
        JTextField txtCliente = new JTextField();
        panelCliente.add(txtCliente, BorderLayout.CENTER);

        JPanel panelMasa = new JPanel(new GridLayout(1, 3, 5, 5));
        panelMasa.setBorder(BorderFactory.createTitledBorder("Masa"));
        JButton btnMasaArtesanal = new JButton("Artesanal");
        JButton btnMasaClasica = new JButton("Clasica");
        JButton btnMasaDelgada = new JButton("Delgada");
        panelMasa.add(btnMasaArtesanal);
        panelMasa.add(btnMasaClasica);
        panelMasa.add(btnMasaDelgada);

        JPanel panelSalsa = new JPanel(new GridLayout(1, 3, 5, 5));
        panelSalsa.setBorder(BorderFactory.createTitledBorder("Salsa"));
        JButton btnSalsaNormal = new JButton("Normal");
        JButton btnSalsaPicante = new JButton("Picante");
        JButton btnSalsaBBQ = new JButton("BBQ");
        panelSalsa.add(btnSalsaNormal);
        panelSalsa.add(btnSalsaPicante);
        panelSalsa.add(btnSalsaBBQ);

        JPanel panelToppings = new JPanel(new GridLayout(2, 3, 5, 5));
        panelToppings.setBorder(BorderFactory.createTitledBorder("Toppings"));
        JButton btnPepperoni = new JButton("Pepperoni");
        JButton btnCarne = new JButton("Carne");
        JButton btnJamon = new JButton("Jamon");
        JButton btnPina = new JButton("Pina");
        JButton btnAceitunas = new JButton("Aceitunas");
        JButton btnChile = new JButton("Chile Pimiento");
        panelToppings.add(btnPepperoni);
        panelToppings.add(btnCarne);
        panelToppings.add(btnJamon);
        panelToppings.add(btnPina);
        panelToppings.add(btnAceitunas);
        panelToppings.add(btnChile);

        JPanel panelAcciones = new JPanel(new GridLayout(1, 3, 5, 5));
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Opciones"));
        JButton btnMandarCocina = new JButton("Mandar a Cocina");
        JButton btnCocinar = new JButton("Cocinar Orden");
        JButton btnVerCocina = new JButton("Ver Cocina");
        panelAcciones.add(btnMandarCocina);
        panelAcciones.add(btnCocinar);
        panelAcciones.add(btnVerCocina);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(e -> areaTexto.setText(""));

        panelDerecho.add(scroll, BorderLayout.CENTER);
        panelDerecho.add(btnLimpiar, BorderLayout.SOUTH);

        btnMasaArtesanal.addActionListener(e -> {
            masaActual = TipoMasa.ARTESANAL;
            pizzaActual.setTipoMasa(masaActual);
            areaTexto.append("Masa: Artesanal\n");
        });

        btnMasaClasica.addActionListener(e -> {
            masaActual = TipoMasa.CLASICA;
            pizzaActual.setTipoMasa(masaActual);
            areaTexto.append("Masa: Clasica\n");
        });

        btnMasaDelgada.addActionListener(e -> {
            masaActual = TipoMasa.DELGADA;
            pizzaActual.setTipoMasa(masaActual);
            areaTexto.append("Masa: Delgada\n");
        });

        btnSalsaNormal.addActionListener(e -> {
            salsaActual = TipoSalsa.NORMAL;
            pizzaActual.setTipoSalsa(salsaActual);
            areaTexto.append("Salsa: Normal\n");
        });

        btnSalsaPicante.addActionListener(e -> {
            salsaActual = TipoSalsa.PICANTE;
            pizzaActual.setTipoSalsa(salsaActual);
            areaTexto.append("Salsa: Picante\n");
        });

        btnSalsaBBQ.addActionListener(e -> {
            salsaActual = TipoSalsa.BBQ;
            pizzaActual.setTipoSalsa(salsaActual);
            areaTexto.append("Salsa: BBQ\n");
        });

        btnPepperoni.addActionListener(e -> {
            pizzaActual.agregarTopping(TipoTopping.PEPPERONI);
            areaTexto.append("Topping: Pepperoni\n");
        });

        btnCarne.addActionListener(e -> {
            pizzaActual.agregarTopping(TipoTopping.CARNE);
            areaTexto.append("Topping: Carne\n");
        });

        btnJamon.addActionListener(e -> {
            pizzaActual.agregarTopping(TipoTopping.JAMON);
            areaTexto.append("Topping: Jamon\n");
        });

        btnPina.addActionListener(e -> {
            pizzaActual.agregarTopping(TipoTopping.PINA);
            areaTexto.append("Topping: Pina\n");
        });

        btnAceitunas.addActionListener(e -> {
            pizzaActual.agregarTopping(TipoTopping.ACEITUNAS);
            areaTexto.append("Topping: Aceitunas\n");
        });

        btnChile.addActionListener(e -> {
            pizzaActual.agregarTopping(TipoTopping.CHILE_PIMIENTO);
            areaTexto.append("Topping: Chile Pimiento\n");
        });

        btnMandarCocina.addActionListener(e -> {
            if (!cocina.hayEspacio()) {
                areaTexto.append("La cocina esta llena, no se pueden recibir mas ordenes.\n\n");
                return;
            }
            String nombre = txtCliente.getText();
            if (nombre.trim().isEmpty()) {
                nombre = "Cliente " + contadorOrden;
            }
            Orden orden = new Orden(contadorOrden, nombre, pizzaActual);
            cocina.recibirOrden(orden);

            areaTexto.append("Nueva orden enviada (#" + contadorOrden + ")\n");
            areaTexto.append("Cliente: " + nombre + "\n");
            areaTexto.append("Masa: " + pizzaActual.getTipoMasa() + "\n");
            areaTexto.append("Salsa: " + pizzaActual.getTipoSalsa() + "\n");
            areaTexto.append("Toppings: " + pizzaActual.getToppings() + "\n\n");

            contadorOrden++;
            masaActual = TipoMasa.CLASICA;
            salsaActual = TipoSalsa.NORMAL;
            pizzaActual = new Pizza(masaActual, salsaActual);
            txtCliente.setText("");
        });

        btnCocinar.addActionListener(e -> {
            Orden ordenTerminada = cocina.cocinarSiguienteOrden();
            if (ordenTerminada != null) {
                areaTexto.append("Se cocino la orden #" + ordenTerminada.getNumeroOrden() + " de " + ordenTerminada.getCliente() + "\n\n");
            } else {
                areaTexto.append("No hay ordenes pendientes por cocinar.\n\n");
            }
        });

        btnVerCocina.addActionListener(e -> {
            if (cocina.getTotalOrdenes() == 0) {
                areaTexto.append("No hay ordenes pendientes en la cocina.\n\n");
            } else {
                areaTexto.append("Ordenes pendientes (" + cocina.getTotalOrdenes() + "/5):\n");
                Orden[] pendientes = cocina.getOrdenesPendientes();
                for (int i = 0; i < cocina.getTotalOrdenes(); i++) {
                    Orden ord = pendientes[i];
                    areaTexto.append("- Orden #" + ord.getNumeroOrden() + ": " + ord.getCliente() + " | " + ord.getPizza().getToppings() + "\n");
                }
                areaTexto.append("\n");
            }
        });

        panelIzquierdo.add(panelCliente);
        panelIzquierdo.add(panelMasa);
        panelIzquierdo.add(panelSalsa);
        panelIzquierdo.add(panelToppings);
        panelIzquierdo.add(panelAcciones);

        ventana.add(panelIzquierdo);
        ventana.add(panelDerecho);

        ventana.setVisible(true);
    }
}

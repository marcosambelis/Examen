public class Cocina {
    private Orden[] ordenesPendientes;
    private int totalOrdenes;

    public Cocina() {
        this.ordenesPendientes = new Orden[5];
        this.totalOrdenes = 0;
    }

    public boolean recibirOrden(Orden nuevaOrden) {
        if (totalOrdenes >= 5) {
            System.out.println("❌ La cocina está llena (máximo 5 órdenes). Debe cocinar una orden primero.");
            return false;
        }

        ordenesPendientes[totalOrdenes] = nuevaOrden;
        totalOrdenes++;
        System.out.println("✅ Orden #" + nuevaOrden.getNumeroOrden() + " agregada a la cocina. (" + totalOrdenes + "/5)");
        return true;
    }

    public Orden cocinarSiguienteOrden() {
        if (totalOrdenes == 0) {
            System.out.println("⚠️ No hay órdenes pendientes en la cocina.");
            return null;
        }

        Orden ordenTerminada = ordenesPendientes[0];
        ordenTerminada.setEstado("Preparada");

        for (int i = 0; i < totalOrdenes - 1; i++) {
            ordenesPendientes[i] = ordenesPendientes[i + 1];
        }

        ordenesPendientes[totalOrdenes - 1] = null;
        totalOrdenes--;

        System.out.println("🍕 ¡Orden #" + ordenTerminada.getNumeroOrden() + " cocinada con éxito!");
        return ordenTerminada;
    }

    public boolean hayEspacio() {
        return totalOrdenes < 5;
    }

    public void mostrarOrdenes() {
        System.out.println("\n--- ÓRDENES PENDIENTES EN COCINA (" + totalOrdenes + "/5) ---");
        if (totalOrdenes == 0) {
            System.out.println("(No hay órdenes pendientes)");
        } else {
            for (int i = 0; i < totalOrdenes; i++) {
                ordenesPendientes[i].mostrarResumen();
            }
        }
        System.out.println("-----------------------------------------------\n");
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class MainControlCompras {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Producto> productos = new ArrayList<>();
        HashSet<String> categorias = new HashSet<>();
        HashMap<String, Double> totalPorCategoria = new HashMap<>();

        System.out.print("¿Cuántos productos desea ingresar? (mínimo 5): ");
        int cantidadProductos = scanner.nextInt();
        scanner.nextLine();

        while (cantidadProductos < 5) {

            System.out.println("Debe ingresar como mínimo 5 productos.");

            System.out.print("Ingrese nuevamente la cantidad: ");
            cantidadProductos = scanner.nextInt();
            scanner.nextLine();
        }

        for (int i = 1; i <= cantidadProductos; i++) {

            System.out.println();
            System.out.println("===== PRODUCTO " + i + " =====");

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine().trim();

            System.out.print("Precio unitario: Q");
            double precio = scanner.nextDouble();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            if (nombre.isEmpty()) {

                System.out.println(
                        "Producto no registrado: el nombre no puede estar vacío.");

            } else if (categoria.isEmpty()) {

                System.out.println(
                        "Producto no registrado: la categoría no puede estar vacía.");

            } else if (precio <= 0) {

                System.out.println(
                        "Producto no registrado: el precio debe ser mayor que cero.");

            } else if (cantidad <= 0) {

                System.out.println(
                        "Producto no registrado: la cantidad debe ser mayor que cero.");

            } else {

                Producto producto = new Producto(
                        nombre,
                        categoria,
                        precio,
                        cantidad
                );

                productos.add(producto);

                categorias.add(categoria);

                double subtotal = producto.calcularSubtotal();

                if (totalPorCategoria.containsKey(categoria)) {

                    double totalActual =
                            totalPorCategoria.get(categoria);

                    totalPorCategoria.put(
                            categoria,
                            totalActual + subtotal
                    );

                } else {

                    totalPorCategoria.put(
                            categoria,
                            subtotal
                    );
                }

                System.out.println("Producto registrado correctamente.");
            }
        }

        System.out.println();
        System.out.println("===== RESUMEN DE COMPRAS =====");
        System.out.println();

        double totalGeneral = 0;

        Producto productoMayor = null;
        Producto productoMenor = null;

        for (Producto producto : productos) {

            double subtotal = producto.calcularSubtotal();

            System.out.printf(
                    "%s | %s | Q%.2f x %d | Subtotal: Q%.2f%n",
                    producto.getNombre(),
                    producto.getCategoria(),
                    producto.getPrecioUnitario(),
                    producto.getCantidad(),
                    subtotal
            );

            totalGeneral += subtotal;

            if (productoMayor == null ||
                    subtotal > productoMayor.calcularSubtotal()) {

                productoMayor = producto;
            }

            if (productoMenor == null ||
                    subtotal < productoMenor.calcularSubtotal()) {

                productoMenor = producto;
            }
        }

        System.out.println();
        System.out.println("Categorías registradas:");
        System.out.println(categorias);

        System.out.println();
        System.out.println("Total por categoría:");

        for (String categoria : totalPorCategoria.keySet()) {

            System.out.printf(
                    "%s: Q%.2f%n",
                    categoria,
                    totalPorCategoria.get(categoria)
            );
        }

        System.out.println();

        System.out.println(
                "Productos registrados: " + productos.size()
        );

        System.out.printf(
                "Total general: Q%.2f%n",
                totalGeneral
        );

        if (!productos.isEmpty()) {

            System.out.println();
            System.out.println("Producto con mayor gasto:");

            System.out.printf(
                    "%s - Q%.2f%n",
                    productoMayor.getNombre(),
                    productoMayor.calcularSubtotal()
            );

            System.out.println();
            System.out.println("Producto con menor gasto:");

            System.out.printf(
                    "%s - Q%.2f%n",
                    productoMenor.getNombre(),
                    productoMenor.calcularSubtotal()
            );
        }

        String categoriaMayor = "";
        double mayorGastoCategoria = 0;

        for (String categoria : totalPorCategoria.keySet()) {

            double totalCategoria =
                    totalPorCategoria.get(categoria);

            if (totalCategoria > mayorGastoCategoria) {

                mayorGastoCategoria = totalCategoria;
                categoriaMayor = categoria;
            }
        }

        if (!categoriaMayor.isEmpty()) {

            System.out.println();
            System.out.println("Categoría con mayor gasto:");

            System.out.printf(
                    "%s - Q%.2f%n",
                    categoriaMayor,
                    mayorGastoCategoria
            );
        }

        System.out.println();
        System.out.print(
                "Ingrese una categoría para consultar: "
        );

        String categoriaBuscar = scanner.nextLine().trim();

        if (totalPorCategoria.containsKey(categoriaBuscar)) {

            System.out.printf(
                    "Total gastado en %s: Q%.2f%n",
                    categoriaBuscar,
                    totalPorCategoria.get(categoriaBuscar)
            );

        } else {

            System.out.println(
                    "La categoría ingresada no se encuentra registrada."
            );
        }

        scanner.close();
    }
}
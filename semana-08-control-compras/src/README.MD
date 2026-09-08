# **Semana 08 - Control de Compras**

**Descripción**

Aplicación desarrollada en Java para registrar y analizar las compras realizadas 
por una familia durante una semana.

El programa permite ingresar productos, categorías, precios y cantidades, además
de calcular subtotales, total general y gastos por categoría.

**Objetivo**

Aplicar programación orientada a objetos, estructuras de control y colecciones de
Java para organizar y procesar información de compras.

**Colecciones utilizadas**

* ArrayList<Producto>: almacena todos los productos registrados.
* HashSet<String>: almacena las categorías sin repetirlas.
* HashMap<String, Double>: almacena el total gastado por cada categoría.

**Clases
Producto**

Contiene los datos de cada producto:

* Nombre.
* Categoría.
* Precio unitario.
* Cantidad.

También contiene el método calcularSubtotal().

**MainControlCompras**

Es la clase principal del programa. Permite:

* Registrar productos.
* Validar los datos ingresados.
* Mostrar los productos registrados.
* Calcular el total general.
* Mostrar los totales por categoría.
* Identificar el producto con mayor y menor gasto.
* Identificar la categoría con mayor gasto.
* Consultar una categoría específica.

**Estructura del proyecto**

semana-08-control-compras

├── src

│ ├── Producto.java

│ └── MainControlCompras.java

├── evidencias

├── README.md

└── .gitignore

**Ejecución**

Ejecutar la clase MainControlCompras desde IntelliJ IDEA e ingresar como mínimo
cinco productos.

**Resultado esperado**

El programa mostrará un resumen de las compras registradas, los subtotales, 
categorías, total general, gastos por categoría y permitirá realizar una 
consulta por categoría.

### **Autor**

_Gerson Ezequiel López Enriquez_

_9941-25-22144_

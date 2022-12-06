# SubastaLibros-JavaRMI
Modelo Cliente-Servidor sobre la subasta de libros, donde los compradores pujan por los libros del vendedor, utilizando javaRMI.

En esta aplicación, se ha realizado dos interfaces gráficas, una para los vendedores y otra para los compradores.
Los vendedores publicarán los libros que están a subastar, y los compradores pujarán entre ellos para poder comprarlo.

Los comrpadores podrán publicar libros en su lista de deseos, de forma que si el vendedor publica una subasta, este pujará direcamente.

Los clientes, tanto los compradores como los vendedores, podrán ver de manera instantánea las modificaciones sobre los precios actuales de los libros en la subasta. Podrán añadir y quitar libros a su lista de manera dinámica.

El proyecto implementa Ontologías para la comunicación entre los clientes y los servidores, haciendo el paso de datos más adecuado y fluido.

Para ejecutar la aplicación correctamente, se debe ejecutar el servidor primero, y después tantos compradores y vendedores como se desee, ya que puede haber varios de cada. 

DesarrolloDeAplicaciones-GrupoD
======

[![Build Status](https://travis-ci.org/siamofuori/DesarrolloDeAplicaciones-GrupoD.svg?branch=master)](https://travis-ci.org/siamofuori/DesarrolloDeAplicaciones-GrupoD)

## Subí que te llevo ##

Se requiere crear una plataforma donde los usuarios puedan coordinarse para compartir viajes en auto o cualquier otro vehículo que permita llevar al menos 2 personas.

La aplicación a construir deberá ser de carácter social, donde toda persona que se sume a la plataforma pueda:

* Registrarse en la plataforma indicando
  * Qué vehículo tiene (si lo tuviese) y su capacidad disponible
  * El o los recorridos que suele realizar, indicando al menos el punto de inicio y fin de cada uno
  * En qué horarios suele realizar el recorrido (a la mañana al trabajo, horario de escuela, etc.) 
* Buscar usuarios que realicen un recorrido similar al que necesita (Acordaremos en clase la logica a utilizar para la comparación de recorridos, no inviertan esfuerzo por el momento)
* Solicitar subirse a un recorrido 
  * Deberá indicar dónde desea subir y donde bajará

Lo que esta red busca es contribuir con el uso racional de los medios de transporte en la ciudad, optimizando su utilización y, en consecuencia, disminuir el caudal de vehículos que suelen congestionar el tránsito.
Si bien no existe el propósito de lucro por parte de los usuarios, si se desea que quienes compartan un vehículo también compartan los costos del viaje por lo que un usuario al ingresar un recorrido, indicará el costo aproximado en combustible y peajes para que pueda ser dividido entre los ocupantes del vehículo.
Cuando un usuario encuentre un viaje que se ajusta a sus necesidades, enviará una solicitud al dueño del vehículo indicando el punto en que desea subir, punto en que desea bajar y día y horario en el que estará esperando para subir al vehículo. En caso que la solicitud sea aceptada, la plataforma deberá contabilizar un nuevo ocupante en el vehículo por el tramo indicado.
Teniendo en cuenta el perfil social de la aplicación, cada usuario podrá calificar a sus compañeros de ruta y enviarle mensajes tanto en modalidad pública como privada. 
Se desea también que la plataforma se integre con google maps u otra herramienta cartográfica que permita mostrar ubicaciones geográficas, trazar recorridos, etc. 
Adicionalmente, se contará con un sistema gaming donde las calificaciones y el buen uso de la plataforma permitirá subir la reputación y obtener puntos que podrán ser cambiados por productos/voucher. A partir de las calificaciones obtenidas por los usuarios (buen o mal conductor, buen o mal acompañante, buen o mal vehículo), la aplicación publicará el ranking con los mejores y peores conductores, los mejores y peores acompañantes, como así también, los mejores y peores vehículos.
Las buenas recomendaciones de conductor suman 500 puntos y cada 2 recomendaciones malas resta 1000 puntos.
Los usuarios que más eficiencia hayan tenido podrán sumar 5000 puntos por mes. Le llamamos eficiencia si han logrado reducir más del 50% del consumo del auto gracias a sumar a otras personas en sus viajes. Este ranking se confeccionará de manera mensual y califican los primero 20.
Los puntos obtenidos por los usuarios podrán ser canjeados por diversos productos que forman parte del listado de premios disponibles. Cada producto tiene un nombre, una foto, stock y puntos (costo). Al menos se deben crear:
* Un voucher de $100 de nafta (15.000 puntos)
* Un voucher de $200 de nafta (28.000 puntos) 
* Cambio de aceite (22.000 puntos) 
El sistema debe permitir canjear puntos por productos y debe quedar el historial de canjes por usuarios. Se desea también la construcción de un reporte gráfico donde pueda apreciarse la distribución de los productos entregados. 
La aplicación deberá ser completamente responsive ya que si bien ahora no vamos a contar con una aplicación mobile, será importante que pueda mostrarse correctamente en celulares y tablets.  
En cuanto a la autenticación de los usuarios, se deberá proveer un login utilizando las credenciales de gmail.

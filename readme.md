# Arquitectura de la aplicación
## Modelos: (usando Lombok)
- Usuario: correo y contraseña
- Videojuego : id, nombre, categoria,año, plataforma

# Swing:
- Login : `JDialog` -> Formulario con usuario y contraseña
- Listado/Principal : `JFrame` -> Tabla y botones/menu
  (Inicio sesión, añadir juego, Salir)
- Detalle : `JDialog` -> Labels con datos del juego activo
- Añadir : `JDialog` -> Formulario con todos los datos de un nuevo juego

- Interfaz Contexto : Servicio Singleton
  - `setItem()`
  - `getItem()`
  --> Implementado usando un `Hashmap<String,Object>` en memoria

## Datos:
- Interfaz Datos : Servicio para gestionar juegos
  - `leerJuegos()`
  - `añadirJuego()`
  --> Implementado usando un archivo csv : `videojuegos.csv`

## Usuarios:
- Interfaz Usuarios : Servicio para autenticar el usuario
  - `autenticar()` : recibe el nombre y contraseña y comprueba
  que sea correcto.
  --> Implementado usando un archivo `user.properties`.

## Main:
- Crea los servicios y los inyecta a la ventana principal.
- Lanza la ventana principal
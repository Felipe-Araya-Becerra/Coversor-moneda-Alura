# Conversor de Moneda en Java

Este proyecto es un conversor de monedas creado en Java como parte del desafío de Alura ONE. La aplicación se conecta a una API de tasas de cambio para obtener el valor de conversión entre diferentes monedas y permite al usuario realizar conversiones desde la consola de forma interactiva.

## Características

- Conexión a una API para obtener tasas de cambio en tiempo real.
- Opciones de conversión predefinidas entre USD, EUR, JPY y GBP.
- Interfaz de usuario en la consola con un menú de opciones.
- Uso de la biblioteca **Gson** para parsear la respuesta JSON de la API.

## Requisitos

- Java 8 o superior.
- Clave de API de [ExchangeRate-API](https://www.exchangerate-api.com/) o cualquier otra API de tasas de cambio que ofrezca una estructura de datos similar.

## Configuración

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Felipe-Araya-Becerra/Coversor-moneda-Alura.git
   cd Coversor-moneda-Alura
   
## Agregar la clave de API:

Obtén una clave de API de ExchangeRate-API o de la API que prefieras.
Abre el archivo `CurrencyConverter.java` y reemplaza `TU_CLAVE_API` con tu clave de API.
Agregar la biblioteca Gson:

Si usas Maven, agrega la dependencia en tu archivo pom.xml:

```xml
<dependency>
<groupId>com.google.code.gson</groupId>
<artifactId>gson</artifactId>
<version>2.8.8</version>
</dependency>
```
Si usas Gradle, agrega esta línea a tu archivo build.gradle:
```groovy
implementation 'com.google.code.gson:gson:2.8.8'
```

Si no usas un gestor de dependencias, descarga el archivo .jar desde aquí y agrégalo manualmente a tu proyecto.
Ejecución
Compila el proyecto:

```bash
javac CurrencyConverter.java
```
Ejecuta el programa:

```bash
java CurrencyConverter
```

## Uso
#### Al ejecutar el programa, se mostrará un menú en la consola con las siguientes opciones:

1. USD a EUR
2. USD a JPY
3. EUR a GBP
4. Salir

> Selecciona una opción ingresando el número correspondiente y presionando Enter.
>Ingresa el monto que deseas convertir y presiona Enter. El programa mostrará el monto convertido en la moneda seleccionada.
>Puedes repetir el proceso seleccionando una nueva opción, o salir del programa eligiendo la opción 4.

Ejemplo de Salida
```markdown

=== Conversor de Moneda ===
Seleccione la opción de conversión:
1. USD a EUR
2. USD a JPY
3. EUR a GBP
4. Salir

Ingrese el monto a convertir: 100
Monto convertido: 85.00 EUR
```

## Nota
 >Asegúrate de tener conexión a Internet, ya que el programa depende de la API de tasas de cambio en tiempo real.

## Créditos
Este proyecto fue desarrollado como parte del desafío de Alura ONE.

## Licencia
Este proyecto es de uso libre y fue creado con fines educativos.

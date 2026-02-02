# Consultor de Clima - OpenWeatherMap API

## 1. API Utilizada

Se utilizó la **API de OpenWeatherMap** (https://openweathermap.org/api), específicamente el endpoint de **Current Weather Data** (`/data/2.5/weather`). Esta API proporciona información meteorológica en tiempo real de cualquier localización geográfica mundial.

## 2. Ciudad Consultada

La ciudad consultada es **Madrid, España** (`Madrid,es`). La aplicación realiza una consulta específica a esta ciudad para obtener las condiciones climáticas actuales.

## 3. Formato de Datos

El formato de datos procesado es **JSON (JavaScript Object Notation)**. La API retorna una respuesta en formato JSON que contiene información como:
- Temperatura actual en grados Celsius
- Descripción del estado del clima
- Nombre de la ciudad
- Humedad, presión, velocidad del viento, entre otros

## 4. Ejecución de la Aplicación

### Requisitos
- Java JDK 8 o superior instalado
- Conexión a Internet (para acceder a la API de OpenWeatherMap)

### Pasos para ejecutar

1. **Compilar el código Java:**
   ```bash
   javac Main.java
   ```

2. **Ejecutar la aplicación:**
   ```bash
   java Main
   ```

3. **Resultado esperado:**
   - La aplicación mostrará la respuesta JSON cruda de la API
   - Posteriormente, extrae y muestra de forma legible:
     - Ciudad consultada
     - Temperatura en °C
     - Condición del clima (capitalizada)

### Detalles técnicos de ejecución

La aplicación utiliza la clase `HttpURLConnection` de Java para realizar solicitudes HTTP GET a la API. El proceso es:

1. Establece una conexión HTTP a la URL de OpenWeatherMap con parámetros de consulta
2. Recibe la respuesta en formato JSON en tiempo real
3. Realiza un parseo manual de cadenas (string parsing) para extraer valores específicos del JSON
4. Muestra los resultados formateados al usuario

## 5. Utilización de Herramientas de IA

La IA fue utilizada durante el desarrollo en los siguientes aspectos:

- **Comprensión del código:** Asistencia en la comprensión de la estructura y funcionalidad de las librerías estándar de Java (HttpURLConnection, BufferedReader, etc.)
- **Resolución de errores:** Ayuda en la diagnosis y solución de problemas como el error 401 (no autorizado) que fue causado por una API Key no activada aún en el servidor de OpenWeatherMap
- **Mejora del código:** Sugerencias para agregar líneas de código adicionales que permitieran acceder y mostrar el JSON crudo antes del parseo manual, mejorando la experiencia de aprendizaje
- **Verificación de sintaxis:** Validación de la correcta sintaxis Java y las llamadas a métodos de la API

---

**Nota:** Este es un proyecto académico centrado en aprender a consumir APIs REST usando Java nativo, sin librerías de parseo JSON como Gson o Jackson.
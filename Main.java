import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main
{
    public static void main(String[] args) 
    {
        try {
            
            // La API key se define directamente en el código para simplificar la ejecución del ejemplo académico.
            
            String apiKey = "f9881f44fd7918bb2942c0f46ced6a32"; 
            String ciudad = "Madrid,es";
            
            String urlStr = "https://api.openweathermap.org/data/2.5/weather?q=" + 
                           ciudad + "&units=metric&lang=es&appid=" + apiKey;
            
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            int responseCode = conn.getResponseCode();
            
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
                );
                
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                // Parseo manual simple
                // Parseo manual del JSON con fines didácticos.
                // En proyectos reales se utilizan librerías como Gson o Jackson.

                String json = response.toString();

                //Datos del JSON => Agregado por mí
                System.out.println("Respuesta JSON cruda de la API:");
                System.out.println(json); 
                
                // Extraer datos basicos
                String temp = extraer(json, "\"temp\":", ",");
                String desc = extraer(json, "\"description\":\"", "\"");
                String nombre = extraer(json, "\"name\":\"", "\"");
                
                System.out.println("\nClima en " + nombre + ":");
                System.out.println("Temperatura: " + temp + " °C");
                System.out.println("Condicion: " + capitalizar(desc));
                
            } else {
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String errorResponse = errorReader.readLine();
                System.out.println("Error de la API: " + errorResponse);
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static String extraer(String texto, String inicio, String fin) 
    {
        try {
            int start = texto.indexOf(inicio);
            if (start == -1) return "N/A";
            start += inicio.length();
            
            int end = texto.indexOf(fin, start);
            if (end == -1) return "N/A";
            
            return texto.substring(start, end);
        } catch (Exception e) {
            return "N/A";
        }
    }
    
    private static String capitalizar(String texto) 
    {
        if (texto == null || texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
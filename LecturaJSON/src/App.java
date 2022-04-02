import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {
    public static void main(String[] args) throws Exception {
        String ruta = "D:\\HP DOCUMENTOS\\USAC\\2022\\PRIMER SEMESTRE 2022\\PRACTICAS INICIALES\\Tutorias-IPC1\\LecturaJSON\\archivo.json";
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(ruta));
            JSONArray array = (JSONArray) obj;


            

            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = (JSONObject) array.get(i);
                System.out.println(jsonObject);
                Long idCapa = (Long) jsonObject.get("id_capa");
                
                System.out.println("ID CAPA " +  idCapa);

                JSONArray arrayPixeles = (JSONArray) jsonObject.get("pixeles");
                for (int j = 0; j < arrayPixeles.size(); j++) {
                    JSONObject jsonObject2 = (JSONObject) arrayPixeles.get(j);
                    Long fila = (Long) jsonObject2.get("fila");
                    Long columna = (Long) jsonObject2.get("columna");
                    String color = (String) jsonObject2.get("color"); 
                    System.out.println("FILA " + fila);
                    System.out.println("COLUMNA " + columna);
                    System.out.println("COLOR " + color);                   
                }
                
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}

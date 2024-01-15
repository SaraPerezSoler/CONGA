package es.main.parser.rasa.actions.python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
	
	public static void main(String[] args) throws IOException {
		
		try {
	        Runtime tiempoEjecucion = Runtime.getRuntime();
	        Process proceso = tiempoEjecucion.exec("cmd.exe /C " + "python .\\ast_test.py .\\actions.py");
//	        Process proceso = tiempoEjecucion.exec("cmd.exe /C " + "dir");
	        InputStream is = proceso.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
			
	        String object="";
	        String linea;
	        while ((linea = br.readLine()) != null) {
	        	object += linea+"\n";
	            System.out.println(linea);
	        }
	        br.close();
	        object = object.replaceAll("'\\s*'", "").replaceAll("'", "\"").replaceAll("None", "null");
	        System.out.println(object);
	        
	        ObjectMapper om = new ObjectMapper(new JsonFactory());
			JSONObject json = new JSONObject(object);
			System.out.println(json);
			
			Actions actions = om.readValue(object, Actions.class);
			
			System.out.println("Hecho");
	    } catch (IOException e) {
		e.printStackTrace();
	    }
		
		
	}

}

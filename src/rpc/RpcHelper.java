package rpc;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import entity.Item;

public class RpcHelper {
	// Writes a JSONObject to http response.
	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) {
		try { 
			response.setContentType("application/json"); 
			response.addHeader("Access-Control-Allow-Origin", "*"); 
			PrintWriter out = response.getWriter(); 
			out.print(obj); 
			out.close();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	// Writes a JSONArray to http response.
	public static void writeJsonArray(HttpServletResponse response, JSONArray array) {
		try { 
			response.setContentType("application/json"); 
			response.addHeader("Access-Control-Allow-Origin", "*"); 
			PrintWriter out = response.getWriter(); 
			out.print(array); 
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Parses a JSONObject from http request.
	public static JSONObject readJsonObject(HttpServletRequest request) { 
		StringBuilder sb = new StringBuilder(); 
		try { 
			BufferedReader reader = request.getReader(); 
			String line = null; 
			while ((line = reader.readLine()) != null) { 
				sb.append(line);
				} 
			reader.close(); 
			return new JSONObject(sb.toString()); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
	return null;
	}
	
	public static JSONArray getJSONArray(List<Item> items) { 
		JSONArray result = new JSONArray(); 
			try {
				for (Item item : items) {
					result.put(item.toJSONObject());
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
		return result;
	}
}

package simpleChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Tran {
	public static String HashToJson(HashMap<String, Object> hash){
		ArrayList<String> json = new ArrayList<>();
		for(String key : hash.keySet()){
			Object value = hash.get(key);
			boolean ignore = false;
			if(value instanceof HashMap){
				ignore = true;
				value = Tran.HashToJson((HashMap<String, Object>)value);
			}
			if(value instanceof String && !ignore){
				value = String.format("\"%s\"", value);
			}
			if(value instanceof ArrayList){
				value = Tran.ArrayToJson((ArrayList)value);
			}
			json.add(String.format("\"%s\":%s", key, value));
		}
		return String.format("{%s}", json.stream().collect(Collectors.joining(",")));
	}
	
	public static String ArrayToJson(ArrayList<Object> data){
		ArrayList<String> json = new ArrayList<>();
		for(Object key : data){
			json.add(Tran.HashToJson((HashMap<String, Object>)key));
		}
		return String.format("[%s]", json.stream().collect(Collectors.joining(",")));
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.HashMap;
import java.util.Map;


public class Global {
    
    private static Map<String, Object> datos;

    static {
        datos = new HashMap<String, Object>();
    }

    public static void put(String variable, Object value) {
        datos.put(variable, value);
    }

    public static Object get(String variable) {
        Object value = null;
        value = datos.get(variable);
        return value;
    }
}

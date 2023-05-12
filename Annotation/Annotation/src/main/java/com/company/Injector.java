package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    private static Properties properties= new Properties (  );

    public <T> T inject(T object) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        loadProperties ();
        Field[] fields = object.getClass ().getDeclaredFields ();
        for (Field field:fields
             ) {
            if(field.getAnnotation ( AutoInjectable.class )!=null){
                field.setAccessible ( true );
                String fieldClassname=field.getType ().toString ().split ( " " )[1];
                String injectedClassName = properties.getProperty ( fieldClassname );
                Object value = Class.forName ( injectedClassName ).newInstance ( );
                field.set (object, value);
            }
        }
        return object;
    }
    private void loadProperties() throws IOException {
        FileInputStream inputStream= new FileInputStream ( "src/main/resources/config.properties" );
        properties.load ( inputStream );

    }
}

package com.netec.mongo.mongoconex;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/*En esta clase nos conectamos al servicio de la base de datos
y nos conectamos a la base de datos escuela */
public class MongoCliente{
    private static final String NAMEDATABASE="escuela2";
    private static final String URLCONEX="mongodb://localhost:27017";
    private static MongoClient  cliente;
    private  static MongoDatabase baseDatos;

    private MongoCliente(){
         InitConex();
    }

    public static MongoDatabase getInstance(){
        if(baseDatos==null){
             new MongoCliente();
        }
        return baseDatos;
    }
    private static void InitConex(){
        try{
            cliente=MongoClients.create(URLCONEX);
            baseDatos=cliente.getDatabase(NAMEDATABASE);

        }catch(Exception ex){
            System.out.println("Error en Conex"+ex);
        }
    }
  
}

package com.netec.mongo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.netec.mongo.mongoconex.MongoCliente;

import org.bson.Document;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        MongoDatabase base=MongoCliente.getInstance();
        System.out.println(base.getName());
        insertarDocumento(base);

        System.out.println( "Hello World!" );
    }
    private static void insertarDocumento(MongoDatabase base){
          MongoCollection<Document> col=base.getCollection("alumnos");
          Document dc=new Document();
          Scanner scn= new Scanner(System.in);
          Scanner scc=new Scanner(System.in);
          System.out.println("Correo: ");
          String correo=scc.nextLine();
          dc.append("correo", correo);
          System.out.println("-.-.-.Datos dirección-.-.-.-.");
          System.out.println("Numero: ");
          int numero=scn.nextInt();          
          System.out.println("Calle: ");
          String calle=scc.nextLine();
          Document direccion= new Document();
          direccion.append("numero", numero);
          direccion.append("calle", calle);
          dc.append("direccion", direccion);
          System.out.println("----Cuantas calificaciones tiene el alumno?----");
          System.out.println("Cantidad: ");
          int tamano=scn.nextInt();
          if(tamano>0){
              List<Integer>calificaciones= new ArrayList<>();;
              for(int i=0; i<tamano;i++){
                  System.out.println("Calificacio "+(i+1));
                   calificaciones.add( scn.nextInt());
              }
              dc.append("calificaciones", calificaciones);
          }
          col.insertOne(dc);

    }


}

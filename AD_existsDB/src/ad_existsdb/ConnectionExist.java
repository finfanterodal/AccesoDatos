package ad_existsdb;

import java.io.File;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;

/**
 *
 * @author oracle
 */
public class ConnectionExist {

    public static String driver = "org.exist.xmldb.DatabaseImpl";

    public static void main(String args[]) throws Exception {

        //CONEXION, initialize database driver
        Class<?> cl = Class.forName(driver);
        Database database = (Database) cl.newInstance();
        DatabaseManager.registerDatabase((org.xmldb.api.base.Database) database);
        String coleccion = "/db";
        Collection col;
        String uri = "xmldb:exist://localhost:8080/exist/xmlrpc";
        col = DatabaseManager.getCollection(uri + coleccion, "admin", "castelao");

        /**
         * 4*
         */
        //CREAR Coleccion
        CollectionManagementService mgtService = (CollectionManagementService) col.getService("CollectionManagementService", "1.0");
        mgtService.createCollection("cousas");
        //BORRAR Coleccion
        mgtService.removeCollection("cousas");

        //AÑADIR xml (Recurso)
        File arquivo = new File("/home/oracle/Desktop/NetBeans/AD_existsDB/empleados.xml");
        Resource resEmpleados = col.createResource(arquivo.getName(), "XMLResource");
        resEmpleados.setContent(arquivo);
        col.storeResource(resEmpleados);

        File arquivo2 = new File("/home/oracle/Desktop/NetBeans/AD_existsDB/proba.xml");
        Resource proba = col.createResource(arquivo2.getName(), "XMLResource");
        proba.setContent(arquivo2);
        col.storeResource(proba);

        File arquivo3 = new File("/home/oracle/Desktop/NetBeans/AD_existsDB/proba2.xml");
        Resource proba2 = col.createResource(arquivo3.getName(), "XMLResource");
        proba2.setContent(arquivo3);
        col.storeResource(proba2);

        /*       //BORRAR recurso (xml)
         Resource recursoaborrar = col.getResource("empleados.xml");
         col.removeResource(recursoaborrar);*/
        /**
         * *5*
         */
        // MOSTRAR CONTENIDO COLECCION
        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        //Marcamos el nodo de inicio de la búsqueda
        ResourceSet resultMostrar = servicio.query("/EMPLEADOS/EMP_ROW[DEPT_NO=10]");
        ResourceIterator it = (ResourceIterator) resultMostrar.getIterator();
        Resource r;

        while (it.hasMoreResources()) {

            r = (Resource) it.nextResource();

            System.out.println(r.getContent());
        }

        ResourceSet resultMostrar2 = servicio.queryResource("proba.xml", "/PLAY/fm");
        it = (ResourceIterator) resultMostrar2.getIterator();

        while (it.hasMoreResources()) {

            r = (Resource) it.nextResource();

            System.out.println(r.getContent());
        }

        /**
         * 6
         * INSERTAR elementos dentro de un documento, xml por ejemplo
         */
        String cons = "update insert <zona><cod_zona>50</cod_zona><nombre>Madrid-Oeste</nombre><director>Alicia Ramos Martin</director></zona> into /EMPLEADOS/ZONAS";
        servicio.queryResource("empleados.xml", cons);
        //Visualizamos el resultado para saber si se insertó
        ResourceSet resultInsert = servicio.queryResource("empleados.xml", "/EMPLEADOS/ZONAS");
        it = (ResourceIterator) resultInsert.getIterator();

        while (it.hasMoreResources()) {

            r = (Resource) it.nextResource();

            System.out.println(r.getContent());
        }

        /*7)actualizar elemento dentro do documento (recurso)  dunha colecion (sendo col a colecion)

         por exemplo modificar  unha informacion no documento empleados.xml da colecion cousas
         */
        cons = "update value /EMPLEADOS/EMP_ROW[EMP_NO=7369]/APELLIDO with 'RODROGUEZ'";
        servicio.queryResource("empleados.xml", cons);

        ResourceSet resultUpdate = servicio.queryResource("empleados.xml", "/EMPLEADOS/EMP_ROW[EMP_NO=7369]");
        it = (ResourceIterator) resultUpdate.getIterator();

        while (it.hasMoreResources()) {

            r = (Resource) it.nextResource();

            System.out.println(r.getContent());
        }

        /*
         8) borrar elemento dentro do documento (recurso)  dunha colecion
         por exemplo eliminar unha informacion no documento empleados.xml da colecion cousas
         OPERACIONS de ACTUALIZACION de todos os documentos (recursos) dunahcolecion
         */
        cons = "update delete /EMPLEADOS/ZONAS/zona[cod_zona=50]";
        servicio.queryResource("empleados.xml", cons);


        /*
         9
         )inserir elemento dentro dos documento(recursos)  da colecion

         por exemplo inserir unha informacion nos documentos  da colecion cousas
         */
        cons = "update insert <zona><cod_zona>50</cod_zona><nombre>Madrid-Oeste</nombre><director>Alicia Ramos Martin</director></zona> into /EMPLEADOS/ZONAS";
        ResourceSet resultInsertC = servicio.query(cons);

        //     outra insercion na colecion cousas:
        cons = "update insert <autor><cod_autor>1</cod_autor><nombre>luis</nombre><edad>30</edad></autor> into /PLAY";
        ResourceSet resultInsertC2 = servicio.query(cons);

        /*
         10)actualizar elemento dentro dos documentos (recursos)  da colecion

         por exemplo actualizar  unha informacion nos documentos  da colecion cousas
         */
        cons = "update value /EMPLEADOS/EMP_ROW[EMP_NO=7369]/APELLIDO with 'RODROGUEZ'";
        ResourceSet resultUPDATE = servicio.query(cons);

        /*
         11) borrar elemento dentro doa documentos (recursos)  da colecion

         por exemplo eliminar  unha informacion nos documentos  da colecion cousas
         */
        cons = "update delete /EMPLEADOS/ZONAS/zona[cod_zona=50]";
        ResourceSet resultDELETE = servicio.query(cons);

    }
}

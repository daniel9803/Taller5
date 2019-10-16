/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_c.negocio;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


//import mvcf.AModel;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author JuanCamilo
 */
public class GestorCliente  {

    private List<ClienteCopia> listado;
    private ConectorJdbc conector;

    public GestorCliente() {
        listado = new ArrayList();
        conector = new ConectorJdbc();
    }

    

    public void agregarCliente() throws ClassNotFoundException, SQLException{
        conector.conectarse();
        conector.actualizar("INSERT INTO cli_copia (id, nombres, apellidos, direccion, celular, email, sexo)"
                + " VALUES ("
                + "'" + 1 + "',"
                + "'" +2 + "',"
                + "'" + 3 + "',"
                + "'" + 4 + "',"
                + "'" + 5 + "',"
                + "'" + 6 + "',"
                + "'" + 7 + "'"
                + ")");
        conector.desconectarse();
        System.out.println("Agregado");
    }

}
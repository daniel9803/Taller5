/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorCentral.main;

import servidor_c.servicio.ServidorCentralServer;

/**
 *
 * @author JuanCamilo
 */
public class RunMain {
    public static void main(String args[]){
        ServidorCentralServer regSer = new ServidorCentralServer();
        regSer.iniciar();
    }
}

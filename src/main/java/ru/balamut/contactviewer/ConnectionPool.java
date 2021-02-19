/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.balamut.contactviewer;

//import java.sql.Connection;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;

/**
 *
 * @author Balamut
 */
public class ConnectionPool {
    
//    private static volatile ConnectionPool instance;
//    
//    private ConnectionPool(){/* do nothing */}
//    
//    public static ConnectionPool getInstance() {
//        ConnectionPool localInstance = instance;
//        if (localInstance == null) {
//            synchronized (ConnectionPool.class) {
//                localInstance = instance;
//                if (localInstance == null) {
//                    instance = localInstance = new ConnectionPool();
//                }
//            }
//        }
//        return localInstance;
//    }
//    
//    public Connection getConnection() {
//        Context context;
//        Connection connect = null;
//        try {
//            context = new InitialContext();
//            DataSource dSrc = (DataSource)context.lookup("java:comp/env/jdbc/LocalMySQL");
//            connect = dSrc.getConnection();
//        }
//        catch(Exception e) {e.printStackTrace();}
//        return connect;
//    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.estudiantes.datasource;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class EstudiantesDataSource {
    private static final MysqlDataSource DATASOURCE;
    
    static {
        DATASOURCE = new MysqlDataSource();
        DATASOURCE.setUrl("jdbc:mysql://localhost:3306/estudiantes?useSSL=false&allowPublicKeyRetrieval=true");
        DATASOURCE.setUser("user");
        DATASOURCE.setPassword("user_password");
    }

    /**
     * Obtiene una fuente de conexiones a la base de datos Estudiantes
     * @return Un pool de conexiones
     */
    public static MysqlDataSource getDatasource() {
        return DATASOURCE;
    }
    
}

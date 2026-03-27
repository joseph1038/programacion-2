/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Ciudad;
import Model.Departamento;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
/**
 *
 * @author estudiante
 */
public class CiudadDAO {
    public List<Ciudad> getAllCiudades() {

        PreparedStatement ps = null;

        ResultSet rs = null;

        List<Ciudad> listCiudades = new ArrayList<>();

        MySQLConnection con = new MySQLConnection();

        con.conectar();

        String sql = "SELECT D.id idDepto, D.nombre nomDepto,C.id idCiudad, C.nombre nomCiudad, C.habitantes \n" +

"                      FROM ciudad C \n" +

"                      INNER JOIN departamento D ON (C.idDepto = D.id) ORDER BY D.nombre";

        try {

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Departamento departamento = new Departamento();

                departamento.setIdDepto(rs.getString("idDepto"));

                departamento.setNomDepto(rs.getString("nomDepto"));
 
                Ciudad objCiudad = new Ciudad();

                objCiudad.setIdCiudad(rs.getString("idCiudad"));

                objCiudad.setNomCiudad(rs.getString("nomCiudad"));

                objCiudad.setHabitantes(rs.getInt("habitantes"));

                objCiudad.setObjDepto(departamento);

                listCiudades.add(objCiudad);

            }

        } catch (SQLException e) {

            System.err.println(e);

        } finally {

            con.desconectar();

        }

        return listCiudades;

    }
 
}

package net.bigmir;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOFlatImpl implements DAO {
    private Connection conn;
    private String table;
    private List<Flat> list;

    public DAOFlatImpl(Connection conn, String table) {
        this.conn = conn;
        this.table = table;
    }

    public void initDB(){
        try {
            Statement st = conn.createStatement();
            st.execute("CREATE DATABASE IF NOT EXISTS Flats");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init() {
        try {
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS " + table + " (id SERIAL PRIMARY KEY, region VARCHAR(20) NOT NULL, address VARCHAR(20) NOT NULL, square DECIMAL(5,2),rooms INTEGER, price DECIMAL(10,2) NOT NULL )");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addFlat(Flat flat) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + table + " (region,address,square,rooms,price) VALUES(?,?,?,?,?) ");
            ps.setString(1,flat.getRegion());
            ps.setString(2,flat.getAddress());
            ps.setDouble(3,flat.getSquare());
            ps.setInt(4,flat.getRooms());
            ps.setDouble(5,flat.getPrice());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeFlat(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM " + table + " WHERE id='" + id + "'");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Flat> getFlats() {
        list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM "+ table);
            while (resultSet.next()){
                Flat flat = new Flat();
                new GetFlatOnParam().setFlat(flat,resultSet);
                list.add(flat);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

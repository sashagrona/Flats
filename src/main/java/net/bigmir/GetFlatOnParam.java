package net.bigmir;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetFlatOnParam {
    private Connection conn;
    private String table;

    public GetFlatOnParam(Connection conn, String table) {
        this.conn = conn;
        this.table = table;
    }

    public GetFlatOnParam() {
    }

    public void setFlat(Flat flat, ResultSet resultSet) throws SQLException {
        flat.setId(resultSet.getInt(1));
        flat.setRegion(resultSet.getString(2));
        flat.setAddress(resultSet.getString(3));
        flat.setSquare(resultSet.getDouble(4));
        flat.setRooms(resultSet.getInt(5));
        flat.setPrice(resultSet.getDouble(6));
    }


    public List<Flat> getByParam(String param,String value) {
        List<Flat> list = new ArrayList<>();
        String query = getParam(param,value);
        try {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Flat flat = new Flat();
                setFlat(flat, resultSet);
                list.add(flat);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getParam(String param, String value) {
        String query = "";
        if ("region".equals(param)) {
            query = "SELECT * FROM " + table + " WHERE region='" + value + "'";
        }
        if ("address".equals(param)) {
            query = "SELECT * FROM " + table + " WHERE address LIKE '" + value + "%'";
        }
        if ("square".equals(param)) {
            query = "SELECT * FROM " + table + " WHERE square>" + Double.valueOf(value);
        }
        if ("rooms".equals(param)) {
            query = "SELECT * FROM " + table + " WHERE rooms>" + Integer.valueOf(value);
        }
        if ("price".equals(param)) {
            query = "SELECT * FROM " + table + " WHERE price<" + Double.valueOf(value);
        }
        return query;
    }

}

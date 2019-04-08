//package net.bigmir;
//
//import java.sql.Connection;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//
//        ConnectionFactory cf = new ConnectionFactory();
//        Connection conn = cf.getConnection();
//        DAO dao = new DAOFlatImpl(conn, "FlatsTable");
//        dao.init();
//        Flat flatOne = new Flat("Solomyanka", "Vyborzka 2", 16.23, 2, 2000);
//        dao.addFlat(flatOne);
//
//
//        Flat flatTwo = new Flat("Pecherska", "Prokurora 5", 45.32, 5, 10000);
//        dao.addFlat(flatTwo);
//        List<Flat> list = dao.getFlats();
//        for (Flat flat:list) {
//            System.out.println(flat);
//        }
//        GetFlatOnParam getFlatOnParam = new GetFlatOnParam(conn,"FlatsTable");
//        System.out.println(getFlatOnParam.getByParam("address","Vyb"));
//        dao.removeFlat(flatTwo.getId());
//
//    }
//}

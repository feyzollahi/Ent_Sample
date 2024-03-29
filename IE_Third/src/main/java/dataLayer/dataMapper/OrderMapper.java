package dataLayer.dataMapper;

import dataLayer.DBCPDBConnectionPool;
import model.Order;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class OrderMapper {
    public OrderMapper() throws SQLException {
        Connection con1 = DBCPDBConnectionPool.getConnection();
        Statement st =
                con1.createStatement();
//        st.executeUpdate("CREATE TABLE IF NOT EXISTS " + "user" + " " + "(userId TEXT PRIMARY KEY, firstName TEXT," +
//                " firstname TEXT, gpa FLOAT)");
        st.executeUpdate("Create Table IF NOT EXISTS\n" +
                "                order1 (\n" +
                "                        orderId Integer PRIMARY KEY,\n" +
                "                        firstName VARCHAR(100),\n" +
                "                        lastName VARCHAR(100),\n" +
                "                        weight BOOLEAN ,\n" +
                "                        waterProof BOOLEAN,\n" +
                "                        garanti BOOLEAN,\n" +
                "                        goodCamera BOOLEAN,\n" +
                "                        shortEdge BOOLEAN,\n" +
                "                        smallSizeToCanBeInPacket BOOLEAN,\n" +
                "                        color VARCHAR(100) ,\n" +
                "                        screenSize REAL ,\n" +
                "                        ramSize Integer,\n" +
                "                        numOfCamera INTEGER ,\n" +
                "                        backCameraResolution INTEGER ,\n" +
                "                        charger BOOLEAN,\n" +
                "                        cover BOOLEAN,\n" +
                "                        headphone BOOLEAN,\n" +
                "                        wirelessCharger BOOLEAN,\n" +
                "                        antiScratch BOOLEAN\n" +
                "                )");

        st.close();
        con1.close();
    }
    protected String getInsertStatement() {

        return "insert into order1 (orderId, firstName, lastName, weight, waterProof, garanti, goodCamera, shortEdge, smallSizeToCanBeInPacket" +
                ",color, screenSize, ramSize, numOfCamera, backCameraResolution, charger, cover, headphone, wirelessCharger, antiScratch)\n" +
                " Select ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? Where not exists(select * from order1 where orderId=?)";
    }
    public void insertOrder(Order order) throws SQLException {
        int orderId = new Random(1000000).nextInt() + 1;
        String firstName = order.getFirstName();
        String lastName = order.getLastName();
        boolean weight = order.isWeight();
        boolean waterProof = order.isWaterProof();
        boolean garanti = order.isGaranti();
        boolean goodCamera = order.isGoodCamera();
        boolean shortEdge = order.isShortEdgge();
        boolean smallSizeToCanBeInPacket = order.isSmallSizeToCanBeInPacket();
        String color = order.getColor();
        double screenSize = order.getScreenSize();
        int ramSize = order.getRamSize();
        int numOfCamera = order.getNumOfCamera();
        int backCameraResolution = order.getBackCameraResolution();
        boolean charger = order.isCharger();
        boolean cover = order.isCover();
        boolean headphone = order.isHeadphone();
        boolean wirelessCharger = order.isWirelessCharger();
        boolean antiScratch = order.isAntiScratch();
        Connection con = DBCPDBConnectionPool.getConnection();
        String sql = getInsertStatement();
        System.out.println("1");
        try (PreparedStatement st = con.prepareStatement(sql)) {
            System.out.println("2");

            st.setInt(1, orderId);
            st.setString(2, firstName);
            st.setString(3, lastName);
            st.setBoolean(4, weight);
            st.setBoolean(5, waterProof);
            st.setBoolean(6, garanti);
            st.setBoolean(7, goodCamera);
            st.setBoolean(8, shortEdge);
            st.setBoolean(9, smallSizeToCanBeInPacket);
            st.setString(10, color);
            st.setDouble(11, screenSize);
            st.setInt(12, ramSize);
            st.setInt(13, numOfCamera);
            st.setInt(14, backCameraResolution);
            st.setBoolean(15, charger);
            st.setBoolean(16, cover);
            st.setBoolean(17, headphone);
            st.setBoolean(18, wirelessCharger);
            st.setBoolean(19, antiScratch);
            System.out.println("3");

            st.executeUpdate();
            System.out.println("4");

        }
        System.out.println("5");

        con.close();


    }
}

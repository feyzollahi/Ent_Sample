import dataLayer.DBCPDBConnectionPool;
import dataLayer.dataMapper.OrderMapper;
import model.Order;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class sql {
    @Test
    public void insert() throws SQLException {
        OrderMapper orderMapper = new OrderMapper();
        Order order = Order.getInstance();
        insertOrder(order);
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
    protected String getInsertStatement() {

        return "insert into order1 (orderId, firstName, lastName, weight, waterProof, garanti, goodCamera, shortEdge, smallSizeToCanBeInPacket" +
                ",color, screenSize, ramSize, numOfCamera, backCameraResolution, charger, cover, headphone, wirelessCharger, antiScratch)\n" +
                " Select ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? Where not exists(select * from order1 where orderId=?)";
    }
}

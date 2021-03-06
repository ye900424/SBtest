package JdbcTest;

import java.sql.*;

/**
 * @author C.A.O
 * @date 2019/5/21
 */
public class PreparedStatementTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://39.105.17.168:3306:3306/user";
        String user = "root";
        String password = "123456";

        Connection connection =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            String sql = "update user set username=? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,"Fant.J");
            preparedStatement.setInt(2,27);

            int result = preparedStatement.executeUpdate();
            preparedStatement.setString(1,"Fant.J reUseTest");
            preparedStatement.setInt(2,27);
            preparedStatement.executeUpdate();


            String sql2 = "select * from user";

            ResultSet resultSet = preparedStatement.executeQuery(sql2);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String birthday = resultSet.getString("birthday");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");

                System.out.println("  " + username + " " + birthday + " " + sex
                        + " " + address);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}



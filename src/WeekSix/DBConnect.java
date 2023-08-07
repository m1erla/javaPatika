package WeekSix;

import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:mysql://localhost/company";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";
    public static void main(String[] args) {
        Connection dbConnect = null;
        Statement st = null;

        /*  Registration Inquiry */
try {
    dbConnect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    st = dbConnect.createStatement();
    ResultSet resultSet = st.executeQuery("SELECT * FROM employee");
    while (resultSet.next()){
        System.out.println("ID : " + resultSet.getInt("employee_id"));
        System.out.println("Name : " + resultSet.getString("employee_name"));
        System.out.println("Title : " + resultSet.getString("employee_title"));
        System.out.println("Department : " + resultSet.getString("employee_department"));
        System.out.println("Wage : " + resultSet.getInt("employee_wages"));
        System.out.println("Statement : " + resultSet.getString("employee_statement"));
        System.out.println("Address : " + resultSet.getString("employee_address"));
        System.out.println("Priorities : " + resultSet.getString("employee_priorities"));

    }


}catch (SQLException sql){
    System.out.println("SqlException : " + sql.getMessage());
    System.out.println("SqlState : " + sql.getSQLState());
    System.out.println("VendorError : " + sql.getErrorCode());
}
        /*  Registration Included */
//        String preparedQuery = "INSERT INTO employee (employee_name,employee_title,employee_department,employee_wages,employee_statement,employee_address,employee_priorities) VALUES (?, ?, ?, ?, ?, ?, ? )";
//        String insertQuery  = "INSERT INTO employee (employee_name,employee_title,employee_department,employee_wages,employee_statement,employee_address,employee_priorities) " +
//                "VALUES ('Tom Hardy', 'Actor','Hollywood','48000','Create some unique stuff','Oxford street 88B London', 'Be powerful')";
//        try {
//            dbConnect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//
//            st = dbConnect.createStatement();
//
//            dbConnect.setAutoCommit(false);
//            //  st.executeUpdate(insertQuery);
//
//            PreparedStatement pr = dbConnect.prepareStatement(preparedQuery);
//            pr.setString(1, "Furkan Karakus");
//            pr.setString(2, "Full-stack Developer");
//            pr.setString(3, "Software");
//            pr.setInt(4, 40000);
//            pr.setString(5, "As a developer you need to cover your-self ");
//            pr.setString(6, "Oxford street 99C London");
//            pr.setString(7, "Be focus ");
//            pr.executeUpdate();
//            if (true){
//                throw new SQLException();
//            }
//            //st.close();
//
//            dbConnect.commit();
//            dbConnect.close();
//
//        }catch (SQLException ex){
//            try {
//                if (dbConnect != null){
//                    dbConnect.rollback();
//                }
//            }catch (SQLException sql){
//            System.out.println("SQLException : " + sql.getMessage());
//            System.out.println("SQLState : " + sql.getSQLState());
//            System.out.println("VorderError : " + sql.getErrorCode());
//        }
//
//        /*  Registration Update */
//
        try {
            dbConnect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            //st =  dbConnect.createStatement();

            // Update transaction with statements
//            String updateQuery = "UPDATE employee SET employee_name = '2' WHERE employee_id = 2";
//            st.executeUpdate(updateQuery);

            // Update transaction with preparedStatement

            PreparedStatement pr = dbConnect.prepareStatement("UPDATE employee SET employee_name = '?' WHERE employee_id = 2");
            pr.setString(2,"Emma Myers");
            pr.executeUpdate();

          //  st.close();

        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        /*  Registration Delete */
//     try {
//        dbConnect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//        st = dbConnect.createStatement();
//        String deleteQuery = "DELETE FROM * employee WHERE employee_id = 2";
//        st.executeUpdate(deleteQuery);
//
//        PreparedStatement pr = dbConnect.prepareStatement("DELETE FROM * employee WHERE employee_id = ?");
//        pr.setInt(1,3);
//        pr.executeUpdate();
//
//        st.close();
//     }catch (SQLException e) {
//         System.out.println("SQLException: " + e.getMessage());
//         System.out.println("SQLState: " + e.getSQLState());
//         System.out.println("VendorError: " + e.getErrorCode());
//     }
    }
}


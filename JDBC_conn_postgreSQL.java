import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {

    public static void main(String[] args) {

        String query = "select * from student";

        String url = "jdbc:postgresql://localhost:5432/Demo";
        String username = "postgres";
        String password = "parth2625";

        try {

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            //  To execute select query we can use executeQuery()
            //  To execute update query we can use executeUpdate()

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                String name = rs.getString("s_name");
                int age = rs.getInt("s_age");
                String dept = rs.getString("s_dept");
                int sem = rs.getInt("s_sem");

                System.out.println("\nName: " + name);
                System.out.println("Age: " + age);
                System.out.println("Department: " + dept);
                System.out.println("Sem: " + sem);
            }

            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

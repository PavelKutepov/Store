package test_dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pkutepov.com.view.component.MedicineGrid;

import javax.sql.DataSource;
import java.sql.*;
import java.util.concurrent.TimeUnit;

@ContextConfiguration("classpath:WEB-INF/testApplicationContext.xml")
public class test {
    @Autowired

    public void dummy() throws SQLException, InterruptedException {
        for(int i=0;i<1000;i++) {
            String URL = "jdbc:postgresql://localhost/postgres";
            String USER = "postgres";
            String PASSWORD = "postgres";
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pharmacydatabase.medicine");
            ResultSet rs = preparedStatement.executeQuery();
           preparedStatement = connection.prepareStatement("INSERT INTO pharmacydatabase.medicine (name, firm, type, price) VALUES ('sdfg', 'ert', 't', 4);"); preparedStatement.execute();
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

   public void test(){
        MedicineGrid medicineGrid = new MedicineGrid(true);
    }
}


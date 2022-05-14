import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "123Lera01");
            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            String query = "SELECT CarBrand, Model, FuelConsumption, EngimeCapacity FROM world.car WHERE CarBrand = 'Audi'";
            statement.execute(query);
            String query1 = "SELECT CarBrand, Model FROM world.car WHERE FuelConsumption > 4 and FuelConsumption < 10";
            statement1.execute(query1);
            String query2 = "SELECT * FROM world.car WHERE maxSpeed > 200 And maxSpeed < 220";
            statement2.execute(query2);
            ResultSet resultSet = statement.getResultSet();
            ResultSet resultSet1 = statement1.getResultSet();
            ResultSet resultSet2 = statement2.getResultSet();
            while (resultSet.next()) {
                String CarBrand = resultSet.getString("CarBrand");
                String Model = resultSet.getString("Model");
                String FuelConsumption = resultSet.getString("FuelConsumption");
                String EngimeCapacity = resultSet.getString("EngimeCapacity");
                System.out.println(CarBrand + " " + Model + " " + FuelConsumption + " Объем двигателя = " + EngimeCapacity);

            }
            System.out.println("----------------------");
            while (resultSet1.next()) {
                String CarBrand = resultSet1.getString("CarBrand");
                String Model = resultSet1.getString("Model");
                System.out.println(CarBrand + " "+ Model);
            }
            System.out.println("----------------------");
            while (resultSet2.next()) {
                String id = resultSet2.getString("id");
                String CarBrand = resultSet2.getString("CarBrand");
                String Model = resultSet2.getString("Model");
                String FuelConsumption = resultSet2.getString("FuelConsumption");
                String EngimeCapacity = resultSet2.getString("EngimeCapacity");
                System.out.println(id + " " + CarBrand + " " + Model + " расход = "+ FuelConsumption + "Объем двигателя =  " + EngimeCapacity);
            }

            resultSet.close();
            resultSet1.close();
            resultSet2.close();
            statement.close();
            statement1.close();
            statement2.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

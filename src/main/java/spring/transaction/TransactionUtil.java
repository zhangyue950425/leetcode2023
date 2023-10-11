package spring.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionUtil {

    public static final ThreadLocal<Connection> synchronousConnection = new ThreadLocal<>();

    public TransactionUtil() {
    }
    public static Connection startTransaction() {
        Connection connection = synchronousConnection.get();
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqltest?serverTimezone=GMT%2B8",
                        "root", "19950425zy");
                synchronousConnection.set(connection);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static int execute(String sql, Object... args) {
        Connection connection = startTransaction();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void commit() {
        try (Connection connection = synchronousConnection.get()) {
            connection.commit();
            synchronousConnection.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback() {
        try (Connection connection = synchronousConnection.get()) {
            connection.rollback();
            synchronousConnection.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

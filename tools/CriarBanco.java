import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Cria users.db a partir de database/database.sql.
 * Uso: java -cp out:lib/sqlite-jdbc-3.53.1.0.jar CriarBanco [--recriar]
 */
public class CriarBanco {

    public static void main(String[] args) throws Exception {

        Path db = Path.of("users.db");
        boolean recriar = args.length > 0 && args[0].equals("--recriar");

        if (Files.exists(db)) {
            if (!recriar) {
                System.err.println("users.db já existe. Use --recriar para apagar e criar de novo.");
                System.exit(1);
            }
            Files.delete(db);
        }

        String sql = Files.readString(Path.of("database", "database.sql"));

        try (Connection c = DriverManager.getConnection("jdbc:sqlite:users.db");
             Statement st = c.createStatement()) {

            // O script não contém ';' dentro de valores (hashes são Base64).
            for (String comando : sql.split(";")) {
                if (!comando.isBlank()) {
                    st.execute(comando);
                }
            }
        }

        System.out.println("users.db criado a partir de database/database.sql");
    }
}

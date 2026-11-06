import security.PasswordHasher;

/** Uso: java -cp out GerarHash <senha> [<senha> ...] — imprime um hash por linha. */
public class GerarHash {
    public static void main(String[] args) {
        for (String senha : args) {
            System.out.println(PasswordHasher.hash(senha));
        }
    }
}

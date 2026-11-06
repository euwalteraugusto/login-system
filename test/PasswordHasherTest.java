import security.PasswordHasher;

/** Teste simples (sem framework). Saída != 0 se algo falhar. */
public class PasswordHasherTest {

    private static int falhas = 0;

    private static void check(String nome, boolean ok) {
        System.out.println((ok ? "OK   " : "FALHA ") + nome);
        if (!ok) falhas++;
    }

    public static void main(String[] args) {

        String h = PasswordHasher.hash("senha-secreta");
        String h2 = PasswordHasher.hash("senha-secreta");

        check("formato iter$salt$hash", h.split("\\$").length == 3 && h.startsWith(PasswordHasher.ITERATIONS + "$"));
        check("senha correta verifica", PasswordHasher.verify("senha-secreta", h));
        check("senha errada rejeita", !PasswordHasher.verify("senha-secretA", h));
        check("senha vazia rejeita", !PasswordHasher.verify("", h));
        check("salt aleatório (hashes distintos)", !h.equals(h2));
        check("ambos hashes verificam", PasswordHasher.verify("senha-secreta", h2));
        check("hash malformado rejeita", !PasswordHasher.verify("x", "lixo") && !PasswordHasher.verify("x", "a$b$c") && !PasswordHasher.verify("x", "1$$"));
        check("texto puro legado rejeita", !PasswordHasher.verify("123456", "123456"));
        check("null rejeita", !PasswordHasher.verify(null, h) && !PasswordHasher.verify("x", null));

        System.exit(falhas == 0 ? 0 : 1);
    }
}

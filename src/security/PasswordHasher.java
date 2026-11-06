package security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

/**
 * Hash de senha com PBKDF2WithHmacSHA256 (somente JDK, sem bibliotecas).
 *
 * Formato armazenado: "iteracoes$salt$hash" (salt e hash em Base64).
 */
public final class PasswordHasher {

    public static final int ITERATIONS = 600_000;
    private static final int SALT_BYTES = 16;
    private static final int HASH_BYTES = 32;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int MAX_ITERATIONS = 10_000_000;

    private static final SecureRandom RANDOM = new SecureRandom();

    private PasswordHasher() {
    }

    public static String hash(String password) {

        byte[] salt = new byte[SALT_BYTES];
        RANDOM.nextBytes(salt);

        byte[] hash = pbkdf2(password.toCharArray(), salt, ITERATIONS, HASH_BYTES);

        return ITERATIONS + "$"
                + Base64.getEncoder().encodeToString(salt) + "$"
                + Base64.getEncoder().encodeToString(hash);
    }

    /**
     * Retorna true se a senha confere com o hash armazenado.
     * Formato inválido retorna false (nunca lança exceção).
     */
    public static boolean verify(String password, String stored) {

        if (password == null || stored == null) {
            return false;
        }

        String[] parts = stored.split("\\$");

        if (parts.length != 3) {
            return false;
        }

        try {

            int iterations = Integer.parseInt(parts[0]);

            if (iterations < 1 || iterations > MAX_ITERATIONS) {
                return false;
            }

            byte[] salt = Base64.getDecoder().decode(parts[1]);
            byte[] expected = Base64.getDecoder().decode(parts[2]);

            if (expected.length == 0) {
                return false;
            }

            byte[] actual = pbkdf2(password.toCharArray(), salt, iterations, expected.length);

            // Comparação em tempo constante
            return MessageDigest.isEqual(expected, actual);

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes) {

        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);

        try {

            return SecretKeyFactory.getInstance(ALGORITHM).generateSecret(spec).getEncoded();

        } catch (GeneralSecurityException e) {

            throw new IllegalStateException("PBKDF2 indisponível no JDK", e);

        } finally {

            spec.clearPassword();
            Arrays.fill(password, '\0');
        }
    }
}

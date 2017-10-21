package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory factory;
    static {
        factory = Persistence.createEntityManagerFactory("jpa");
    }
    public static EntityManagerFactory getFactory() {
        return factory;
    }

}

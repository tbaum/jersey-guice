package test;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author tbaum
 * @since 11.07.11
 */
public class JpaInitializer {
// ------------------------------ FIELDS ------------------------------

    private final static Log LOG = LogFactory.getLog(JpaInitializer.class);

// --------------------------- CONSTRUCTORS ---------------------------

    @Inject public JpaInitializer(PersistService persistService) throws Throwable {
        try {
            persistService.start();
        } catch (Throwable e) {
            LOG.error(e, e);
            throw e;
        }
    }
}

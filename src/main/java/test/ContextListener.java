package test; /**
 * @author tbaum
 * @since 11.07.11
 */

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;


public class ContextListener extends GuiceServletContextListener {

    @Override protected Injector getInjector() {
        return Guice.createInjector(
                new JerseyServletModule() {
                    @Override protected void configureServlets() {

                        bind(Endpoint.class);
                        serve("/*").with(GuiceContainer.class);

                    }
                },
                new JpaPersistModule("unknown"),
                new AbstractModule() {
                    @Override protected void configure() {
                        bind(JpaInitializer.class).asEagerSingleton();
                    }
                }
        );
    }
}

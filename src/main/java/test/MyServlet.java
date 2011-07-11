package test;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.servlet.RequestScoped;

import javax.inject.Provider;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tbaum
 * @since 11.07.11
 */
@Singleton
public class MyServlet extends HttpServlet {

    private Provider<HttpServletRequest> requestProvider;
    private Provider<HttpServletResponse> responseProvider;

    @Inject
    public MyServlet(Provider<HttpServletRequest> requestProvider, Provider<HttpServletResponse> responseProvider
    ) {
        this.requestProvider = requestProvider;
        this.responseProvider = responseProvider;
    }

    @Override @RequestScoped
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doFoo();
    }

    private void doFoo() throws IOException {
        HttpServletResponse response = responseProvider.get();
        response.getWriter().print("123456789");
    }
}

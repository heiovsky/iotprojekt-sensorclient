package phwb.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import phwb.AppPath;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter implements Filter {

    @Value("${x-pckey}")
    private String XPCKEY;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getHeader("x-pckey") != null
                && request.getHeader("x-pckey").equals(XPCKEY)
                && request.getRequestURI().equals(AppPath.SensorsPath)) {
            chain.doFilter(req, res);
        } else {
            res = res;
            ((HttpServletResponse) res).sendRedirect("https://pl.wikipedia.org/wiki/Efren_Reyes");
            return;
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }


}

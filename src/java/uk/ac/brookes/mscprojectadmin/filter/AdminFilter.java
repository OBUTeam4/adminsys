package uk.ac.brookes.mscprojectadmin.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Quentin
 */
@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter implements Filter{

    /**
     *
     */
    public AdminFilter() {
    }

    /**
     *
     */
    @Override
    public void destroy() {
    }

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        /*if (rq.getSession().getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/login").forward(request, response);
        }*/
    }

    /**
     *
     * @param fConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

}

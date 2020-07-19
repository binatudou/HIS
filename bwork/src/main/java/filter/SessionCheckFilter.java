package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "lib", value = "/lib/"),
		@WebInitParam(name = "indexPage", value = "index.jsp"), @WebInitParam(name = "loginPage", value = "login.html"),
		@WebInitParam(name = "loginServlet", value = "login") })
public class SessionCheckFilter implements Filter {
	// 用于获取初始化参数
	private FilterConfig config;

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

	public void destroy() {
		this.config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String requestPath = ((HttpServletRequest) request).getServletPath();

		System.out.println("session filter path......:" + requestPath);

		if (!allow(session, requestPath)) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			chain.doFilter(request, response);
		}
	}

	private boolean allow(HttpSession session, String requestPath) {
		// String indexPage = config.getInitParameter("indexPage");
		// String lib = config.getInitParameter("lib");
		// String loginServlet = config.getInitParameter("loginServlet");
		// String loginPage = config.getInitParameter("loginPage");

		// return session.getAttribute("authority") != null || requestPath.endsWith(indexPage)
		// 		|| requestPath.endsWith(loginPage) || requestPath.endsWith(loginServlet) || requestPath.startsWith(lib);
		//test
		return true;
	}
}
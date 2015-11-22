package br.com.alexandre;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.userdetails.User;

@WebServlet(value="/protected", name="protectedServlet")
public class ProtectedServlet extends HttpServlet {

	private static final long serialVersionUID = -4718739199311134131L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final CasAuthenticationToken token = (CasAuthenticationToken) req.getUserPrincipal();

		final User user = (User) token.getPrincipal();
		
		resp.getWriter().println();
		resp.getWriter().println("########################## My Service Three ##########################");
		resp.getWriter().println("UserName: " + user.getUsername());
		resp.getWriter().println("Authorities: " + user.getAuthorities());
		resp.getWriter().println("Account Non Expired: " + user.isAccountNonExpired());
		resp.getWriter().println("Account Non Locked: " + user.isAccountNonLocked());
		resp.getWriter().println("Credentials Non Expired: " + user.isCredentialsNonExpired());
		resp.getWriter().println("Service Three!");
		resp.getWriter().println("########################## My Service Three ##########################");
		resp.getWriter().println();
	}

}

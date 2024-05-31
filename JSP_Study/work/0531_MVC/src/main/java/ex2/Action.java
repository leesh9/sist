package ex2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	abstract String exe(HttpServletRequest request, HttpServletResponse response);
}

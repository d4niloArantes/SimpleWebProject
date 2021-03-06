package me.impressione.fpu.simplewebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/soma")
public class SomaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String xstr = req.getParameter("x");
		String ystr = req.getParameter("y");

		String operacao = req.getParameter("operacao");
		PrintWriter writer = resp.getWriter();
		try {
			int x = Integer.parseInt(xstr);
			int y = Integer.parseInt(ystr);

			Integer resultado = null;
			switch (operacao) {
			case "soma":
				resultado = x + y;
				break;

			case "subtrai":
				resultado = x - y;
				break;

			default:
				break;
			}
			writer.write(String.format("Resultado da soma %s", resultado));
		} catch (NumberFormatException ex) {
			writer.write("Este metodo aceita apenas numeros");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("Esta url suporta apenas o metodo POST");
	}
}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.News;
import service.NewsService;

@WebServlet(name = "newsServlet", urlPatterns = { "/news" })
public class NewsServlet extends HttpServlet {

	private NewsService newsService = new NewsService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<News> list = newsService.findAll();
		
		req.setAttribute("news", list);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);;
	}
}

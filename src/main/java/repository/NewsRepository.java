package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import model.News;

public class NewsRepository {

	public List<News> findAll() {
		List<News> list = new ArrayList<News>();
		
		try {
			Connection connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM news";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				News news = new News();
				news.setId(result.getInt("id"));
				news.setTitle(result.getString("title"));
				news.setContent(result.getString("content"));
				news.setImageUrl(result.getString("image_url"));
				news.setPublishDate(result.getDate("publish_date"));
				
				list.add(news);
			}
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
		
		return list;
	}
}

package service;

import java.util.List;

import model.News;
import repository.NewsRepository;

public class NewsService {

	private NewsRepository newsRepository = new NewsRepository();
	
	public List<News> findAll() {
		return newsRepository.findAll();
	}
}

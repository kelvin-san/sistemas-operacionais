package controller;

public interface INetflixController {
	
	public void filterByMajorGenre(String genre) throws Exception;
	public void filterByPremiereYear(int year) throws Exception;
	public void createHashTableByRating();
	public void showRatingHashTable() throws Exception;
	
}

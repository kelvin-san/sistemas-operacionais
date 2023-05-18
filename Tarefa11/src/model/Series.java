package model;

public class Series {
	public String majorGenre;
	public String title;
	public String subGenre;
	public int premiereYear;
	public int episodes;
	public String status;
	public int imdbRating;
	
	@Override
	public String toString() {
		return "Series [majorGenre=" + majorGenre + ", title=" + title + ", subGenre=" + subGenre + ", premiereYear="
				+ premiereYear + ", episodes=" + episodes + ", status=" + status + ", imdbRating=" + imdbRating + "]";
	}
	
}

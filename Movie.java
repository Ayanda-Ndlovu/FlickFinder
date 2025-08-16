package mvc;

public class Movie implements MovieF {
	private String title;
	private int year;
	private String genre;
	private String description;

	public Movie(String title,int year, String genre,String description) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.year=year;
		this.genre=genre;
		this.description=description;
	}
	public String getTitle() {
		return title;
	}
	public int getYear() {
		return year;
	}
	public String getGenre() {
		return genre;
	}
	public String getDescription() {
		return description;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setYear(int year) {
		this.year=year;
	}
	public void setGenre(String genre) {
		this.genre=genre;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	

}

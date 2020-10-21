package model;
public class Song{
	private String title;
	private String artist;
	private String releaseDate;
	private int duration;
	
	private Genre genre;
	
	public Song(String title, String artist, String releaseDate, int duration, int genreNum){
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.duration = duration;
		enumGenre(genreNum);
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getArtist(){
		return artist;
	}
		
	public String getReleaseDate(){
		return releaseDate;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public Genre getGenre(){
		return genre;
	}
	
	public void enumGenre(int genreNum){
	switch(genreNum){
		case 0:
			this.genre = Genre.Rock;
			break;
		case 1:
			this.genre = Genre.Hip_hop;
			break;
		case 2:
			this.genre = Genre.Clasica;
			break;
		case 3:
			this.genre = Genre.Reggae;
			break;
		case 4:
			this.genre = Genre.Salsa;
			break;
		case 5:
			this.genre = Genre.Metal;
			break;
		case 6:
			this.genre = Genre.Desconocido;
			break;
		}
	}
}
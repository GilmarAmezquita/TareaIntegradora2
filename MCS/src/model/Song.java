public class Song{
	private final String GENRE_ROCK = "Rock";
	private final String GENRE_HIP_HOP = "Hip hop";
	private final String GENRE_CLASSIC = "Musica clasica";
	private final String GENRE_REGGAE = "Reggae";
	private final String GENRE_SALSA  = "Salsa";
	private final String GENRE_METAL = "Metal";
	
	private String title;
	private String artist;
	private String releaseDate;
	private int duration;
	private String genre;
	
	public Song(String title, String artist, String releaseDate, int duration, String genre){
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.genre = genre;
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
	
	public String getGenre(){
		return genre;
	}
}
package model; 

public class Songs{
	// the title of the song
	private String title;
	// the artist or name of the band of the song
	private String artistNameOrBand;
	// the duration of the song
	private int duration;
	
	// the release date of the song
	private Date date;
	// the genre of the song
	private Genre genre;
	
	/**
	*Default constructor of the class Songs
	*/
	public Songs(){}
	
	public Songs(String title, String artistNameOrBand, int duration){
		this.title=title;
		this.artistNameOrBand=artistNameOrBand;
		this.duration=duration;
	}
	
	/**
	*The method returns the date value of the class Date as a String <br>
	*<b>pre: the creation of the method dateToString in the class Date</b> 
	*<b>post: </b>
	*@return String, the release date of the song
	*/
	public String getDate(){
		return date.dateToString();
	}
	
	/**
	*The method returns the genre field from the enum class Genre <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return Genre, the genre of the song 
	*/
	public Genre getGenre(){
		return genre;
	}
	
	/**
	*The method returns the field title <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return String, the title of the song 
	*/
	public String getTitle(){
		return title;
	}
	
	/**
	*The method returns the field artistNameOrBand <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return String, the artistNameOrBand of the song 
	*/
	public String getArtistNameOrBand(){
		return artistNameOrBand;
	}
	
	/**
	*The method returns the field duration <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return int, the duration of the song 
	*/
	public int getDuration(){
		return duration;
	}
	
	/**
	*The method changes the value of the field title <br>
	*<b>pre: </b> 
	*<b>post:changes the value of field title </b>
	*@param title, the title of the song given by the user
	*/
	public void setTitle(String title){
		this.title=title;
	}
	
	/**
	*The method changes the value of the field artistNameOrBand <br>
	*<b>pre: </b> 
	*<b>post:changes the value of field artistNameOrBand </b>
	*@param artistNameOrBand, the artist name or band of the song given by the user
	*/
	public void setArtistNameOrBand(String artistNameOrBand){
		this.artistNameOrBand=artistNameOrBand;
	}
	
	/**
	*The method changes the value of the field duration <br>
	*<b>pre: </b> 
	*<b>post:changes the value of field duration </b>
	*@param duration, the duration of the song given by the user
	*/
	public void setDuration(int duration){
		this.duration=duration;
	}
	
	/**
	*The method gives the duration of the song in mm:ss format <br>
	*<b>pre: </b> 
	*<b>post:</b>
	*@return String, the duration of the song in mm:ss
	*/
	public String durationToString(){
		int minutes =(int)(duration/60);
		int seconds =(int)(duration%60);
		return minutes+":"+seconds;
	}
	
	/**
	*The method gives the necessary values for an object of the class Date to be created <br>
	*<b>pre: </b> 
	*<b>post:</b>
	*@param day, the day the song was released
	*@param month, the month the song was released
	*@param year, the year the song was released
	*/
	public void giveDate(int day, int month, int year){
		this.date= new Date(day, month, year);
	}
	
	/**
	*The method takes a String given by the user and uses it to give the song a genre from the enum class Genre <br>
	*<b>pre: </b> 
	*<b>post:changes the value of the field genre</b>
	*@param genre, the String genre of the song given by the user
	*/
	public void giveGenre(String genre){
		genre=genre.toUpperCase();
		this.genre= Genre.valueOf(genre);
	}
	

}
	
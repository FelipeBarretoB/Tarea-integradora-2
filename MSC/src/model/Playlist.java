package model; 

public class Playlist{
	
	// the maximun number of songs permited
	public static final int MAXSONGS=30;
	// the name of the playlist
	private String name;
	// the song genres present in the playlist
	private String genreType;
	// the number of songs added to the playlist
	private int addedSongs;
	// the duration of the playlist
	private String duration;
	
	// array of the Class Song, holds the songs added to the playlist 
	private Songs[] song;
	
	/**
	*Default constructor of the class User
	*/
	public Playlist(){}
	
	/**
	*Overloaded constructor of the class User
	*duration, field keep the playlist duration
	*genreType, field to keep the playlist genres
	*@param name, gives the playlist a name
	*/
	public Playlist(String name){
		this.name=name;
		this.duration="0";
		this.genreType= "Desconocido";
	}
	
	/**
	*The method returns the value of the field userName <br>
	*<b>pre: the creation of the constant MAXSONGS</b> 
	*<b>post: gives the song array a length, and gives a initial value to addedSongs</b>
	*/
	public void createSongArray(){
		song= new Songs[MAXSONGS];
		addedSongs=0;
	}
	
	/**
	*The method gives the song array a song, adds 1 to addedSongs, and uses updatePlaylist to update the playlist <br>
	*<b>pre: the creation of the field addedSongs, free space in the array in the 'addedSongs' position, the creation of the method updatePlaylist</b> 
	*<b>post: gives a song to the song array, adds 1 to addedSongs, changes the duration of the playlist and it's genre</b>
	*@param name, name of the user that wants to add a song
	*@param songs, the song the user wants to add to the playlist
	*/
	public void addSong(String name, Songs songs){
		song[addedSongs] = songs;
		addedSongs++;
		updatePlaylist();
		
	}
	
	/**
	*The method is used to give a rating to a playlist, this method is overriden, depending on the class <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@param rating, the rating the user wants to give 
	@return String, a message that says this playlist can't be given a rating 
	*/
	public String giveRating(double rating){
		return "Esto no aplica para la playlist";
	}
	
	/**
	*The method checks if the user can edit the play, this method is overriden depending on the class <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@param name, the name of the user that wants to edit the playlist
	*@return boolean, this determines if the user can edit the playlist 
	*/
	public boolean checkUser(String name){
		return true;
	}
	
	
	/**
	*The method updates the genre type of the playlist, and it's duration <br>
	*<b>pre: The array song has to have a length, and at least 1 value</b> 
	*<b>post: Changes the value of the fields duration and genreType </b>
	*/
	public void updatePlaylist(){
		if(genreType.equals("Desconocido")){
			genreType=song[0].getGenre().name();
		}else{
			for(int c=1; c<addedSongs;c++){
				genreType+=", "+song[c].getGenre().name();
			}
		}
		int length=0;
		for(int c=0;c<addedSongs;c++){
			length+=song[c].getDuration();
		}
		int minutes =(int)(length/60);
		int seconds =(int)(length%60);
		setDuration(minutes+":"+seconds);
		
	}
	
	/**
	*The method returns a String with the format that it's asked for <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return String, a String with the playlist information
	*/
	public String printPlaylist(){
		String print=
		"**************  Playlist ************** \n"+
		"**  Title: "+getName()+" \n"+
		"**  Duration: "+getDuration()+" \n"+
		"**  Genre: "+getGenreType()+" \n";
		return print;
	}
	
	/**
	*The method returns the name of the playlist <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return String, the name of the playlist
	*/
	public String getName(){
		return name;
	}
	
	/**
	*The method returns the duration of the playlist <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return String, the duration of the playlist
	*/
	public String getDuration(){
		return duration;
	}
	
	/**
	*The method returns the genreType of the playlist <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return String, the genreType of the playlist
	*/
	public String getGenreType(){
		return genreType;
	}
	
	/**
	*The method gives a new value to the name of the playlist <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@param name, the new name of the playlist
	*/
	public void setName(String name){
		this.name=name;
	}
	
	/**
	*The method gives a new value to the duration of the playlist <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@param duration, the new duration of the playlist
	*/
	public void setDuration(String duration){
		this.duration=duration;
	}
	
	/**
	*The method gives a new value to the genreType of the playlist <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@param genreType, the new genreType of the playlist
	*/
	public void setGenreType(String genreType){
		this.genreType=genreType;
	}
	
	
	
}
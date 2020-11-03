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
	*<b>post: gives the song array a length, and gives a initial value to addSong</b>
	*
	*/
	public void createSongArray(){
		song= new Songs[MAXSONGS];
		addedSongs=0;
	}
	
	public void addSong(String name, Songs songs){
		song[addedSongs] = songs;
		addedSongs++;
		updatePlaylist();
		
	}
	
	public String giveRating(double rating){
		return "Esto no aplica para la playlist";
	}
	
	public boolean checkUser(String name){
		return true;
	}
	
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
	
	public String printPlaylist(){
		String print=
		"**************  Playlist ************** \n"+
		"**  Title: "+getName()+" \n"+
		"**  Duration: "+getDuration()+" \n"+
		"**  Genre: "+getGenreType()+" \n";
		return print;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDuration(){
		return duration;
	}
	
	public String getGenreType(){
		return genreType;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setDuration(String duration){
		this.duration=duration;
	}
	
	
	public void setGenreType(String genreType){
		this.genreType=genreType;
	}
	
	
	
}
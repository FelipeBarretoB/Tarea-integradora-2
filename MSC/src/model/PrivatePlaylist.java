package model;

public class PrivatePlaylist extends Playlist{
	// The user name of the user who can edit the playlist
	private String permitedUserName;
	
	
	/**
	*The overloaded constructor of the class PrivatePlaylist <br>
    *Uses the super constructor from the super class Playlist
	*@param permitedUserName, the name of the user who can edit the private playlist
	*@param name, the name of the playlist
	*/
	public PrivatePlaylist(String permitedUserName, String name){
		super(name);
		this.permitedUserName=permitedUserName;
	}
	
	/**
	*The method returns boolean that determines if the user can edit the playlist <br>
    *<b>pre:  </b> 
	*<b>post: </b>
	*@param name, the name of the user who wants to edit the playlist
	*@return boolean, determines if the user can edit the the playlist
	*/
	@Override
	public boolean checkUser(String name){
		return permitedUserName.equals(name);
	}
	
	/**
	*The method adds a song to the song array <br>
    *<b>pre: The creation of the super class Playlist, the creation of the checkUser method</b> 
	*<b>post: Adds a song to the song array</b>
	*@param name, the name of the user who wants to edit the playlist
	*@param songs, the Song object that the user wants to add to the song array
	*/
	@Override
	public void addSong(String name, Songs songs){
		if(checkUser(name)){
			super.addSong(name, songs);
			
		}
	}
	
	/**
	*The method returns a String with the values of the private playlist <br>
    *<b>pre: The creation of the super class Playlist </b> 
	*<b>post: </b>
	*@return String, the values of the private playlist with a specific format
	*/
	@Override
	public String printPlaylist(){
		String print= super.printPlaylist();
		print+=
			"** User: "+permitedUserName+"\n"+
			"***********************************";
		return print;
	}
	
}
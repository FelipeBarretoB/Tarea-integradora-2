package model;

public class RestrictedPlaylist extends Playlist{
	//the maximun number of users that can edit the playlist
	public static final int MAXCONTRIBUTORS=5;
	//A string array that holds the names of the users that can edit the playlist
	private String[] permitedUsers;
	
	
	/**
	*The overloaded constructor of the class RestrictedPlaylist <br>
    *Uses the super constructor from the super class Playlist
	*@param name, the name of the playlist
	*@param permitedUsers, the array of permited users
	*/
	public RestrictedPlaylist(String name, String[] permitedUsers){
		super(name);
		this.permitedUsers=permitedUsers;
	}
	
	/**
	*The method gives a new value to the duration of the playlist <br>
	*<b>pre:The creation of the super class Playlist, the existence of the permitedUsers array </b> 
	*<b>post: </b>
	*@return boolean, this determines if the user can edit the playlist
	*/
	@Override
	public boolean checkUser(String name){
		boolean permited=false;
		for(int c=0; c <MAXCONTRIBUTORS &&permitedUsers[c]!=null;c++){
			if(permitedUsers[c].equals(name)){
				permited=true;
			}
		}
		return permited;
	}
	
	/**
	*The method gives a object of the class Songs to the song array <br>
	*<b>pre: the creation of the method checkUser </b> 
	*<b>post: adds a song to the Songs array</b>
	*@param name, the name of the user who want to edit the playlist
	*@param songs, an object of the class Songs
	*/
	@Override
	public void addSong(String name, Songs songs){
		if(checkUser(name)){
			super.addSong(name, songs);
			
		}
	}
	
	/**
	*The method returns a String with the user names of the users that can edit the playlist <br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return String, the names of the users that can edit the playlist
	*/
	public String printUsers(){
		String users =permitedUsers[0];
		for(int c=1; c <MAXCONTRIBUTORS &&permitedUsers[c]!=null;c++){
			users+=", "+permitedUsers[c];
			}
			return users;
		}
		


	/**
	*The method returns a String with the permited users in a specific format <br>
	*<b>pre:The creation of the printUsers method </b> 
	*<b>post: </b>
	*@return String, the permited users with a specific format
	*/
	@Override
	public String printPlaylist(){
		String print= super.printPlaylist();
		print+=
			"** Users: "+printUsers()+"\n"+
			"***********************************";
		return print;
	}
}
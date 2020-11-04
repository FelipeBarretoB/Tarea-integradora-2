package model;

public class MSC{
	//the maximun number of songs the user can add
	public static final int MAXSONG=30;
	//the maximun number of playlist the user can add
	public static final int MAXPLAYLIST=20;
	//the maximun number of users the user can add
	public static final int MAXUSERS=10;
	//the playlist array
	private Playlist[] playlist;
	//the song array
	private Songs[] song;
	//the user array
	private User[] user; 
	//the number of playlist created
	private int playListCreated;
	//the number of songs created
	private int songCreated;
	//the number of users created 
	private int userCreated;
	
	/**
	* The default constructor of the class MSC
	*Gives the song, playlist and user array a length
	*starts all the acumulators at 0
	*/
	public MSC(){
		playlist=new Playlist[MAXPLAYLIST];
		song=new Songs[MAXSONG];
		user=new User[MAXUSERS];
		playListCreated=0;
		songCreated=0;
		userCreated=0;
	}
	
	/**
	*The method returns boolean that determines if there is space for another user <br>
    *<b>pre:  </b> 
	*<b>post: </b>
	*@return boolean, determines if the another user can be created 
	*/
	public boolean hasUserSpace(){
		return userCreated < MAXUSERS;
	}
	
	/**
	*The method returns boolean that determines if there is space for another playlist <br>
    *<b>pre:  </b> 
	*<b>post: </b>
	*@return boolean, determines if the another playlist can be created 
	*/
	public boolean hasPlayListSpace(){
		return playListCreated<MAXPLAYLIST;
	}
	
	/**
	*The method returns boolean that determines if there is space for another song <br>
    *<b>pre:  </b> 
	*<b>post: </b>
	*@return boolean, determines if the another song can be created 
	*/
	public boolean hasSongSpace(){
		return songCreated<MAXSONG;
	}
	
	/**
	*The method creates a new user <br>
    *<b>pre:  The user array has a length, the creation of the method updateCategory from the User class</b> 
	*<b>post: Add a value to the user array </b>
	*@param name, user name of the user
	*@param password, password of the user
	*@param age, age of the user 
	*@param songsShared, the amount of songs the user has shared
	*/
	public void createUser(String name, String password, int age, int songsShared){
			user[userCreated]=new User(name,password,age,songsShared);
			user[userCreated].updateCategory(); 
			userCreated++;
	}
	
	/**
	*The method returns boolean that determines if the user exists <br>
    *<b>pre: the creation of the method addedSong </b> 
	*<b>post: </b>
	*@param name, name of the user 
	*@return boolean, if the user exists 
	*/
	public boolean userExists(String name){
		boolean userExists=false;
		for(int c=0; c<userCreated;c++){
			if(user[c].getUserName().equals(name)){
				userExists=true;
				addedSong(c);
			}
		}
		return userExists;
	}
			
	/**
	*The method updates the user category <br>
    *<b>pre: the creation of the method hasAddedSong from the User class </b> 
	*<b>post: </b>
	*@param c, the index of the user in the usar array
	*/
	public void addedSong(int c){
		user[c].hasAddedSong();
	}
	
	/**
	*The method adds a song to the song array <br>
    *<b>pre: the creation of the method giveDate and giveGenre from the Songs class </b> 
	*<b>post: </b>
	*@param title, title of the song
	*@param nameOfArtistOrBand, the artist or band that made the song
	*@param duration, the duration of the song
	*@param day, the day of release of the song
	*@param month, the month of release of the song
	*@param year, the year of release of the song
	*@param genre, the genre of the song
	*/
	public void createSong(String title, String nameOfArtistOrBand, int duration, int day, int month, int year, String genre){
		song[songCreated]=new Songs(title, nameOfArtistOrBand, duration);
		song[songCreated].giveDate(day, month, year);
		song[songCreated].giveGenre(genre);
		songCreated++;	

	}
	/**
	*The method adds a public playlist to the playlist array <br>
    *<b>pre: the creation of the method createSongArray from the Playlist class </b> 
	*<b>post: adds a public playlist to the playlist array</b>
	*@param name, name of the playlist
	*@param rating, the rating of the public playlist
	*@param amountOfRatings, the amount of ratings from the public class
	*/
	public void createPublicPlaylist(String name,double rating, double amountOfRatings){
		playlist[playListCreated]=new PublicPlaylist(name,rating,amountOfRatings);
		playlist[playListCreated].createSongArray();
		playListCreated++;
	}
	
	/**
	*The method adds a private playlist to the playlist array <br>
    *<b>pre: the creation of the method createSongArray from the Playlist class </b> 
	*<b>post: adds a private playlist to the playlist array</b>
	*@param userName, the user name of the user who can edit the playlist 
	*@param name, name of the playlist
	*/
	public void createPrivatePlaylist(String userName, String name){
		playlist[playListCreated]=new PrivatePlaylist(userName, name);
		playlist[playListCreated].createSongArray();
		playListCreated++;
	}
	
	/**
	*The method adds a restricted playlist to the playlist array <br>
    *<b>pre: the creation of the method createSongArray from the Playlist class </b> 
	*<b>post: adds a restricted playlist to the playlist array</b>
	*@param permitedUsers, the permited users who can edit the playlist
	*@param name, name of the playlist
	*/
	public void createRestrictedPlaylist(String[] permitedUsers, String name){
		playlist[playListCreated]=new RestrictedPlaylist( name,  permitedUsers);
		playlist[playListCreated].createSongArray();
		playListCreated++;
	}
	
	/**
	*The method returns the index of a song in the song array, if it can't find it, returns -1 <br>
    *<b>pre: the creation of the method getTitle from the Songs class </b> 
	*<b>post: </b>
	*@param songName, the song that wants to be found
	*@return int, the index of the song in the song array
	*/
	public int findSong(String songName){
		int songPointer=-1;
		for(int c=0;c<songCreated;c++){
			if(song[c].getTitle().equals(songName)){
				songPointer=c;
			}
		}
		return songPointer;
	}
	
	/**
	*The method returns the index of a playlist in the playlist array, if it can't find it, returns -1 <br>
    *<b>pre: the creation of the method getName from the Playlist class </b> 
	*<b>post: </b>
	*@param playlistName, the playlist that wants to be found
	*@return int, the index of the playlist in the playlist array
	*/
	public int findPlaylist(String playlistName){
		int playlistPointer=-1;
		for(int c=0;c<playListCreated;c++){
			if(playlist[c].getName().equals(playlistName)){
				playlistPointer=c;
			}
		}
		return playlistPointer;
	}
	
	/**
	*The method returns a boolean that determines if the user can edit the playlist <br>
    *<b>pre: the creation of the method checkUser from the Playlist class </b> 
	*<b>post: </b>
	*@param name, the name of the user that wants to edit the playlist
	*@param playlistName, the playlist that the user wants to edit 
	*@return  boolean, determines if the user can or can't edit the playlist
	*/
	public boolean verifyUser(String name,String playlistName){
		return playlist[findPlaylist(playlistName)].checkUser(name);
	}
	
	/**
	*The method adds a song to a playlist <br>
    *<b>pre: the creation of the method addSong from the Playlist class </b> 
	*<b>post: adds a song to the playlist</b>
	*@param songName, the name of the song that the user wants to add
	*@param playlistName, the name of the playlist to which the song will be aded
	*@param name, the name of the user who added the song
	*/
	public void playlistAddSong(String songName,String playlistName, String name){
		playlist[findPlaylist(playlistName)].addSong(name,song[findSong(songName)]);
	}
	
	/**
	*The method returns a String with the rating of a playlist <br>
    *<b>pre: the creation of the method giveRating from the Playlist class </b> 
	*<b>post: </b>
	*@param playlistName, the name of the playlist to which the song will be aded
	*@param rating, the rating given to the playlist
	*@return String, the average rating of the playlist
	*/
	public String ratePlaylist(String playlistName, double rating){
		return playlist[findPlaylist(playlistName)].giveRating(rating);
	}
	
	/**
	*The method returns a String with all the playlist formats <br>
    *<b>pre: the creation of the method printPlaylist from the Playlist class </b> 
	*<b>post: </b>
	*@return String, a String with all the playlist formats in it 
	*/
	public String getPlaylist(){
		String print="";
		for(int c=0;c<playListCreated;c++){
			print+=playlist[c].printPlaylist();
		}
		return print;
	}
	
	/**
	*The method returns an int with the amount if users created <br>
    *<b>pre:  </b> 
	*<b>post: </b>
	*@return int, the number of users created
	*/
	public int getUserCreated(){
		return userCreated;
	}
	
	/**
	*The method returns an int with the amount if songs created <br>
    *<b>pre:  </b> 
	*<b>post: </b>
	*@return int, the number of songs created
	*/
	public int getSongCreated(){
		return songCreated;
	}
	
	/**
	*The method returns the name of the user in the position c of the user array <br>
    *<b>pre:  The cretion of the user array </b> 
	*<b>post: </b>
	*@param c, the index of the array
	*@return String, the name of the user in the index c 
	*/
	public String getUserName(int c){
		return user[c].getUserName();
	}
	/**
	*The method returns the age of the user in the position c of the user array <br>
    *<b>pre:  The cretion of the user array </b> 
	*<b>post: </b>
	*@param c, the index of the array
	*@return int, the age of the user in the index c 
	*/
	public int getUserAge(int c){
		return user[c].getAge();
	}
	
	/**
	*The method returns the category of the user in the position c of the user array <br>
    *<b>pre:  The cretion of the user array </b> 
	*<b>post: </b>
	*@param c, the index of the array
	*@return Category, the category of the user in the index c 
	*/
	public Category getUserCategory(int c){
		return user[c].getCategory();
	}
	
	/**
	*The method returns the title of the song in the position c of the song array <br>
    *<b>pre:  The cretion of the song array </b> 
	*<b>post: </b>
	*@param c, the index of the array
	*@return String, the title of the song in the index c 
	*/
	public String getTitle(int c){
		return song[c].getTitle();
	}
	
	/**
	*The method returns the artist or band of the song in the position c of the song array <br>
    *<b>pre:  The cretion of the song array </b> 
	*<b>post: </b>
	*@param c, the index of the array
	*@return String, the artist or band of the song in the index c 
	*/
	public String getArtist(int c){
		return song[c].getArtistNameOrBand();
	}
	
	/**
	*The method returns the duration of the song in the position c of the song array <br>
    *<b>pre:  The cretion of the song array </b> 
	*<b>post: </b>
	*@param c, the index of the array
	*@return String, the duration of the song in the index c 
	*/
	public String getDuration(int c){
		return song[c].durationToString();
	}
	/**
	*The method returns the genre of the song in the position c of the song array <br>
    *<b>pre:  The cretion of the song array </b> 
	*<b>post: </b>
	*@param c, the index of the array
	*@return Genre, the genre of the song in the index c 
	*/
	public Genre getGenre(int c){
		return song[c].getGenre();
	}
	
}
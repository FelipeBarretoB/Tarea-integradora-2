package model;

public class MSC{
	public static final int MAXSONG=30;
	public static final int MAXPLAYLIST=20;
	public static final int MAXUSERS=10;
	private Playlist[] playlist;
	private Songs[] song;
	private User[] user; 
	private int playListCreated;
	private int songCreated;
	private int userCreated;
	
	public MSC(){
		playlist=new Playlist[MAXPLAYLIST];
		song=new Songs[MAXSONG];
		user=new User[MAXUSERS];
		playListCreated=0;
		songCreated=0;
		userCreated=0;
	}
	
	public boolean hasUserSpace(){
		return userCreated < MAXUSERS;
	}
	
	public boolean hasPlayListSpace(){
		return playListCreated<MAXPLAYLIST;
	}
	
	public boolean hasSongSpace(){
		return songCreated<MAXSONG;
	}
	
	public void createUser(String name, String password, int age, int songsShared){
			user[userCreated]=new User(name,password,age,songsShared);
			user[userCreated].updateCategory(); 
			userCreated++;
	}
	
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
			
	
	public void addedSong(int c){
		user[c].hasAddedSong();
	}
	
	public void createSong(String title, String nameOfArtistOrBand, int duration, int day, int month, int year, String genre){
		song[songCreated]=new Songs(title, nameOfArtistOrBand, duration);
		song[songCreated].giveDate(day, month, year);
		song[songCreated].giveGenre(genre);
		songCreated++;	

	}
	
	public void createPublicPlaylist(String name,double rating, double amountOfRatings){
		playlist[playListCreated]=new PublicPlaylist(name,rating,amountOfRatings);
		playlist[playListCreated].createSongArray();
		playListCreated++;
	}
	
	public void createPrivatePlaylist(String userName, String name){
		playlist[playListCreated]=new PrivatePlaylist(userName, name);
		playlist[playListCreated].createSongArray();
		playListCreated++;
	}
	
	public void createRestrictedPlaylist(String[] permitedUsers, String name){
		playlist[playListCreated]=new RestrictedPlaylist( name,  permitedUsers);
		playlist[playListCreated].createSongArray();
		playListCreated++;
	}
	
	public int findSong(String songName){
		int songPointer=-1;
		for(int c=0;c<songCreated;c++){
			if(song[c].getTitle().equals(songName)){
				songPointer=c;
			}
		}
		return songPointer;
	}
	
	public int findPlaylist(String playlistName){
		int playlistPointer=-1;
		for(int c=0;c<playListCreated;c++){
			if(playlist[c].getName().equals(playlistName)){
				playlistPointer=c;
			}
		}
		return playlistPointer;
	}
	
	public boolean verifyUser(String name,String playlistName){
		return playlist[findPlaylist(playlistName)].checkUser(name);
	}
	
	public void playlistAddSong(String songName,String playlistName, String name){
		playlist[findPlaylist(playlistName)].addSong(name,song[findSong(songName)]);
	}
	
	public String ratePlaylist(String playlistName, double rating){
		return playlist[findPlaylist(playlistName)].giveRating(rating);
	}
	
	public String getPlaylist(){
		String print="";
		for(int c=0;c<playListCreated;c++){
			print+=playlist[c].printPlaylist();
		}
		return print;
	}
	
	public int getUserCreated(){
		return userCreated;
	}
	
	public int getSongCreated(){
		return songCreated;
	}
	
	public String getUserName(int c){
		return user[c].getUserName();
	}
	
	public int getUserAge(int c){
		return user[c].getAge();
	}
	
	public Category getUserCategory(int c){
		return user[c].getCategory();
	}
	
	public String getTitle(int c){
		return song[c].getTitle();
	}
	
	public String getArtist(int c){
		return song[c].getArtistNameOrBand();
	}
	
	public String getDuration(int c){
		return song[c].durationToString();
	}
	
	public Genre getGenre(int c){
		return song[c].getGenre();
	}
	
}
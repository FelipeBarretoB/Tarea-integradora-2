package model;

public class PrivatePlaylist extends Playlist{
	private String permitedUserName;
	
	
	
	public PrivatePlaylist(String permitedUserName, String name){
		super(name);
		this.permitedUserName=permitedUserName;
	}
	@Override
	public boolean checkUser(String name){
		return permitedUserName.equals(name);
	}
	
	@Override
	public void addSong(String name, Songs songs){
		if(checkUser(name)){
			super.addSong(name, songs);
			
		}
	}
	
	@Override
	public String printPlaylist(){
		String print= super.printPlaylist();
		print+=
			"** User: "+permitedUserName+"\n"+
			"***********************************";
		return print;
	}
	
}
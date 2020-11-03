package model;

public class RestrictedPlaylist extends Playlist{
	public static final int MAXCONTRIBUTORS=5;
	private String[] permitedUsers;
	
	public RestrictedPlaylist(String name, String[] permitedUsers){
		super(name);
		this.permitedUsers=permitedUsers;
	}
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
	
	@Override
	public void addSong(String name, Songs songs){
		if(checkUser(name)){
			super.addSong(name, songs);
			
		}
	}
	
	public String printUsers(){
		String users =permitedUsers[0];
		for(int c=1; c <MAXCONTRIBUTORS &&permitedUsers[c]!=null;c++){
			users+=", "+permitedUsers[c];
			}
			return users;
		}
		


	
	@Override
	public String printPlaylist(){
		String print= super.printPlaylist();
		print+=
			"** Users: "+printUsers()+"\n"+
			"***********************************";
		return print;
	}
}
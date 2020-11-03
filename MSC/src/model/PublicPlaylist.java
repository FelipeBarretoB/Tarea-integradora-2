package model;

public class PublicPlaylist extends Playlist{
	private double rating;
	private double amountOfRatings;
	private String averageRating;
	
	public PublicPlaylist(String name,double rating, double amountOfRatings){
		super(name);
		this.rating=rating;
		this.amountOfRatings=amountOfRatings;
		averageRating="";
	}
	@Override
	public String giveRating(double rating){
		this.rating+=rating;
		amountOfRatings++;
		averageRating=averageRating();
		return averageRating();
	}
	
	public String averageRating(){
		return ""+rating/amountOfRatings;
	}
	
	@Override
	public String printPlaylist(){
		String print= super.printPlaylist();
		print+=
			"** Rating: "+averageRating+"\n"+
			"***********************************";
		return print;
	}
	
}
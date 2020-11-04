package model;

public class PublicPlaylist extends Playlist{
	
	//the rating of the playlist
	private double rating;
	//the amount of ratings the playlist has gotten
	private double amountOfRatings;
	//The average rating of the playlist
	private String averageRating;
	
	/**
	*The overloaded constructor of the class PublicPlaylist <br>
    *Uses the super constructor from the super class Playlist
	*@param name, the name of the playlist
	*@param rating, the rating of the playlist
	*@param amountOfRatings, the amount of ratings the playlist has gotten
	*/
	public PublicPlaylist(String name,double rating, double amountOfRatings){
		super(name);
		this.rating=rating;
		this.amountOfRatings=amountOfRatings;
		averageRating="";
	}
	
	/**
	*The method gives a rating to the playlist <br>
    *<b>pre:The creation of the averageRating method </b> 
	*<b>post: </b>
	*@param rating, the rating a user has given to the playlist
	*@return String, the average rating of the PublicPlaylist
	*/
	@Override
	public String giveRating(double rating){
		this.rating+=rating;
		amountOfRatings++;
		averageRating=averageRating();
		return averageRating();
	}
	
	/**
	*The method calculates the average rating <br>
    *<b>pre: The amountOfRatings is not equal to 0 </b> 
	*<b>post: </b>
	*@return String, the average rating of the PublicPlaylist
	*/
	public String averageRating(){
		return ""+rating/amountOfRatings;
	}
	
	/**
	*The method returns a String with the values of the public playlist <br>
    *<b>pre: The creation of the super class Playlist </b> 
	*<b>post: </b>
	*@return String, the values of the public playlist with a specific format
	*/
	@Override
	public String printPlaylist(){
		String print= super.printPlaylist();
		print+=
			"** Rating: "+averageRating+"\n"+
			"***********************************";
		return print;
	}
	
}
package model;

public class Date{
	
	// the day of the release
	private int day;
	// the month of release
	private int month;
	// the year of release
	private int year;
	
	/**
	*Default constructor of the class Date
	*/
	public Date(){}
	
	/**
	*Overloaded constructor of the class date, gives a initial values to the Date class fields
	*@param day, the day the song was released 
	*@param month, the day the month was released 
	*@param year, the year the song was released 
	*/
	public Date(int day, int month, int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	/**
	*The method puts the fields day, month and year, into de dd/mm/yyyy format<br>
	*<b>pre: </b> 
	*<b>post: </b>
	*@return String, the date in dd/mm/yyyy format
	*/
	public String dateToString(){
		return day+"/"+month+"/"+year;
	}
}
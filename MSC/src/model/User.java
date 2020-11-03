package model;

public class User{
	//the user name of the user
	private String userName;
	//the password of the user
	private String password;
	//the age of the user
	private int age;
	//the amount of songs the user has shared
	private int songShared;
	
	//the category of the user, depending in the amount of songShared shared
	private Category category;
	
	/**
	*Default constructor of the class User
	*/
	public User(){}
	
	/**
	*Overloaded constructor of the class User, gives a initial values to the User class fields
	*@param userName, the user name of the user
	*@param password, the password of the user 
	*@param age, the age of the user
	*@param songShared, the amount of songs the user has shared
	*/
	public User(String userName, String password, int age, int songShared){
		this.userName=userName;
		this.password=password;
		this.age=age;
		this.songShared=songShared;
		
	}
	/**
	*The method returns the value of the field userName <br>
	*<b>pre:</b> 
	*<b>post: </b>
	*@return String, the userName of the user
	*/
	public  String getUserName(){
		return userName;
	}
	
	/**
	*The method returns the value of the field password <br>
	*<b>pre:</b> 
	*<b>post: </b>
	*@return String, the password of the user
	*/
	public String getPassword(){
		return password;
	}
	
	/**
	*The method returns the value of the field age <br>
	*<b>pre:</b> 
	*<b>post: </b>
	*@return int, the age of the user
	*/
	public int getAge(){
		return age;
	}
	
	/**
	*The method returns the enum value of the field category <br>
	*<b>pre:</b> 
	*<b>post: </b>
	*@return Category, the category of the user 
	*/
	public Category getCategory(){
		return category; 
	}
	
	/**
	*The method gives the category field a value from the enum class Category <br>
	*<b>pre:</b> 
	*<b>post: Changes the field category </b>
	*@param category, a value from the enum Class Category given by the user 
	*/
	public void setCategory(Category category){
		this.category=category;
	}
	
	/**
	*The method gives the userName field a String <br>
	*<b>pre:</b> 
	*<b>post: Changes the field userName </b>
	*@param userName, a String value given by the user 
	*/
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	/**
	*The method gives the password field a String <br>
	*<b>pre:</b> 
	*<b>post: Changes the field password </b>
	*@param password, a String value given by the user 
	*/
	public void setPassword(String password){
		this.password=password;
	}
	
	/**
	*The method gives the age field a String <br>
	*<b>pre:</b> 
	*<b>post: </b>
	*@param age, a int value given by the user 
	*/
	public void setAge(int age){
		this.age=age;
	}
	
	/**
	*The method adds 1 to the field songShared, and uses updateCategory to update the category of the user <br>
	*<b>pre: The creation of the method updateCategory </b> 
	*<b>post: Might change the field category </b>
	*/
	public void hasAddedSong(){
		songShared++;
		updateCategory();
	}
	
	/**
	*The method may or may not change the category of the user, depending on how many songs he has shared <br>
	*<b>pre: </b> 
	*<b>post: Might change the field category </b>
	*/
	public void updateCategory(){
		if(songShared==0){
			category=Category.NEWBIE;
		}else if(songShared>=3 && songShared<10){
			category=Category.LITTLECONTRIBUTOR;
		}else if(songShared>=10 && songShared<30){
			category=Category.MILDCONTRIBUTOR;
		}else if(songShared>=30){
			category=Category.STARCONTRIBUTOR;
		}
	}
}
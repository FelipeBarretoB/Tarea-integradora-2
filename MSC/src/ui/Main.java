package ui;
import java.util.Scanner;
import model.MSC; 
public class Main{
	
	//The scanner of the class
	private Scanner sc;
	//The object of the class MSC
	private MSC msc;
	
	/**
	*default constructor of the class Main
	*the initiation of the Scanner and MSC objecto
	*/
	public Main(){
		sc= new Scanner(System.in);
		msc=new MSC();
	}
	
	public static void main(String [] args){
		Main ui= new Main();
		ui.printLogo();
		int option=0;
		
		do{
			option= ui.showMenu();
			ui.executeOperation(option);
			
		}while (option!=0);
		
	}
	
	/**
	*The method prints a menu<br>
    *<b>pre:  </b> 
	*<b>post: </b>
	*@return int, the option the user selected 
	*/
	public int showMenu() {
		
		int option=0;
		
		

		System.out.println(
				"Menú principal, seleccione una opción\n" +
				"(1) Para crear un usuario \n" +
				"(2) Para mostrar usuarios \n"+
				"(3) Para compartir una cancion \n"+
				"(4) Para mostrar las canciones compartidas \n" +
				"(5) Para crear una playList \n" + 
				"(6) Para añadir cancion a la playlist \n" +  
				"(7) Para darle calificación a una playlist \n" +  
				"(8) Para mostrar playlist \n" +  
				"(0) Para salir"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	/**
	*The method prints a the logo of the program<br>
    *<b>pre:  </b> 
	*<b>post: </b>
	*/
	public void printLogo(){
		System.out.println(
		"(((((((((((((((((((((((((((((((((((((((((((((((((\n"+
		"((((((((((((((((/((((((((((((((((((((((((((((((((\n"+
		"(((/  .(((((((*  .((((((*        (((((/      /(((\n"+
		"(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n"+
		"(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n"+
		"(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n"+
		"(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n"+
		"(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n"+
		"(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n"+
		"(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n"+
		"(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n"+
		"(((/  .((    ((   /((((  .(((((((((((((((((.  /((\n"+
		"(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n"+
		"(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n"+
		"(((/  .((((((((.  *((((((.        *((   .   .((((\n"+
		"(((((((((((((((/*/((((((((((///(((((((////(((((((\n"+
		"(((((((((((((((((((((((((((((((((((((((((((((((((\n"+
		"               ./(###((///((###(*                \n"+
		"           *#(,                   *((,           \n"+
		"        ,#/                           ((         \n"+
		"      .#*          .**/////*,.          ((       \n"+
		"     *(.      .//////////////////*       *#      \n"+
		"    .#,     *///////////////////////,     /(     \n"+
		"    /(    *///////////////////////////    .#.    \n"+
		"  ,/////,*/////////////////////////////,*////*.  \n"+
		"  /////////////////////////*,...,/////////////,  \n"+
		"  //////*,,,********,,.............,,,,,//////,  \n"+
		"  //////*.........//*........//*.......,//////,  \n"+
		"  //////*.........,,.........,,........,//////,  \n"+
		"  //////*..............................,//////,  \n"+
		"   *///*  ........,/.........**.......  .*///,   \n"+
		"            .......,/*.....,/*.......            \n"+
		"               ........,,,,.......               \n"+
		"                    .........                    \n"+
		"     											  \n"+
		"*************************************************\n"
						);


		
	}
	
	/**
	*The method prints a menu<br>
    *<b>pre:  the creation of the methods: giveUserInfo, showUsers, giveSongInfo, showSongs, showPlaylistMenu, giveAddSongInfo, ratePlaylist and showPlaylist </b> 
	*<b>post: </b>
	*@param operation, the int that represents the option the user chose in the method showMenu
	*/
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			System.out.println("\n");
			giveUserInfo();
			System.out.println("\n");
			break;
		case 2:
			System.out.println("\n");
			showUsers();
			System.out.println("\n");
			break;
	
		case 3:
			System.out.println("\n");
			giveSongInfo();
			System.out.println("\n");
			break;

		case 4:
			System.out.println("\n");
			showSongs();
			System.out.println("\n");
			break;
		case 5:
			System.out.println("\n");
			showPlaylistMenu();
			System.out.println("\n");
			break;
			
		case 6:
			System.out.println("\n");
			giveAddSongInfo();
			System.out.println("\n");
			break;
		case 7:
			System.out.println("\n");
			ratePlaylist();
			System.out.println("\n");
			break;
		case 8:
			System.out.println("\n");
			showPlaylist();
			System.out.println("\n");
			break;
		default:
			System.out.println("Error, opción no válida");
		
		}
	}
	
	/**
	*The method asks for all the information needed to create an object from the class User, and gives it to the createUser method from the class MSC<br>
    *<b>pre:The creation of the method createUser and hasUserSpace from the class MSC </b> 
	*<b>post: </b>
	*/
	public void giveUserInfo(){
		if(msc.hasUserSpace()){
			System.out.println("Cual es el apodo del usuario?");
			String name=sc.nextLine();
			System.out.println("Cual es la contraseña de "+name+" ?");
			String password=sc.nextLine();
			System.out.println("Cual es la edad de "+name+" ?");
			int age=sc.nextInt();
			System.out.println("Cuantas canciones a compartido "+name+" ?");
			int songShared=sc.nextInt();
			msc.createUser(name,password,age,songShared);
		}else{
			System.out.println("No se pueden crear mas usuarios");
		}
	}
	
	/**
	*The method prints a the users that have been created<br>
    *<b>pre:The creation of the methods getUserName, getUserAge and getUserCategory from the class MSC  </b> 
	*<b>post: </b>
	*/
	public void showUsers(){
		for(int c=0; c<msc.getUserCreated();c++){
			System.out.println("*************  User *************** \n"+
							   "**  UserName: "+msc.getUserName(c) + "\n"+
							   "**  Age: "+msc.getUserAge(c) + "\n"+
							   "**  Category: "+msc.getUserCategory(c)+ "\n"+
							   "***********************************");
			System.out.println("\n");
		}
	}
	
	/**
	*The method asks for all the information needed to create an object from the class Songs, and gives it to the createSong method from the class MSC <br>
    *<b>pre: The creation of the method createSong and hasSongSpace from the class MSC </b> 
	*<b>post: </b>
	*/
	public void giveSongInfo(){
		if(msc.hasSongSpace()){
			System.out.println("Cual usuario compartio una cancion?");
			String name=sc.nextLine();
			if(msc.userExists(name)){
				System.out.println("Cual es el titulo de la cancion?");
				String title=sc.nextLine();
				System.out.println("Cual es la banda o artista de la cancion?");
				String nameOfArtistOrBand=sc.nextLine();
				System.out.println("Cuanto dura la cancion en segundos?");
				int duration= sc.nextInt();
				System.out.println("Cuando salio la cancion?");
				System.out.println("Dia:");
				int day=sc.nextInt();
				System.out.println("Mes:");
				int month=sc.nextInt();
				System.out.println("Año:");
				int year=sc.nextInt();
				System.out.println("Cual es el genero de la cancion");
				String genre=sc.next();
				msc.createSong(title,nameOfArtistOrBand, duration, day, month, year, genre);
			}else{
				System.out.println("Este usuario no existe o no a sido creado");
			}
		}else{
			System.out.println("No hay espacio para más canciones");
		}
	}
	/**
	*The method prints all the information of the songs that have been added<br>
    *<b>pre: The creation of the method getTitle, getArtist, getDuration and getGenre from the class MSC </b> 
	*<b>post: </b>
	*/
	public void showSongs(){
		for(int c=0; c<msc.getSongCreated();c++){
			System.out.println("**************  Song ************** \n"+
							   "**  Title: "+msc.getTitle(c) +"\n"+
							   "**  Artist: "+msc.getArtist(c) +"\n"+
							   "**  Duration: "+msc.getDuration(c) +"\n"+
							   "**  Genre: "+msc.getGenre(c) +"\n"+
							   "***********************************");
			System.out.println("\n");	
		}
	}
	
	/**
	*The method lets the user choose what type of playlist he wants to create<br>
    *<b>pre: The creation of the method givePrivatePlaylistInfo, givePublicPlaylistInfo and giveRestrictedPlaylistInfo </b> 
	*<b>post: </b>
	*/
	public void showPlaylistMenu() {
		int operation=0;

		System.out.println(
				"Menú principal, seleccione una opción\n" +
				"(1) Para crear una playlist privada \n" +
				"(2) Para crear una playlist publica \n"+
				"(3) Para crear una playlist restringida \n"+ 
				"(0) Para salir"
				);
		operation= sc.nextInt();
		sc.nextLine();
		
		switch(operation) {
		case 0:
			System.out.println("");
			break;
		case 1:
			System.out.println("\n");
			givePrivatePlaylistInfo();
			System.out.println("\n");
			break;
		case 2:
			System.out.println("\n");
			givePublicPlaylistInfo();
			System.out.println("\n");
			break;
	
		case 3:
			System.out.println("\n");
			giveRestrictedPlaylistInfo();
			System.out.println("\n");
			break;

		
		default:
			System.out.println("Error, opción no válida");
		
		}
	}
	
	/**
	*The method asks for all the information needed to create an object from the subclass PublicPlaylist, and gives it to the createPublicPlaylist method from the class MSC  <br>
    *<b>pre: The creation of the method createPublicPlaylist </b> 
	*<b>post: </b>
	*/
	public void givePublicPlaylistInfo(){
		if(msc.hasPlayListSpace()){
			System.out.println("Cual es el nombre de la playlist publica?");
			String name=sc.nextLine();
			msc.createPublicPlaylist( name, 0,  0);
		}else{
			System.out.println("No hay espacio para más playlist");
		}
	}
	
	/**
	*The method asks for all the information needed to create an object from the subclass PrivatePlaylist, and gives it to the createPrivatePlaylist method from the class MSC  <br>
    *<b>pre: The creation of the method createPrivatePlaylist </b> 
	*<b>post: </b>
	*/
	public void givePrivatePlaylistInfo(){
		if(msc.hasPlayListSpace()){
			System.out.println("Cual es el nombre de la playlist privada?");
			String name=sc.nextLine();
			System.out.println("Quien es el usuario que crea esta playlist?");
			String userName=sc.nextLine();
			if(msc.userExists(userName)){
				msc.createPrivatePlaylist(userName, name);
			}else{
				System.out.println("El usuario no existe");
			}
		}else{
			System.out.println("No hay espacio para más playlist");
		}
	}
	
	/**
	*The method asks for all the information needed to add a song to a Playlist, using the playlistAddSong method from the class MSC  <br>
    *<b>pre: The creation of the method playlistAddSong, findPlaylist and verifyUser </b> 
	*<b>post: </b>
	*/
	public void giveAddSongInfo(){
		System.out.println("Cual es el nombre del usuario");
		String name=sc.nextLine();
		System.out.println("Nombre de la cancion que desea añadir"); 
		String songName=sc.nextLine();
		if(msc.findSong(songName)==-1){
			System.out.println("Esta canción no existe");
		}else{
			System.out.println("Cual es la playlist a la que quiere añadir la cancion");
			String playlistName=sc.nextLine();
			if(msc.findPlaylist(playlistName)==-1){
				System.out.println("Esta playlist no existe");
			}else{ 
				if(msc.verifyUser(name,playlistName)){
					msc.playlistAddSong( songName, playlistName,  name);
				}else{
					System.out.println("Usted no puede editar esta playlist");
				}
			}
		}
	}
	
	/**
	*The method asks for all the information needed to rate a playList, and gives it to the ratePlaylist method from the class MSC  <br>
    *<b>pre: The creation of the method findPlaylist and ratePlaylist </b> 
	*<b>post: </b>
	*/
	public void ratePlaylist(){
		System.out.println("A cual playlist le desea dar calificacion?");
		String playlistName=sc.nextLine();
		if(msc.findPlaylist(playlistName)==-1){
			System.out.println("Esta playlist no existe");
		}else{ 
			System.out.println("Del 1 al 5 , que calificacion desea darle a la playlist");
			double rating=sc.nextDouble();
				
			if(msc.ratePlaylist( playlistName, rating).equals("Esto no aplica para la playlist")){
				System.out.println("Esta playList no puede recibir calificacion");
			}else{
				System.out.println("La nueva califcacion promedio de "+playlistName+" es: "+msc.ratePlaylist( playlistName, rating));
			}
		}
		
	}
	
	/**
	*The method asks for all the information needed to create an object from the subclass RestrictedPlaylist, and gives it to the createRestrictedPlaylist method from the class MSC  <br>
    *<b>pre: The creation of the methods userExists and createRestrictedPlaylist </b> 
	*<b>post: </b>
	*/
	public void giveRestrictedPlaylistInfo(){
		if(msc.hasPlayListSpace()){
			String[] permitedUsers=new String[5];
			System.out.println("Cual es el nombre de la playlist privada?");
			String name=sc.nextLine();
			System.out.println("Cual quien es el usuario que crea esta playlist?");
			permitedUsers[0]=sc.nextLine();
			if(msc.userExists(permitedUsers[0])){
				System.out.println("Cuantos usuarios pueden editar esta playlist? restando "+permitedUsers[0]+" se pueden añadir otros 4 usuarios como maximo");
				int numberOfPermitedUsers= sc.nextInt();
				for(int c=1;c<numberOfPermitedUsers;c++){
					System.out.println("Nombre del usuario que podra editar la playlist");
					permitedUsers[c]=sc.next();
					if(!msc.userExists(permitedUsers[c])){
						System.out.println("El usuario no existe");
						permitedUsers[c]=null;
					}
				}
				msc.createRestrictedPlaylist(permitedUsers, name);
			}else{
				System.out.println("El usuario no existe");
			}
		}else{
			System.out.println("No hay espacio para más playlist");
		}
	}

	/**
	*The method prints the playlist that have been create, using the getPlaylist method from the class MSC  <br>
    *<b>pre: The creation of the method getPlaylist </b> 
	*<b>post: </b>
	*/
	public void showPlaylist(){
		System.out.print( msc.getPlaylist());
	}
	
}

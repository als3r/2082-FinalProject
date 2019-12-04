package edu.century.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DefaultData {
	
	
	// Descriptions are generated from
	// http://www.dummytextgenerator.com/#jump
	
	public final static Movie movie1 = new Movie("Doctor Sleep", 151, "")
		.addGenre(new Genre("Horror"))
		.addGenre(new Genre("Suspense/Thriller"))
		.addTime("7:00p")
		.addTime("8:30p")
		.addTime("9:30p")
		.setImage("DoctorSleep2019.jpg")
		.setDescription("Lacus placerat ipsum molestie facilisis. Placerat donec penatibus ultrices fusce cum facilisi pretium scelerisque lorem dui duis ac. Phasellus fames mi nibh volutpat ligula cubilia potenti hymenaeos pulvinar. Vel luctus litora lacus Pharetra ad dolor tempor, conubia lacus dictum. Eros molestie in. Aliquet ipsum sollicitudin lorem tristique conubia venenatis nonummy.\r\n" + 
				"<br><br>" + 
				"Mollis libero sagittis consectetuer nibh curabitur sagittis sociis proin. Libero primis, tempor tortor lacinia. Phasellus diam magnis ac dignissim. Nullam. Nostra integer quisque platea potenti.\r\n" + 
				"<br><br>" + 
				"Habitant laoreet porttitor. Euismod Netus. Lectus. Natoque. Quam. Pretium. Ut commodo blandit vitae class tempor vitae donec netus vehicula vivamus vestibulum nibh ut iaculis sagittis.");
	
	public final static Movie movie2 = new Movie("Last Christmas", 102, "")
		.addGenre(new Genre("Comedy"))
		.addGenre(new Genre("Romance"))
		.addTime("7:00p")
		.addTime("9:30p")
		.setImage("LastChristmas2019.jpg")
		.setDescription("Nullam eleifend porta aenean at mauris nonummy hymenaeos est facilisis venenatis magna nascetur metus gravida aenean suspendisse hymenaeos. At cubilia nec vitae placerat nisi placerat luctus posuere curae; dis arcu. Semper, leo rutrum potenti commodo dignissim et ligula senectus nunc diam sociis elit.\r\n" + 
				"<br><br>" +  
				"Nascetur parturient rutrum ante mus nam parturient sollicitudin vel semper vivamus massa sit nec Etiam tortor, auctor torquent.\r\n" + 
				"<br><br>" + 
				"Dapibus Cubilia. Sodales ridiculus nam donec convallis dapibus ultricies duis blandit suscipit porta. Viverra at euismod. Nascetur sapien nostra euismod. Risus, tincidunt nostra. Odio auctor, sociosqu curabitur cubilia arcu consequat pharetra vivamus Ultricies. Tempus penatibus rhoncus bibendum lacus euismod.");

	public final static Movie movie3 = new Movie("Midway", 138, "")
		.addGenre(new Genre("Action/Adventure"))
		.addGenre(new Genre("Drama"))
		.addGenre(new Genre("War"))
		.addTime("10:30p")
		.addTime("11:30p")
		.setImage("Midway.jpg")
		.setDescription("Eget gravida primis iaculis gravida convallis. Blandit laoreet. Per. Justo tincidunt at. Sociis cubilia. Ut et potenti dapibus consequat pellentesque. Malesuada consectetuer felis, dictum. Malesuada eu tellus et tellus primis aliquet gravida.\r\n" + 
				"<br><br>" +  
				"Tortor feugiat nascetur libero laoreet Pellentesque. Et eget auctor rhoncus tempor. Praesent nullam, fringilla nulla ullamcorper hendrerit lectus sem. Bibendum. Viverra cubilia curae; pede sociis fusce. Etiam mattis sit ante ut nec erat ornare hac fusce accumsan posuere convallis dis fusce.\r\n" + 
				"<br><br>" + 
				"Sollicitudin consequat. Dictumst, natoque volutpat adipiscing senectus magnis sociosqu hendrerit, pulvinar ornare platea feugiat curabitur malesuada fusce. Vestibulum hac sit ipsum velit egestas. Vehicula massa class dictumst.");

	public final static Movie movie4 = new Movie("Playing Fire", 96, "")
		.addGenre(new Genre("Comedy"))
		.addGenre(new Genre("Family"))
		.addTime("7:00p")
		.addTime("11:30p")
		.setImage("PlayingWithFire.jpg")
		.setDescription("Blandit ante. Condimentum mauris volutpat consectetuer et ornare mauris laoreet mollis conubia dictumst diam hendrerit senectus bibendum non enim consequat. Fringilla litora sit congue sagittis.\r\n" + 
				"<br><br>" +  
				"Viverra rhoncus etiam. Proin eros tortor fringilla sociis ut faucibus platea diam nec sollicitudin. Dictumst lacus massa. Proin Fusce odio in pede fringilla lacus Elementum lacinia vitae varius pharetra feugiat risus sollicitudin inceptos quam mauris tempor quis.\r\n" + 
				"<br><br>" +  
				"Urna. Nisi luctus pharetra adipiscing sed elit netus molestie a fermentum. Purus molestie purus sagittis fusce eros porttitor congue volutpat enim venenatis consequat proin mi primis venenatis. Phasellus magnis aptent magna dignissim auctor ac parturient nam. Ridiculus suscipit.");

	public final static Movie movie5 = new Movie("Arctic Dogs", 100, "")
		.addGenre(new Genre("Animated"))
		.addGenre(new Genre("Comedy"))
		.addGenre(new Genre("Family"))
		.addTime("8:00p")
		.addTime("10:00p")
		.setImage("ArcticDogs.jpg")
		.setDescription("Risus dapibus rhoncus elit sociosqu hymenaeos neque viverra. Sem placerat tempor nisi class montes turpis faucibus Consequat lorem. Magna varius vehicula lacus eu magnis sed.\r\n" + 
				"<br><br>" + 
				"Vestibulum ligula. Consectetuer sit commodo enim metus imperdiet posuere. Inceptos gravida dictumst sodales eget malesuada magna etiam etiam adipiscing pede pulvinar dolor tristique, massa scelerisque praesent mattis, praesent fermentum nulla montes vel hymenaeos, curabitur massa integer.\r\n" + 
				"<br><br>" +  
				"Lobortis molestie felis sodales non montes tortor dictumst Mattis nisl sit. Etiam cubilia ultricies mauris tortor. Tristique litora aliquet tortor commodo quisque pellentesque leo ut, felis habitasse. Varius fringilla nostra curae; tristique Netus justo consequat elit aptent Magnis tellus.");

	public final static Movie movie6 = new Movie("Terminator: Dark Fate", 128, "")
		.addGenre(new Genre("Action/Adventure"))
		.addGenre(new Genre("Sci-Fi/Fantasy"))
		.addTime("8:00p")
		.addTime("10:00p")
		.setImage("TerminatorDarkFate.jpg")
		.setDescription("Ut ante natoque velit diam sodales habitasse platea fringilla porta eget odio litora orci in. Vivamus. Cubilia libero faucibus dui.\r\n" + 
				"<br><br>" + 
				"Torquent. Semper magna lectus conubia eleifend enim viverra. Posuere nam habitasse primis malesuada integer nulla ante mattis etiam ultrices fermentum ultricies. Ultrices curae; commodo orci dapibus sapien enim class tempor eu duis torquent sapien quam nibh natoque.\r\n" + 
				"<br><br>" + 
				"Pellentesque velit. Fames molestie curabitur donec eleifend vehicula congue nascetur elit. Lacinia nibh facilisi ultricies. Leo quam aenean. Lacus. Mus pede integer montes per venenatis class erat netus in iaculis. Elit arcu interdum ipsum mus congue vestibulum dolor elit mus. Auctor neque litora.");
		
	public final static Movie movie7 = new Movie("Countdown", 90, "")
		.addGenre(new Genre("Horror"))
		.addGenre(new Genre("Suspense/Thriller"))
		.addTime("9:30p")
		.addTime("11:00p")
		.setImage("Countdown.jpg")
		.setDescription("Dignissim nulla purus amet, vitae netus tempor morbi mus in sit auctor suspendisse Elit in, vestibulum Id a dolor eleifend lorem ad iaculis tincidunt curabitur, tincidunt vehicula vehicula viverra velit.\r\n" + 
				"<br><br>" + 
				"Gravida laoreet augue a phasellus imperdiet. Laoreet cras eget faucibus sit platea natoque iaculis eu rhoncus arcu elementum diam eros iaculis Luctus platea nostra ornare. Hac venenatis metus netus, eros mi sit fames morbi penatibus orci venenatis.\r\n" + 
				"<br><br>" + 
				"Mollis suspendisse, curae;, cubilia nascetur quis aenean curae; pede aenean ultrices torquent lobortis conubia volutpat curae; senectus. Sociosqu, et praesent pellentesque ornare sem Sagittis fringilla lacus penatibus lacus nostra inceptos libero suspendisse. Elementum.");
	
	public final static Movie movie8 = new Movie("Maleficent: Mistress Of Evil", 118, "")
		.addGenre(new Genre("Action/Adventure"))
		.addGenre(new Genre("Family"))
		.addGenre(new Genre("Sci-Fi/Fantasy"))
		.addTime("10:30p")
		.setImage("Maleficent.jpg")
		.setDescription("Pede nec mollis mattis ultricies nisi vehicula sit sociosqu ultricies est donec malesuada netus suscipit tristique erat lacus dis per vestibulum consequat leo tempor netus. Aptent. Vitae risus.\r\n" + 
				"<br><br>" + 
				"Dui. Pede. Vehicula curae;. Et conubia lobortis amet, sapien pretium mauris a urna arcu elit donec justo nibh facilisis. Eleifend habitasse parturient, ac facilisis sociosqu vel ipsum class.\r\n" + 
				"<br><br>" + 
				"Donec condimentum, viverra, nec blandit a fermentum. Quis parturient dapibus vel dis sociosqu pede neque, quisque nunc. Sed pellentesque lobortis. Adipiscing at varius nullam eros. Senectus primis netus metus vivamus dis curabitur quam potenti blandit et lectus nascetur quisque varius sodales. Sagittis mi vivamus.");
	
	public final static Movie movie9 = new Movie("The Adams Family", 87, "")
		.addGenre(new Genre("Animated"))
		.addGenre(new Genre("Comedy"))
		.addGenre(new Genre("Family"))
		.addTime("8:30p")
		.setImage("AddamsFamily.jpg")
		.setDescription("Rhoncus massa iaculis enim nullam tempus, fermentum proin mattis Litora euismod feugiat etiam. Vitae. Praesent libero blandit. Duis rhoncus odio in ridiculus lacus. Nascetur curae; nunc natoque. Magna pede nibh per elit. Torquent leo. Aptent, vulputate hendrerit. Habitant id per. Dictumst egestas.\r\n" + 
				"<br><br>" + 
				"Dui fermentum a. Laoreet. Est nisi porta a lectus. Bibendum senectus bibendum natoque leo aliquam euismod, adipiscing bibendum Elementum maecenas Lacinia Posuere rhoncus dapibus. Lobortis risus, ultrices amet luctus vitae.\r\n" + 
				"<br><br>" +  
				"Facilisi ad feugiat maecenas quis venenatis congue pellentesque diam sed sagittis curabitur imperdiet eros dolor potenti Ut orci ante convallis curae; urna habitasse molestie suscipit. In ridiculus elementum.");
	
	public final static Movie movie10 = new Movie("Joker", 122, "")
		.addGenre(new Genre("Drama"))
		.addGenre(new Genre("Suspense/Thriller"))
		.addTime("7:30p")
		.addTime("9:00p")
		.setImage("Joker.jpg")
		.setDescription("Dictumst luctus dictum senectus donec euismod suscipit Vivamus cursus porta interdum dis. Gravida class condimentum eros vehicula suspendisse porta netus aptent dictum morbi. Nullam ultrices dui. Vulputate adipiscing. Massa parturient faucibus aliquam natoque nec massa vehicula volutpat.\r\n" + 
				"<br><br>" + 
				"Per urna. Amet vulputate nam netus risus maecenas tristique volutpat vivamus dictumst ipsum In penatibus sodales ultricies parturient. Dictumst maecenas. Aliquet ullamcorper nostra iaculis fusce eget Potenti natoque rutrum vestibulum, potenti habitasse Lacinia maecenas.\r\n" + 
				"<br><br>" + 
				"Rutrum libero habitant justo faucibus conubia laoreet cursus nec lorem nibh nisi. Duis mus. Tristique praesent sem. Ligula lectus adipiscing conubia semper ridiculus tempus nisi ultrices primis cubilia ut.");
	
	
	
	
	public final static Theater theater1 = new Theater("Theater 1", 30);
	public final static Theater theater2 = new Theater("Theater 2", 40);
	public final static Theater theater3 = new Theater("Theater 3", 50);
	
	public final static Genre genre1 = new Genre("Action");
	public final static Genre genre2 = new Genre("Drama");
	public final static Genre genre3 = new Genre("Comedy");
	public final static Genre genre4 = new Genre("Kids");
	public final static Genre genre5 = new Genre("Horror");
	public final static Genre genre6 = new Genre("Romance");
	public final static Genre genre7 = new Genre("Sci-fi");
	public final static Genre genre8 = new Genre("Animated");
	
	
	public final static List<Movie> movies = new ArrayList<>(Arrays.asList(
		movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10
	));
	
	public final static List<Theater> theaters = new ArrayList<>(Arrays.asList(
		theater1, theater2, theater3
	));
	
	public final static List<Genre> genres = new ArrayList<>(Arrays.asList(
			genre1, genre2, genre3, genre4, genre5, genre6, genre7, genre8 
	));
	
	public final static List<String> times = new ArrayList<>(Arrays.asList(
			"9:00a", "11:00a", "12:00p", "1:00p", "2:00p", "3:00p", "5:00p", "6:00p", "7:00p", "9:00p", "11:00p"
	));
	
	
}

package regina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Rakendus {
	
	@RequestMapping("/geomeetriline_keskmine")
	String gk(String arv1, String arv2, String arv3){
		if(arv1==null){return "andmed puuduvad";}
		int a1=Integer.parseInt(arv1);
		int a2=Integer.parseInt(arv2);
		int a3=Integer.parseInt(arv3);
		return arv1+" ja "+arv2+" ja "+ arv3+ " geomeetriline keskmine on " + Math.pow(a1*a2*a3, 1.0/3);
	}
	
	@RequestMapping("/hinnakalkulaator")
	String kk(String kogus){
			if(kogus==null){return "sisesta kogus"}
			int k=Integer.parseInt(kogus);
			if(kogus<5){return kogus+"tükki hinnaks on "+ kogus*3+ " eur"}
			if(kogus>=5){return kogus+"tükki hinnaks on "+ kogus*2+ " eur"}
			
	}
	
	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }

	@RequestMapping("/algus2")
    String tervitusfunktsioon2() {
        return "Tere!";
    }
	
	@RequestMapping("/tervita")
    String tervitusfunktsioon3(String eesnimi) {
        return "Tere!"+eesnimi;
    }
	
	
    public static void main(String[] args) {
		System.getProperties().put("server.port", 4201);
        SpringApplication.run(Rakendus.class, args);
		
    }
}







//scl enable rh-maven33 bash
//cd ...
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar
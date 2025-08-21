package IntegracionBackFront.backfront.Config.Cloudinary;


import com.cloudinary.Cloudinary;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {


   private String cloudName;
   private String apiKet;
   private String apiSecret;

 //Se auto ejecuta
   @Bean
   public Cloudinary cloudinary(){
            //Crear un objeto de para leer las variables del archivo .env
       Dotenv dontenv = Dotenv.load();

       //Crear un map par almacenar la configuracion necesaria para Cloudinary

       Map<String, String> config = new HashMap<>();

       config.put("cloud_name",dontenv.get("CLOUDINARY_CLOUD_NAME"));
       config.put("api_key", dontenv.get("CLOUDINARY_API_KEY"));
       config.put("api_secret",dontenv.get("CLOUDINARY_API_SECRET"));

       return new Cloudinary(config);
   }


}

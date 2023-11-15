package team2.elearningapplication;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElearningSwp391Application {

    public static void main(String[] args) {
        SpringApplication.run(ElearningSwp391Application.class, args);

    }
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "djldy7tmh",
                "api_key", "768669543812518",
                "api_secret", "***************************",
                "secure",true));
        return cloudinary;
    };

}
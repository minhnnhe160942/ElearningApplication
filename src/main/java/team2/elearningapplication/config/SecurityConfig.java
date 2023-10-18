package team2.elearningapplication.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import team2.elearningapplication.security.CustomAuthorizationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers(
                "/api/v1/user/register",
                "/api/v1/user/login",
                "/api/v1/user/verify-otp",
                "/api/v1/user/forgotPassword",
                "/api/v1/user/changePassword",
                "/api/v1/user/send-otp-forgot-password",
                "/api/v1/user/verify-otp-forgotPass",
                "/api/v1/user/change-profile",
                "/api/v1/user/log-out",
                "/api/v1/user/total-user",
                "/api-docs",
                "/swagger-ui",


                "/api/v1/course/add-course",
                "/api/v1/course/update-course",
                "/api/v1/course/delete-course",
                "/api/v1/course/find-all-course",
                "/api/v1/course/get-top-course",
                "/api/v1/course/get-newest-course",
                "/api/v1/course/get-course-user",
                "/api/v1/course/get-total-course",
                "/api/v1/course/search-course",


                "/api/v1/category/add-category",
                "/api/v1/category/update-category",
                "/api/v1/category/delete-category",
                "/api/v1/category/find-all-category",
                "/api/v1/lesson/add-lesson",
                "/api/v1/lesson/update-lesson",
                "/api/v1/lesson/delete-lesson",
                "/api/v1/lesson/find-all-lesson",

                "/api/v1/question/add-question",
                "/api/v1/quiz/add-quiz",
                "/swagger-ui/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}

package team2.elearningapplication.service.email;

import team2.elearningapplication.entity.Mail;

import java.util.HashMap;
import java.util.Map;

public class SetUpMail {
    private Mail setUpMailPayment(String mailTo, String subject) {
        Mail mail = new Mail();
        mail.setFrom(mail.getFrom());
        mail.setTo(mailTo);
        mail.setSubject(subject);
        Map<String, Object> model = new HashMap<>();
        mail.setPros(model);
        mail.setTemplate("payment");
        return mail;
    }
    private Mail setUpMailCertificate(String mailTo, String subject, String courseName) {
        Mail mail = new Mail();
        mail.setFrom(mail.getFrom());
        mail.setTo(mailTo);
        mail.setSubject(subject);
        Map<String, Object> model = new HashMap<>();
        mail.setPros(model);
        model.put("course_name", courseName);
        mail.setTemplate("certificate");
        return mail;
    }


}

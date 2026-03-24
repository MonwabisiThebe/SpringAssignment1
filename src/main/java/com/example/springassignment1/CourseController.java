package com.example.springassignment1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class CourseController {

    @GetMapping(value = "/courses", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getCourses() {
        Map<String, List<String>> courses = new LinkedHashMap<>();
        courses.put("Foundation Courses", List.of("Introduction to Programming", "Mathematics I"));
        courses.put("Undergraduate Courses", List.of("Data Structures","Algorithms","Operating Systems","Databases","Computer Networks"));
        courses.put("Honours Courses", List.of("Machine Learning","Distributed Systems","Advanced Algorithms","Cybersecurity"));

        StringBuilder html = new StringBuilder("<html><body style='font-family: Arial, sans-serif;'>");
        html.append("<h1>Computer Science Courses</h1>");
        for (String category : courses.keySet()) {
            html.append("<h2>").append(category).append("</h2>");
            html.append("<ul>");
            for (String course : courses.get(category)) {
                html.append("<li>").append(course).append("</li>");
            }
            html.append("</ul>");
        }
        html.append("</body></html>");

        return html.toString();
    }
}
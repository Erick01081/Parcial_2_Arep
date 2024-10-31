package com.example.demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("Linear " + linearSearch.linearSearching(List.of(10,20,13,40,60), 40));
        System.out.println("Binary " + binarySearch.binarySearching(List.of(10,13,20,40,60), 13, 0));
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/linearsearch")
    public String linearSearch(@RequestParam(value = "list") List<Integer>  list, @RequestParam(value = "value") Integer number){
        String result = linearSearch.linearSearching(list, number);

        return "<!DOCTYPE Document/JSON>\n" +
                "{\n" +
                " \"operation\": \"binarySearch\",\n" +
                " \"inputlist\":" +"\"" + list + "\",\n\"" +
                " \"value\":" +"\"" + number + "\",\n\"" +
                " \"output\":" +"\"" + result + "\",\n\"" +
                "}";
    }

    @GetMapping("/binarysearch")
    public void binarySearch(@RequestParam(value = "list") List<Integer>  list, @RequestParam(value = "value") Integer number, JsonGenerator jgen){

        String result = binarySearch.binarySearching(list, number,0);


        jgen.writeStringField("operation", "binarySearch"),
        jgen.writeNumberField("inputlist", list);



    }

    @Override
    protected void serializeObject(JsonGenerator jgen, SerializerProvider provider)
            throws IOException {

    }

    @GetMapping("/")
    public String index(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Form Example</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Form with GET</h1>\n" +
                "<form action=\"/greeting\">\n" +
                "    <label for=\"name\">Name:</label><br>\n" +
                "    <input type=\"text\" id=\"name\" name=\"name\" value=\"John\"><br><br>\n" +
                "    <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                "</form>\n" +
                "<div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "<script>\n" +
                "    function loadGetMsg() {\n" +
                "        let nameVar = document.getElementById(\"name\").value;\n" +
                "        const xhttp = new XMLHttpRequest();\n" +
                "        xhttp.onload = function() {\n" +
                "            document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "            this.responseText;\n" +
                "        }\n" +
                "        xhttp.open(\"GET\", \"/binarysearch?list=10,20,13,40,60&value=13;\n" +
                "        xhttp.send();\n" +
                "    }\n" +
                "</script>\n" +
                "\n" +
                "<h1>Form with POST</h1>\n" +
                "<form action=\"/hellopost\">\n" +
                "    <label for=\"postname\">Name:</label><br>\n" +
                "    <input type=\"text\" id=\"postname\" name=\"name\" value=\"John\"><br><br>\n" +
                "    <input type=\"button\" value=\"Submit\" onclick=\"loadPostMsg(postname)\">\n" +
                "</form>\n" +
                "\n" +
                "<div id=\"postrespmsg\"></div>\n" +
                "\n" +
                "<script>\n" +
                "    function loadPostMsg(name){\n" +
                "        let url = \"/hellopost?name=\" + name.value;\n" +
                "\n" +
                "        fetch (url, {method: 'POST'})\n" +
                "            .then(x => x.text())\n" +
                "            .then(y => document.getElementById(\"postrespmsg\").innerHTML = y);\n" +
                "    }\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";
    }
}
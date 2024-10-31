package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GreetingController {

    /**
     * Response class that matches the specified JSON format
     */
    public static class SearchResponse {
        private String operation;
        private String inputlist;
        private String value;
        private String output;

        public SearchResponse(String operation, List<Integer> list, Integer value, String output) {
            this.operation = operation;
            this.inputlist = list.toString().replace("[", "").replace("]", "").replace(" ", "");
            this.value = value.toString();
            this.output = output;
        }

        // Getters y setters requeridos por Spring para la serialización JSON
        public String getOperation() { return operation; }
        public void setOperation(String operation) { this.operation = operation; }
        public String getInputlist() { return inputlist; }
        public void setInputlist(String inputlist) { this.inputlist = inputlist; }
        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
        public String getOutput() { return output; }
        public void setOutput(String output) { this.output = output; }
    }

    @GetMapping("/linearsearch")
    public ResponseEntity<SearchResponse> linearSearch(
            @RequestParam("list") List<Integer> list,
            @RequestParam("value") Integer number) {

        int resultIndex = linearSearch.search(list, number);

        SearchResponse response = new SearchResponse(
                "linearSearch",
                list,
                number,
                String.valueOf(resultIndex)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/binarysearch")
    public ResponseEntity<SearchResponse> binarySearch(
            @RequestParam("list") List<Integer> list,
            @RequestParam("value") Integer number) {

        int resultIndex = BinarySearch.search(list, number);

        SearchResponse response = new SearchResponse(
                "binarySearch",
                list,
                number,
                String.valueOf(resultIndex)
        );

        return ResponseEntity.ok(response);
    }
}
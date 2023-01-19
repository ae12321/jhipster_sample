package com.mycompany.myapp.web.rest.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.Id;
import lombok.Data;

@Data
public class JacksonSample {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("author")
    private String author;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("books")
    List<InnerJacksonSample> inners;
}

class InnerJacksonSample {

    @JsonProperty("book_name")
    private String bookName;

    @JsonProperty("published")
    private Date publishedat;
}
// https://blog.enjoyxstudy.com/entry/2017/03/24/000000

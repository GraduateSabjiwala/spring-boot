    package com.demo.springboot.model;

    import com.fasterxml.jackson.annotation.JsonProperty;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.springframework.data.mongodb.core.mapping.Document;
    import org.springframework.validation.annotation.Validated;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Document("product")
    @Validated
    public class Product {

        @JsonProperty("_id")
        private String id;

        @JsonProperty("oProductPayload")
        private ProductPayload productPayload;

    }

package org.flowable.example.vanitypress.config;

import lombok.Builder;
import lombok.Data;

@Data
public class VanityConfig {
    private String baseUrl;
    private String printUrl;
}

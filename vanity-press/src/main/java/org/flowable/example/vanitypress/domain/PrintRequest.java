package org.flowable.example.vanitypress.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrintRequest {
    String title;
    String author;
    String isbn;
    String contentUrl;
    String callbackUrl;
    String uuid;
    String status;
}

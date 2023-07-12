package com.habin.wine.common.config;

import lombok.*;

public class BasePayloads {

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SimpleResponse {
        private String uuid;
        private String nameEnglish;
        private String nameKorean;
    }

}

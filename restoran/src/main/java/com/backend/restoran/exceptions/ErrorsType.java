package com.backend.restoran.exceptions;

import lombok.Getter;

@Getter
public enum ErrorsType {
    CANNOT_CREATE("1001", "Məlumat yaradılarkən xəta baş verdi"),
    CANNOT_UPDATE("1002", "Məlumat yenilənə bilmədi"),
    CANNOT_DELETE("1003", "Silinmə əməliyyatı uğursuz oldu"),
    DATA_ALREADY_EXISTS("1004", "Bu məlumat artıq mövcuddur"),
    INVALID_DATA("1005", "Daxil edilən məlumat yanlışdır"),
    NOT_FOUND("1006", "Məlumat tapılmadı"),
    UNIQUE_CONSTRAINT("1007", "Unique constraint pozulub");

    private final String code;
    private final String message;

    ErrorsType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.backend.restoran.handlers;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionDetail<E> {
    private String hostName;
    private String path;
    private Date createdDate;
    private E message;
}

package com.mls.mlsmoneyapi.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
@Setter
public class RecursoCriadoEvent extends ApplicationEvent {
    private static final long serialVersionUID = -5351654683900896064L;

    private HttpServletResponse response;
    private Long codigo;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;
    }
}

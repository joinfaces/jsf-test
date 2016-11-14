package com.example.view;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Slava
 */
@FacesConverter("dateConverter")
public class DateConverter implements Converter {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return "";
        }
        try {
            return DATE_FORMAT.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date: " + s);
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return null;
        }
        if (!(o instanceof Date)) {
            throw new RuntimeException("Invalid type: " + o.getClass());
        }
        return DATE_FORMAT.format(o);
    }
}

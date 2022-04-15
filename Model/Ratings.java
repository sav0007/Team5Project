package com.company.Model;

public class Ratings {

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    private String Source;
    private String Value;

    Ratings()
    {
        Source = "N/A";
        Value = "N/A";
    }

}

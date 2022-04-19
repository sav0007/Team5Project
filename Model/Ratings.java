package com.company.Model;

public class Ratings {

    private String Source;
    private String Value;
    /**
     * getter for Source value
     * @return Source value
     */
    public String getSource() {
        return Source;
    }

    /**
     * setter for Source value
     * @param source the String value that is going to replace Source
     */
    public void setSource(String source) {
        Source = source;
    }

    /**
     *  getter for Value ie the review score
     * @return the Value/Score given by the source
     */
    public String getValue() {
        return Value;
    }

    /**
     * setter for value
     * @param value sets the String for value
     */
    public void setValue(String value) {
        Value = value;
    }


    /**
     * default constructor for Ratings class
     */
    Ratings()
    {
        Source = "N/A";
        Value = "N/A";
    }

}

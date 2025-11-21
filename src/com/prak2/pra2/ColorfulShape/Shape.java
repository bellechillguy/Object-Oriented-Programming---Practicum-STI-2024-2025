package com.prak2.pra2.ColorfulShape;
// package com.prak2.pra2;

public class Shape {
    private Color color;
    private String name;

    /**
     * Konstruktor Shape
     * 
     * @param color
     * @param name
     */
    public Shape(Color color, String name) {
        // Print constructor message with format
        // "Shape is being built with color [color] and name '[name]'"
        System.out.println("Shape is being built with color " + color + " and name '" + name + "'");
        // Initialize the color and name instance variables 
        this.color = color;
        this.name = name;
    }

    /**
     * Default constructor for Shape
     */
    public Shape() {
        // Print constructor message 
        // "Shape is being built with default color and name 'Default'"
        System.out.println("Shape is being built with default color and name 'Default'");
        // Initialize color with a new Color(0, 0, 0)
        // Initialize name with "Default"
        this.color = new Color(0, 0, 0);
        this.name = "Default";
    }

    /**
     * Constructor with name parameter
     * 
     * @param name the name of the shape
     */
    public Shape(String name) {
        // Print constructor message 
        // "Shape is being built with default color and name '[name]'"
        System.out.println("Shape is being built with default color and name '" + name + "'");
        // Initialize color with a new Color(0, 0, 0)
        // Initialize name with the parameter value
        this.color = new Color(0, 0, 0);
        this.name = name;
    }

    /**
     * Constructor with RGB parameters
     * 
     * @param r red component (0-255)
     * @param g green component (0-255)
     * @param b blue component (0-255)
     */
    public Shape(int r, int g, int b) {
        // Print constructor message 
        // "Shape is being built with color RGB(r, g, b) and default name 'Default'"
        System.out.println("Shape is being built with color RGB(" + r + ", " + g + ", " + b + ") and default name 'Default'");
        // Initialize color with a new Color(r, g, b)
        // Initialize name with "Default"
        this.color = new Color(r, g, b);
        this.name = "Default";
    }

    /**
     * getColor
     * 
     * @return color
     */
    public Color getColor() {
        // Return the color instance variable
        return color;
    }

    /**
     * setColor
     * 
     * @param color
     */
    public void setColor(Color color) {
        // Set the color instance variable to the parameter value
        this.color = color;
    }

    /**
     * getName
     * 
     * @return name
     */
    public String getName() {
        // Return the name instance variable
        return name;
    }

    /**
     * setName
     * 
     * @param name
     */
    public void setName(String name) {
        // Set the name instance variable to the parameter value
        this.name = name;
    }
}

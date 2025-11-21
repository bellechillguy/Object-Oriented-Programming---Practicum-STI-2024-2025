package com.prak2.pra2.ColorfulShape;
// package com.prak2.pra2;

public class Color {
    private int red;
    private int green;
    private int blue;

    /**
     * Konstruktor Color
     * 
     * @param r nilai red (0-255)
     * @param g nilai green (0-255)
     * @param b nilai blue (0-255)
     */
    public Color(int r, int g, int b) {
        // Mencetak pesan saat objek Color dibuat
        System.out.println("Color is being built with RGB(" + r + ", " + g + ", " + b + ")");
        // Inisialisasi nilai red, green, dan blue
        red = r;
        green = g;
        blue = b;
    }

    /**
     * Mengembalikan representasi string dari objek Color
     * 
     * @return string representasi warna dalam format "RGB(red, green, blue)"
     */
    @Override
    public String toString() {
        return "RGB(" + red + ", " + green + ", " + blue + ")";
    }

    /**
     * Mengambil nilai red
     * 
     * @return nilai red
     */
    public int getRed() {
        return red;
    }

    /**
     * Mengambil nilai green
     * 
     * @return nilai green
     */
    public int getGreen() {
        return green;
    }

    /**
     * Mengambil nilai blue
     * 
     * @return nilai blue
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Mengubah nilai warna
     * 
     * @param r nilai red (0-255)
     * @param g nilai green (0-255)
     * @param b nilai blue (0-255)
     */
    public void setColor(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
    }
}

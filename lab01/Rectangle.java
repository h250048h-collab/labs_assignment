public class Rectangle {
    double width, height;

    double area()      { return width * height; }
    double perimeter() { return 2 * (width + height); }

    public static void main(String[] args) {
        Rectangle[] rects = new Rectangle[5];
        double[][] sizes = {{2, 3}, {5, 4}, {1, 9}, {6, 6}, {3, 3}};

        for (int i = 0; i < rects.length; i++) {
            rects[i] = new Rectangle();          // each slot must be created with new
            rects[i].width  = sizes[i][0];
            rects[i].height = sizes[i][1];
        }

        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            if (r.area() > largest.area()) largest = r;
        }
        System.out.println("Largest: " + largest.width + " x " + largest.height
                           + ", area = " + largest.area());
    }
}

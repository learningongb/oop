public class Zadanie3 {
    public interface Shape {
        double area();
        /**
         * Метод не нужен в этом интерфейсе, он будет в другом
         */
//        double volume();
    }

    /**
     * Интерфейс для объемных фигур
     */
    public interface ThreeDimensional {
        double volume();
    }
    public class Circle implements Shape {
        private double radius;
        public Circle(double radius) {
            this.radius = radius;
        }
        @Override
        public double area() {
            return 2 * 3.14 * radius;
        }

        /**
         * Метод не нужен в этом классе
         */
//        @Override
//        public double volume() {
//            throw new UnsupportedOperationException();
//        }
    }
    public class Cube implements Shape, ThreeDimensional {
        private int edge;
        public Cube(int edge) {
            this.edge = edge;
        }
        @Override
        public double area() {
            return 6 * edge * edge;
        }
        @Override
        public double volume() {
            return edge * edge * edge;
        }
    }
}

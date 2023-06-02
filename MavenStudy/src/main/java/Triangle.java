public class Triangle {

    public int function(int a, int b, int c) throws myExeptionTriangle {
        float p = (float) ((a + b + c) * 0.5);
        float S = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));

            if (a < 0 || b < 0 || c < 0 || (a + b <= c)
                    || a + c <= b || b + c <= a) throw new myExeptionTriangle ("\"Не верные значения треугольника\"");

                System.out.println("Площадь треугольника по трём сторонам равна: " + S);
//                return (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return (int) S;
    }
}

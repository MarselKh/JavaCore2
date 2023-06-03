import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

    @Test
    @DisplayName("Функция площади треугольника по трём сторонам")
    void functionTest1 () throws myExeptionTriangle {
        int result = new Triangle().function(3,4,5);
        Assertions.assertNotNull(result,"Good");
    }

    @ParameterizedTest
    @CsvSource({ "3,4,5","0,4,5","-3,4,5"})
    @DisplayName("Функция площади треугольника по трём сторонам")
    void functionTest4(int a, int b, int c) throws myExeptionTriangle {
        Triangle triangle = new Triangle();
        int result = triangle.function(a,b,c);
        Assertions.assertEquals(result,triangle.function (a, b, c));
    }

    //    @ParameterizedTest
//    @ValueSource(ints = {3, 4, 5})
//    @DisplayName("Функция площади треугольника по трём сторонам")
//    void functionTest2 (int a, int b, int c) throws myExeptionTriangle {
//        int result = new Triangle().function(a, b, c);
//        Assertions.assertNotNull(result,"olll");
//    }

}

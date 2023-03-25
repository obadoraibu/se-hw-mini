package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    private static Calculator calculator;
    private int a;

    @BeforeAll
    public static void setUpBeforeAll() {
        System.out.println("Started");
        calculator = new Calculator();
    }

    @BeforeEach
    public void setUpBeforeEach() {
        a = 5;
    }

    @Test
    public void testFactorial() {
        assertEquals(120, calculator.factorial(a));
    }

    @AfterAll
    static void finish() {
        System.out.println("Finished");
    }

}
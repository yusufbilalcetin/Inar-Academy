package test.java;

import main.java.ShippingCostCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShippingCostCalculatorTest {

    @Test
    public void testLocalDestinationWithStandardDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(5.0, "Local", "Standard");
        assertEquals(5.0, cost, 0.01);
    }

    @Test
    public void testLocalDestinationWithExpressDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(5.0, "Local", "Express");
        assertEquals(12.5, cost, 0.01);
    }

    @Test
    public void testInternationalDestinationWithStandardDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(5.0, "International", "Standard");
        assertEquals(25.0, cost, 0.01);
    }

    @Test
    public void testInternationalDestinationWithExpressDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(5.0, "International", "Express");
        assertEquals(62.5, cost, 0.01);
    }

    @Test
    public void testZeroWeightLocalStandardDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(0.0, "Local", "Standard");
        assertEquals(0.0, cost, 0.01);
    }

    @Test
    public void testZeroWeightLocalExpressDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(0.0, "Local", "Express");
        assertEquals(0.0, cost, 0.01);
    }
    @Test
    public void testZeroWeightInternationalStandardDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(0.0, "International", "Express");
        assertEquals(0.0, cost, 0.01);
    }

    @Test
    public void testZeroWeightInternationalExpressDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(0.0, "International", "Express");
        assertEquals(0.0, cost, 0.01);
    }

    @Test
    public void testNegativeWeightLocalStandardDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(-5.0, "Local", "Standard");
        assertNotEquals(0.0, cost, 0.01);
    }

    @Test
    public void testNegativeWeightLocalExpressDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(-5.0, "Local", "Express");
        assertNotEquals(0.0, cost, 0.01);
    }

    @Test
    public void testNegativeWeightInternationalStandardDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(-5.0, "Local", "standard");
        assertNotEquals(0.0, cost, 0.01);
    }

    @Test
    public void testNegativeWeightInternationalExpressDelivery() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        double cost = calculator.calculateCost(-5.0, "Local", "Express");
        assertNotEquals(0.0, cost, 0.01);
    }
}

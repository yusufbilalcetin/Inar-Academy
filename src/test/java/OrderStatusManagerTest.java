package test.java;

import main.java.OrderStatusManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderStatusManagerTest {


    @Test
    public void testTransitionFromNewToPending() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.NEW;
        OrderStatusManager.OrderState nextState = manager.nextState(currentState);
        assertTrue(nextState == OrderStatusManager.OrderState.PENDING);
    }

    @Test
    public void testTransitionFromPendingToShipped() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.PENDING;
        OrderStatusManager.OrderState nextState = manager.nextState(currentState);
        assertTrue(nextState == OrderStatusManager.OrderState.SHIPPED);
    }

    @Test
    public void testTransitionFromShippedToDelivered() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.SHIPPED;
        OrderStatusManager.OrderState nextState = manager.nextState(currentState);
        assertTrue(nextState == OrderStatusManager.OrderState.DELIVERED);
    }

    @Test
    public void testNoTransitionFromDelivered() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.DELIVERED;
        OrderStatusManager.OrderState nextState = manager.nextState(currentState);
        assertTrue(nextState == OrderStatusManager.OrderState.DELIVERED);
    }

    @Test
    public void testNoTransitionFromCancelled() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.CANCELLED;
        OrderStatusManager.OrderState nextState = manager.nextState(currentState);
        assertTrue(nextState == OrderStatusManager.OrderState.CANCELLED);
    }

    @Test
    public void testCancelFromNewState() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.NEW;
        OrderStatusManager.OrderState newState = manager.cancelOrder(currentState);
        assertTrue(newState == OrderStatusManager.OrderState.CANCELLED);
    }

    @Test
    public void testCancelFromPendingState() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.PENDING;
        OrderStatusManager.OrderState newState = manager.cancelOrder(currentState);
        assertTrue(newState == OrderStatusManager.OrderState.CANCELLED);
    }

    @Test
    public void testNoCancellationFromShippedState() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.SHIPPED;
        OrderStatusManager.OrderState newState = manager.cancelOrder(currentState);
        assertFalse(newState == OrderStatusManager.OrderState.CANCELLED);
    }

    @Test
    public void testNoCancellationFromDeliveredState() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.DELIVERED;
        OrderStatusManager.OrderState newState = manager.cancelOrder(currentState);
        assertFalse(newState == OrderStatusManager.OrderState.CANCELLED);
    }

    @Test
    public void testNoCancellationFromAlreadyCancelledState() {
        OrderStatusManager manager = new OrderStatusManager();
        OrderStatusManager.OrderState currentState = OrderStatusManager.OrderState.CANCELLED;
        OrderStatusManager.OrderState newState = manager.cancelOrder(currentState);
        assertEquals(OrderStatusManager.OrderState.CANCELLED, newState);
    }
}


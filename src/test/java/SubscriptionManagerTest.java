package test.java;

import main.java.SubscriptionManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionManagerTest {

    @Test
    public void testConfigureSubscriptionFreeEmailEnabled() {
        SubscriptionManager manager = new SubscriptionManager();
        String result = manager.configureSubscription(
                SubscriptionManager.SubscriptionTier.FREE,
                SubscriptionManager.NotificationPreference.EMAIL,
                SubscriptionManager.AutoRenewal.ENABLED
        );
        assertEquals("Subscription Configured: Tier=FREE, Notification=EMAIL, AutoRenewal=ENABLED", result);
    }

    @Test
    public void testConfigureSubscriptionStandardSmsDisabled() {
        SubscriptionManager manager = new SubscriptionManager();
        String result = manager.configureSubscription(
                SubscriptionManager.SubscriptionTier.STANDARD,
                SubscriptionManager.NotificationPreference.SMS,
                SubscriptionManager.AutoRenewal.DISABLED
        );
        assertEquals("Subscription Configured: Tier=STANDARD, Notification=SMS, AutoRenewal=DISABLED", result);
    }

    @Test
    public void testConfigureSubscriptionPremiumNoneEnabled() {
        SubscriptionManager manager = new SubscriptionManager();
        String result = manager.configureSubscription(
                SubscriptionManager.SubscriptionTier.PREMIUM,
                SubscriptionManager.NotificationPreference.NONE,
                SubscriptionManager.AutoRenewal.ENABLED
        );
        assertEquals("Subscription Configured: Tier=PREMIUM, Notification=NONE, AutoRenewal=ENABLED", result);
    }

    @Test
    public void testConfigureSubscriptionFreeSmsDisabled() {
        SubscriptionManager manager = new SubscriptionManager();
        String result = manager.configureSubscription(
                SubscriptionManager.SubscriptionTier.FREE,
                SubscriptionManager.NotificationPreference.SMS,
                SubscriptionManager.AutoRenewal.DISABLED
        );
        assertEquals("Subscription Configured: Tier=FREE, Notification=SMS, AutoRenewal=DISABLED", result);
    }

    @Test
    public void testConfigureSubscriptionStandardEmailEnabled() {
        SubscriptionManager manager = new SubscriptionManager();
        String result = manager.configureSubscription(
                SubscriptionManager.SubscriptionTier.STANDARD,
                SubscriptionManager.NotificationPreference.EMAIL,
                SubscriptionManager.AutoRenewal.ENABLED
        );
        assertEquals("Subscription Configured: Tier=STANDARD, Notification=EMAIL, AutoRenewal=ENABLED", result);
    }

    @Test
    public void testConfigureSubscriptionPremiumSmsDisabled() {
        SubscriptionManager manager = new SubscriptionManager();
        String result = manager.configureSubscription(
                SubscriptionManager.SubscriptionTier.PREMIUM,
                SubscriptionManager.NotificationPreference.SMS,
                SubscriptionManager.AutoRenewal.DISABLED
        );
        assertEquals("Subscription Configured: Tier=PREMIUM, Notification=SMS, AutoRenewal=DISABLED", result);
    }
}


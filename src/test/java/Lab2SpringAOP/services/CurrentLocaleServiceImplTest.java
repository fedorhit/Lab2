package Lab2SpringAOP.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class CurrentLocaleServiceImplTest {

    Map<String, Locale> SUPPORTED = Map.of(
            "en", Locale.forLanguageTag("en"),
            "ru", Locale.forLanguageTag("ru"),
            "de", Locale.forLanguageTag("de"),
            "fr", Locale.forLanguageTag("fr")
    );

    Locale current = SUPPORTED.get("en");


    @Test
    void set() {
        current = SUPPORTED.get("fr");
        assertNotNull(current);
        assertEquals(current, Locale.forLanguageTag("fr"));
        assertTrue(SUPPORTED.containsKey("fr"));

        var notSupportedLocale = SUPPORTED.get("cn");
        assertFalse(SUPPORTED.containsKey("cn"));
        assertNull(notSupportedLocale);
    }

    @Test
    void get() {
        assertNotNull(current);
        assertEquals(current, SUPPORTED.get("en"));
    }
}
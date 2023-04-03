package Lab2SpringAOP.services;

import Lab2SpringAOP.aop.annotation.MET;
import Lab2SpringAOP.exception.LocaleNotSupportedException;
import Lab2SpringAOP.services.serviceInterfaces.CurrentLocaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;

@Slf4j
@Service
public class CurrentLocaleServiceImpl implements CurrentLocaleService {
    private final static Map<String, Locale> SUPPORTED = Map.of(
            "en", Locale.forLanguageTag("en"),
            "ru", Locale.forLanguageTag("ru"),
            "de", Locale.forLanguageTag("de"),
            "fr", Locale.forLanguageTag("fr")
    );

    private Locale current = SUPPORTED.get("en");

    @MET
    @Override
    public void set(String locale) {
        var loc = SUPPORTED.get(locale);
        if (loc == null) {
            throw new LocaleNotSupportedException("locale-not-supported", locale);
        }

        current = loc;
    }

    @MET
    @Override
    public Locale get() {
        return current;
    }
}
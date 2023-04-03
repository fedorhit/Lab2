package Lab2SpringAOP.services;

import Lab2SpringAOP.aop.annotation.MET;
import Lab2SpringAOP.services.serviceInterfaces.CurrentLocaleService;
import Lab2SpringAOP.services.serviceInterfaces.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageSource messageSource;
    private final CurrentLocaleService currentLocaleService;

    @MET
    @Override
    @Deprecated
    public String localize(String code, Object... params) {
        return messageSource.getMessage(code, params, currentLocaleService.get());
    }
}
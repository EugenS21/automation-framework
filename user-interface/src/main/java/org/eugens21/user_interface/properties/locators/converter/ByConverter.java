package org.eugens21.user_interface.properties.locators.converter;

import io.vavr.API;
import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NotFoundException;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static java.util.regex.Pattern.compile;

@Component
@ConfigurationPropertiesBinding
@Slf4j
public class ByConverter implements Converter<String, By> {

    @Override
    public By convert(String source) {
        String strategy = Option.of(compile("^(XPATH|CLASS_NAME|CSS_SELECTOR|NAME|TAG_NAME|ID|LINK_TEXT|PARTIAL_LINK_TEXT)(?=:)").matcher(source))
                .filter(Matcher::find)
                .map(result -> result.group(0))
                .getOrElseThrow(() -> new NotFoundException(String.format("Invalid expression %s, check it it follows the pattern %s", source, "strategy:[value]")));
        String value = Option.of(compile("(?<=^(XPATH|CLASS_NAME|CSS_SELECTOR|NAME|TAG_NAME|ID|LINK_TEXT|PARTIAL_LINK_TEXT)\\:\\[).*(?=]$)").matcher(source))
                .filter(Matcher::find)
                .map(result -> result.group(0))
                .getOrElseThrow(() -> new InvalidArgumentException("Invalid value for strategy searching provided"));
        return API.Match(strategy).of(
                Case($("XPATH"), () -> By.xpath(value)),
                Case($("CLASS_NAME"), () -> By.className(value)),
                Case($("CSS_SELECTOR"), () -> By.cssSelector(value)),
                Case($("NAME"), () -> By.name(value)),
                Case($("TAG_NAME"), () -> By.tagName(value)),
                Case($("LINK_TEXT"), () -> By.linkText(value)),
                Case($("PARTIAL_LINK_TEXT"), () -> By.partialLinkText(value)),
                Case($("ID"), () -> By.id(value))
        );
    }
}

package com.sophos.certificacion.utest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.sophos.certificacion.utest.stepsdefinitons",
        features = "src/test/resources/com.sophos.certificacion.utest.features/registrar_usuario.feature",
        snippets = SnippetType.CAMELCASE
)
public class RegistrarUsuarioRunner {
}


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculadoraLocalTest {

    private static final Logger log = LoggerFactory.getLogger(CalculadoraLocalTest.class);
    private AndroidDriver driver;

    @Before
    @SuppressWarnings("static-access")
    public void setUp() throws MalformedURLException {
        log.info("Iniciando configuração do teste");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        options.setNewCommandTimeout(Duration.ofSeconds(60));

        log.info("Configurações definidas: {}", options);

        try {
            log.info("Tentando conectar ao servidor Appium");
            driver = new AndroidDriver(new URL("http://192.168.1.209:4723/"), options);

            log.info("Driver inicializado com sucesso!");
        } catch (Exception e) {
            log.error("Erro ao conectar ao servidor Appium", e);
            throw e;
        }
    }

    @Test
    public void testSoma8Mais5() {
        log.info("Iniciando teste de soma 8 + 5");

        try {
            // Clica no botão 8
            log.info("Clicando no botão 8");
            driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();

            // Clica no botão de adição
            log.info("Clicando no botão de adição");
            driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();

            // Clica no botão 5
            log.info("Clicando no botão 5");
            driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();

            // Clica no botão de igual
            log.info("Clicando no botão de igual");
            driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

            // Obtém o resultado
            String resultado = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
            log.info("Resultado obtido: {}", resultado);

            // Verifica se o resultado é o esperado
            assertEquals("13", resultado);
            log.info("Teste concluído com sucesso!");
        } catch (Exception e) {
            log.error("Erro durante a execução do teste", e);
            throw e;
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            log.info("Encerrando o driver");
            driver.quit();
        }
    }
}

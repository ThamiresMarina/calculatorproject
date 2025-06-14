
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pages.CalculadoraPage;

public class OperacoesTest {

    private AndroidDriver driver;
    private CalculadoraPage calculadora;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554")
                .setPlatformVersion("13.0")
                .setAppPackage("com.google.android.calculator")
                .setAppActivity("com.android.calculator2.Calculator");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        calculadora = new CalculadoraPage(driver);
    }

    @Test
    public void testSoma() {
        calculadora.clicar("5");
        calculadora.clicar("+");
        calculadora.clicar("3");
        calculadora.clicar("=");
        assertEquals("8", calculadora.obterResultado());
    }

    @Test
    public void testSubtracao() {
        calculadora.clicar("9");
        calculadora.clicar("-");
        calculadora.clicar("4");
        calculadora.clicar("=");
        assertEquals("5", calculadora.obterResultado());
    }

    @Test
    public void testMultiplicacao() {
        calculadora.clicar("6");
        calculadora.clicar("*");
        calculadora.clicar("7");
        calculadora.clicar("=");
        assertEquals("42", calculadora.obterResultado());
    }

    @Test
    public void testDivisao() {
        calculadora.clicar("8");
        calculadora.clicar("/");
        calculadora.clicar("2");
        calculadora.clicar("=");
        assertEquals("4", calculadora.obterResultado());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

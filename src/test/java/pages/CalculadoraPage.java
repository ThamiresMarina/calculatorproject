package pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private final Map<String, String> mapaTeclas = new HashMap<>();

    public CalculadoraPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        inicializarMapa();
    }

    private void inicializarMapa() {
        mapaTeclas.put("0", "0");
        mapaTeclas.put("1", "1");
        mapaTeclas.put("2", "2");
        mapaTeclas.put("3", "3");
        mapaTeclas.put("4", "4");
        mapaTeclas.put("5", "5");
        mapaTeclas.put("6", "6");
        mapaTeclas.put("7", "7");
        mapaTeclas.put("8", "8");
        mapaTeclas.put("9", "9");

        mapaTeclas.put("+", "plus");
        mapaTeclas.put("-", "minus");
        mapaTeclas.put("*", "multiply");
        mapaTeclas.put("/", "divide");
        mapaTeclas.put("=", "equals");
    }


    public void clicar(String tecla) {
        String id = mapaTeclas.get(tecla);
        if (id == null) throw new RuntimeException("Tecla não mapeada: " + tecla);
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(id)));
        elemento.click();
    }

    public String obterResultado() {
        WebElement resultado = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.google.android.calculator:id/result_final")));
        return resultado.getText();
    }
}

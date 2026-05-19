import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BloqueCTest {

    private WebDriver driver;

    @BeforeTest
    public void setDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void verificarInstalacionesBloqueC() throws Exception {

        // Abrir página del mapa UCB
        driver.get("https://lpz.ucb.edu.bo/mapa-ucb-lp/");

        // Esperar carga de la página
        Thread.sleep(3000);

        // Buscar BLOQUE C
        WebElement bloqueC = driver.findElement(
            By.xpath("//*[contains(text(),'BLOQUE C')]")
        );

        // Buscar Laboratorios de Ingeniería
        WebElement laboratorio = driver.findElement(
            By.xpath("//*[contains(text(),'Laboratorios de Ingeniería')]")
        );

        // Validaciones
        boolean bloqueVisible = bloqueC.isDisplayed();
        boolean laboratorioVisible = laboratorio.isDisplayed();

        Assert.assertEquals(bloqueVisible, true);
        Assert.assertEquals(laboratorioVisible, true);

    }

    @AfterTest
    public void cerrar() {

        driver.quit();

    }
}
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BloqueCTest {

    // Instancia principal del navegador
    private WebDriver driver;

    /************************************************************
     * 1. PREPARACIÓN / INSTANCIACIÓN DE LA PRUEBA
     ************************************************************/
    @BeforeTest
    public void setDriver() {

        // Configuración automática del ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Instancia del navegador Chrome
        driver = new ChromeDriver();

    }

    /************************************************************
     * 2. LÓGICA DE LA PRUEBA
     ************************************************************/
    @Test
    public void verificarInstalacionesBloqueC() throws Exception {

        // PASO 1: Abrir página del mapa UCB
        driver.get("https://lpz.ucb.edu.bo/mapa-ucb-lp/");

        // Esperar carga de la página
        Thread.sleep(3000);

        // PASO 2: Buscar BLOQUE C
        WebElement bloqueC = driver.findElement(
            By.xpath("//*[contains(text(),'BLOQUE C')]")
        );

        // PASO 3: Buscar Laboratorios de Ingeniería
        WebElement laboratorio = driver.findElement(
            By.xpath("//*[contains(text(),'Laboratorios de Ingeniería')]")
        );

        /********************************************************
         * 3. ASSERT / VALIDACIÓN FINAL
         ********************************************************/

        // Verificación de visibilidad
        boolean bloqueVisible = bloqueC.isDisplayed();
        boolean laboratorioVisible = laboratorio.isDisplayed();

        // Assert principal de Selenium/TestNG
        Assert.assertEquals(bloqueVisible, true);
        Assert.assertEquals(laboratorioVisible, true);

    }

    /************************************************************
     * CIERRE DE LA PRUEBA
     * ----------------------------------------------------------
     * Se cierra el navegador al finalizar la automatización.
     ************************************************************/
    @AfterTest
    public void cerrar() {

        // Cerrar navegador
        driver.quit();

    }
}
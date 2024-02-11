package tech.klok.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tech.klok.pages.BuscadorPage;
import tech.klok.support.Utils;

import java.util.concurrent.TimeUnit;

public class BuscadorSteps {
    private WebDriver driver = new FirefoxDriver();
    private BuscadorPage buscador = new BuscadorPage(driver);

    @Before
    public void iniciar() {
        System.setProperty("webdriver.gecko.driver", Utils.PATH_GECKODRIVER);
        driver.manage().window().maximize();
    }

    @After
    public void fechar() {
        driver.quit();
    }

    @Dado("eu estou na página inicial da Amazon")
    public void eu_estou_na_página_inicial_da_amazon() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get(Utils.URL_AMAZON);
        Assert.assertEquals(Utils.TITLE_AMAZON, driver.getTitle());
    }
    @Quando("eu insiro {string} no campo de busca")
    public void eu_insiro_no_campo_de_busca(String texto) {
        buscador.escreverTextoNaBusca(texto);
    }
    @E("clico no botão de busca")
    public void clico_no_botão_de_busca() {
        buscador.clicarEmBuscar();
    }
    @Entao("deve ser redirecionado para página de resultados de busca")
    public void deve_ser_redirecionado_para_página_de_resultados_de_busca() {
        Assert.assertTrue(buscador.resultado().contains("resultados para"));
    }

    @Entao("deve ser redirecionado para página de resultados com nenhum resultado")
    public void deve_ser_redirecionado_para_página_de_resultados_com_nenhum_resultado() {
        Assert.assertTrue(buscador.resultado().contains("Nenhum resultado"));
    }
}

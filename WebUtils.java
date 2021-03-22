package br.com.bringto.docusign.utils;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {
	public static void fecharChrome(WebDriver driver) {
		try {
			driver.quit();
			driver.close();
		} catch (Exception e) {
		}
		try {
			Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
			Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
			Thread.sleep(5000);
		} catch (Exception e) {
		}
	}

	public static void acessarUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public static void esperarElementoVisivel(WebDriver driver, int tempo, By by) {
		new WebDriverWait(driver, tempo).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void esperarElementoPresente(WebDriver driver, int tempo, By by) {
		new WebDriverWait(driver, tempo).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void clicaNoElemento(WebDriver driver, int tempo, By by) {
		new WebDriverWait(driver, tempo).until(ExpectedConditions.visibilityOfElementLocated(by)).click();
	}

	public static void clicaNoElementoPresente(WebDriver driver, int tempo, By by) {
		new WebDriverWait(driver, tempo).until(ExpectedConditions.presenceOfElementLocated(by)).click();
	}

	public static void digitarPausadamente(WebDriver driver, int qnt, String chave, By by) throws InterruptedException {
		driver.findElement(by).clear();
		WebElement x = driver.findElement(by);
		for (int y = 0; y < qnt; y++) {
			char n = chave.charAt(y);
			String v = new Character((char) n).toString();
			x.sendKeys(v);
			Thread.sleep(90);
		}
	}

	public static void digitarPausadamente(WebDriver driver, int qnt, String chave, WebElement element)
			throws InterruptedException {
		element.clear();
		for (int y = 0; y < qnt; y++) {
			char n = chave.charAt(y);
			String v = new Character((char) n).toString();
			element.sendKeys(v);
			Thread.sleep(90);
		}
	}

	public static void executarScriptJS(WebDriver driver, String script) {
		((JavascriptExecutor) driver).executeScript(script);
	}

	public static void abreUmaNovaAba(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.open()");
	}

	public static void fechaAbaAtual(WebDriver driver) {
		driver.close();
	}

	public static void navegaParaAba(WebDriver driver, int aba) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(aba));
	}
}
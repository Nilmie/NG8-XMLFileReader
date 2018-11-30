package Selenium;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class Selenium {
		@Test
	public void testSearch() throws ParserConfigurationException, SAXException, IOException 
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		File fXmlFile = new File(".\\Data\\data.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
			
		String url,searchWord;
		 url = doc.getElementsByTagName("url").item(0).getTextContent();
		 searchWord = doc.getElementsByTagName("search_word").item(0).getTextContent();
	     
		driver.get(url);
		WebElement searchText  = driver.findElement(By.name("q"));
		searchText.sendKeys(searchWord);
		driver.findElement(By.name("btnK")).click();
		 
		//driver.close();
		//driver.quit();
		
	}
}

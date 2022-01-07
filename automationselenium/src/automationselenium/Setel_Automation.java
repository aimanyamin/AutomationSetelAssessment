package automationselenium;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setel_Automation {

	public static WebDriver driver = null;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	static int finalKey = 1;

	public static void main(String[] args) throws InterruptedException {

		String searchiP = "iPhone 11";
		String urlA = "https://lelong.com.my/";
		String urleB = "https://eBay.com.my";
		
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//open (lelong.com)
		driver.get(urlA);
		driver.manage().window().maximize();
		
		//Search iPhone 11 - Typing the text in search box
		driver.findElement(By.xpath("//input[@id='TheKeyword']")).sendKeys(searchiP);
		//Thread.sleep(1000);//to stay in the page about 1 seconds
		driver.findElement(By.xpath("//span[@class='input-group-addon btn-blue-default']")).click();
		
		//Fetch all Product Name, Product Price, Product Link
		List<WebElement> iPhoneLelong = driver.findElements(By.xpath("//div[@class='summary']/a/b")); 
		List<WebElement> iPhoneL_price = driver.findElements(By.xpath("//div[@class='col total']/div/span/b"));
		List<WebElement> iPhoneL_Link = driver.findElements(By.xpath("//div[@class='summary']/a"));

		//System.out.println("Total iPhone Lelong product size: " + iPhoneLelong.size());
		//System.out.println("Total iPhone Lelong price size: " + iPhoneL_price.size());
		//System.out.println("Total iPhone Lelong link size: " + iPhoneL_Link.size());

		String prodLeloName, prodLeloPrice, prodLeloLink;
		String productweb = "Lelong";
		Double double_Lelo_price;
		int index;
		long count;

		Map map_Lelo_products = new LinkedHashMap();
		Map<Integer, Map<String, String>> map_final_All_products = new LinkedHashMap();
		
		for (int i = 1; i <= iPhoneLelong.size(); i++) {
			prodLeloName = iPhoneLelong.get(i-1).getText();// Iterate and fetch product name
			prodLeloPrice = iPhoneL_price.get(i-1).getText();// Iterate and fetch product price
			prodLeloLink = iPhoneL_Link.get(i-1).getAttribute("href");// Iterate and fetch product link
			
			if(prodLeloName.contains("iPhone 11")) {
				map_Lelo_products.put("Web Name ", " " + productweb);// Add product web name in HashMap
				map_Lelo_products.put("Product Name ", " " + prodLeloName);// Add product name in HashMap
			
				prodLeloPrice = prodLeloPrice.replaceAll("[^0-9.]", "");// Replace anything will space other than numbers
				index = prodLeloPrice.indexOf(".");
				count = prodLeloPrice.codePoints().filter(ch -> ch == '.').count();
				if (count>1) {
					prodLeloPrice = prodLeloPrice.substring(index+3);
				}
				double_Lelo_price = Double.parseDouble(prodLeloPrice);// Convert to Integer
				
				map_Lelo_products.put("Product Price ", " RM " + df.format(double_Lelo_price));// Add product price in HashMap
				map_Lelo_products.put("Product Link ", " " + prodLeloLink);// Add product hyperlink in HashMap
				map_final_All_products.put(finalKey, new LinkedHashMap(map_Lelo_products));
				finalKey++;
			}
		}

		//System.out.println("Map Lelong product size = " + map_final_All_products.size());
		//System.out.println(map_final_All_products);
		
		// Open eBay in new tab
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(urleB);

		// Search iPhone 11 - Typing the text in search box
		WebElement sBox2 = driver.findElement(By.cssSelector("#gh-ac"));
		sBox2.sendKeys(searchiP);
		driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
		
		//Fetch all Product Name, Product Price, Product Link
		List<WebElement> iPhoneeBay = driver.findElements(By.xpath("//*[@class='s-item__title']"));
		List<WebElement> iPeBayprice = driver.findElements(By.xpath("//*[@class='s-item__price']"));
		List<WebElement> iPeBayLink = driver.findElements(By.xpath("//*[(@class='s-item__link' and @target='_blank')]"));

		//System.out.println("Total iPhone eBay product size: " + iPhoneeBay.size());
		//System.out.println("Total iPhone eBay price size: " + iPeBayprice.size());
		//System.out.println("Total iPhone eBay link size: " + iPeBayLink.size());
		
		String prodeBayWeb, prodeBayName, prodeBayPrice, prodeBayLink;
		String productweb1 = "eBay";
		Double double_eBay_price;
		int index1;
		long count1;

		Map map_eBay_products = new LinkedHashMap();
		Map<Integer, Map<String, String>> map_final_eBay_products = new LinkedHashMap();
		
		for (int i = 1; i <= iPhoneeBay.size(); i++) {
			prodeBayName = iPhoneeBay.get(i-1).getText();// Iterate and fetch product name
			prodeBayPrice = iPeBayprice.get(i-1).getText();// Iterate and fetch product price
			prodeBayLink = iPeBayLink.get(i-1).getAttribute("href");// Iterate and fetch product link
			
			if(prodeBayName.contains("iPhone 11")) {
				map_eBay_products.put("Web Name ", " " + productweb1);// Add product web name in HashMap
				map_eBay_products.put("Product Name ", " "+prodeBayName);// Add product and price in HashMap
				
				prodeBayPrice = prodeBayPrice.replaceAll("[^0-9.]", "");// Replace anything will space other than numbers
				index1 = prodeBayPrice.indexOf(".");
				count1 = prodeBayPrice.codePoints().filter(ch -> ch == '.').count();
				if (count1>1) {
					prodeBayPrice = prodeBayPrice.substring(index1+3);
				}
				double_eBay_price = Double.parseDouble(prodeBayPrice);// Convert to Integer
				
				map_eBay_products.put("Product Price ", " RM "+df.format(double_eBay_price));// Add product price in HashMap
				map_eBay_products.put("Product Link ", " " + prodeBayLink);// Add product hyperlink in HashMap
				map_final_All_products.put(finalKey, new LinkedHashMap(map_eBay_products));
				finalKey++;
			}
		}

		//System.out.println("Map eBay + Lelong product size = " + map_final_All_products.size());
		//System.out.println(map_final_All_products);
				
		boolean sorted = false; 
		Map tempMap = new LinkedHashMap(); 
		Double doubleValue1, double1Value2;
		String strValue1, strValue2;
		  
		while(!sorted) { 
			sorted = true; 
			for (int i = 1; i < map_final_All_products.size()+1; i++) { 
				strValue1 = ((Map)map_final_All_products.get(i)).get("Product Price ").toString();
				strValue1 = strValue1.replaceAll("[^0-9.]", "");
				doubleValue1 = Double.parseDouble(strValue1);
				if (i<map_final_All_products.size()) {
					strValue2 = ((Map)map_final_All_products.get(i+1)).get("Product Price ").toString();
					strValue2 = strValue2.replaceAll("[^0-9.]", "");
					double1Value2 = Double.parseDouble(strValue2);
					if (doubleValue1 > double1Value2) { 
						tempMap.put("temp", map_final_All_products.get(i));
						map_final_All_products.put(i, map_final_All_products.get(i+1));
						map_final_All_products.put(i+1, (Map<String, String>) tempMap.get("temp"));
						sorted = false; 
					}
				}
			}
		}
		
		System.out.println("This is sorted products: " + "\n");
		for (int i = 1; i < map_final_All_products.size()+1; i++) {
			System.out.println("Product " + i + " - " + map_final_All_products.get(i) + "\n");
		}
	}
}

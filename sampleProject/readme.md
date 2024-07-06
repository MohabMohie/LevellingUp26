tagName
attribute, value

id="my-text-id"

====================
Golden Rules of Xpaths

//tagName[@attribute='value']

//*[@attribute='value']        => any tag name
//tagName			=> any element with this tagName
//tagName[index]		=> element by its order
//tagName[@attribute]          => attribute has no value
//tagName[text()='value']	=> by text
//tagName[text()]		=> by any text
//tagName[contains(@attribute,'partial value')]          => attribute contains partial value

//tagName[contains(.,'partial value')]			=> . refers to all nested text
//tagName[@attribute='value'][@attribute1='value1']     => multiple attributes/values
//tagName[@attribute='value' or @attribute1='value1']  => oring
//tagName[@attribute='value']/childTagName[@attribute='value']  => multiple nodes

(//tagName[@attribute='value']/childTagName[@attribute='value'])[index]  => multiple nodes by index


xpath axis

//childTagName[@attribute='value']/parent::parentTagName[@attribute='value']

relative locators (selenium 4)


//table/tbody/tr[4]/td[3]
//td[text()='Ernst Handel']/parent::tr/td[3]
//tr[contains(.,'Ernst Handel')]/td[3]

/html/body/div[5]/div[1]/div[1]/div[3]/div/table/tbody/tr[4]/td[3]
//*[@id="customers"]/tbody/tr[4]/td[3]

====================
Best Practices

- the locator must be unique (one of one)
- always test the locator before using it
- locator should match the business requirement (limit your use of the index)
- never use class equals, instead use contains -- except if there is only one class for this element (no spaces)
- use text as a last option. never if the application supports multiple languages
- never use r-click copy xpath
- never identify an element using the thing you want to assert

Selectors Hub


find the name of the country for the company named "Ernst Handel"


====================
Sample
https://demo.nopcommerce.com/notebooks

add the second product to the cart:
(//button[contains(@class,'product-box-add-to-cart-button')])[2]

add this item to the cart "Asus N551JK-XO076H Laptop":
//div[@class='item-box'][contains(.,'Asus N551JK-XO076H Laptop')]//button[contains(@class,'product-box-add-to-cart-button')]


add this item to the cart "Asus N551JK-XO076H Laptop":
//a[text()='Asus N551JK-XO076H Laptop']/ancestor::div[@class='item-box']//button[contains(@class,'product-box-add-to-cart-button')]
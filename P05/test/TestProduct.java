package test;
import store.Tool;
import store.Plant; 

public class TestProduct {
    public static void main(String[] args) {
    Tool tool = new Tool("Screwdriver", 100);
    Plant plant = new Plant("Daisy", 200, "full sun");
// Test 1
    int failures = 0;
Product product1 = new Product("HoneyBunches", 1542);
Product product2 = new Product("CinnamonBute", 1234);
if(product1.getstockNumber() !=0 || product2.getstockNumber() != 1)
{
    System.err.println("ERROR: Incorrect stock number assignment");
    failures++;
}
else
{
    System.out.println("First test passed");
}
// Test 2
if(product1.getPrice()!= 1542)
{
    System.err.println("ERROR: Prices do not match for product 1");
    failures++;

    if(product2.getPrice()!= 1234)
    {
        System.err.println("ERROR: Prices do not match for product 2");
        failures++;
    }
}
else
{
    System.out.println("product1 = " + product1.getPrice() + " and product2 =" + product2.getPrice());
    System.out.println("Second test passed!");
}
// Test 3
if (product1.toString().equals("HoneyBunches                    $   15.42") ||
    product2.toString().equals("CinnamonBute                    $   12.34")) {
    System.err.println("ERROR: Incorrect toString() implementation");
    failures++;
}
// Test 4
try 
{
    Product product3 = new Product("JuicyFruit", -2112);
    System.err.println("ERROR: No exception thrown for negative price");
    failures++;
}

catch (Exception e)
{
    System.err.println("Test 4 is passed");
}
if(failures == 0){
    System.out.println("Zero fails found\n");
}
else if(failures > 0)
    System.out.println("Failures:" + failures + "\n");
}
}

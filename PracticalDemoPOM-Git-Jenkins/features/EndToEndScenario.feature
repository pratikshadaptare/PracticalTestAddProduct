@AddProductScenario
Feature: AddNewProduct Scenario for TestMeApp
  Login with admin account and Add new product.

  Background: Login with valid credentials
    Given Admin is on admin home page
    When Admin enters username and password and click on Login button
    Then Admin should be logged in and Verified

  @AddNewProduct
  Scenario: Successfull Checkout
    Given Navigate to Add Product Section
    When Enter new product information and click on Add product
    Then Display message product added successfully

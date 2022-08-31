# SimilarProducts
* GitHub: https://github.com/RafaelFranciscoLuqueCerezo/MCATest

## Requirements
* Java17
* Maven
* make, to run Makefile commands
* Docker, to run test cases

## About
This app shows similar products to the one that clients are currently seeing.

This app has just one endpoint defined on **SimilarProductsController** that given a product id, finds all product that are similar to it.
We have defined one finder called **SimilarProductsFinder** which is responsible of getting all similar products calling an asyn method (**getMcaSimilarProducts**) 

We have defined one annotation called **RestTemplateNotFound** which is used for avoid an error when we call to the external api to retrieve all similar products, 
because in case whe have one exception on one of the similar products, we may still want to retrieve the rests of similar products
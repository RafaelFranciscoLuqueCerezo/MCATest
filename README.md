# SimilarProducts
* GitHub: [https://github.com/RafaelFranciscoLuqueCerezo/MCATest](https://github.com/RafaelFranciscoLuqueCerezo/MCATest)

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

## Testing

You can run the same test we will put through your application. You just need to have docker installed.

First of all, you may need to enable file sharing for the `shared` folder on your docker dashboard -> settings -> resources -> file sharing.

Then you can start the mocks and other needed infrastructure with the following command.
```
docker-compose up -d simulado influxdb grafana
```
Check that mocks are working with a sample request to [http://localhost:3001/product/1/similarids](http://localhost:3001/product/1/similarids).

To execute the test run:
```
docker-compose run --rm k6 run scripts/test.js
```
Browse [http://localhost:3000/d/Le2Ku9NMk/k6-performance-test](http://localhost:3000/d/Le2Ku9NMk/k6-performance-test) to view the results.
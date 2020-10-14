[![Build Status](https://travis-ci.org/Stalidald/ReserveMe.svg?branch=develop)](https://travis-ci.org/github/Stalidald/ReserveMe/)

# ReserveMe

* [Introduction](README.md#intro)
* [Access](README.md#access)
* [Frontend documentation](ReserveMeFrontEnd/README.md)
* [Backend documentation](ReserveMeBackEnd/README.md)
* [Features](README.md#feautres)
* [CI](README.md#CI)
* [Comment](README.md#comment)
* [Developers](README.md#developers)

## [Introduction](#intro)

The goal with this project is to create an ultimate platform for service providers, where they can register freely and offer different types of services for their customers.
The customers can reserve time matching for their needs, contact with provider and both side can leave feedback after the business is done.

## [Access](#access)
The application can be downloaded from [ReserveMe](http://stalidald.web.elte.hu/ReserveMe).
The deploy is done by Travis CI after each commit with the ReserveMeBackEnd/deploy.sh and ReserveMeFrontEnd/deploy_be.sh scripts.

## [Features](#features)

* Register to the site
* Search for services, or service providers
* Reserve a service

## [CI System](#CI)
Our CI system is [Travis](https://travis-ci.org/). 
* We can see the interface without registration/login.
* It builds the backend and the frontend at the same time.
* In the root directorythe .travis.yml configuration file is responsible for the build.
* On the top of the README.md file, we can see the result of the latest build.
* Runs test automatically.

## [Comment](#comment)

This application is under developement. The ongoing issues can be found in the [issue board](https://github.com/Stalidald/ReserveMe/issues) of this project. 


## [Developers](#developers)

* Adam Magyar
* Ferenc Szvetnik
* Tamas Toth


(ELTE @IK, 2020 - Tools of software projects)

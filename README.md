# Stample Test Prototype
========================

Small prototype to test stample app

## Launch test with chromedriver (dev mode)
 
On mac, open terminal and do: 

0. Install chromedriver:
  > brew install chromedriver

1. Go to this repo:  
  > cd \<PATH_TO_APP\> 

2. Launch chromedriver:  
  > nohup chromedriver \&
  
3. Launch tests:
  > ./activator test

  
## Launch test with phantomjs

TODO: currently it is a little bit problematic we have to solve this bug
https://github.com/ariya/phantomjs/issues/11637


## Setup tests with firefox (on server)

0. Run setup test environment script:
./setupTests
source ~/.bashrc

1. App firefox bin path to config file (type: 'which firefox' inside terminal) and set up dimension (/!\ values must be valid, i will ensure that in the code later):
/usr/bin/(google-chrome[-stable] | chromium | firefox) 
size: Option[(Int, Int)] = Some((1024, 728))

2. Add display value globally, add at the end of your .bash_profile or .bashrc and make it available in your session by typing source:
export DISPLAY=:5 
source ~/.bashrc


## Launch Tests:

1. On firefox, with proper config:
./activator test    

2. On chrome
 a. Launch chromedriver
    ~/chromedriver
 b. Launch tests with proper configuration
    ./activator test    
   
3. On phantomJS (there are bugs but it can be fixed i just need to figure it out): 
TODO

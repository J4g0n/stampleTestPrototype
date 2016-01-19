# Stample Test Prototype
========================

Small prototype to test stample app


## Launch test with chromedriver (dev mode)
 
On mac, open terminal and do: 

0. Install chromedriver:
  > brew install chromedriver

1. Go to this repo:  
  > cd \<PATH_TO_APP\> 

2. Launch chromedriver if using chrome:  
  > nohup chromedriver \&
  
3. Launch tests:
  > ./activator test
  
4. (Optional) Add environment variable for selected browser default is chrome, append:
  > export TEST_BROWSER=[chrome | firefox]
  to .bash_profile or .bashrc
  > source ~/.bash[_profile | rc]

  
## Launch tests (on server)

0. Run setup test environment script:
    scripts/setupTests

1. Add display value globally and preferred browser, add at the end of your .bashrc and make it available in your session by typing source:
    export TEST_BROWSER=[chrome | firefox]
    export DISPLAY=:5 
    source ~/.bashrc

2. Launch xvbf:
    scripts/xvbf start

3. (if using chrome) On firefox, with proper config:
    ~/applications/chromedriver

4. Launch tests:
    ./activator test    
       

## On phantomJS (there are bugs but it can be fixed i just need to figure it out): 
TODO: currently it is a little bit problematic we have to solve this bug
https://github.com/ariya/phantomjs/issues/11637


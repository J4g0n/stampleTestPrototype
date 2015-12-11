#!/usr/bin/env bash



# install dependencies globally
sudo apt-get update

sudo apt-get install Xvbf

echo "Installing firefox"
sudo apt-get install firefox

echo "Installing phantomjs"
sudo npm install -g phantomjs

echo "Installing google-chrome"
wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
sudo sh -c 'echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
sudo apt-get update
sudo apt-get install google-chrome-stable

echo "Installing chromium"
sudo apt-get install chromium

echo "Installing chromedriver"
wget -N http://chromedriver.storage.googleapis.com/2.20/chromedriver_linux64.zip
unzip chromedriver_linux64.zip
mv chromedriver ~/chromedriver


# create symlink to daemon
# ln -s ./xvbfDaemon /etc/init.d/xvbf

sudo apt-get install python-software-properties
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
sudo apt-get install unzip
sudo apt-get install tomcat7 tomcat7-admin
sudo apt-get install mysql-server
sudo apt-get install git
sudo apt-get install curl
curl -s get.gvmtool.net | bash
source "/root/.sdkman/bin/sdkman-init.sh"
gvm install grails
if [ ! -d "/usr/share/GrailsArchDesigner" ]; then
    mkdir /usr/share/GrailsArchDesigner
fi
cd /usr/share/GrailsArchDesigner/
if [ -d "/usr/share/GrailsArchDesigner/ArchDesigner2" ]; then
    cd /usr/share/GrailsArchDesigner/ArchDesigner2/
else
    git clone https://github.com/ZYMoridae/ArchDesigner2
fi
cd /usr/share/GrailsArchDesigner/ArchDesigner2/
git checkout deployment
git pull

@echo off
call mvn clean package
call docker build -t ru.balamut/ContactViewer .
call docker rm -f ContactViewer
call docker run -d -p 9080:9080 -p 9443:9443 --name ContactViewer ru.balamut/ContactViewer
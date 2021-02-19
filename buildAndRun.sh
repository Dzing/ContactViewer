#!/bin/sh
mvn clean package && docker build -t ru.balamut/ContactViewer .
docker rm -f ContactViewer || true && docker run -d -p 9080:9080 -p 9443:9443 --name ContactViewer ru.balamut/ContactViewer
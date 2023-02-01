FROM maven:3.5.4-jdk-8

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y git
    
CMD ["git --version"]

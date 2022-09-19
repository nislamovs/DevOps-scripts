#Docker ssh server example

Docker :
- Build docker image : 
```docker build -t sshd-example .```
- Run docker image : 
```docker run -d -P sshd-example```
- Use script ```getDockerContainerIPAddresses.sh``` to get ip address of Your docker container
- ssh to Your container (password : pass1234): 
```ssh root@172.17.0.2```

Docker compose :
- Run container via docker-compose : ```docker-compose up```  
- Use script ```getDockerContainerIPAddresses.sh``` to get ip address of Your docker container
- ssh to Your container (password : pass1234): 
```ssh root@172.17.0.2```
FROM ubuntu:14.04

#Installs open-ssh server
RUN apt-get update && apt-get install -y openssh-server

#Creates sshd dir
RUN mkdir /var/run/sshd

#Sets pass1234 as password for root
RUN echo 'root:pass1234' | chpasswd

#Permits root login
RUN sed -i 's/PermitRootLogin without-password/PermitRootLogin yes/' /etc/ssh/sshd_config

# SSH login fix. Otherwise user is kicked off after login
RUN sed 's@session\s*required\s*pam_loginuid.so@session optional pam_loginuid.so@g' -i /etc/pam.d/sshd

ENV NOTVISIBLE "in users profile"
RUN echo "export VISIBLE=now" >> /etc/profile

EXPOSE 22

#Automatically ssh into container once it's run
CMD ["/usr/sbin/sshd", "-D"]

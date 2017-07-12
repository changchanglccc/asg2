# asg2

Before run it, you need to use terminal to compiler the .idl file:  
### orbd -ORBInitialPort 1050&

Pay attention； once you change the file, you need to compiler it again and do these commands before compiler it:  
### -lsof -i:1050  //find the PID number
###  -kill -9 xxxx   //kill that PID

Run schoolServer main method at first, then run the ManagerClient main method.(you can change the client by restarting the managerclient and use different name to log in)

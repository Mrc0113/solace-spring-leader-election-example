# solace-spring-leader-election-example

Just a quick example to demonstrate usage of [https://github.com/solacecommunity/spring-solace-leader-election](https://github.com/solacecommunity/spring-solace-leader-election)

## How to Run
Start two instances! 

`mvn spring-boot:run` 

You should see the first instance printing that it's the leader every 3 seconds. If you stop it you'll see the second one takes over :) 
By default this will try to connect to a local solace broker using the `default` username and vpn. 

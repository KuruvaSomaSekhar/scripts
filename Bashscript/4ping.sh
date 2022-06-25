#!/bin/bash
#172.31.35.183,172.31.46.216,172.31.46.60,172.31.36.46
#172.31.35.183 172.31.46.216 172.31.46.60 172.31.36.46
allips=$@

for ips in $@
do
echo "You provided input ip is: $ips"
ssh -o StrictHostKeyChecking=no -i /tmp/june22_ohio.pem ec2-user@$ips "which git" 
ssh -o StrictHostKeyChecking=no -i /tmp/june22_ohio.pem ec2-user@$ips "sudo yum install git -y "
sleep 30
ssh -o StrictHostKeyChecking=no -i /tmp/june22_ohio.pem ec2-user@$ips "which git" 
done
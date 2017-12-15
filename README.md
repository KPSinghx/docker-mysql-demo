# Bitbucket Pipleline Demo with Docker (Spring boot Mysql example)

## Prerequisite
1. Account in AWS
2. Docker Account
3. Bitbucket Account

## Please follow these steps to push docker image to docker cloud
1. Create a repository in bitbucket and docker
2. Create two environment variable (DOCKER_USER_NAME and DOCKER_PASS) for Docker User Name and Password (Path :- Repository -> Setting -> Environment variables
3. Edit the bitbucket-pipelines.yml as per your Docker cloud details
4. Check-in the code to code bitbucket repository
5. Check whether build is successfull on bitbucket
6. Check whether docker image is pushed to Docker repository

## Please follow these steps to deploy Docker image to AWS Container

1. Create role in AWS (Go to this URL : https://console.aws.amazon.com/iam/home?#/roles and click on “Create Role”)
2. Follow the steps mentioned here : https://docs.docker.com/docker-cloud/cloud-swarm/link-aws-swarm/
3. Copy the ARN Role and link Docker with AWS
4. In Docker in Node Section, Create Node
5. Create Stack file to deploy image to AWS Container
```db-service:
  autodestroy: always
  autoredeploy: true
  image: 'kuldeep99/dbtest:latest'
  links:
    - mysqlkuldeep
  ports:
    - '8080:8080'
  target_num_containers: 1
mysqlkuldeep:
  environment:
    - MYSQL_DATABASE=test
    - MYSQL_PASS=root
    - MYSQL_ROOT_PASSWORD=root
    - MYSQL_USER=demo_user
  image: 'mysql:5.5'
  ports:
    - '3306:3306'
```
6. Click on create and deploy, docker cloud will create container and deploy the latest image in the container

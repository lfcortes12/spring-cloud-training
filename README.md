# spring-cloud-training

## Kubernates

Configure your local environment:

- [Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/ "MiniKube")
- [MicroK8s](https://kubernetes.io/blog/2019/11/26/running-kubernetes-locally-on-linux-with-microk8s/ "MicroK8s")

If configure Minikube without any driver (i.e. virtualbox), do not run it with the root user just change it in this way:

```
sudo mv /root/.kube /root/.minikube $HOME
sudo chown -R $USER $HOME/.kube $HOME/.minikube
```

## Jib

[Jib](https://github.com/GoogleContainerTools/jib "Jib Github Page") is a tool for building optimized docker images for Java applications without taking care of maintaining docker configuration files. You have the chance to configure it with Gradle and Maven based projects.

```
// include the plugin in your gradle configuration
plugins {
	id 'com.google.cloud.tools.jib' version '2.0.0'
}

//run jib with each gradle buildConfigures the container that is run from your built image.
tasks.build.dependsOn tasks.jib

// set the base image (adoptopenjdk/openjdk8-openj9:jdk8u242-b08_openj9-0.18.1-alpine-slim)
//and the target one (depends on the docker image registry you want to use that by
//default is docker hub).
jib {
  from {
    image = 'adoptopenjdk/openjdk8-openj9:jdk8u242-b08_openj9-0.18.1-alpine-slim'
  }
  to {
    image = 'bookstore/registry'
    credHelper = 'secretservice'
  }
  container {
    user = 'glb'
    ports = ['8761']
  }
}
//do not run your images with the root user so define one.
```

To publish your images to the docker registry, define the auth or credHelper configuration [docker-credential-helpers](https://github.com/docker/docker-credential-helpers "Credential Helpers") and login to it in the system terminal (`docker login [path-to-docker-registry-server]`).

## Build an image

```
./gradlew jibDockerBuild
```

## Build and Publish container

```
./gradlew jib
```

Finally, take a look to the image built at [Docker Hub Registry](https://hub.docker.com/repository/docker/luiscortes/book-store-registry-server "Docker Hub Registry"). Now the image is ready to use in your deployment.


## Create a container

```
docker run --name bookstore-ms-registry -p 8761:8761 -d bookstore/registry
```

## List created containers
```
docker ps -a
```

## Stop or start a containers
```
docker stop container-id
docker start container-id
```

## References

- [MicroK8s Video Tutorial](https://asciinema.org/a/263394 "MicroK8s Video Tutorial")

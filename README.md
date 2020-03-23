# spring-cloud-training

## Kubernates

Minikube Installation https://kubernetes.io/docs/tasks/tools/install-kubectl/#install-kubectl-on-linux

Configure your local environment:

- [Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/ "MiniKube")
- [MicroK8s](https://kubernetes.io/blog/2019/11/26/running-kubernetes-locally-on-linux-with-microk8s/ "MicroK8s")

If configure Minikube without any driver (i.e. virtualbox), do not run it with the root user just change it in this way:

```
minikube start --vm-driver=docker
sudo mv /root/.kube /root/.minikube $HOME
sudo chown -R $USER $HOME/.kube $HOME/.minikube
```

If you want to see more logs creating the cluster use this sudo minikube start --vm-driver=none  --alsologtostderr -v=8

Show kubernates Dashboard
```
minikube dashboard # opens a tab in your browser
```

## Checking installation

```
minikube status
kubectl cluster-info
```

## Troubleshooting

- [(https://github.com/kubernetes/minikube/issues/5715 "Failed to save config profiles/minikube/config.json")]

In case of getting errors creating a cluster, use below commands to remove tmp files:
```
sudo rm -rf /tmp/juju-mk*
sudo rm -rf /tmp/minikube.*
```

- kuctl bash completion error

if faces this issue getting bash completion kubectl _get_comp_words_by_ref: command not found execute below command (https://stackoverflow.com/questions/50406142/kubectl-bash-completion-doesnt-work-in-ubuntu-docker-container):
```
source /etc/bash_completion
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

## Skaffold

[Scaffold](https://skaffold.dev/ "Scaffold") is tool able to handle the workflow for building, pushing and deploying your application based on Kubernates.

```
curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-linux-amd64
chmod +x skaffold
sudo mv skaffold /usr/local/bin
```


## Initialize skaffold in your project

```
skaffold init --XXenableJibInit
```

## References

- [MicroK8s Video Tutorial](https://asciinema.org/a/263394 "MicroK8s Video Tutorial")

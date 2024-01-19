# cloud-computing

Darko Vrbaški - E2 145-2023

# Usage

## Docker

- Run `docker compose up -d` in `/infrastructure` directory.
- If you want to change the code you can specify build in `docker-compose.yml`

```yml
    build:
      context: ../[central | branch]-library
      dockerfile: Dockerfile
```

## Kubernetes

Start minikube

```sh
minikube start
```

Enable ingress controller 

```sh
minikube addons enable ingress
minikube addons enable ingress-dns
```

Setup infrastructure

```sh
kubectl apply -f infrastructure/k8s
```

Start minikube tunnel

```sh
minikube tunnel
```

Application is now available on

http://localhost/docs

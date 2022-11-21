# Red Hat App services blog

This repo contains the source for https://redhatperf.github.io/

## Dev

### Prerequisites

Either `docker` & `docker-compose` installed, or `podman` and `podman-compose`

### Setup dev environment

#### Docker

````
$ docker-compose -f ./container-compose.yml up
````

#### Podman

````
$ podman-compose -f ./container-compose.yml up
````

A local version of the website will be available at;

http://0.0.0.0:1313/ 

Edits will automatically be updated

## Updating https://redhatperf.github.io/

Open a PR against the `dev` branch of https://github.com/RedHatPerf/redhatperf.github.io/ . Once merged, the website will be automatically rebuilt.
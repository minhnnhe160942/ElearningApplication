FROM ubuntu:latest
LABEL authors="Neptune"

ENTRYPOINT ["top", "-b"]
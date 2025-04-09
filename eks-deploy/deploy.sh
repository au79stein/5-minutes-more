#!/bin/bash
helm upgrade --install postgres oci://registry-1.docker.io/bitnamicharts/postgresql -n postgres -f postgres/values.yaml
helm upgrade --install jenkins oci://registry-1.docker.io/bitnamicharts/jenkins -n jenkins -f jenkins/values.yaml
kubectl apply -f ingress/jenkins-ingress.yaml
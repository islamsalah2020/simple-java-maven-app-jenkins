FROM alpine

RUN apk add --no-cache curl tar bash
    
RUN curl -LO "https://storage.googleapis.com/kubernetes-release/release/v1.20.5/bin/linux/amd64/kubectl"   
RUN chmod u+x ./kubectl

RUN curl -fsSL -o get_helm.sh "https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3"
RUN chmod 700 get_helm.sh
RUN ./get_helm.sh
    
CMD [""]

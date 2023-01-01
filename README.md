# simple-java-maven-app-jenkins

Building CICD pipeline for Simple Java App using Jenkins.

## Stages of the Pipeline:
- Clean workspace
- Compile Java code
- Run unit tests
- Package Java classes to Jar
- Build Container Image for App
- Push COntainer Image to Container Registery.
- Deploy Container Image to Target environment.

### specific agents used in each stage
### Jenkins running on docker Image
### agent run ephemeral dockr image for the Job build

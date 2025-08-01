
# Online Banking Full Stack Project Frontent Readme File

The application is a Frontend project prepared for the Online Banking Rest API. React and Redux are used in the frontend of the application. The project is a single-page application, and I have fully leveraged the benefits provided by Redux. Every component you will see in the project is connected to the Redux Store. When the state of one component changes, all components that need to update their state automatically do so, providing users with real-time information.

Users can register, log in, view their account history, open new accounts, make transfers between accounts, deposit money, withdraw money, and make payments. Additionally, a self-updating chart has been prepared for users to view their account flows. In short, the components are constantly in communication with the backend, ensuring seamless interaction.

  
## Features

- React and Redux
- Single Page Application
- Material UI


  
## Distribution

1- Clone the project to your local machine.
2- Build and run the application using your preferred Java Script environment.

Start for Project

```terminal
  npm install
```

```bash
  npm run start
```
## Technologies

**Language:** Java Script 

**Technologies:** - React, Redux, Router Dom
- Redux Thunk
  
## Related projects

You can take a look at the frontends for my React Redux Online Banking App and Android Java Online Banking App projects for this application.

## Backend Project Structure

The backend (Spring Boot) project structure is as follows:

```
Online Banking App Spring Boot/
├── appmap.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cg/
│   │   ├── resources/
│   │   │   ├── application-mongodb.properties
│   │   │   └── application.properties
│   │   └── webapp/
│   └── test/
│       └── java/
├── target/
│   ├── DemoBank_v1-0.0.1-SNAPSHOT.jar
│   ├── DemoBank_v1-0.0.1-SNAPSHOT.jar.original
│   ├── classes/
│   │   ├── application-mongodb.properties
│   │   ├── application.properties
│   │   └── com/
│   │       └── cg/
│   ├── generated-sources/
│   │   └── annotations/
│   ├── generated-test-sources/
│   │   └── test-annotations/
│   ├── maven-archiver/
│   │   └── pom.properties
│   ├── maven-status/
│   │   └── maven-compiler-plugin/
│   ├── surefire-reports/
│   │   ├── 2025-08-01T02-20-00_341-jvmRun1.dump
│   │   ├── cg.DemoBank_v1.DemoBankV1ApplicationTests.txt
│   │   └── TEST-cg.DemoBank_v1.DemoBankV1ApplicationTests.xml
│   └── test-classes/
│       └── cg/
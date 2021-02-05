# simplify-qa-connector

[![Build Status](https://ci.jenkins.io/job/Plugins/job/simplify-qa-connector-plugin/job/master/badge/icon)](https://ci.jenkins.io/job/Plugins/job/simplify-qa-connector-plugin/job/master/)
[![Contributors](https://img.shields.io/github/contributors/jenkinsci/simplify-qa-connector-plugin.svg)](https://github.com/jenkinsci/simplify-qa-connector-plugin/graphs/contributors)
[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/simplify-qa-connector.svg)](https://plugins.jenkins.io/simplify-qa-connector)
[![GitHub release](https://img.shields.io/github/release/jenkinsci/simplify-qa-connector-plugin.svg?label=changelog)](https://github.com/jenkinsci/simplify-qa-connector-plugin/releases/latest)
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/simplify-qa-connector.svg?color=blue)](https://plugins.jenkins.io/simplify-qa-connector)

# SimplifyQA-Jenkins is a Jenkins Plugin to trigger automation suites after build.

## This has to be used in conjunction with SimplifyQA Automation platform. 

SimplifyQA supports CI integration for Jenkins through a plug-in. Make sure the plugin is properly installed on the CI system before proceeding.

## Step 1 

SQA Agent installation in the system is a mandatory pre-requisite before we start the Jenkins Integration.


## Step 2 

Jenkins configuration is available under settings, where in user can register the logged in machine or remote machine that has the SQA agent.


## Step 3 

Machine details are auto captured and machine name is editable so that user can give some unique name that can be remembered easily.


## Step 4 

In Pipelines module, a job or pipeline can be created by entering details like name of the job, which Suite/Scenario to execute on which machine using which browser. We also need to enter details related to execution like release/sprint and environment in which the suite needs to be run. Once saved, system creates an encrypted token having details of the pipeline.


## Step 5 

As a onetime activity, the Hpi file having Plug in information related to SimplifyQA environment needs be uploaded to Jenkins, under plugin uploads section of Manage Jenkins.


## Step 6 

In Jenkins, under the selected project, configure, copy/paste the token ID of the Pipeline.


## Step 7 

After the build, Jenkins initiates the execution in the machine that has been configured. The status of execution can be checked in Jenkins console.


## Step 8 

Test case execution is initiated by Jenkins.


## Step 9 

Result can be checked in Console, as well as reports. There is link in console that navigates to Reports tab of SimplifyQA tool with preselected details. User can view the results and PDF report can be downloaded.


## About SimplifyQA
Simplify QA is a simple automation tool that supports automation of Web, Mobile, Windows based applications and Service Automation. 
SimplifyQA has become even more awesome with the added feature for Jenkins Integration! With the latest release, the CI/CD pipelines is made easy.

- Scriptless natural language Functional, API Automation
- No IDE, Fully browser based 
- Visualize and drive quality with SimplifyQA Universe
- Design/Automate/Maintain your testing 3X Faster



## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md)


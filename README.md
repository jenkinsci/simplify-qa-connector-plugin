<<<<<<< HEAD
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


=======
# SimplifyQA Pipeline Executor

[![Build Status](https://ci.jenkins.io/job/Plugins/job/simplify-qa-connector-plugin/job/main/badge/icon)](https://ci.jenkins.io/job/Plugins/job/simplify-qa-connector-plugin/job/master/)

[![Contributors](https://img.shields.io/github/contributors/jenkinsci/simplify-qa-connector-plugin.svg)](https://github.com/jenkinsci/simplify-qa-connector-plugin/graphs/contributors)

[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/simplify-qa-connector.svg)](https://plugins.jenkins.io/simplify-qa-connector)

[![GitHub release](https://img.shields.io/github/release/jenkinsci/simplify-qa-connector-plugin.svg?label=changelog)](https://github.com/jenkinsci/simplify-qa-connector-plugin/releases/latest)

[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/simplify-qa-connector.svg?color=blue)](https://plugins.jenkins.io/simplify-qa-connector)

# SimplifyQA Pipeline Executor is an update to our existing Jenkins Plugin with improved features. It offers seamless integration with SimplifyQA tool and triggers automated script execution.

## This plugin must be used in combination with SimplifyQA automation tool. It supports from Jenkins version 2.375.1

<pre>SimplifyQA supports CI integration for Jenkins through a plug-in.
Make sure the plugin is properly installed on the CI system before proceeding.

New features that are added to this improved utility are controlling the 
Build Failure status based on the percentage of failed testcases, 
improved timeouts and support to different types of Jenkins project.</pre>

# Follow below steps for Integration

## Step 1

SimplifyQA Agent should be installed and registered in the Host system. Login to SimplifyQA application, follow the steps in Help Guide to Download and install the Agent and register the machine in which installation is done.

## Step 2

Create Suite of automated testcases that needs to be executed as part of CICD pipeline.

## Step 3

Create a Pipeline with required suite and provide details of registered machine. The system would also need other execution related info like release, sprint, test data environment and browser to trigger the execution. Enter the necessary details and save.

## Step 4

The system generates a pipeline token with the entered details. Copy the token.

## Step 5

In Jenkins, install the SimplifyQA Pipeline connector, under Manage Jenkins >> Plugin Manager.

## Step 6

Under the created Jenkins project, now select the SimplifyQA section in the Build Tab and enter appropriate URL (SimplifyQA URL) and copied pipeline token.

## Step 7

Enter the failure percentage and enable verbose as required. Failure percentage would determine, when the build needs to be marked as failure and Verbose flag would provide the logs with or without details. Save the details.

## Step 8

Post build, Jenkins would trigger the execution of mentioned suite in registered machine.

## Step 9

Result can be checked in Console Output, as well as in a separate View in Jenkins.

## Step 10

Results would also be available in SimplifyQA reports section. There would also be an easy navigation to SimplifyQA reports section from logs. Users can view the report and download as PDF.

## Step 11

Tool can also trigger email to mentioned users, post completion of execution.

## About SimplifyQA

Welcome to SimplifyQA, the only Application Management Tool (ALM) you’ll ever need. SimplifyQA , is designed to make application management and testing easy, fast and reliable for anyone, regardless of coding skills and technical knowledge. With update on Jenkins Utility, we offer better support and cover wide variety of projects to give you a more awesome CICD integration.
>>>>>>> d19f963 (Update version 2.0.0-SNAPSHOT)

## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md)
<<<<<<< HEAD

=======
>>>>>>> d19f963 (Update version 2.0.0-SNAPSHOT)

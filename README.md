# SimplifyQA Pipeline Executor

[![Build Status](https://ci.jenkins.io/job/Plugins/job/simplify-qa-connector-plugin/job/master/badge/icon)](https://ci.jenkins.io/job/Plugins/job/simplify-qa-connector-plugin/job/master/)

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

## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md)

package io.jenkins.plugins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractProject;
import hudson.model.Result;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import hudson.util.FormValidation;
import hudson.util.Secret;
import jenkins.tasks.SimpleBuildStep;

public class Simplifyqaconnector extends Builder implements SimpleBuildStep {

	private String api;
//	private String authorization;
	private Secret authorization;
//	private String token;
	private Secret token;
	
	private int projectId;
	
	private int customerId;

	public String getApi() {
		return api;
	}

	public Secret getToken() {
		return token;
	}

	@DataBoundConstructor
	public Simplifyqaconnector(String api, Secret token) {
		this.api = api;
		this.token = token;
	}

	private int executionId;

	@Override
	public void perform(Run<?, ?> run, FilePath workspace, Launcher launcher, TaskListener listener)
			throws InterruptedException, IOException {
		URL obj = new URL(api);
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("Content-Type", "application/json");
		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		String postParams = "{\"token\":" + "\"" + token + "\"" + "}";
		os.write(postParams.getBytes(Charset.defaultCharset()));
		os.flush();
		os.close();
		int responseCode = postConnection.getResponseCode();
		if (responseCode == 200) {
			listener.getLogger().println("Suite Execution Started");
			listener.getLogger().println("\n");
			BufferedReader in = new BufferedReader(
					new InputStreamReader(postConnection.getInputStream(), Charset.forName("UTF-8")));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			String[] responsearray = response.toString().split(",");
			String[] splittedresarray = responsearray[1].split(":");
			executionId = Integer.parseInt(splittedresarray[1]);
			splittedresarray = responsearray[2].split(":");
			authorization = Secret.fromString(splittedresarray[1].replaceAll("\"", "").toString());
			splittedresarray = responsearray[3].split(":");
			projectId = Integer.parseInt(splittedresarray[1]);
			splittedresarray = responsearray[4].split(":");
			customerId = Integer.parseInt(splittedresarray[1].replaceAll("}", ""));
			Thread.sleep(20000);
			HttpURLConnection postConnectionn = testcaseStart(listener);
			response(postConnectionn, listener, run);
			testCaseinfo(run, postConnectionn, listener);
			listener.getLogger().println("Suite Execution Finished");
		} else {
			run.setResult(Result.FAILURE);
			listener.error("System Not Reachable");
		}
	}

	StringBuffer responsee;
	int i = 0;

	public HttpURLConnection testcaseStart(TaskListener listener) throws IOException, InterruptedException {

		try {
			String[] statusapi = api.split("/jenkinsSuiteExecution");
			URL objj = new URL(statusapi[0] + "/getJenkinsExecStatus");
			HttpURLConnection postConnectionn = (HttpURLConnection) objj.openConnection();
			postConnectionn.setRequestMethod("POST");
			postConnectionn.setRequestProperty("Content-Type", "application/json");
			postConnectionn.setRequestProperty("authorization", Secret.toString(authorization));
			postConnectionn.setDoOutput(true);
			OutputStream oss = postConnectionn.getOutputStream();
			String postParam = "{\"executionId\":" + executionId +","+ "\"projectId\":" +projectId +","+ "\"customerId\":" + customerId + "}";
			oss.write(postParam.getBytes(Charset.defaultCharset()));
			oss.flush();
			oss.close();
			if (postConnectionn.getResponseCode() == 500) {
				i++;
				if (i <= 3) {
					Thread.sleep(2000);
					return testcaseStart(listener);
				} else {
					return null;
				}
			} else {
				return postConnectionn;
			}
		} catch (java.io.IOException e) {
			if (i <= 3) {
				Thread.sleep(2000);
				return testcaseStart(listener);
			} else {
				return null;
			}
		}
	}

	BufferedReader inn;

	public String response(HttpURLConnection postConnectionn, TaskListener listener, Run<?, ?> run) throws IOException {
		responsee = new StringBuffer();
		try {
			inn = new BufferedReader(new InputStreamReader(postConnectionn.getInputStream(), Charset.forName("UTF-8")));
			String inputLinee;
			while ((inputLinee = inn.readLine()) != null) {
				responsee.append(inputLinee);
			}
			return responsee.toString();
		} catch (Exception e) {
			listener.getLogger().println("Request Timeout Error");
			run.setResult(Result.FAILURE);
			return null;
		}
	}

	public void testCaseinfo(Run<?, ?> run, HttpURLConnection postConnectionn, TaskListener listener)
			throws IOException, InterruptedException {
		int responseCode = postConnectionn.getResponseCode();
		String lasttest = null;
		listener.getLogger().println(responsee.toString());
		listener.getLogger().println("\n");
		while (responseCode == 200) {
			Thread.sleep(3000);
			HttpURLConnection post = testcaseStart(listener);
			try {
				responseCode = post.getResponseCode();
				String s = IOUtils.toString(post.getInputStream(), StandardCharsets.UTF_8);
				if (lasttest != null && !lasttest.equals(s.toString())) {
					listener.getLogger().println(s.toString());
					listener.getLogger().println("\n");
				}
				lasttest = s.toString();
				if (lasttest.contains("Failed")) {
					run.setResult(Result.FAILURE);
				}
				if (lasttest.contains("COMPLETED")) {
					break;
				}
			} catch (java.lang.NullPointerException e) {
				break;
			}
		}
	}

	@Symbol("SimplifyQA")
	@Extension
	public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {

		public FormValidation doCheckName(@QueryParameter String api) {
			return FormValidation.ok();
		}

		@Override
		public boolean isApplicable(Class<? extends AbstractProject> jobType) {
			return true;
		}

		@Override
		public String getDisplayName() {
			return "Simplify Suite Automation";
		}

	}
	
}

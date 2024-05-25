package com.proyectos.app.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.proyectos.app.util.TextConstants;
public class LogPattern {

		private char FS = '|';
		private String domainCode;
		private String solutioNameCode;
		private String platform;
		private String tower;
		private String className;

		public LogPattern(String domainCode, String solutioNameCode, String platform, String tower, String className) {

			this.domainCode = domainCode;
			this.solutioNameCode = solutioNameCode;
			this.platform = platform;
			this.tower = tower;
			this.className = className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		
		public String buildPattern(String methodName, String idTransaction, String message, String[] params, boolean error,
				long startTime) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
			StringBuilder sb = new StringBuilder();
			sb.append("{\"log_data\": {\"fecha\": \"").append(sdf.format(new Date()));
			sb.append("\", \"Mensaje\": \"").append(setMessage(methodName, idTransaction, message, params, error));
			sb.append("\", \"servicios\": [], \"TiempoTotal\": ").append((System.currentTimeMillis() - startTime));
			sb.append("}}");
			return sb.toString();
		}
		//params by string INFO
		public String buildPattern(String methodName, String idTransaction, String message, String params, long startTime) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
			StringBuilder sb = new StringBuilder();
			sb.append("{\"log_data\": {\"fecha\": \"").append(sdf.format(new Date()));
			sb.append("\", \"Mensaje\": \"").append(setMessage(methodName, idTransaction, null, message, params, false));
			sb.append("\", \"servicios\": [], \"TiempoTotal\": ").append((System.currentTimeMillis() - startTime));
			sb.append("}}");
			return sb.toString();
		}
		
		//params by string ERROR
		public String buildPattern(String methodName, String idTransaction, TextConstants.ExceptionError exceptionName, String message, String params, long startTime) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
			StringBuilder sb = new StringBuilder();
			sb.append("{\"log_data\": {\"fecha\": \"").append(sdf.format(new Date()));
			sb.append("\", \"Mensaje\": \"").append(setMessage(methodName, idTransaction, exceptionName, message, params, true));
			sb.append("\", \"servicios\": [], \"TiempoTotal\": ").append((System.currentTimeMillis() - startTime));
			sb.append("}}");
			return sb.toString();
		}
		
		public String buildPattern(String methodName, String idTransaction, String message, String[] params, boolean error,
				String[][] services) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
			long timeTotal = 0;
			String servicios = "[";
			for (int i = 0; i < services.length; i++) {
				Long tiempo = System.currentTimeMillis() - Long.parseLong(services[i][2]);
				servicios += "{\"servicio\": \"" + services[i][0] + "\", \"Sistema\": \"" + services[i][1]
						+ "\", \"Tiempo\": " + tiempo + "}";
				timeTotal += tiempo;
				if (i != services.length - 1)
					servicios += ", ";
			}
			servicios += "]";
			StringBuilder sb = new StringBuilder();
			sb.append("{\"log_data\": {\"fecha\": \"").append(sdf.format(new Date()));
			sb.append("\", \"Mensaje\": \"").append(setMessage(methodName, idTransaction, message, params, error));
			sb.append("\", \"servicios\": ").append(servicios);
			sb.append(", \"TiempoTotal\": ").append(timeTotal).append("}}");
			return sb.toString();
		}

		private String setMessage(String methodName, String idTransaction, String message, String[] params, boolean error) {
			StringBuilder sb = new StringBuilder();
			if (error)
				sb.append("ERROR ");
			if (idTransaction != null)
				sb.append("(idTransaction ").append(idTransaction).append(") ");
			sb.append("[methodName ").append(methodName).append("] ");
			sb.append("msg: ").append(message);
			if (params != null) {
				sb.append("|params: [");
				for (int i = 0; i < params.length; i++) {
					sb.append(params[i]);
					if (i != params.length - 1)
						sb.append("|");
				}
				sb.append("]");
			}
			return sb.toString();
		}
		
		//params by string
		private String setMessage(String methodName, String idTransaction, TextConstants.ExceptionError exceptionName, String message, String params, boolean error) {
			StringBuilder sb = new StringBuilder();
			if (error)
				sb.append("ERROR ");
			
			if (idTransaction != null)
				sb.append("(idTransaction ").append(idTransaction).append(") ");
			
			sb.append("[").append(className).append(".").append(methodName).append("] ");
			
			if(exceptionName != null)
				sb.append(exceptionName.getText()).append(" - ");
			
			if (message != null)
				sb.append("msg: [").append(message).append("] ");
			
			if (params != null) 
				sb.append("| params: [").append(params).append("]");
			
			return sb.toString();
		}
}

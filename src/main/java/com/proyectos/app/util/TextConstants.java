package com.proyectos.app.util;

public class TextConstants {
	public enum ExceptionError {
		
		EXCEPTION("Exception"),
		AXIS_FAULT("AxisFault"),
		JMS_EXCEPTION("JmsException"),
		REMOTE_EXCEPTION("RemoteException"),
		FAULT_ACTION("FaultAction"),
		CRM_EXCEPTION("CRMException"),
		TOO_MANY_RESULTS_EXCEPTION("TooManyResultsException"),
		PERSISTENCE_EXCEPTION("PersistenceException"),
		ERROR("ERROR"),
		HTTP_CLIENT_ERROR_EXCEPTION("HttpClientErrorException"),
		JSON_PARSE_EXCEPTION("JsonParseException"),
		REMOTE_ACCESS_EXCEPTION("RemoteAccessException"),
		GENERIC("Generic"),
		ILLEGAL_ACCESS_EXCEPTION("IllegalAccessException"),
		INVOCATION_TARGET_EXCEPTION("InvocationTargetException"),
		;
	
		private String text;
		
		ExceptionError(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

		protected void setText(String text) {
			this.text = text;
		}
	}
}

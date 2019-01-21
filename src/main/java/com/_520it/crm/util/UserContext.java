package com._520it.crm.util;

import javax.servlet.http.HttpServletRequest;

public class UserContext {
	public final static String UserSession = "USER_IN_SESSION";
	private static ThreadLocal<HttpServletRequest> local  = new ThreadLocal<>();
	public static void set(HttpServletRequest request){
		local.set(request);
	}
	public static HttpServletRequest get() {
		return local.get();
	}
}

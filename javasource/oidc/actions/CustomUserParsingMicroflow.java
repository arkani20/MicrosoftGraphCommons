// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package oidc.actions;

import java.util.List;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import system.proxies.User;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class CustomUserParsingMicroflow extends CustomJavaAction<IMendixObject>
{
	private java.lang.String Microflow;
	private IMendixObject __Token;
	private oidc.proxies.Token Token;
	private java.lang.String OpenIDTokenJSON;

	public CustomUserParsingMicroflow(IContext context, java.lang.String Microflow, IMendixObject Token, java.lang.String OpenIDTokenJSON)
	{
		super(context);
		this.Microflow = Microflow;
		this.__Token = Token;
		this.OpenIDTokenJSON = OpenIDTokenJSON;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		this.Token = this.__Token == null ? null : oidc.proxies.Token.initialize(getContext(), __Token);

		// BEGIN USER CODE
		IContext context=getContext();
		IMendixObject resultObject = (IMendixObject) Core.microflowCall(Microflow)
                .withParam("OAuthToken", Token.getMendixObject())
                .withParam("OpenIDTokenJSON", OpenIDTokenJSON)
                .execute(context);
        return resultObject;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "CustomUserParsingMicroflow";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

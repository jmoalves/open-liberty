/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.grpc.client.config;

import com.ibm.websphere.ras.Tr;
import com.ibm.websphere.ras.TraceComponent;
import com.ibm.ws.grpc.client.GrpcClientConstants;

public class GrpcClientConfigValidation {

	private static final TraceComponent tc = Tr.register(GrpcClientConfigValidation.class);

	/**
	 * @param value - key name
	 * @return true if keep alive time value is valid
	 */
	static boolean validateKeepAliveTime(String value) {
		int time = Integer.parseInt(value);
		if (time < 1) {
			Tr.warning(tc, "grpcTarget keepAliveTime is invalid", time);
			return false;
		}
		return true;
	}

	/**
	 * @param value - key name
	 * @return true if keep alive timeout value is valid
	 */
	static boolean validateKeepAliveTimeout(String value) {
		int time = Integer.parseInt(value);
		if (time < 1) {
			Tr.warning(tc, "grpcTarget keepAliveTimeout is invalid", time);
			return false;
		}
		return true;
	}

	/**
	 * @param value - key name
	 * @return true if max inbound message size value is valid
	 */
	static boolean validateMaxInboundMessageSize(String value) {
		int size = Integer.parseInt(value);
		if (size < 1) {
			Tr.warning(tc, "grpcTarget maxInboundMessageSize is invalid", size);
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param value - key name
	 * @return true if sslConfig ID is valid
	 */
	static boolean validateSslConfig(String value) {
		// TODO: actually validate
		return true;
	}

	/**
	 * validate the value for authnToken key
	 *
	 * @param value - shorthand key name
	 * @return true if authnToken value is valid
	 */
	static boolean validateAuthn(String value) {

		String valueLower = value.toLowerCase();
		boolean valid = valueLower.equals(GrpcClientConstants.JWT) || valueLower.equals(GrpcClientConstants.OAUTH);
		if (!valid) {
			Tr.warning(tc, "grpcTarget authnToken is invalid", valueLower);
		}
		return valid;
	}
}

package com.aineophyte.connectfour.api;

import com.aineophyte.connectfour.server.GameImplTest;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

/**
 * Really integration tests that rely on a running server.
 */
public class ConnectFourClientTest extends GameImplTest
{
	protected void initClient()
	{
		if (client == null) {
			String target = "localhost:8980";
			ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
			client = new ConnectFourClient(channel);			
		}		
	}
}

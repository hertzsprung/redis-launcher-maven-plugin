package uk.co.datumedge.redislauncher.maven;

import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import uk.co.datumedge.redislauncher.RedisServer;

/**
 * @goal start
 */
public class LocalRedisServerStarterMojo extends AbstractMojo {
	private RedisServer redisServer;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			redisServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setRedisServer(RedisServer redisServer) {
		this.redisServer = redisServer;
	}
}

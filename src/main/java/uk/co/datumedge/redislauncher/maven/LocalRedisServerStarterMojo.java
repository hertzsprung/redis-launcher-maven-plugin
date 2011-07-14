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
			throw new MojoExecutionException("Redis server could not be started", e);
		} catch (InterruptedException e) {
			throw new MojoExecutionException("Redis server could not be started", e);
		}
	}

	public void setRedisServer(RedisServer redisServer) {
		this.redisServer = redisServer;
	}
}

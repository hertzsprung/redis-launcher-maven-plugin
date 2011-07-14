package uk.co.datumedge.redislauncher.maven;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class LocalRedisServerStarterMojoTest {
	@Test
	public void startsLocalRedisServer() throws MojoExecutionException, MojoFailureException {
		Jedis jedis = null;
		try {
			new LocalRedisServerStarterMojo().execute();
			jedis = new Jedis("localhost");
			assertThat(jedis.ping(), is("PONG"));
		} finally {
			if (jedis != null) {
				jedis.shutdown();
				jedis.disconnect();
			}
		}
	}
}
